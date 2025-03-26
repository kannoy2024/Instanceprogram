// 导入 AWT 事件包，用于处理 ActionListener 接口相关的事件
import java.awt.event.*; 

// 定义一个名为 ComputerListener 的类，该类实现了 ActionListener 接口
public class ComputerListener implements ActionListener {
    // 定义一个 NumberView 类型的成员变量 view，用于与界面交互
    NumberView view;

    // 定义一个字符串类型的成员变量 operator，用于存储用户选择的操作符（如 +、-、*、/）
    String operator;

    // 定义一个方法 setView，用于设置 NumberView 对象
    public void setView(NumberView view) {
        this.view = view; // 将传入的 view 对象赋值给类的成员变量 view
    }

    // 定义一个方法 setOperationSymbol，用于设置操作符
    public void setOperationSymbol(String operator){
        this.operator = operator; // 将传入的操作符赋值给类的成员变量 operator
    }

    // 实现 ActionListener 接口的 actionPerformed 方法，用于处理按钮点击事件
    public void actionPerformed(ActionEvent e){
        try {
            // 获取输入框 inputNumber1 中的文本，并将其转换为 double 类型
            double number1 = Double.parseDouble(view.inputNumber1.getText());
            
            // 获取输入框 inputNumber2 中的文本，并将其转换为 double 类型
            double number2 = Double.parseDouble(view.inputNumber2.getText());

            // 定义一个 double 类型的变量 result，用于存储计算结果
            double result = 0;

            // 定义一个布尔类型的变量 isShow，用于判断是否显示结果
            boolean isShow = true;

            // 根据操作符执行不同的运算
            if (operator.equals("+")) { // 如果操作符是 "+"
                result = number1 + number2; // 执行加法运算
            } else if (operator.equals("-")) { // 如果操作符是 "-"
                result = number1 - number2; // 执行减法运算
            } else if (operator.equals("*")) { // 如果操作符是 "*"
                result = number1 * number2; // 执行乘法运算
            } else if (operator.equals("/")) { // 如果操作符是 "/"
                if (number2 == 0) { // 检查除数是否为 0
                    isShow = false; // 如果除数为 0，则不显示结果
                } else {
                    result = number1 / number2; // 执行除法运算
                }
            } else {
                isShow = false; // 如果操作符非法，则不显示结果
            }

            // 如果 isShow 为 true，则将计算结果显示在输出区域
            if (isShow) {
                view.output.append(number1 + " " + operator + " " + number2 + " = " + result + "\n");
            }
        } catch (Exception exp) { // 捕获异常（如输入非数字字符）
            // 如果发生异常，提示用户输入错误
            view.output.append("妈的你输入错误了，要数字字符\n");
        }
    }
}