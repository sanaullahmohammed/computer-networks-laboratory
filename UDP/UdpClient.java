import java.net.*;
class UdpClient
{
    public void display(DatagramPacket packet)
    {
        byte[] p = packet.getData();
        for(int i=0; i<packet.getLength(); i++)
        {
            System.out.print((char)p[i]);
        }
        System.out.println();
    }
    public void client() throws Exception
    {
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024, InetAddress.getByName("localhost"), 3333);
        socket.send(packet);
        packet = new DatagramPacket(new byte[1024], 1024);
        do
        {
            socket.receive(packet);
            display(packet);
        }
        while(Boolean.TRUE);
        socket.close();
    }
    public static void main(String[] args) throws Exception
    {
        UdpClient uc = new UdpClient();
        uc.client();
    }
}