import java.io.*;
import java.net.ServerSocket;

public class Server {

    private InputStream in;
    private PrintStream out;
    private int portNumber;
    private ServerSocket serverSocket;

    public Server(InputStream in, PrintStream out, int portNumber) {
        this.in = in;
        this.out = out;
        this.portNumber = portNumber;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.print(Message.awaitingConnection);
    }
}
