import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
	 public static void main(String[] args) throws Exception{
	      Socket socket = new Socket("localhost",6000); // tạo socket từ client
	      DataInputStream in = new DataInputStream(socket.getInputStream()); // gửi 
	      DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // nhận
	      // nhập chuỗi để gửi đến serve
	      Scanner sc = new Scanner(System.in);
	      while (true) 
	      {
	    	  System.out.println("client: ");
	    	  String msg = sc.nextLine();
	    	  out.writeUTF("client : " + msg); // lưu vô hàng đợi 
	    	  out.flush(); //  đẩy qua serve
	    	  
	    	  
	    	  // client nhận được dữ liệu từ serve
	    	  String st = in.readUTF();  // đọc dữ liệu
	    	  System.out.println(st); // in ra dữ liệu đã đọc
	      }
	 
	      

	 }
}
