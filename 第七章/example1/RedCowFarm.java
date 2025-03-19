

public class RedCowFarm {
    static String  farmName;
    RedCow cow;
    RedCowFarm(){
    }
    RedCowFarm(String name){
        cow = new RedCow(120);
        farmName=name;
    }
    public void showCow(){
        cow.speak();
    }
    class RedCow{
        String cowName="红牛";
        int weight;
        RedCow(int w){
            weight=w;
        }
        void speak(){
            System.out.println("weight="+weight+"生活在"+farmName);
        }
    }
}
