import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowView extends JFrame {
    private static final String FONT_NAME = "微软雅黑"; // 使用支持中文的字体
    private static final int FONT_SIZE_BOLD = 20;
    private static final int FONT_SIZE_NORMAL = 15;

    public JTextField inputText;
    public JButton button;
    public JTextArea textArea;
    private PoliceListener listener;

    public WindowView() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        setLayout(new FlowLayout());// 使用FlowLayout布局
        Font font = new Font(FONT_NAME, Font.BOLD, FONT_SIZE_BOLD);// 设置字体
        inputText = new JTextField(20);// 输入框
        inputText.setFont(font);
        button = new JButton("确定"); // 将按钮文本改为中文
        button.setFont(font);
        font = new Font(FONT_NAME, Font.BOLD, FONT_SIZE_NORMAL);
        textArea = new JTextArea(10, 20);// 输出框
        textArea.setFont(font);
        listener = new PoliceListener();
        listener.setView(this);
        inputText.addActionListener(listener);
        button.addActionListener(listener);
        add(inputText);
        add(button);
        add(new JScrollPane(textArea));
    }
}