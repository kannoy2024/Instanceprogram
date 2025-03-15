package example4;

public class Application {
    public static void main(String[] args) {
        MobileTelephone mobileTelephone = new MobileTelephone();
        SIM sim = new SIMOfChinaMobile();
        sim.SetNumber("123456789");
        mobileTelephone.UseSIM(sim);
        mobileTelephone.show();
        sim = new SIMOfChinaUnicom();
        sim.SetNumber("987654321");
        mobileTelephone.UseSIM(sim);
        mobileTelephone.show();
    }
}
