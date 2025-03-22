package example7;
import java.util.Scanner;
//如何使用一个String对象password的字符序列作为密码,对另一个String对象的字符序列进行加密。
public class example {
  public static void main(String[] args) {
    String sourceString = "原神启动!";
    EncryptAndDecrypt encryptAndDecrypt = new EncryptAndDecrypt();
    System.out.println("输入密码加密:"+sourceString);
    Scanner scanner = new Scanner(System.in);
    String password = scanner.nextLine();
    String secret= encryptAndDecrypt.encrypt(sourceString,password);
    System.out.println("加密后:"+secret);
    System.out.println("输入密码解密:");
    password = scanner.nextLine();
    String source = encryptAndDecrypt.decrypt(secret,password);
    System.out.println("解密后:"+source);
    scanner.close();
  }
}
