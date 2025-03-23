import javax.swing.*;
import java.awt.*;

public class ComponentInWindow extends JFrame {
    JCheckBox checkBox1;
    JCheckBox checkBox2;//check box
    JRadioButton radioButton1;//radio button
    JRadioButton radioButton2;
    ButtonGroup group;
    JComboBox<String>comboBox;//combo box
    public ComponentInWindow(){
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        setLayout(new FlowLayout());
        comboBox = new JComboBox<String>();
        checkBox1 = new JCheckBox("like music");
        checkBox2 = new JCheckBox("likes sports");
        group = new ButtonGroup();
        radioButton1 = new JRadioButton("male");
        radioButton2 = new JRadioButton("female");
        group.add(radioButton1);
        group.add(radioButton2);
        add(checkBox1);
        add(checkBox2);
        add(radioButton1);
        add(radioButton2);
        comboBox.addItem("Chinese");
        comboBox.addItem("English");
        add(comboBox);
    }
}
