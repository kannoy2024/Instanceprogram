package example11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//模式匹配的使用
public class example11 {
    public static void main(String[] args) {
        String dataSource ="长途77.6,市内13.9,国际966.2";
        String regex = "-?[1-9][0-9]*[.]?[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dataSource);
        double sum = 0;
        while (matcher.find()){
            sum += Double.parseDouble(matcher.group());
        }
        System.out.println("sum="+sum);
     }
}
