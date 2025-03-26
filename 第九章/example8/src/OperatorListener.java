// 导入 AWT 事件包，用于处理 ItemListener 和 ActionListener 接口相关的事件
import java.awt.event.*;

// 定义一个名为 OperatorListener 的类，该类实现了 ItemListener 和 ActionListener 接口
public class OperatorListener implements ItemListener, ActionListener {
    // 定义一个 NumberView 类型的成员变量 numberView，用于与界面交互
    NumberView numberView;

    // 定义一个方法 setView，用于设置 NumberView 对象
    public void setView(NumberView view) {
        numberView = view; // 将传入的 view 对象赋值给类的成员变量 numberView
    }

    // 实现 ItemListener 接口的 itemStateChanged 方法，用于处理下拉框选择项变化事件
    public void itemStateChanged(ItemEvent e) {
        // 获取下拉框 selectOperationSymbol 当前选择的操作符，先选取被选中的符号，再选取字符串的内容
        String operator = numberView.selectOperationSymbol.getSelectedItem().toString();

        // 调用 ComputerListener 的 setOperationSymbol 方法，将操作符传递给 ComputerListener
        numberView.computerListener.setOperationSymbol(operator);
    }

    // 实现 ActionListener 接口的 actionPerformed 方法，用于处理按钮点击事件
    public void actionPerformed(ActionEvent e) {
        // 获取下拉框 selectOperationSymbol 当前选择的操作符
        String operator = numberView.selectOperationSymbol.getSelectedItem().toString();

        // 调用 ComputerListener 的 setOperationSymbol 方法，将操作符传递给 ComputerListener
        numberView.computerListener.setOperationSymbol(operator);
    }
}