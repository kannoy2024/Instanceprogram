public class Example1 {
    public static void main(String[] args) {
        RedCowFarm redCowFarm=new RedCowFarm("红牛养殖场");
        redCowFarm.showCow();//主函数生成的对象调用外嵌函数的方法
        redCowFarm.cow.speak();//主函数生成的对象调用外嵌类生成的内嵌类的对象，以此调用内嵌类的方法
    }
}
