package ua.hillel;

import java.util.Comparator;

public class MyComparator implements Comparator<FileData> {
    @Override
    public int compare(FileData o1, FileData o2) {
        return Long.compare(o1.getFileSize(), o2.getFileSize());
    }
}
