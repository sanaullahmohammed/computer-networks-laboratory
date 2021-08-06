import java.io.*;
import java.net.*;
import java.util.*;

public class TcpClient
{
    void client() throws Exception
    {
        Socket socket = new Socket("localhost",3333);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        System.out.print("Enter filename:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        dout.writeUTF(fileName);
        String message;
        do
        {
            message = din.readUTF();
            System.out.println("Client: "+message);
        }
        while(!message.equals("stop"));
        scanner.close();
        din.close();
        dout.close();
        socket.close();
    }
    public static void main(String[] args) throws Exception
    {
        TcpClient tc = new TcpClient();
        tc.client();
    }
}
