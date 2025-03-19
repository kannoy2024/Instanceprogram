package example7;

public class AdvertisementBoard{
    Advertisement advert;
    public void setAdvertisement(Advertisement advert) {
        this.advert = advert;
    }
    public void show() {
        if(advert == null ){
            System.out.println("广告招商中");
        }else {
            advert.showAdvertisement();
        }
    }
}
