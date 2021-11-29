# 大202 2020310853
## 一、实验目的
1. 掌握java中类的定义
2. 掌握static、final等修饰符的用法
3. 了解异常的使用方法，并在程序中根据输入情况做异常处理

## 二、业务要求
&emsp;&emsp;某学校为了给学生提供勤工俭学机会，选派了部分学生参与实验室的卫生清洁工作。
每个学生被分配若干间实验室，视实验室的清洁打分情况给予劳务补贴。
&emsp;&emsp;按国家税务制度，劳务费应按国家规定纳税，请统计一学期学生的实际收入。

## 三、实验要求
1. 设计系统中的类（如：学生、实验室等等）
2. 一学期按18周计算；
3. 每个学生负责的实验室数量不一定相同；
4. 对学期勤工俭学收入和纳税进行统计，求得实际收入；
5. 国家最新纳税标准（系数），属于某一时期的固定值，与实例化对象没有关系，考虑如何用static、final修饰定义。
6. 根据处理情况，要在程序中考虑做异常处理。

## 四、实验过程
1. 设计系统中需要的类，学生（Student），实验室（Lab）,设置构造函数，并定义他们的属性。
<br>&emsp;&emsp;1)Student类的属性：姓名（name）,学号（id）,补助价格（money）,实验室列表（labs）；
<br>&emsp;&emsp;2)Lab类的属性：不同等级补助价格（great,good,pass），实验室名称（name），房间号（room），实验室评分表（score）。
2. 实例化一些学生和实验室。编写函数（add_lab），将实验室分配给不同的同学。
3. 设置评分机制，此处为了方便测试，我做了两种评分方式，一种是可以输入的，另一种是直接传给他一个成绩列表。
其中输入评分机制，考虑到会出现错误输出，所以在这里运用了异常处理（try-catch）。
4. 设置函数（cal_money）计算每个学生的所得总值，通过遍历学生的实验室列表，将实验室每周的分数都分别按照分数等级计算每周能获得的工资，并且求和。
5. 单独创建一个类Peizhi用来存储一些永恒不变的量，在本实验中即是国家规定不变的利率。
6. 设置函数（cal_tax），根据既定的不变利率，计算税后所得。（税率并非准确数字，为自定义税率）

## 五、流程图
![](https://github.com/Minomeis/Java-Experiment04/blob/master/img/liucheng.png)
## 六、主要代码
1. 实例化Lab类，在其中添加属于整个类的属性，价格补助。
```java
public class Lab {
    static double great = 20; //优的补助价格
    static double good = Math.ceil(great * 0.75); //良的补助价格
    static double pass = Math.ceil(great * 0.5); //及格的补助价格
}
```
2. 评分输入机制
```java
    public void setScore() {
        Scanner in = new Scanner(System.in);
        System.out.println("请打分");
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
```

3. 评分机制的异常处理，经过官网查询错误类型对应名称，使用了“”来进行具体的错误处理，并在最后添加exception主类，捕捉所有错误。
```java
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
        catch (NumberFormatException e){
            System.out.println("数据结构异常");
        }
        catch (Exception e){
            System.out.println("异常");
        }
    }
```

4. cal_money函数，通过遍历学生的实验室列表，将实验室每周的分数都分别按照分数等级计算每周能获得的工资，并且求和。
```java
    public void cal_money(){
        int[] a = new int[18];
        System.out.println(this.name + "的收入统计");
        for (int i = 0;i< labs.length;i++){

            if (labs[i] == null){
                continue;
            }
            else {
                System.out.println(labs[i].getName() + "收入统计：");
                a = labs[i].getScore(); //分数数组
                for(int j=0;j<18;j++){

                    if(a[j]>0 & a[j]<=5){ //5分一下及格
                        money = money + Lab.pass;
                        System.out.println(j+1 +"周收入:" +money);
                    }
                    else if(a[j]>7 & a[j]<=10){ //7分以上优秀
                        money = money + Lab.great;
                        System.out.println(j+1 +"周收入:" +money);
                    }
                    else if(a[j]>5 & a[j]<=7){  //其余良好
                        money = money + Lab.good;
                        System.out.println(j+1 +"周收入:" +money);
                    }
                }
            }
        }
        System.out.println(this.name + "的总共收入" + money);
    }
```

5. 创建类Peizhi，用来存储不能被修改的利率。
```java
public class Peizhi {
    public static final double tax = 0.03;
    public static final double taxmax = 0.05;
    public static final double taxmin = 0.01;
}
```

6.cal_tax函数，根据相应利率，计算税后所得。
```java
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
```

## 七、运行截图

## 八、感想体悟
&emsp;&emsp;本次实验个人感觉比上两次要简单，这次实验帮助我更加精细的了解到了static以及final的使用方法和使用情景。
还有异常处理的用法，以及如何去搜索不同的异常对应的具体名称等。