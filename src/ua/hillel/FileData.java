package ua.hillel;

import java.io.File;

public class FileData {

    private final String filename;
    private final long fileSize;
    private final String filePath;

    public FileData(File file) {
        this.filePath = file.getParent();
        this.filename = file.getName();
        this.fileSize = file.length();
    }

    public String getFilePath() {
        return filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "filePath='" + filePath + '\'' +
                ", filename='" + filename + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
