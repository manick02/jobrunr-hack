package org.example.atl;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class QueryFileCollection {

    private final List<File> files;
    public QueryFileCollection(List<File> files) {
      this.files = files;
    }

    public long getAllFileSize() {
        if (this.files== null || this.files.isEmpty())
             return 0;
        IntSummaryStatistics collect = this.files.stream().collect(Collectors.summarizingInt(x -> x.getFileSize()));
        return collect.getSum();
    }

    public Set<String> getTopNCollectionBySize() {
      //  this.files.stream().flatMap(x->x.getCollections().stream().map(File::getCollections
       // Stream<String> stringStream = this.files.stream().flatMap(x -> x.getCollections().stream()).collect(groupingBy(y-),mapping());
        Map<String,List<File>> map = new HashMap<>();
        return null;
    }

    class FileCollection {

    }
}
