import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketStub extends Socket {

    private OutputStream out;
    private InputStream in;

    public SocketStub(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public InputStream getInputStream() {
        return in;
    }

    @Override
    public OutputStream getOutputStream() {
        return out;
    }
}
