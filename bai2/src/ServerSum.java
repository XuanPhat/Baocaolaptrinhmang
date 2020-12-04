import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class ServerSum extends Thread {

    ServerSocket ss;
    int port=7;
    Scanner input;
    PrintWriter output;
    Socket s;
    String s1;
    String s2[];
    float kq;
    public ServerSum()
    {
        try {
            ss = new ServerSocket(this.port);
            output = new PrintWriter(System.out);
            output.println("Server được khởi động...!");
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ServerSum(int p)
    {
        try {
            this.port = p;
            ss = new ServerSocket(this.port);
            output = new PrintWriter(System.out);
            output.println("Server được khởi động...!");
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Recived()
    {
        try {
            input = new Scanner(s.getInputStream());
            s1 = input.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Procesing()
    {
        s2 = new String[100];
        s2 = s1.split(" ");
        switch(s2[0]){
            case "+":
                float a = Float.valueOf(s2[1]).floatValue();
                float b = Float.valueOf(s2[2]).floatValue();
                kq = a+b;
                break;
            case "-":
                float a1 = Float.valueOf(s2[1]).floatValue();
                float b1 = Float.valueOf(s2[2]).floatValue();
                kq = a1-b1;
                break;
            case "*":
                float a2 = Float.valueOf(s2[1]).floatValue();
                float b2 = Float.valueOf(s2[2]).floatValue();
                kq = a2*b2;
                break;
            case "/":
                float a3 = Float.valueOf(s2[1]).floatValue();
                float b3 = Float.valueOf(s2[2]).floatValue();
                kq = a3/b3;
                break;
            default:
                kq=0;
                break;
        }
    }
    public void Send()
    {
        try {
            output = new PrintWriter(s.getOutputStream());
            output.println(kq);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void run()
    {
        while(true)
        {
            try {
                s = ss.accept();
                Recived();
                Procesing();
                Send();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }




    public static void main(String[] args) {
        ServerSum S = new ServerSum(8080);
        PrintWriter output = new PrintWriter(System.out);
        output.println("Server đã chạy và chờ kết nối từ Client...");
        S.start();

    }

}

