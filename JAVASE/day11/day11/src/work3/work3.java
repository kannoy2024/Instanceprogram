package work3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class work3 {
    // 在JAVA中就有专门用来使用IP的方法，java.net.InetAddress,用来得到客户的IP地址
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("Zachary-Huang");
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
    }
}
