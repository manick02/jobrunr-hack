package org.example.atl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class File {
    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public Set<String> getCollections() {
        return this.collections;
    }

    private String fileName;
    private int fileSize;

    private Set<String> collections;

    public File(String fileName, int fileSize, Set<String> collections) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.collections = collections;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", collections=" + collections +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return fileSize == file.fileSize && Objects.equals(fileName, file.fileName) && Objects.equals(collections, file.collections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, fileSize, collections);
    }
}
