package work1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class working2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream("F:\\Directory_of_files_used_for_testing_code\\User.txt");
        ObjectInputStream in = new ObjectInputStream(fin);

        List<User> list = (List<User>) in.readObject();
        in.close();
        for (User u : list) {
            System.out.println(u.getName());
            System.out.println(u.getPassword());
        }

    }
}
