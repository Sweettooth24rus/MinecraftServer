package com.kkoz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.TimerTask;

public class Connection extends TimerTask {
    private Socket socket;
    private BufferedWriter outStream;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void run() {
        try {
            outStream.write(PhraseRepository.getPhrase());
            outStream.newLine();
            outStream.flush();
        }
        catch (Exception ignored) {
        }
    }
}