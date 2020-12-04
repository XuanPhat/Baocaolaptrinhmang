import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	public static void main(String[] args) throws Exception{
		 ServerSocket server = new ServerSocket(6000); // khởi tạo serve socket
		  System.out.println("server đang chạy ");
		  Socket socket = server.accept();
		  DataInputStream in = new DataInputStream(socket.getInputStream());
	      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
	      // nhập chuỗi để gửi đến client
	      Scanner sc = new Scanner(System.in);
	      // server nhận dữ liệu từ client
	      while (true)
	      {
	    	  String st = in.readUTF(); // sau đó đọc chuỗi từ client gửi qua
	    	  System.out.println(st); // in ra chuỗi đã đọc
	    	  System.out.println("server : "); // server bắt đầu nhập để gửi qua client
	    	  String  msg = sc.nextLine(); // lưu lại vào b msg
	    	  out.writeUTF("server " + msg); // // vô hàng đợi
	    	  out.flush();// đẩy qua dữ liệu qua client
	      }

	    
	 }

}
