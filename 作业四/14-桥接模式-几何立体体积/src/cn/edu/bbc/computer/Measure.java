/*================================================*/
/* This interface is the interface of the abstract class hierarchy
/* in the bridge design pattern
/*================================================*/
package cn.edu.bbc.computer;



public interface Measure {

   public abstract double findVolume();
   public abstract String convert();
}