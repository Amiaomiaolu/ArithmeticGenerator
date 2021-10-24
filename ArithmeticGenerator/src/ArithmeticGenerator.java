import Funtion.CreateExpression;
import Util.AccuracyUtil;
import Util.FIleUtil;
import Util.InputUtil;

import java.io.File;

/**
 * @date 2021.10.22
 * @author Miaomiaolu and  Qiao
 *主类
 */


public class ArithmeticGenerator {

    public static void main(String[] args) throws Exception {
        /**
         * 指引用户
         */
        File file = new File("");
        String file_path = file.getAbsolutePath();
        File f1 = new File(file_path+"\\Exercise.txt");
        File f2 = new File(file_path+"\\Answer.txt");
        File f3 = new File(file_path+"\\Grade.txt");
        FIleUtil.creatOrEliminate(f1);
        FIleUtil.creatOrEliminate(f2);
        FIleUtil.creatOrEliminate(f3);
        //  输入一些基本信息，如要生成的表达式数目num，和表达式的数值范围limits
        InputUtil.inputBase();
        //  输出表达式，等待用户作答，num：表达式数目，limits：表达式的数值范围
        CreateExpression.outCorrectExpression(InputUtil.num, InputUtil.limits,f1,f2);
        // 用户答案获取
        String[] useranswers = InputUtil.usersAnswer();
        // 如果要输出正确率，输入正确命令，表示输出自己答题情况
        boolean tag = InputUtil.inputExpand();
        if (tag) {
            System.out.println("及时检查自己的作业哦");
            //  写入文件
            AccuracyUtil.result(useranswers,f3);
        }else{
            System.out.println("感谢您的使用");
        }
    }
}
