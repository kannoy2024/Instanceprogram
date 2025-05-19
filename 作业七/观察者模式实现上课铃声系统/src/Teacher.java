
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

 @Override
    public void update(String bellState) {
        if ("下课铃响".equals(bellState)) {
            System.out.println(name + "：下课时间到，布置完作业准备离开。");
        } else if ("上课铃响".equals(bellState)) {
            System.out.println(name + "：上课铃响，走进教室开始授课。");
        }
    }
}