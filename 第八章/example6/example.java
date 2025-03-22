package example6;

public class example {
    public static void main(String[] args) {
        byte d[]="Java还是好玩的,要好好学习天天向上".getBytes();
        System.out.println("数组b的长度:"+d.length);
        String hao = new String(d,6,2);
        System.out.println(hao);
        // System.out.println("数组b的第6位到第8位:"+hao);
        String javaN1= new String(d,0,6);
        System.out.println(javaN1);
    }
}
