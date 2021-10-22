package proxy;

import java.io.BufferedReader;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Cliente {

    public static void handleClient(Socket clienteNavegador) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(clienteNavegador.getInputStream()));
        StringBuilder requestBuilder = new StringBuilder();

        Socket clienteHablaInternet = clienteNavegador;
        Map<Socket, Cliente> solicitud;
        // clienteHablaInternet.getOutputStream(clienteNavegador.getInputStream());
        Socket socketReciveInternet;
        // c

        // if(solicitud.containsKey(clienteHablaInternet))

        String line;
        while (!(line = br.readLine()).isBlank()) {
            requestBuilder.append(line + "\r\n");
        }
        String request = requestBuilder.toString();
        System.out.println(request);
    }
    /*
     * String request = requestBuilder.toString(); String[] requestsLines =
     * request.split("\r\n"); String[] requestLine = requestsLines[0].split(" ");
     * String method = requestLine[0]; String path = requestLine[1]; String version
     * = requestLine[2]; String host = requestsLines[1].split(" ")[1];
     * 
     * List<String> headers = new ArrayList<>(); for (int h = 2; h <
     * requestsLines.length; h++) { String header = requestsLines[h];
     * headers.add(header); }
     * 
     * String accessLog = String.
     * format("Client %s, method %s, path %s, version %s, host %s, headers %s",
     * client.toString(), method, path, version, host, headers.toString());
     * System.out.println(accessLog);
     * 
     * Path filePath = getFilePath(path); if (Files.exists(filePath)) { // file
     * exist String contentType = guessContentType(filePath); sendResponse(client,
     * "200 OK", contentType, Files.readAllBytes(filePath)); } else { // 404 byte[]
     * notFoundContent = "<h1>Not found :(</h1>".getBytes(); sendResponse(client,
     * "404 Not Found", "text/html", notFoundContent); }
     * 
     * }
     * 
     * private static void sendResponse(Socket client, String status, String
     * contentType, byte[] content) throws IOException { OutputStream clientOutput =
     * client.getOutputStream(); clientOutput.write(("HTTP/1.1 \r\n" +
     * status).getBytes()); clientOutput.write(("ContentType: " + contentType +
     * "\r\n").getBytes()); clientOutput.write("\r\n".getBytes());
     * clientOutput.write(content); clientOutput.write("\r\n\r\n".getBytes());
     * clientOutput.flush(); client.close(); }
     * 
     * private static Path getFilePath(String path) { if ("/".equals(path)) { path =
     * "/index.html"; }
     * 
     * return Paths.get("/tmp/www", path); }
     * 
     * private static String guessContentType(Path filePath) throws IOException {
     * return Files.probeContentType(filePath); }
     */
}
