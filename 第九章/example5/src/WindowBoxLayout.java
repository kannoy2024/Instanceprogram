import javax.swing.*;

public class WindowBoxLayout extends JFrame{
    Box BoxH;
    Box BoxVOne;
    Box BoxVTwo;
    public WindowBoxLayout(){
        setLayout(new java.awt.FlowLayout());
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        BoxH = Box.createHorizontalBox();
        BoxVOne = Box.createVerticalBox();
        BoxVTwo = Box.createVerticalBox();
        BoxVOne.add(new JLabel("Name"));
        BoxVOne.add(new JLabel("career"));
        BoxVTwo.add(new JTextField(10));
        BoxVTwo.add(new JTextField(10));
        BoxH.add(BoxVOne);
        BoxH.add(Box.createHorizontalStrut(10));
        BoxH.add(BoxVTwo);
        add(BoxH);
    }
}
