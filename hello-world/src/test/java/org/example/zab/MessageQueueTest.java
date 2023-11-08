package org.example.zab;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageQueueTest {

    class MessageTuple {
        MessageTuple() {

        }
    }
    @Test
    public void sendAndReceive() {
        MessageQueue<MessageTuple> messageQueue = new MessageQueueImpl<>();
        MessageTuple object = new MessageTuple();
        messageQueue.send(object);
        MessageTuple receiveObject = messageQueue.get();
        assertTrue(object.equals(receiveObject));
    }
}