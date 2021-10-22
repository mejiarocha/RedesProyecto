package proxy;

import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppJava {

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    Cliente.handleClient(client);
                } catch (BindException e) {
                    // e.printStackTrace();
                }
            }
        }
    }

}