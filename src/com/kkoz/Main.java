package com.kkoz;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;

public class Main {

    public static final int PORT = 1234;

    public static void main(String[] args) {

        PhraseRepository.readFile();

        try {
            ServerSocket server = new ServerSocket(PORT);
            Timer timer = new Timer();
            while (true) {
                Socket socket = server.accept();
                try {
                    timer.schedule(new Connection(socket), 0, 5000);
                } catch (Exception e) {
                    socket.close();
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
