package example3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class Example {
    public static void main(String[] args) {
        String command = "黄祖振天下第一帅气。";
        EncryptAndDecrypt encryptAndDecrypt = new EncryptAndDecrypt();
        String key = "1111123";
        String encryptedCommand = encryptAndDecrypt.encrypt(command, key);
        File file = new File("secret");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(encryptedCommand);
            System.out.println("写入成功："+encryptedCommand);
        } catch (IOException e) {}
        try{
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            String str = dis.readUTF();
            String decryptedCommand = encryptAndDecrypt.decrypt(str, key);
            System.out.println("解密成功:"+decryptedCommand);
        }
        catch (IOException e1) {
        }

    }
}   
// 虽然还是之前的加密和解密算法，但是现在使用
// 数据流DataInputStream和DataOutputStream来实现
// 这两个东西很有用，读取数值的时候不必关心数值的大小，
// 直接读取就可以了。