import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketStub extends ServerSocket {

    private Socket clientSocket;

    public ServerSocketStub(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
    }

    @Override
    public Socket accept() {
        return clientSocket;
    }
}
