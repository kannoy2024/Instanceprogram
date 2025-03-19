package example7;

public class example7 {
    public static void main(String[] args) {
        AdvertisementBoard board = new AdvertisementBoard();
        board.show();
        board.setAdvertisement(new Advertiser1());
        board.show();
        board.setAdvertisement(new Advertiser2());
        board.show();
    }
}
