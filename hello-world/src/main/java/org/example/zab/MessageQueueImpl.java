package org.example.zab;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueueImpl<T> extends MessageQueue<T>{
    public BlockingQueue<T> queue;
    public MessageQueueImpl() {
        queue = new LinkedBlockingQueue<>();
    }
    @Override
    public void send(T message) {
        queue.add(message);
    }

    @Override
    public T get() {
        return queue.poll();
    }
}
