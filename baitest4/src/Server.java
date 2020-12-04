import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Server
{
    static ServerSocket server = null;
    static Socket client = null;
    static BufferedReader in = null;
    static PrintWriter out = null;
    static String line1;
    static String line2;

    public static void main(String[]args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        while (true)
        {
            server = new ServerSocket(9006);

            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("waiting for connection");
            client = server.accept();
            System.out.println("connection accepted");
            System.out.println("running...");

            try
            {in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);

                line1 = in.readLine();
                line2 = in.readLine();
                out.println(line1);
                out.println(line2);

//        String value1 = text1.getText();                                   //i know this section has to be used but how?
//  String value2 = text2.getText();
//  if (value1.equals("employee") && value2.equals("password") || value1.equals("manager") && value2.equals("password"))
//  {
//            MainMenu menu = new MainMenu();
//            menu.show();
//            super.setVisible(false);
//  }
//  else
//        {
//            JOptionPane.showMessageDialog(this,"Incorrect username or password.", "Error", JOptionPane.ERROR_MESSAGE);
//  }

            }
            catch(IOException e){};
        }
    }
}
