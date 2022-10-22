package ua.hillel;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String path1 = "./resources";
        String path2 = "./resources/test.dir";
        String path3 = "./resources/test.dir2";
        String errPath = "./resources/non-existent";

        FileNavigator fileNavigator = new FileNavigator();

        try{
            fileNavigator.add(path1);
            fileNavigator.add(path2);
            fileNavigator.add(path3);
            fileNavigator.add(errPath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------");
        System.out.println(fileNavigator.filesMapToString());
        System.out.println("-----------------");

        System.out.println("fileNavigator.find(path2):");
        System.out.println(fileNavigator.find(path2));
        System.out.println("-----------------");

        System.out.println("fileNavigator.filterBySize(20):");
        System.out.println(fileNavigator.filterBySize(10));
        System.out.println("-----------------");

        System.out.println("remove(path3)");
        fileNavigator.remove(path3);
        System.out.println("-----------------");

        System.out.println("fileNavigator.sortBySize():\n");
        fileNavigator.sortBySize().forEach(System.out::println);
        System.out.println("-----------------");

        System.out.println(fileNavigator.filesMapToString());
        System.out.println("-----------------");
    }
}