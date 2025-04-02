package example3;

public class EncryptAndDecrypt {
    String encrypt(String sourceString,String key) {
        char []p =key.toCharArray();
        int n = p.length;
        char []c = sourceString.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ p[i % n]);
        }
        return new String(c);// 返回加密后的字符串
    }

    String decrypt(String sourceString,String key) {
        char []p =key.toCharArray();
        int n = p.length;
        char []c = sourceString.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ p[i % n]);
        }
        return new String(c);// 返回解密后的字符串
    }
}
