package MAP1;

public class Student {
    private String name;
    private String adds;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdds() {
        return adds;
    }
    public void setAdds(String adds) {
        this.adds = adds;
    }
    public Student(String name, String adds) {
        this.name = name;
        this.adds = adds;
    }
    public Student() {
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", adds=" + adds + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((adds == null) ? 0 : adds.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (adds == null) {
            if (other.adds != null)
                return false;
        } else if (!adds.equals(other.adds))
            return false;
        return true;
    }
}
