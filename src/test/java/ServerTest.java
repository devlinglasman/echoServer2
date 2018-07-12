import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static junit.framework.TestCase.assertEquals;

public class ServerTest {

    ByteArrayInputStream clientIn;
    ByteArrayOutputStream clientOut;

    @Test
    public void connectClient() throws IOException {
        clientIn = new ByteArrayInputStream("".getBytes());
        clientOut = new ByteArrayOutputStream();
        SocketStub socketStub = new SocketStub(clientIn, clientOut);
        ServerSocketStub serverSocketStub = new ServerSocketStub(socketStub);
        Server server = new Server(serverSocketStub);

        server.connectClient();

        assertEquals(Message.clientConnected, socketStub.getOutputStream().toString());
    }

    @Test
    public void printClientData() throws IOException {
        clientIn = new ByteArrayInputStream("Hola".getBytes());
        clientOut = new ByteArrayOutputStream();
        SocketStub socketStub = new SocketStub(clientIn, clientOut);
        ServerSocketStub serverSocketStub = new ServerSocketStub(socketStub);
        Server server = new Server(serverSocketStub);

        server.connectClient();
        server.echoMessage();

        assertEquals(Message.clientConnected.toString() + "Hola",  clientOut.toString());
    }
}
