public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("求1000以内的完数");
        for(int i = 1; i <= 1000; i++){
            if(perfectnumber(i)){
                System.out.println(i);

            }
        }
    }
    public static boolean perfectnumber(int n){
        int sum=0;
        for(int i = 1; i < n/2; i++){
            if(n % i == 0){//因子，可以整除就是因子
                sum += i;
            }
        }
        return sum == n;
    }
}
