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
    public  T get() {
        T oldValue = reference.get();
       if (oldValue == null) {
          synchronized (this) {
              T t = wrapped.get();
              if (reference.compareAndSet(null, t)){
               System.out.println("if this line is printed more than once then race condition is not handled");
              }
          }
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
