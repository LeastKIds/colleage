

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * �̹����� �� �� �� ������ �����ϴ� Ŭ���̾�Ʈ�� ���鵵�� �ϰڽ��ϴ�.
 * 
 * ������ �����ϰ� �޼����� ���Ű� �߽��� ����ϴ� �����尡 �ϳ��� �ʿ��մϴ�.
 *
 * �ҽ��ڵ� ��ó : https://gist.github.com/massivcode/1135348a2d70eee6de54
 * 
 * ������ ������ �ߺ��Ǵ� ������ ���� ����.
 */

/**
 * �޽����� ������ ����ϴ� ������ �Դϴ�.
 */

class ReceiverThread extends Thread {
	Socket socket;
	byte[] byteStr=null;

	public ReceiverThread(Socket socket) {
		this.socket = socket;
		Gson gson = new Gson();
	}

	@Override
	public void run() {

		try {
			// Input ���� ������ ������ ���� ��.
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			while (true) {
				String str = reader.readLine();
				if (str == null) {
					break;
				}
				System.out.println(str);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

/**
 * �޽����� �߽��� ����ϴ� ������ �Դϴ�.
 */

class SenderThread extends Thread {
	Socket socket;
	String name;

	public SenderThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,StandardCharsets.UTF_8));
			// PrintWriter writer = new PrintWriter(socket.getOutputStream());
			Scanner sc=new Scanner(System.in);
			
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8));
			// OutputStreamWriter writer2=new OutputStreamWriter(socket.getOutputStream(),"utf-8");

			// ���� ���� ������ ��ȭ���� �۽��մϴ�.
			// �� ���� �� ���� �г����� �Ǳ� ����.
			writer.println(name);
			writer.flush();

			while (true) {
				
				// System.out.println("����>");
				 String str = reader.readLine();
//				String str=sc.nextLine();
//				System.out.println("������� ��");

				

				if (str.equals("bye")) {
					break;
				}

				
				writer.println(str);
				
				writer.flush();
				// writer2.write(str);
				// writer2.flush();
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("너의 이름은?");
			String name = "김씨2";
			
			String originalStr = name; 
			String [] charSet = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949"};
			  
			
			
			Socket socket = new Socket("localhost", 7777);
	
			Thread thread1 = new SenderThread(socket, name);
			Thread thread2 = new ReceiverThread(socket);
			
			thread1.start();
			thread2.start();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}