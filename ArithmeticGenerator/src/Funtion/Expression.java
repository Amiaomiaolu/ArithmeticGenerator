package Funtion;

public class Expression {
    private String operatorNumber[];//表示操作数 ,该字符串数组只存储操作数
    private String operator;//表示操作符  ,该字符串数组只存储操作符，特别的第一个位置表示该表达式是否为操作符开头.
    private String answer; //表示为结果
    private String repeatExprssion[];//用于查重.
    private int repeatFlag = 0; //用于标识该表达式是否重复.

    public Expression() {
    }

    public int getrepeatFlag() {

        return repeatFlag;
    }

    public void setrepeatFlag(int repeatFlag) {

        this.repeatFlag = repeatFlag;
    }

    public String[] getisrepeatExprssion() {

        return repeatExprssion;
    }

    public void setrepeatExprssion(String[] repeatExprssion) {
        this.repeatExprssion = repeatExprssion;
    }


}

