// 导入 Swing 和 AWT 包，用于创建图形用户界面
import javax.swing.*;
import java.awt.*;

// 定义一个名为 NumberView 的类，该类继承自 JFrame，用于创建计算器的用户界面
public class NumberView extends JFrame {
    // 定义字体名称常量
    private static final String FONT_NAME = "微软雅黑";
    // 定义输出区域字体大小常量
    private static final int FONT_SIZE_OUT = 20;
    // 定义输入框字体大小常量
    private static final int FONT_SIZE_INT = 30;

    // 定义输入框 inputNumber1 和 inputNumber2，用于接收用户输入的数字
    public JTextField inputNumber1;
    public JTextField inputNumber2;

    // 定义下拉框 selectOperationSymbol，用于选择运算符（如 +、-、*、/）
    public JComboBox<String> selectOperationSymbol;

    // 定义文本区域 output，用于显示计算结果
    public JTextArea output;

    // 定义按钮 count，用于触发计算操作
    public JButton count;

    // 定义两个监听器：operatorListener 和 computerListener
    public OperatorListener operatorListener;
    public ComputerListener computerListener;

    // 构造方法，初始化界面并设置窗口可见
    public NumberView() {
        init(); // 调用 init 方法初始化界面组件
        setVisible(true); // 设置窗口可见
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭操作
    }

    // 初始化方法，用于创建和布局界面组件
    public void init() {
        // 设置布局管理器为 FlowLayout，组件按从左到右、从上到下的顺序排列
        setLayout(new FlowLayout());

        // 创建字体对象，用于设置输入框的字体样式
        Font font = new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_INT);

        // 创建两个输入框 inputNumber1 和 inputNumber2，用于接收用户输入的数字
        inputNumber1 = new JTextField(10); // 输入框宽度为 10 个字符
        inputNumber1.setFont(font); // 设置字体样式
        inputNumber2 = new JTextField(10); // 输入框宽度为 10 个字符
        inputNumber2.setFont(font); // 设置字体样式

        // 创建下拉框 selectOperationSymbol，用于选择运算符
        selectOperationSymbol = new JComboBox<String>(); // 创建下拉框
        selectOperationSymbol.setFont(font); // 设置字体样式
        selectOperationSymbol.addItem("选择运算符号"); // 添加默认提示项

        // 定义支持的运算符数组
        String[] operationSymbol = {"+", "-", "*", "/"};
        //增强for循环
        // for(数据类型 变量名 :遍历的目标){} //数据类型 变量名:声明一个变量用来接收遍历目标遍历后的元素
        for (String s : operationSymbol) { // 遍历数组，将每个运算符添加到下拉框中
            selectOperationSymbol.addItem(s);
        }
        selectOperationSymbol.setSelectedItem(-1); // 设置初始状态为未选择任何符号

        // 创建字体对象，用于设置输出区域和按钮的字体样式
        font = new Font(FONT_NAME, Font.PLAIN, FONT_SIZE_OUT);

        // 创建文本区域 output，用于显示计算结果
        output = new JTextArea(5, 20); // 设置文本区域的行数和列数
        output.setFont(font); // 设置字体样式

        // 创建两个监听器对象，并将当前界面对象传递给它们
        operatorListener = new OperatorListener();
        computerListener = new ComputerListener();
        operatorListener.setView(this); // 将当前界面对象传递给 operatorListener
        computerListener.setView(this); // 将当前界面对象传递给 computerListener

        // 为下拉框添加 ActionListener 和 ItemListener，用于监听运算符选择事件
        selectOperationSymbol.addActionListener(operatorListener);
        selectOperationSymbol.addItemListener(operatorListener);

        // 创建按钮 count，用于触发计算操作
        count = new JButton("计算"); // 按钮文本为 "计算"
        count.setFont(font); // 设置字体样式
        count.addActionListener(computerListener); // 为按钮添加 ActionListener，监听点击事件

        // 将所有组件添加到窗口中
        add(inputNumber1); // 添加输入框 inputNumber1
        add(selectOperationSymbol); // 添加下拉框 selectOperationSymbol
        add(inputNumber2); // 添加输入框 inputNumber2
        add(count); // 添加按钮 count
        add(output); // 添加文本区域 output
    }
}