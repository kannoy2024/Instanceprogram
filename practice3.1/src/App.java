//编写1！+2！+3!....
public class App {
    public static void main(String[] args) throws Exception {
        double sum = 0,item = 1;
        int i =1,z=10;
        while(i<=z){
            item = item*i;
            sum = sum + item;
            i++;
        }
        System.out.println(sum);
    }
}
