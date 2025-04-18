public class App {
    public static void main(String[] args) throws Exception {
    // double sum = 0,item= 1;
    // int i=1,n=20;
    // do{
    //     item = item * (1.0/i);
    //     sum = sum + item;
    //     i++;    
    // }while(i<=n);
    // System.out.println(sum);
    double sum = 0,item= 1;
    int i=1,n=20;
    for(;i<=n;i++){
        item = item * (1.0/i);
        sum = sum + item;
    }
    System.out.println(sum);
    }
}
