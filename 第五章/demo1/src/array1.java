public class array1 {
    
    public static void main(String[] args) {
        //java数组声明不允许在方括号里面指定元素个数
    //可以指定int型变量的值来当数组的元素
    int size=13;
    int [] a=new int[size];//这样就得到了一个变化数组
    //数组索引从零开始
    float b[]=new float[12];
    int c[][]=new int[4][44];
        System.out.println(a.length);
        System.out.println(b.length);
        System.out.println(c.length);

    }
}
