package example2;

import java.io.RandomAccessFile;

public class example3 {
    public static void main(String[] args) {
        RandomAccessFile INANDOUT= null;
        int data[] = {1,2,3,4,5,6,7,8,9,10};
        try {
            INANDOUT = new RandomAccessFile("./INANDOUT.txt","rw");
            for (int i = 0; i < data.length; i++) {
                INANDOUT.writeInt(data[i]);
            }
            for (long i=data.length-1;i>=0;i--){
                INANDOUT.seek(i*4);
                System.out.println(INANDOUT.readInt());
            }
            INANDOUT.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//使用传统的输入流和输出流，在输入和输出文件之前就要对文件建立对应的流，
//随机流对象RandomAccessFile，可以以读写方式打开一个文件，并指定一个位置，
//然后就可以从该位置开始读写文件。
