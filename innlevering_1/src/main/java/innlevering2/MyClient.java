package innlevering2;

import java.io.*;
import java.net.*;

public class MyClient {
    public static void main (String [] args) throws Exception {
        MyClient Client = new MyClient();
        Client.run();
    }

    public void run() throws Exception {
        Socket SuckitTwo = new Socket("localhost",4444) ;
        PrintStream Printing = new PrintStream(SuckitTwo.getOutputStream());
        Printing.println("Hello to the server from the client");

        InputStreamReader Reader = new InputStreamReader(SuckitTwo.getInputStream());
        BufferedReader BReader = new BufferedReader(Reader);

        String info = BReader.readLine() ;
        System.out.println(info);
    }
}
