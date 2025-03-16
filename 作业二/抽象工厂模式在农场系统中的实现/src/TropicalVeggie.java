public class TropicalVeggie implements Veggie {
    private String name;
    public TropicalVeggie(String veggiesName) {
        name = veggiesName;
    }
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
}
