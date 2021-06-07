package J210531.ch18;


import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",9100)) {
            InputStream stream = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            System.out.println(line);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
