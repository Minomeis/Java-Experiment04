import java.util.Scanner;

public class Testing {

    public static void main(String args[]) throws Exception{
        //实例化一堆实验室
        Lab[] labs = new Lab[5];
        Lab lab1 = new Lab("计算机网络实验室",801);
        labs[0] = lab1;
        Lab lab2 = new Lab("组成原理实验室",807);
        labs[1] = lab2;
        Lab lab3 = new Lab("大学生创新实验室",707);
        labs[2] = lab3;

        //实例化学生
        Student stu1 = new Student("韩若梅",2020310853);
        Student stu2 = new Student("韩淋竹",2023310853);

        //给学生分配实验室
        stu1.add_lab(lab1);
        stu2.add_lab(lab2);
        stu2.add_lab(lab3);

        //自己评分
        lab1.setScore();
//        lab2.setScore();
//        lab3.setScore();

        //默认评分
//        int[] a= {5,4,5,7,9,8,10,7,5,8,9,7,9,5,7,9,8,6};
//        int[] b= {5,10,7,5,8,8,7,9,5,7,9,8,6,10,7,5,8,9};
//        int[] c= {5,6,7,9,8,8,7,9,7,7,9,8,8,10,7,5,7,9};
//        lab1.setscore(a);
//        lab2.setscore(b);
//        lab3.setscore(c);

        //算钱,算税后
        stu1.cal_money();
        stu1.cal_tax();
//        stu2.cal_money();
//        stu2.cal_tax();







    }
}
