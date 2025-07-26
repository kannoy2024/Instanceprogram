package Charge;

public class Cinema implements Charge,Play{

    @Override
    public void play() {
        System.out.println("Cinema 播放电影");
    }

    @Override
    public void charge() {
    System.out.println("Cinema 收费");
    }

}
