package org.example.zab;

import jdk.jshell.spi.ExecutionControl;

public abstract class MessageQueue<T> {

    public  abstract void send(T message);
    public abstract  T get();

}
