import java.awt.*;
import javax.swing.*;
public class windowTriangleView extends JFrame{
    Triangle triangle;
    JTextArea showArea;
    JTextField sideA,sideB,sideC;
    JButton button;
    controller controller;

    public windowTriangleView(){
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void init() {
        setLayout(new BorderLayout());
    
        triangle = new Triangle();
        sideA = new JTextField(5);
        sideB = new JTextField(5);
        sideC = new JTextField(5);
        showArea = new JTextArea();
        showArea.setFont(new Font("宋体", Font.PLAIN, 16)); // 调整字体大小
    
        button = new JButton("计算");
        JPanel panel = new JPanel();
        JLabel hintA = new JLabel("边长a");
        JLabel hintB = new JLabel("边长b");
        JLabel hintC = new JLabel("边长c");
    
        panel.add(hintA);
        panel.add(sideA);
        panel.add(hintB);
        panel.add(sideB);
        panel.add(hintC);
        panel.add(sideC);
        panel.add(button);
    
        controller = new controller();
        controller.setView(this);
    
        button.addActionListener(controller);
        add(panel, BorderLayout.NORTH); // 将输入面板放在顶部
    
        JScrollPane scrollPane = new JScrollPane(showArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER); // 将显示区域放在中间
    
        setSize(600, 400); // 设置窗口大小
        setMinimumSize(new Dimension(400, 300)); // 设置窗口最小尺寸
    }
}
