package work1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class working {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream("F:\\Directory_of_files_used_for_testing_code\\User.txt");
        ObjectInputStream in = new ObjectInputStream(fin);

        User u = (User) in.readObject();
        System.out.println(u.getName());
        System.out.println(u.getPassword());
        in.close();
    }
}
