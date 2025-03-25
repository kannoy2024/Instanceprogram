import java.awt.event.*;;
public class ComputerListener implements ActionListener {
    NumberView view;
    String operator;
    public void setView(NumberView view) {
        this.view = view;
    }
    public void setOperationSymbol(String operator){
        this.operator = operator;
    }
    public void actionPerformed(ActionEvent e){
        try {
            double number1=
            Double.parseDouble(view.inputNumber1.getText());
            double number2=
            Double.parseDouble(view.inputNumber2.getText());
            double result = 0;
            boolean isShow=true;
            if(operator.equals("+")){
                result = number1+number2;
            }else if(operator.equals("-")){
                result = number1-number2;
            }else if(operator.equals("*")){
                result = number1*number2;
            }else if(operator.equals("/")){
                if(number2==0){
                    isShow=false;
                }else{
                    result = number1/number2;
                }
            }else{
                isShow=false;
            }
            if(isShow){
                view.output.append(
                    number1+" "+operator+" "+number2+" = "+result+"\n"
                );
            }
        } catch (Exception exp) {
            view.output.append("妈的你输入错误了，要数字字符");
        }
    }
}
