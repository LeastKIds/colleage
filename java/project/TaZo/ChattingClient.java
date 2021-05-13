package project.TaZo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;

/**
 * 이번에는 다 대 다 연결을 지원하는 클라이언트를 만들도록 하겠습니다.
 * 
 * 기존과 동일하게 메세지의 수신과 발신을 담당하는 스레드가 하나씩 필요합니다.
 *
 * 소스코드 출처 : https://gist.github.com/massivcode/1135348a2d70eee6de54
 * 
 * 설명은 서버와 중복되는 내용은 적지 않음.
 */

/**
 * 메시지의 수신을 담당하는 스레드 입니다.
 */

class ReceiverThread extends Thread {
	Socket socket;
	byte[] byteStr=null;

	public ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			// Input 상대방 내용이 나에게 들어올 때.
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
 * 메시지의 발신을 담당하는 스레드 입니다.
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

			// 제일 먼저 서버로 대화명을 송신합니다.
			// 맨 먼저 간 값이 닉네임이 되기 때문.
			writer.println(name);
			writer.flush();

			while (true) {
				
				// System.out.println("여긴>");
				String str = reader.readLine();
				// String str=sc.nextLine();
				System.out.println("여기까진 됨");

				

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

public class ChattingClient {

	public static void main(String[] args) {

		try {
			// 일단은 테스트 용으로 본인의 아이피를 입력해서 진행하겠습니다.
			Socket socket = new Socket("localhost", 7777);
			// 두번째 파라메터 로는 본인의 닉네임을 적어줍니다.
			Thread thread1 = new SenderThread(socket, "좀 돼라씨");
			Thread thread2 = new ReceiverThread(socket);
			
			thread1.start();
			thread2.start();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}