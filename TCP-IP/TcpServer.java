import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.*;

public class TcpServer
{
    void server() throws Exception
    {
        System.out.println("Server waiting for connection from client");
        ServerSocket serverSocket = new ServerSocket(3333);
        Socket socket = serverSocket.accept();
        System.out.println("Server connection to client successful on port:3333");
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        String fileName = din.readUTF();
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for(int i=0; i<lines.size(); i++)
        {
            System.out.println("server: "+lines.get(i));
            dout.writeUTF(lines.get(i));
        }
        din.close();
        dout.close();
        serverSocket.close();
        socket.close();
    }
    public static void main(String[] args) throws Exception
    {
        TcpServer ts = new TcpServer();
        ts.server();
    }
}