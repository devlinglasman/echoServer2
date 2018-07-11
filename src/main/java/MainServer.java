public class MainServer {

    public static void main(String[] args) {
        int portNumber = 6666;
        Server server = new Server(System.in, System.out, portNumber);

        server.start();
    }
}
