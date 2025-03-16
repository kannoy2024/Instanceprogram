public class NorthernFruit implements Fruit {
    private String name;

    public NorthernFruit(String fruitName) {
        name = fruitName;
    }

    public String getName() {
        return new String(name);
    }
    public void setName(String newName) {
        name = newName;
    }



}
