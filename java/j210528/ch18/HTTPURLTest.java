package j210528.ch18;

import java.io.*;
import java.net.*;
public class HTTPURLTest {
    public static void main(String[] args) throws Exception
    {
        String site = "https://www.google.com/search?q=java";
        URL url=new URL(site);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inLine;

        while((inLine = in.readLine()) !=null)
        {
            System.out.println(inLine);
        }

        int code = con.getResponseCode();
        System.out.println("Response code : " + code);
        
        in.close();
    }
}
