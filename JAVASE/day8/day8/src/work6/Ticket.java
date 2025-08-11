package work6;

public class Ticket implements Runnable {
    private int ticket = 100;
    Object lock = new Object();

    @Override
    public void run() {
        while (true) {

            synchronized (lock) {
                if (ticket <= 0) {
                    break;
                }
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                }
                if (ticket == 0) {
                    break;
                }

            }

        }
    }

}
