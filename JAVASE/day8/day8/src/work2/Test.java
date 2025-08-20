package work2;

import LambdaDemo.ShowHandler;

public class Test {
    public static void main(String[] args) {
        // useShowHandler(new ShowHandler() {
        //     @Override
        //     public void show() {
        //         System.out.println("hello world");
        //     }
        // });

        useShowHandler(()->System.out.println("hello world"));
    }

    /**
     * 
     * @param showHandler
     */
    public static void useShowHandler(ShowHandler showHandler) {
        showHandler.show();
    }
}
