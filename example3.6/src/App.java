public class App {
    public static void main(String[] args) throws Exception {
        double sum = 0,item = 1;
        int i = 1, n = 20;
        while(i<=n){
            sum += item;
            i += 1;
            item = item * (1.0/i);
        }
        System.out.println("sum=" + sum);  
    }
}
