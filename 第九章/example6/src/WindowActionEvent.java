// 导入必要的包和类
import java.awt.FlowLayout; // 导入 FlowLayout 布局管理器，用于设置窗口布局
import java.awt.event.ActionListener; // 导入 ActionListener 接口，用于处理事件

import javax.swing.JFrame; // 导入 JFrame 类，用于创建窗口
// import javax.swing.JTextArea; // 未使用的导入，可以删除
import javax.swing.JTextField; // 导入 JTextField 类，用于创建文本框

public class WindowActionEvent extends JFrame { // 定义一个继承自 JFrame 的类 WindowActionEvent
    JTextField textField; // 声明一个 JTextField 对象，用于显示和输入文本
    ActionListener actionListener; // 声明一个 ActionListener 对象，用于监听事件

    public WindowActionEvent() { // 构造方法，初始化窗口组件
        setLayout(new FlowLayout()); // 设置窗口的布局为 FlowLayout（流式布局）
        textField = new JTextField(20); // 创建一个宽度为 20 个字符的文本框
        add(textField); // 将文本框添加到窗口中
        actionListener = new ReaderListener(); // 创建一个 ReaderListener 对象作为事件监听器
        textField.addActionListener(actionListener); // 为文本框添加事件监听器
        setVisible(true); // 设置窗口可见
        setSize(300, 300); // 设置窗口大小为 300x300 像素
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭操作为退出程序
    }
}