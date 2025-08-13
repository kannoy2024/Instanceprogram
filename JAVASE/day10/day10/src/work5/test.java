package work5;

import java.io.File;

public class test {
    public static void main(String[] args) {
        String path = "H:\\私人物品\\家乡\\本子\\SOS3199_127_GNdXgxsboAAPYQ0.jpg";

        getJAVAFile(new File(path));

        // 使用简单的递归思想来实现寻找java文件
    }

    public static void getJAVAFile(File file) {
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isFile()) {
                if (f.getName().endsWith(".java")) {
                    System.out.println(f.getName());
                }
            } else {
                getJAVAFile(f);
            }
        }
    }
}
