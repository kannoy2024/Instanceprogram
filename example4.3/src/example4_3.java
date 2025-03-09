public class example4_3 {
public static void main(String[] args) {
    SIM sim = new SIM(19978915074L);
    MobileTelephone telephone = new MobileTelephone();
    telephone.setSIM(sim);
    System.out.println(telephone.lookNumber());
    SIM sim2 = new SIM(19978915075L);
    telephone.setSIM(sim2);
    System.out.println(telephone.lookNumber());
}
}
