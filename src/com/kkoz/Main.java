package com.kkoz;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;

public class Main {

    public static final int port = 1234; // Порт
    public static final int period = 5000; // Период между отправками

    public static void main(String[] args) {

        PhraseRepository.readFile();

        try {
            ServerSocket server = new ServerSocket(port);
            Timer timer = new Timer();
            while (true) {
                Socket socket = server.accept();
                try {
                    timer.schedule(new Connection(socket), 0, period);
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
