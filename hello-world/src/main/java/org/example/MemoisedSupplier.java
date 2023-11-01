package org.example;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class MemoisedSupplier<T> implements Supplier<T> {
    private Supplier<T> wrapped;
    private AtomicReference<T> reference;
    public MemoisedSupplier(Supplier<T> wrapped) {
        this.wrapped =  wrapped;
        this.reference = new AtomicReference<T>();
    }
    @Override
    public synchronized T get() {
        T oldValue = reference.get();
       if (reference.get()==null) {
           T t = wrapped.get();
           reference.set(t);
       }
       return reference.get();
    }


    public static void main(String[] args) {
           MemoisedSupplier<Integer> supplier = new MemoisedSupplier<>(()->{
               System.out.println("Supplier Called");
               return 1000;
           });
           Integer i = supplier.get();
           System.out.println(i);
           System.out.println(i);
           System.out.println(i);
           System.out.println(i);
           System.out.println(i);
    }
}
