
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ClientSum extends Thread {




    String address = "127.0.0.1";
   int port=7;
    boolean connect = false;
    Scanner input;
    PrintWriter output;
    Socket s;
    String s1;
    String s2[];
    String s3;
    float kq;
    public ClientSum()
    {
    }
    public ClientSum(String ad, int p)
    {
        this.address = ad;
        this.port =p;
        output = new PrintWriter(System.out);
        output.println("Client được khởi động...!");
    }
    public void connected()
    {

        try {
            s = new Socket(this.address, this.port);
            this.connect= true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void disconnect()
    {
        try {
            s.close();
            this.connect = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void InputString()
    {
        input = new Scanner(System.in);
        output = new PrintWriter(System.out);
        output.print("Nhập vào biểu thức operant1 op operant2: ");
        output.flush();
        s1 = input.nextLine();
        s2 = new String[100];
        s2 = s1.split(" ");
        s3 = s2[1]+" "+s2[0]+" "+s2[2];




    }
    public void Send()
    {
        try {
            output = new PrintWriter(s.getOutputStream());
            output.println(s3);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Recived()
    {
        try {
            input = new Scanner(s.getInputStream());
            kq = input.nextFloat();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void Look()
    {
        output = new PrintWriter(System.out);
        output.println("Kết quả: "+kq);
        output.flush();
    }
    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(System.out);
        Scanner input = new Scanner(System.in);
        String address = "127.0.0.1";
        int port =7;
        output.println("Client run....!");
        output.flush();
        output.print("Nhập địa chỉ Server: ");
        output.flush();
        address = input.nextLine();
        output.print("Nhập cổng port: ");
        output.flush();
        port = input.nextInt();
        ClientSum C = new ClientSum(address, port);

        while(true)
        {
            C.connected();

            if (C.connect) {
                C.InputString();
                C.Send();
                C.Recived();
                C.Look();
                C.disconnect();
            } else {
                output.print("Kết nối Server thất bại! ");
                output.flush();
            }
        }






    }


}
