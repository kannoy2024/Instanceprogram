/*=================================================*/
/* This is a subclass to implement interface       */
/* TeaSize                                         */
/* a) This class keeps a reference tk of TeaKind   */
/* b) An object of TeaKind is passed through the   */
/*    parameter                                    */
/* c) This tk is used to call the price method in  */
/*    class hierarchy TeaKind                      */
/*=================================================*/
package cn.edu.bbc.computer;

//杯型桥接茶品，和茶品桥接杯型的互换
public class MediumCup implements TeaSize{

   private final float size = 1.0f;


   public float getSize(){
      return size;
   }
}
