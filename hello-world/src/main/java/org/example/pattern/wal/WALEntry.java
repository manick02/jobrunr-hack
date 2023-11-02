package org.example.pattern.wal;

import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class WALEntry {

    private final int recordType;
    private final int length;

    private final long checkSum;
    private final byte[] data;


    public int getRecordType() {
        return recordType;
    }

    public int getLength() {
        return length;
    }

    public long getCheckSum() {
        return checkSum;
    }

    public byte[] getData() {
        return data;
    }

    /**
     * WAL Entry
     * @param recordType
     * @param data
     * @param checkSum
     * @param length
     */
    private WALEntry(int recordType,byte[] data, long checkSum, int length) {
        this.recordType = recordType;
        this.data = data;
        this.checkSum = checkSum;
        this.length = length;
    }
    public static WALEntry createWALEntry(int recordType, byte[] data) {
        Checksum checksum = new CRC32();
        checksum.update(data,0, data.length);
        long value = checksum.getValue();
        return new WALEntry(recordType,data,value,data.length);
    }

    @Override
    public String toString() {
        return "WALEntry{" +
                "recordType=" + recordType +
                ", length=" + length +
                ", checkSum=" + checkSum +
                '}';
    }

    public static void main(String[] args) {
        String s = "Hello World";
        WALEntry walEntry = WALEntry.createWALEntry(1, s.getBytes());
        System.out.println(walEntry);
    }
}
