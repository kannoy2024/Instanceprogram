package example10;

public class example10 {
    public static void main(String[] args) {
        String cost = "长途77.6,市内13.9,国际966.2";
        double priceSum = GetPrice.givePriceSum(cost);
        System.out.printf("%s\n总价格为:%.2f元\n",cost,priceSum);
    }
}
