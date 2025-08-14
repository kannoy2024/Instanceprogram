package work1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class work2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("F:\\Directory_of_files_used_for_testing_code\\User.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
// 使用对象操作流（序列化）操作多个对象，就是使用集合，将多个对象转换，再将多个对象存储到文件中
        User u = new User();
        u.setName("Rahul");
        u.setPassword("<PASSWORD>");
        User u1 = new User();

        u1.setName("Rahul2");
        u1.setPassword("<PASSWORD2>");

        List<User> list = new ArrayList<User>();

        list.add(u);
        list.add(u1);


        out.writeObject(list);
        System.out.println("程序结束");

        out.close();
    }
}
