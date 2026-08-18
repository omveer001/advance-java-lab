import java.io.*;
import java.net.*;
public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter message to send to server: ");
            String message = console.readLine();
            out.println(message);
            String response = in.readLine();
            System.out.println("Server response: " + response);

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}