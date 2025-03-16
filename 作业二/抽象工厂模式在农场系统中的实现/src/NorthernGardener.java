public class NorthernGardener implements AbstractGardener {
    public Veggie createVeggie(String fruitName) {
        return new NorthernVeggie(fruitName);
    }
    public Fruit createFruit(String veggiesName) {
        return new NorthernFruit(veggiesName);
    }
}