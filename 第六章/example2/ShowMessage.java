package example2;
public interface ShowMessage {
    void  显示商标 (String s);
    default void outPutStart() {
        System.out.println("**************");
    }
}
