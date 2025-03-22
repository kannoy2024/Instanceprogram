package example5;

public class example5 {
    public static void main(String[] args) {
        char []a;
        char []b;
        String s="hello world ssdadwdwdzsdwedadsdwd";
        a = new char[4];//将String对象的子串存放到到数组a中
        s.getChars(11,15 , a, 0);//11,15表示子串的起始位置和结束位置，a表示存放子串的数组，0表示数组a的起始位置
        System.out.println(a);
        b = "今天学习常用类的内容".toCharArray();//可以将String对象的全部内容转换为char数组
        for(int i=0;i<b.length;i++){
            System.out.print("      "+b[i]);
        }
    }
}
