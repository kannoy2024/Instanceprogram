/*=================================================*/
/* This is a subclass to implement interface       */
/* TeaKind. The TeaKind class hierarchy represents */
/* the implementation part of the bridge pattern   */
/*=================================================*/
package cn.edu.bbc.computer;

//杯型桥接茶品，和茶品桥接杯型的互换
public class RedTea implements TeaKind{

    private TeaSize tSize;

    RedTea(TeaSize tSize){
      this.tSize = tSize;
    }
    public float getPrice(){
      float teaPrice = tSize.getSize() * 3.0f;
      return teaPrice;
    }

  
}
