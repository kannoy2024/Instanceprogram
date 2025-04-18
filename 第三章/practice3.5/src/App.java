public class App {
    public static void main(String[] args) throws Exception {
        int sum = 0,z=0;
        for(int i=0;i<15;i++){
            z = z * 10 + 8;//0+8=8,80+8=88,880+8=888,8880+8=8888,88888+8=88888
            sum += z;
        }
        System.out.println(sum);
    }
}
