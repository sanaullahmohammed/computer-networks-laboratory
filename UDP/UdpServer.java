import java.net.*;
import java.util.Scanner;

class UdpServer
{
    public void server() throws Exception
    {
        DatagramSocket socket = new DatagramSocket(3333);
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        socket.receive(packet);
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        Scanner scanner = new Scanner(System.in);
        System.out.println("address: "+address+" Port: "+port);
        System.out.println("Server: type lines of text to send");
        do
        {
            String message = scanner.nextLine();
            packet = new DatagramPacket(message.getBytes(), message.length(), address, port);
            socket.send(packet);
        }
        while(Boolean.TRUE);
        scanner.close();
        socket.close();
    }
    public static void main(String[] args) throws Exception
    {
        UdpServer us = new UdpServer();
        us.server();
    }
}