package work5;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程启动了");
        for (int i = 100; i < 200; i++) {
            System.out.println("新线程"+i);
        }
    }

}
