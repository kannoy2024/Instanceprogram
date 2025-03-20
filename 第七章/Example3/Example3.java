public class Example3 {
    public static void main(String[] args) {
        CargoBoat shipBoat=new CargoBoat();
        shipBoat.setMaxContent(1000);
        int m = 0 ;
        try{
            m=600;
            shipBoat.loading(m);
            m=400;
            shipBoat.loading(m);
            m=500;  
            shipBoat.loading(m);

        }catch(DangerException e){
            System.out.println(e.warnMess());
            System.out.println("无法继续装载重量是"+m+"的集装箱");
            try{
                shipBoat.loading(-m);
            }catch(DangerException e1){
                System.exit(0);;
            }

        }
        finally{
            System.out.println("装载完成");
            System.out.println("目前装载了"+shipBoat.realContent+"的货物");
        }
    }
}
