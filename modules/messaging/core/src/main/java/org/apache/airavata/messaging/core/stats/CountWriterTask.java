package org.apache.airavata.messaging.core.stats;

import java.io.*;
import java.util.List;
import java.util.TimerTask;

public class CountWriterTask extends TimerTask {

    private File file;
    private FileOutputStream fos;
    private BufferedWriter bw;

    public void setFile(File file) {
        this.file = file;

    }

    @Override
    public void run() {
        try {
            StatCounter statCounter = StatCounter.getInstance();
            List<Long> contPer10S = statCounter.getMessageContPer10S();
            fos = new FileOutputStream(file, false);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (int i = 0; i < contPer10S.size(); i++) {
                bw.write(String.valueOf(i+1) + " :" + String.valueOf(contPer10S.get(i)));
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
