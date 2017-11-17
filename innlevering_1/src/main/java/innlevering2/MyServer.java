package innlevering2;

import java.io.*;
import java.net.*;

public class MyServer {
    public static void main (String [] args) throws Exception {

        MyServer SERVER  = new MyServer();
        SERVER.run();
    }

    public void run() throws Exception {
        //oppretter serversocket
        ServerSocket ServerSuckit = new ServerSocket(4444);
        //oppretter socket
        Socket Suckit = ServerSuckit.accept();
        //Reader henter info fra socket
        InputStreamReader Reader = new InputStreamReader(Suckit.getInputStream());
        BufferedReader BReader = new BufferedReader(Reader);

        String info = BReader.readLine();
        System.out.println(info);

        if (info != null) {
            PrintStream Printing = new PrintStream(Suckit.getOutputStream())    ;
            Printing.println("Info Recieved");
        }
    }
}
