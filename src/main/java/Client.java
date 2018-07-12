import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private BufferedReader stdIn;
    private PrintStream stdOut;
    private BufferedReader socketIn;
    private PrintWriter socketOut;
    private int portNumber;
    private String hostAddress;

    public Client(Socket socket, InputStream stdIn, PrintStream stdOut, int portNumber, String hostAddress) {
        this.socket = socket;
        this.stdIn = new BufferedReader(new InputStreamReader(stdIn));
        this.stdOut = stdOut;
        this.portNumber = portNumber;
        this.hostAddress = hostAddress;
        connectSocket();
    }

    public void connectSocket() {
        try {
            socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOut = new PrintWriter(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData() throws IOException {
        String input;
        while (!(input = stdIn.readLine()).equals("Bye.")) {
            socketOut.println(input);
        }
    }

    public void receiveData() throws IOException {
        String input;
        while ((input = socketIn.readLine()) != null) {
            stdOut.println(input);
        }
    }
}
