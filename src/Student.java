public class Student {
    private String name;
    private int id;
    private double money; //全部补助
    private int i; //实验室数量
    private Lab[] labs = new Lab[5]; //一堆实验室


    public Student(String name,int id){
        this.name = name;
        this.id = id;
    }

    //给学生添加实验室
    public void add_lab(Lab lab){
        labs[i] = lab;
        i++;
    }

    //计算全部所得钱数
    public void cal_money(){
        int[] a = new int[18];
        System.out.println("一次最高补助价格：" + Lab.great);
        System.out.println(this.name + "的收入统计");
        double m;
        for (int i = 0;i< labs.length;i++){

            if (labs[i] == null){
                continue;
            }
            else {
                System.out.println(labs[i].getName() + "收入统计：");
                a = labs[i].getScore(); //分数数组
                m = 0;
                for(int j=0;j<18;j++){
                    if(a[j]>0 & a[j]<=5){ //5分一下及格
                        //System.out.println(j + money);
                        m = m + Lab.pass;
                        System.out.println(j+1 +"周收入:" +m);
                    }
                    else if(a[j]>7 & a[j]<=10){ //7分以上优秀
                        m = m + Lab.great;
                        System.out.println(j+1 +"周收入:" +m);
                    }
                    else if(a[j]>5 & a[j]<=7){  //其余良好
                        m = m + Lab.good;
                        System.out.println(j+1 +"周收入:" +m);
                    }

                }
                System.out.println(labs[i].getName() + "的总共收入" + m);
                money = m + money;
            }
        }

        System.out.println(this.name + "的总共收入" + money);
    }

    //算税收
    public void cal_tax(){
        if(money<=200){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.taxmin)));
        }
        else if(money>200 & money<=400){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.tax)));
        }
        else if(money>400){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.taxmax)));
        }
    }
}
