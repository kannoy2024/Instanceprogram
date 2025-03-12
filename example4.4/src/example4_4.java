public class example4_4 {
    public static void main(String[] args) {
        Rational r = new Rational();
      
        r.SetNumerator(2);
        r.SetDenominator(5);
        Rational r2 = new Rational();
     
        r2.SetNumerator(34);
        r2.SetDenominator(122);
        Rational result = r.add(r2);
        int a=result.GetNumerator();
        int b=result.GetDenominator();
        System.out.println("2/5+34/122="+a+"/"+b);
        Rational result2 = r.sub(r2);
        int c=result2.GetNumerator();
        int d=result2.GetDenominator();
        System.out.println("2/5-34/122="+c+"/"+d);
        Rational result3 = r.mul(r2);
        int e=result3.GetNumerator();
        int f=result3.GetDenominator();
        System.out.println("2/5*34/122="+e+"/"+f);
        Rational result4 = r.div(r2);
        int g=result4.GetNumerator();
        int h=result4.GetDenominator();
        System.out.println("(2/5)/(34/122)="+g+"/"+h);
    
    }
}
