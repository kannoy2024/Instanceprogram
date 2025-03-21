public class example3 {
    public static void main(String[] args) {
        int m = 7;
        String binaryString = Integer.toBinaryString(m);
        System.out.println(m+"的二进制:");
        System.out.println(binaryString);
        m = -8;
        binaryString = Integer.toBinaryString(m);
        System.out.println(m+"的二进制:");
        System.out.println(binaryString);

        double sum=566.235;
        double item=0;
        boolean computable = true;
        for(String s:args){
            try{
                item = Double.parseDouble(s);
                sum+=item;
            }catch(NumberFormatException e){
                System.out.println("您输入了非数字字符!");
                computable = false;
                break;
            }
        }
        if(computable){
            System.out.println("sum="+sum);
            String numberStr = String.valueOf(sum);
            int dotPosition = numberStr.indexOf('.');
            System.out.println("sum的二进制:"+Integer.toBinaryString(numberStr.hashCode()));
            String integerPartString = numberStr.substring(0,dotPosition);
            String decimalPartString = numberStr.substring(dotPosition+1);
            System.out.println("整数部分"+integerPartString);
            System.out.println("小数部分"+decimalPartString);
        }
    }
}
