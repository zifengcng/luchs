package com.luchs.java.io;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;

/**
 * @Author cheng
 * @Date 2021/1/20
 */
public class OpenZipFile {

    public static void main(String[] args) {
        File file = new File("D:\\book\\linux\\linux");
        File[] files = file.listFiles((dir, name) -> name.contains(".zip"));

        for (File f : files) {
            try {
                String passWord = "di201805";
                ZipFile zipFile = new ZipFile(f, passWord.toCharArray());
                List<FileHeader> fileHeaders = zipFile.getFileHeaders();
                for (FileHeader fileHeader : fileHeaders) {
                    String entryFilePath = "D:\\book\\linux\\linux\\test" + File.separator + fileHeader.getFileName();
                    int index = entryFilePath.lastIndexOf(File.separator);
                    String entryDirPath = "";
                    if (index != -1) {
                        entryDirPath = entryFilePath.substring(0, index);
                    }

                    File entryDir = new File(entryDirPath);
                    if (!entryDir.exists()) {
                        entryDir.mkdirs();
                    }

                    File entryFile = new File(entryFilePath);
                    if (fileHeader.isDirectory() && !entryFile.exists()) {
                        entryFile.mkdirs();
                        continue;
                    }

                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(entryFile));
                    BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(fileHeader));

                    int len = 0;
                    byte[] b = new byte[1024];
                    while ((len = bis.read(b, 0, 1024)) != -1) {
                        bos.write(b, 0, len);
                    }

                    bos.flush();
                    bos.close();
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
