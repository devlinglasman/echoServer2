import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class ClientTest {

    InputStream stdIn;
    PrintStream stdOut;
    private int portNumber = 6666;
    private String hostAddress = "127.0.0.1";

    @Test
    public void socketAcceptsData() throws IOException {
        InputStream socketIn = new ByteArrayInputStream("".getBytes());
        OutputStream socketOut = new ByteArrayOutputStream();
        stdIn = new ByteArrayInputStream("Hello.\nBye.".getBytes());
        stdOut = new PrintStream(Message.clientConnected);
        SocketStub socketStub = new SocketStub(socketIn, socketOut);
        Client client = new Client(socketStub, stdIn, stdOut, portNumber, hostAddress);

        client.connectSocket();
        client.writeData();

        assertEquals("Hello.",  socketOut.toString());
    }
}
