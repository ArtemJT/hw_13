package ua.hillel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {

    private final Map<String, List<FileData>> filesMap = new HashMap<>();

    public void add(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("There is no file or directory: " + "'" + path + "'");
        }
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            String filePath = listFile.getParent();
            if (!listFile.isDirectory() && !filePath.equals(path)) {
                addFileToList(listFile);
            }
        }
    }

    public List<FileData> find(String path) {
        return filesMap.get(replaceSlashes(path));
    }


    public List<FileData> filterBySize(long maxValue) {
        return filesMap.values().stream()
                .flatMap(Collection::stream)
                .filter(elem -> elem.getFileSize() < maxValue)
                .collect(Collectors.toList());
    }

    public void remove(String path) {
        filesMap.remove(replaceSlashes(path));
    }

    public List<FileData> sortBySize() {
        return filesMap.values().stream()
                .flatMap(Collection::stream)
                .sorted(new FileDataBySizeComparator())
                .collect(Collectors.toList());
    }

    public String filesMapToString() {
        StringBuilder builder = new StringBuilder("filesMap:\n");
        for (Map.Entry<String, List<FileData>> entry : filesMap.entrySet()) {
            builder.append(entry.getKey()).append("=").append("values:");
            for (FileData fileData : entry.getValue()) {
                builder.append(fileData).append(";");
            }
            builder.append('\n');
        }
        return builder.toString().trim();
    }

    private void addFileToList(File file) {
        if (filesMap.containsKey(file.getParent())) {
            filesMap.get(file.getParent()).add(new FileData(file));
        } else {
            List<FileData> tmpList = new ArrayList<>();
            tmpList.add(new FileData(file));
            filesMap.put(file.getParent(), tmpList);
        }
    }

    private String replaceSlashes(String path) {
        return path.contains("/") ? path.replaceAll("/", "\\\\") : path;
    }
}
