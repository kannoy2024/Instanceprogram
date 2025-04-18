package simplefactory;

public interface AutoInsurance {//针对接口原则
   abstract String getInsurInfo();
}//凡是支持接口的尽量使用接口。计算属性没有公共属性的才使用接口。
//负责制造对象的，就是工厂