import java.io.*;
import java.net.*;
import java.util.Scanner;

class UDPServer
{
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        BufferedReader inFromServer =
                new BufferedReader(new InputStreamReader(System.in));
        //Server Socekt Created
        Scanner sc = new Scanner(System.in);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true)
        {

            String sentence1 = inFromServer.readLine();



            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String( receivePacket.getData());
            System.out.println("Client: " + sentence);

//            DatagramPacket sendPacket = new DatagramPacket(receiveData, receiveData.length);
//            serverSocket.send(sendPacket);

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

//            String capitalizedSentence = sentence.toUpperCase();
            //Change sentence to Capital letter
//            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
            //Send Capitalized data back to client
        }
    }
}