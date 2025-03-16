public class TropicalFruit implements Fruit {
    private String name;

    public TropicalFruit(String fruitName) {
        name = fruitName;
    }

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

}
