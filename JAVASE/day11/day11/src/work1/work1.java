package work1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class work1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("F:\\Directory_of_files_used_for_testing_code\\User.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);

        User u = new User();
        u.setName("Rahul");
        u.setPassword("<PASSWORD>");
        System.out.println("程序结束");
        out.writeObject(u);

        out.close();
    }
}
