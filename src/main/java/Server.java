import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private InputStream clientIn;
    private OutputStream clientOut;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void connectClient() {
        try {
            clientSocket = serverSocket.accept();
            clientIn = clientSocket.getInputStream();
            clientOut = clientSocket.getOutputStream();

            clientOut.write(Message.clientConnected.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void echoMessage() throws IOException {
        BufferedReader newIn = new BufferedReader(new InputStreamReader(clientIn));
        String input;
            while ((input = newIn.readLine()) != null) {
                clientOut.write(input.getBytes());
            }
    }
}
