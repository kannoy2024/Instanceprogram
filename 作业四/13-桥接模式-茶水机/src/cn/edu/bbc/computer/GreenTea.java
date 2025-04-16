/*=================================================*/
/* This is a subclass to implement interface       */
/* TeaKind. The TeaKind class hierarchy represents */
/* the implementation part of the bridge pattern   */
/*=================================================*/
package cn.edu.bbc.computer;

//杯型桥接茶品，和茶品桥接杯型的互换
public class GreenTea implements TeaKind{

   private TeaSize TeaSize;

   public GreenTea(TeaSize tSize){
      TeaSize = tSize;
   }

   public float getPrice(){
      float teaPrice = TeaSize.getSize() * 2.0f;
      return teaPrice;
   }
}
