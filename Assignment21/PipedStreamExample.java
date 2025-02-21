package Bridgelabz_2113100011.Assignment21;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes()); // Writing data to pipe
            pos.close(); // Close the stream after writing
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data); // Reading data from pipe
            }
            pis.close(); // Close the stream after reading
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect streams

            // Create and start threads
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            // Wait for threads to finish
            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

