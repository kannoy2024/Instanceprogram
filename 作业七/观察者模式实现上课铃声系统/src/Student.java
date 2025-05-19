

public class Student implements  Observer {
    private String name;
    public Student(String name) {
        this.name = name;
    }

 @Override
    public void update(String bellState) {
        if ("下课铃响".equals(bellState)) {
            System.out.println(name + "：下课了，收拾书本准备离开教室。");
        } else if ("上课铃响".equals(bellState)) {
            System.out.println(name + "：上课铃响了，赶紧回教室准备上课。");
        }
    }
}
