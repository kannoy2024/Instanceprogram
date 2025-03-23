import javax.swing.JFrame;
import java.awt.*;
public class example1 {
    public static void main(String[] args) {
        JFrame windows1 = new JFrame("第一个窗口");
        JFrame windows2 = new JFrame("第二个窗口");
        Container container1 = windows1.getContentPane();
        container1.setBackground(Color.red);//Set the background color of the window to red
        windows1.setBounds(60,100,288,308);
        windows2.setBounds(260, 100, 288, 308);
        windows1.setVisible(true);
        windows1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        windows2.setVisible(true);
        windows2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
