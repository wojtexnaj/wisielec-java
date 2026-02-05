package org.example;

import java.io.File;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class FileManager {
    public void listFilesInDirectory(String directory) {
        filterFiles(directory)
                .map(File::getName)
                .forEach(System.out::println);
    }

    public void sortFilesInDirectory(String directory) {
        filterFiles(directory)
                .sorted((o1, o2) -> Long.compare(o2.length(), o1.length()))
                .forEach(file -> {
                    System.out.println(file.getName());
                    System.out.println(file.length());
                    System.out.println();
                });
    }

    private Stream<File> filterFiles(String directory){
        return Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile);
    }
}
