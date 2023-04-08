package com.tyty.nowcoder.hj1_100;

import java.util.Scanner;

/**
 * 识别有效的IP地址和掩码并进行分类统计
 */
public class LegalIp {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //统计变量初始化
        int aNum = 0, bNum = 0, cNum = 0, dNum = 0, eNum = 0, errNum = 0, pNum = 0;

        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] strArr = str.split("~");
            String ip = strArr[0];
            String mask = strArr[1];

            //首先查看是否开头是0或127，是则直接忽略
            int firstIp = getIpSeg(ip, 0);
            if (firstIp == 0 || firstIp == 127) {
                continue; //跳过本次循环
            }

            //判断掩码是否合法
            if (isMaskInvalid(mask)) {
                errNum++;
                continue;
            }

            //判断ip是否合法
            if (isIpInvalid(ip)) {
                errNum++;
                continue;
            }

            //判断ip类型
            if (firstIp >= 1 && firstIp <= 126) {
                aNum++;
            }
            if (firstIp >= 128 && firstIp <= 191) {
                bNum++;
            }
            if (firstIp >= 192 && firstIp <= 223) {
                cNum++;
            }
            if (firstIp >= 224 && firstIp <= 239) {
                dNum++;
            }
            if (firstIp >= 240 && firstIp <= 255) {
                eNum++;
            }

            //判断是否是私网
            int lastIP = getIpSeg(ip, 3);
            int secIp = getIpSeg(ip, 1);
            if (firstIp == 10) {
                pNum++;
            }
            if (firstIp == 172 && secIp >= 16 && secIp <= 31) {
                pNum++;
            }
            if (firstIp == 192 && secIp == 168) {
                pNum++;
            }

        }

        //输出结果
        System.out.println(aNum + " " + bNum + " " + cNum + " " + dNum + " " + eNum + " " + errNum + " " + pNum);

    }

    //转2进制
    public static String toBinary(String num) {
        String numBinary = Integer.toBinaryString(Integer.valueOf(num));
        //不够的位数上补充0
        while (numBinary.length() < 8) {
            numBinary = "0" + numBinary;
        }

        return numBinary;

    }

    //判断掩码不合法
    public static boolean isMaskInvalid(String mask) {
        String[] maskArr = mask.split("\\.");
        //判断长度
        if (maskArr.length != 4) {
            return true;
        }

        //判断是否是连续1和0的组合
        String maskBinary = toBinary(maskArr[0]) + toBinary(maskArr[1]) + toBinary(
                maskArr[2]) + toBinary(maskArr[3]);
        if (maskBinary.charAt(0) == '0') {
            return true;
        }
        int turnNum = 0; //二进制字符串中变化次数
        for (int i = 1; i < maskBinary.length(); i++) {
            if (maskBinary.charAt(i) != maskBinary.charAt(i - 1)) {
                turnNum++;
            }
        }
        if (turnNum != 1) {
            return true;
        }

        return false;
    }

    //判断ip不合法
    public static boolean isIpInvalid(String ip) {
        if (getLen(ip) != 4) {
            return true;
        }
        int overNum = 0;
        String[] ipArr = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            if (Integer.valueOf(ipArr[i]) > 255) {
                overNum++;
            }
        }

        return !(overNum == 0);
    }

    //获取地址位数
    public static int getLen(String ip) {
        String[] ipArr = ip.split("\\.");
        return ipArr.length;
    }

    //获取ip地址片段
    public static int getIpSeg(String ip, int index) {
        String[] ipArr = ip.split("\\.");
        return Integer.parseInt(ipArr[index]);
    }

}
