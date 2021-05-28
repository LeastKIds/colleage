package j210528.ch18;

import java.io.BufferedReader;
import java.net.URL;
import java.net.*;

import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception
    {
        URL site = new URL("https://www.naver.com/");
        URLConnection url = site.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));

        String inLine;

        while((inLine = in.readLine()) !=null)
        {
            System.out.println(inLine);
        }
        in.close();
    }
}
