package org.example.lsm;

import java.util.Iterator;

public class UniqueSortedIterator<T extends Comparable<T>> implements Iterator<T> {
    private T last;
    private Iterator<T> iterator;
    public UniqueSortedIterator(Iterator<T> iterator) {
         last = iterator.next();
         this.iterator = iterator;
    }
    @Override
    public boolean hasNext() {
        return last!=null;
    }

    @Override
    public T next() {
        T next = iterator.next();
        while(next!=null&&last.compareTo(next)==0)
            next = iterator.next();

        T toReturn = last;
        last = next;
        return toReturn;
    }
}
