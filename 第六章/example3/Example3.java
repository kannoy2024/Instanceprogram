package example3;

public class Example3 {
    public static void main(String[] args) {
        ShowMessage sm;//sm是接口声明的变量
        sm=(s)->{
            System.out.println("@@@@@@@@@@");
            System.out.println(s);
            System.out.println("@@@@@@@@@@");
        };
        sm.显示商标("长虹牌");


        sm=new TV();//接口声明的变量sm存放了TV类中声明的对象的引用
        sm.显示商标("祖振牌");//该接口变量调用被TV类实现的接口方法
        sm= new PC();
        sm.outPutStart();//该接口变量调用接口提供的default方法
        sm.显示商标("甜瓜果酒个人电脑");//接口回调
        sm.outPutStart();
    }
}
// 在Java中，接口回调是指可以把实现某一接口的类，创建的对象的引用，赋值给该接口声明的接口变量
// ，那么该接口变量就可以调用被类实现的接口方法以及接口提供的default方法或类重写的default方法。
