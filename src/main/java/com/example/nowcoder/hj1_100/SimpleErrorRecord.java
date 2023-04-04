package com.example.nowcoder.hj1_100;

import java.util.LinkedList;
import java.util.Scanner;

public class SimpleErrorRecord {

    /**
     * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。
     * 对相同的错误记录只记录一条，但是错误计数增加。
     * 最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
     * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
     * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
     * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        LinkedList<String> fileNameList = new LinkedList<>();
        LinkedList<Integer> errorCountList = new LinkedList<>();

        while (in.hasNextLine()) {
            String inputString = in.nextLine();
            String[] toSplitInfo = inputString.split(" ");
            String wholeFileName = toSplitInfo[0];
            String errorLineNumber = toSplitInfo[1];
            updateErrorInformation(wholeFileName, errorLineNumber, fileNameList, errorCountList);
        }

        int startPrintLine = fileNameList.size() <= 8 ? 0 : fileNameList.size() - 8;
        for (int i = startPrintLine; i < fileNameList.size(); i++) {
            System.out.println(fileNameList.get(i) + " " + errorCountList.get(i));
        }

    }

    /**
     * 返回最长16位的无符号的文件名
     *
     * @param wholeFileName
     * @return
     */
    public static String returnLegalFileName(String wholeFileName) {
        if (wholeFileName.contains(":")) {
            String[] removeDisc = wholeFileName.split(":");
            String filePath = removeDisc[1];
            String[] findLastOne = filePath.split("\\\\");
            String toSubString = findLastOne[findLastOne.length - 1];
            if (toSubString.length() > 16) {
                toSubString = toSubString.substring(toSubString.length() - 16);
            }
            return toSubString;
        } else {
            String[] findLastOne = wholeFileName.split("\\\\");
            String toSubString = findLastOne[findLastOne.length - 1];
            if (toSubString.length() > 16) {
                toSubString = toSubString.substring(toSubString.length() - 16);
            }
            return toSubString;
        }
    }

    /**
     * 负责更新列表，重复出现的不更新顺序，文件名相同即同一文件，
     *
     * @param fileNameList
     * @param errorLineList
     * @param errorCountList
     */
    public static void updateErrorInformation(
            String wholeFileName,
            String errorLineNumber,
            LinkedList<String> fileNameList,
            LinkedList<Integer> errorCountList
    ) {
        String legalFileName = returnLegalFileName(wholeFileName);
        String newErrorInfo = legalFileName + " " + errorLineNumber;
        if (fileNameList.contains(newErrorInfo)) {
            int errorIndex = fileNameList.indexOf(newErrorInfo);
            errorCountList.set(errorIndex, errorCountList.get(errorIndex) + 1);
        } else {
            fileNameList.addLast(newErrorInfo);
            errorCountList.addLast(1);
        }
    }
}
