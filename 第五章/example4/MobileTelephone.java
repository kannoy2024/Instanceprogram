package example4;

public class MobileTelephone {
    private SIM sim;
    public void UseSIM(SIM sim) {
        this.sim = sim;
    }
    public void show() {
        System.out.println("手机卡号：" + sim.GetNumber());
        System.out.println("手机卡所属公司：" + sim.GetCorpName());
    }
}
