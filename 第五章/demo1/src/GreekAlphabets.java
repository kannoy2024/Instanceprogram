public class GreekAlphabets {
    public static void main(String[] args) {
        // 希腊字母的Unicode范围从 \u0391 到 \u03C9
        for (int i = 0x0391; i <= 0x03C9; i++) {
            System.out.print((char) i + " ");
        }
    }
}

