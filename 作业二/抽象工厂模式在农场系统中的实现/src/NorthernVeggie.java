public class NorthernVeggie implements Veggie {
    private String name;
    public NorthernVeggie(String veggiesName) {
        name = veggiesName;
    }
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
}
