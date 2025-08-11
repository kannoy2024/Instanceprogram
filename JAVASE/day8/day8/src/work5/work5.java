package work5;

public class work5 {
public static void main(String[] args) {
    System.out.println("main");
    MyThread myThread = new MyThread();
    myThread.start();

    for (int i = 1; i <100; i++) {
        System.out.println("main方法"+i);
    }

    //可以看到线程在交替运行
}
}
