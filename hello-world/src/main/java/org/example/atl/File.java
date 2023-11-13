package org.example.atl;

import java.util.List;
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

}
