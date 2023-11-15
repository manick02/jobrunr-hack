package org.example.zab;

import java.io.*;

public class SimpleLog {

    private final DataOutputStream output;
    private File log;
    private FileOutputStream fos;

    public SimpleLog(File log) throws FileNotFoundException {
        this.log = log;
        this.fos = new FileOutputStream(log);
        this.output = new DataOutputStream(new BufferedOutputStream(this.fos));
    }

    public void append(LogData data) throws IOException {

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dao = new DataOutputStream(byteArrayOutputStream);
            dao.writeLong(data.getId());
            dao.write(data.getType());
            dao.write(data.getPayload());
            dao.flush();
            byte[] log = byteArrayOutputStream.toByteArray();
            this.output.writeInt(4); // checksum
            this.output.write(log);
            this.output.flush();
        } catch(IOException e) {
            this.output.close();
        }
    }

    public void close() throws IOException {
        this.output.close();
    }
}
