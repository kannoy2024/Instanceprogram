package ch01_simplefactory.firstcouple;


public class Operation {
    public static double getResult(double numberA, double numberB, String operate) {
        double result = 0;
        switch (operate) {
            case "+":
                result = numberA + numberB;
                break;
            case "-":
                result = numberA - numberB;
                break;
            case "*":
                result = numberA * numberB;
                break;
            case "/":
                if (numberB != 0)
                    result = numberA / numberB;
                else
                    System.out.println("除数不能为0！");
                break;
            case "%":
                result = numberA % numberB;
                break;
                default:
                    System.out.println("输入有误");
        }
        return result;
    }

}