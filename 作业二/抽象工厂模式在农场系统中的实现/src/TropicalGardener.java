public class TropicalGardener extends AbstractGardener {
    // 修复：确保方法签名与父类定义一致
    @Override
    public Veggie createVeggie(String fruitName) {
        return new TropicalVeggie(fruitName);
    }

    @Override
    public Fruit createFruit(String veggiesName) {
        return new TropicalFruit(veggiesName);
    }
}