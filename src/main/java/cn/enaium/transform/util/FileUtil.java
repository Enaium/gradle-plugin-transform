package cn.enaium.transform.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: transform
 * Author: Enaium
 */
public class FileUtil {

    private final ArrayList<File> files;

    public FileUtil() {
        files = new ArrayList<>();
    }

    public static byte[] read(File file) {
        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(File file, byte[] bytes) {
        try {
            Files.write(file.toPath(), bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<File> getFiles(File file) {
        find(file);
        return files;
    }

    private void find(File file) {
        List<File> fileList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }

        for (File f : listFiles) {
            if (f.isFile()) {
                fileList.add(f);
            } else if (f.isDirectory()) {
                find(f.getAbsoluteFile());
            }
        }

        for (File f1 : fileList) {
            files.add(f1.getAbsoluteFile());
        }
    }
}
