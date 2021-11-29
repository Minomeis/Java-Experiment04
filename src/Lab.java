import java.util.Scanner;

public class Lab {
    static double great = 20; //优的补助价格
    static double good = Math.ceil(great*0.75); //良的补助价格
    static double pass = Math.ceil(great*0.5); //及格的补助价格
    //向上取整：Math.ceil()
    private String name;
    private int room;
    private int[] score = new int[18];


    public Lab(String name,int room){  //使用默认的补助价格
        //this.Buzhu = buzhu;
        this.name = name;
        this.room = room;
    }

    public Lab(double buzhu,String name,int room){ //自定义补助价格
        this.great = buzhu;
        this.name = name;
        this.room = room;
    }

    public void setRoom(int room) { this.room = room; }
    public void setName(String name) {
        this.name = name;
    }
    public void setscore(int[] a){ this.score = a; }
    //每一个实验室打分
    public void setScore() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("请打分");
            //int[] a = new int[18];
            for (int i = 0; i < 18; i++) {
                System.out.println("第" + (i + 1) + "周:");
                score[i] = in.nextInt();
                if(score[i]>0 & score[i]<=10){
                    continue;
                }
                else{
                    System.out.println("输入错误");
                    break;
                }
            }
        }
        catch (NumberFormatException in){
            System.out.println("数据结构异常");
        }
        catch (Exception n){
            System.out.println("异常");
            n.printStackTrace();
        }
    }

    public double getGreat() {
        return great;
    }
    public double getGood() {
        return good;
    }
    public double getPass() {
        return pass;
    }
    public int getRoom() {
        return room;
    }
    public String getName() {
        return name;
    }
    public int[] getScore(){
        return score;
    }

}
