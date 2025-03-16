public class TropicalGardener implements AbstractGardener {
    public Veggie createVeggie(String fruitName) {
        return new TropicalVeggie(fruitName);
    }
    public Fruit createFruit(String veggiesName) {
        return new TropicalFruit(veggiesName);
    }
}