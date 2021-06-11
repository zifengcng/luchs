package com.luchs.java.nio;

import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author cheng
 * @Date 2021/5/14
 */
public class FileNioCopyDemo {

    public static void main(String[] args) {
        nioCopyResourceFile();
    }

    private static void nioCopyResourceFile() {
        String srcPath = "D:\\BaiduNetdiskDownload\\Tale.of.Immortal.Early.Access.v0.8.2024.Steam\\Snipaste_2021-05-08_09-32-20.png";
        String destPath = "D:\\BaiduNetdiskDownload\\martialArt.png";
        nioCopyFile(srcPath, destPath);
    }

    private static void nioCopyFile(String srcPath, String destPath) {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        if (!destFile.exists()) {
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            int len = 0;
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while ((len = inChannel.read(buf)) != -1) {
                buf.flip();

                int outLen;
               while((outLen = outChannel.write(buf)) != 0) {
                   System.out.println("写入字节数：" + outLen);
               }

               buf.clear();
            }
            outChannel.force(true);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outChannel.close();
                fos.close();
                inChannel.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
