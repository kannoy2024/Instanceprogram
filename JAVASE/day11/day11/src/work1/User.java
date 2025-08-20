package work1;

import java.io.Serializable;

//当前类需要序列化和反序列化的时候都需要实现Serializable接口
public class User implements Serializable {
    private String name;
    private String password;
    private transient String address;

    // private static final long serialVersionUID = 1L;
    // 如果不想每次改变文件都重新序列化，就可以使用固定的序列化ID

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + "]";
    }
}
