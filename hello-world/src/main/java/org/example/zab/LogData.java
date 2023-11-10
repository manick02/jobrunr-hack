package org.example.zab;

public class LogData {
    private final long id;

    public int getType() {
        return type;
    }

    public byte[] getPayload() {
        return payload;
    }

    private int type;
    private byte[] payload;

    public LogData(long id, byte[] payload, int type) {
        this.id = id;
        this.payload = payload;
        this.type = type;
    }


    public long getId() {
        return id;
    }
}
