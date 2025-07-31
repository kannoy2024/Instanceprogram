package work4;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入生日（YYYY-MM-DD）：");
        String birthday = sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(birthday);
            long time = date.getTime();
            Date date1 = new Date();
            long endtime = date1.getTime();
            System.out.println("年龄是" + (endtime - time) / 1000 / 60 / 60 / 24 / 365);
            System.out.println("来到世界："+(endtime - time) / 1000 / 60 / 60 / 24+"天");
        } catch (ParseException e) {
            System.out.println("日期格式错误，请输入正确的日期格式（YYYY-MM-DD）");
        }
        
        sc.close();
    }
}