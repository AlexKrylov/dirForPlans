package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Creator {
    public void listOfFiles(String fileDirPath) {
        File file = new File(fileDirPath);
        File[] files = file.listFiles();
        List<File> listFile = new ArrayList<>();
        assert files != null;
        for (File file2 : files) {
            String fileExt = getFileExtension(file2.getName().toLowerCase());
            assert fileExt != null;
            if (fileExt.equals(".jpg")) {
                listFile.add(file2);
            }
        }

        for (File file1 : listFile) {
            int pos = file1.getName().indexOf("_");
            String fileName = file1.getName().substring(pos + 1);
            String dirName = file1.getName().substring(0, pos);
            File outDirectory = new File(fileDirPath + "" + dirName);
            outDirectory.mkdir();
            file1.renameTo(new File(outDirectory.getPath(), fileName));
        }
    }

    private static String getFileExtension(String file) {
        int index = file.lastIndexOf('.');
        return index == -1 ? null : file.substring(index);
    }
}
