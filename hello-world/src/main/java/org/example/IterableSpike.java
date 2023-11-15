package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class IterableSpike {
    static class ArrayString implements Iterable<String> {

        private final List<String> stringList;

        public ArrayString(List<String> stringList) {
            this.stringList = stringList;
        }

        @Override
        public Iterator<String> iterator() {
            return new ArrayStringIterator(this.stringList);
        }
    }

   static class ArrayStringIterator implements Iterator<String> {


        private final List<String> stringList;
        private int currentPos = 0;

        public ArrayStringIterator(List<String> stringList) {
            this.stringList = stringList;
        }

        @Override
        public boolean hasNext() {
            return this.currentPos < this.stringList.size();
        }

        @Override
        public String next() {

            if (hasNext()) {
                String element = this.stringList.get(this.currentPos);
                this.currentPos++;
                return element;
            }
            throw new NoSuchElementException();

        }
    }

    public static void main(String[] args) {
        List<String> movies = new LinkedList<>();
        movies.add("TestData");
        movies.add("TestData2");
        ArrayString as = new ArrayString(movies);
        for(String s:as) {
            System.out.println(s);
        }
    }
}
