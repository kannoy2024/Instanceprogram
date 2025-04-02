
package example4;

import java.io.*;

public class example {
    public static void main(String[] args) {
        TV lianmaoTv = new TV();
        lianmaoTv.setName("Lianmao");
        lianmaoTv.setPice(1000);
        File file = new File("tv.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(lianmaoTv);
            objectOutputStream.close();
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            TV XIN = (TV) objectInputStream.readObject();
            objectInputStream.close();
            XIN.setName("XIN");
            XIN.setPice(2000);
            System.out.println("lianmaotv:"+lianmaoTv.getName()+"价格"+lianmaoTv.getPice());
            System.out.println("XIN:"+XIN.getName()+"价格"+XIN.getPice());
        } catch (ClassNotFoundException e) {
        System.out.println("发生错误不能读出对象: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("发生IO错误: " + e.getMessage());
        }
    }
}

//序列化：将一个对象转换为字节序列的过程
// 一个类如果实现了Serializable接口，那么这个类就可以被序列化。
