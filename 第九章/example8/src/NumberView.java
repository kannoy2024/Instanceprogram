import javax.swing.*;

import java.awt.*;

public class NumberView extends JFrame{
    private static final String FONT_NAME = "微软雅黑";
    private static final int FONT_SIZE_OUT= 20;
    private static final int FONT_SIZE_INT = 50;

    public JTextField inputNumber1;
    public JTextField inputNumber2;
    public JComboBox<String> selectOperationSymbol;
    public JTextArea output;
    public JButton count;
    public OperatorListener operatorListener;
    public ComputerListener computerListener;


    public NumberView(){
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        setLayout(new FlowLayout());

        Font font = new Font(FONT_NAME,Font.PLAIN,FONT_SIZE_INT);

        inputNumber1 = new JTextField(10);
        inputNumber1.setFont(font);
        inputNumber2 = new JTextField(10);
        inputNumber2.setFont(font);

        selectOperationSymbol = new JComboBox<String>();
        selectOperationSymbol.setFont(font);
        selectOperationSymbol.addItem("选择运算符号");

        String [] operationSymbol = {"+","-","*","/"};
        for(String s : operationSymbol){
            selectOperationSymbol.addItem(s);
        }
        selectOperationSymbol.setSelectedItem(-1);//表示没有选择符号

        font = new Font(FONT_NAME,Font.PLAIN,FONT_SIZE_OUT);
        output = new JTextArea(5,20);
        output.setFont(font);

        operatorListener= new OperatorListener();
        computerListener = new ComputerListener();
        operatorListener.setView(this);
        computerListener.setView(this);
        selectOperationSymbol.addActionListener(operatorListener);
        selectOperationSymbol.addItemListener(operatorListener);

        count = new JButton("计算");
        count.setFont(font);
        count.addActionListener(computerListener);
        
        add(inputNumber1);
        add(selectOperationSymbol);
        add(inputNumber2);
        add(count);
        add(output);
    }

    
}
