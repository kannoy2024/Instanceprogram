package example7;

public class EncryptAndDecrypt {
    String encrypt(String sourceString,String password) {
            char []p = password.toCharArray();
            int n= p.length;
            char []c = sourceString.toCharArray();
            int m = c.length;
            for(int i=0;i<m;i++){
                int mima = (int)p[i%n];
                c[i]=(char)(c[i]^mima);
            }
            return new String(c);
        }
        String decrypt(String sourceString,String password){
            char []p = password.toCharArray();
            int n=p.length;
            char []c=sourceString.toCharArray();
            int m = c.length;
            for(int i=0;i<m;i++){
                int mima = (int)p[i%n];
                c[i]=(char)(c[i]^mima);
            }
            return new String(c);
        }
}
