public class NorthernGardener extends AbstractGardener {
    // 修复：确保方法签名与父类定义一致
    @Override
    public Veggie createVeggie(String fruitName) {
        return new NorthernVeggie(fruitName);
    }

    @Override
    public Fruit createFruit(String veggiesName) {
        return new NorthernFruit(veggiesName);
    }
}