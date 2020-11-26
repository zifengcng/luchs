package com.luchs.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author cheng
 * @Date 2020/9/11
 */
public class TestFile {

    public static void main(String[] args) {
        try {
            File file = new File("D:\\test\\a.txt");
            try (FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(new File("D:\\test\\a1.txt"))) {
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
