import java.io.*;

public class IOHelper {

    public InputStream in;
    public OutputStream out;
    public PrintStream print;

    public IOHelper(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        out = new ByteArrayOutputStream();
        print = new PrintStream(out);
    }

    public String retrieveOutput() {
        return out.toString();
    }
}
