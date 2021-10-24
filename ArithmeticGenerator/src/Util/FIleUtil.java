package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * @author Miaomiaolu
 * 读写文档工具
 */
public class FIleUtil {

    /**
     * 将content写入文件
     * @param fileName 要写入的文件
     * @param content  要写入的内容
     * @throws Exception
     */
    public static  void  write(File fileName,String[] content) throws Exception{
        FileWriter fw =new FileWriter(fileName);
        for(int i=0; i<content.length&& content[i]!=null;i++){
            //输入序号和内容
            fw.write(String.valueOf(i+1) + ". " + content[i]);
            fw.write("\n");
        }
        fw.close();
    }
    /**
     *  创建文件清除文件
     * @param f 要创建的文件或者是清除的文件
     * @throws Exception
     */
    public static void creatOrEliminate(File f) throws Exception{
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fw = new FileWriter(f);
        // 清空文件
        fw.write("");
        fw.flush();
        fw.close();
    }
}
