import java.io.IOException;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) throws IOException {
        int portNumber = 6666;
        String hostAddress = "127.0.0.1";
        Socket socket = new Socket(hostAddress, portNumber);
        Client client = new Client(socket, System.in, System.out, 6666, "127.0.0.1");
        client.connectSocket();
        client.writeData();
    }
}
