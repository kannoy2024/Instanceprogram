package com.itheima.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 工具类，IO流拷贝
 */
public class IOUtil {
    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
    }
}
