public class MobileTelephone {
SIM sim;
void setSIM(SIM sim){
    this.sim=sim;
}
long lookNumber(){
    return sim.getNumber();
}
}
