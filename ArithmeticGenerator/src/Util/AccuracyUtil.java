package Util;

import Funtion.CreateExpression;

import java.io.File;
import java.io.FileWriter;

/**
 * @author Miaomiaolu
 * 正确率Result
 */
public class AccuracyUtil {
    /**
     *  输出正确率到文件中，需要比较userAnswers和Answers
     * @param userAnswers 用户答案
     * @param grade 正确率文件
     * @throws Exception
     */
    public static void result(String[] userAnswers, File grade) throws Exception {
        //  拿到正确答案集，和用户答案做比较
        // 正确题目数和错误题目数
        int correctNum = 0;
        int wrongNum = 0;
        // 正确行输出
        String correctIndex = "";
        // 错误行输出
        String wrongIndex = "";
        // 得到标准答案数组
        String[] answers = CreateExpression.getAnswers();
        String[] write = new String[2];
        for (int i = 0; i < answers.length && answers[i] != null; i++) {
            // 相同下标，用户答案和标准答案一样便是正确
            if (answers[i].equals(userAnswers[i])) {
                correctNum++;
                //  +1 是为了达到正确的题目序号，保存所有正确的题目序号
                correctIndex += i + 1 + " ,";
            } else {
                wrongNum++;
                wrongIndex += i + 1 + " ,";
            }
        }
        StringBuffer s1 = new StringBuffer(correctIndex);
        StringBuffer s2 = new StringBuffer(wrongIndex);
        // 正确数为0，就不加上后面的括号（）
        if (correctNum != 0){
            s1.insert(0, "( ");
            //  取代末尾的  , 变为 ）
            s1.replace(s1.length()-1,s1.length(),")");
        }
        if(wrongNum != 0) {
            s2.insert(0, "(");
            s2.replace(s2.length()-1,s2.length(),")");
        }
        correctIndex = s1.toString();
        wrongIndex = s2.toString();
        // 拼接
        write[0] = "Correct : " + correctNum + " " + correctIndex;
        write[1] = "Wrong : " + wrongNum + " " + wrongIndex;
        write(grade,write);
    }

    /**
     *  专门用于Grade文件的写
     * @param fileName Grade.txt
     * @param content 写入Grade.txt文件的内容
     * @throws Exception
     */
    private static void write(File fileName,String[] content) throws Exception{
        FileWriter fw = new FileWriter(fileName);
        for(int i = 0; i < content.length; i++) {
            fw.write(content[i]);
            fw.write("\n");
        }
        fw.close();
    }

}


