import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
    JButton login;
    JPanel panel;
    JLabel label1,label2;
    final JTextField text1,text2;
    static Socket socket = null;
    static PrintWriter out = null;
    static BufferedReader in = null;

    public Login()
    {
        label1 = new JLabel();
        label1.setText("Username:");
        text1 = new JTextField(15);
        label2 = new JLabel();
        label2.setText("Password:");
        text2 = new JPasswordField(15);
        login = new JButton("Login");

        panel = new JPanel(new GridLayout(3,1));
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(login);
        add(panel,BorderLayout.CENTER);
        login.addActionListener(this);
        setTitle("LOGIN");
    }

    public void actionPerformed(ActionEvent ae)
    {
        Object source = ae.getSource();
        if(source == login)
        {
            String value1 = text1.getText();
            String value2 = text2.getText();
            out.println(value1);
            out.println(value2);
            try
            {
                String line1 = in.readLine();
                String line2 = in.readLine();
            }
            catch(IOException e)
            {
                System.out.println("login failed");
                System.exit(1);
            }
        }
    }

    public void listenSocket()
    {
        try
        {
            socket = new Socket("host", 9006);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        }
        catch (UnknownHostException e)
        {
            System.out.println("Unknown host: host");
            System.exit(1);
        }
        catch  (IOException e)
        {
            System.out.println("No I/O");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws UnknownHostException, IOException
    {
        Login frame = new Login();
        frame.setSize(300,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.listenSocket();
    }
}