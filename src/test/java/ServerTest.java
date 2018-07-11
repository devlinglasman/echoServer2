import org.junit.Test;

import java.net.Socket;

import static junit.framework.TestCase.assertEquals;

public class ServerTest {

    @Test
    public void setup() {
        IOHelper ioHelper = new IOHelper("");
        int portNumber = 6666;
        Server server = new Server(ioHelper.in, ioHelper.print, portNumber);

        server.start();

        assertEquals(Message.awaitingConnection, ioHelper.retrieveOutput());

    }
}
