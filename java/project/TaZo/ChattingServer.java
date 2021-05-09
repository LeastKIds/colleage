package project.TaZo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다 대 다 연결을 지원하는 서버입니다.
 * 
 * 기존과는 다르게 서버에서는 오직 클라이언트로부터 받은 문자열을 모든 클라이언트에 전달해주는 기능만을 가지고 있습니다.
 *
 * 소스코드 출처 : https://gist.github.com/massivcode/e71e3db7df1a2d5e578d
 * 
 * 인터넷에서 찾아본 내용이라 틀릴 수 있음.
 */

/**
 * 연결을 요청하는 클라이언트와 관련된 처리를 하는 스레드 입니다. 
 */
class EachClientThread extends Thread {

	// 여러 스레드가 안전하게 공유할 수 있는 동기화된 리스트로 만듭니다.
	// 서버에 연결된 모든 클라이언트로의 출구가 이 리스트에 보관됩니다.
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	// 채팅하는 사람 한명당 Thread하나 씩 만들어서 list에 넣어서 관리
	// synchronizedList 의 경우는 동기화를 시켜줌. (NodeJs에서 배운 내용. 서버 처음 초기 설정엔 순서대로 실행 되는 동기를 사용함.)


	Socket socket;		// 네트워크 연결을 맡음
	PrintWriter writer;		// PrintWriter : 오로지 출력을 위함

	public EachClientThread(Socket socket) {
		this.socket = socket;
		try {
			// getOutputStream : 출력 스트림 받아오기.
			// 이걸로 채팅 하는 사람을 구분하는 값을 가져옴.
			// 그 값을 list에 넣어서 보관.
			writer = new PrintWriter(socket.getOutputStream());		// PrintWriter는 데코레이터 없이 OutPutStream을 받을 수 있음
			list.add(writer);										// 데코레이터? : 함수에 추가적인 기능을 붙이는 것. Override에 super를 붙이는것과 같음?(솔직히 잘 모르겠음)


			// OutPutStream은 바이트 기반 출력스트림의 최상위 스트림으로 추상 클래스
			// 상대방으로 보낼 내용. InputStream은 반대
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
		run 은 Thread가 실행 될 때 돌아가는 코드들
		run과 start가 있지만 run은 현재 쓰레드가 종료 되어야만 다음 쓰레드로
		start는 현재 실행중인 쓰레드가 있어도 다른 쓰레드가 동시 실행됨
	*/
	@Override
	public void run() {
		String name = null;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			/*
				socket.getInputStream : 소켓을 통해 들어오는 스트림(내용)
				InputStreamReader : InputStream의 경우 바이트로 들어옴. 이걸 문자열로 엮어 준게 InputStreamReader
									생성자로는 InputStream을 받음.
									또한 char이기 때문에 한글 안 깨짐. InputStream의 경우에는 바이트 단위인 2바이트로 와서
									한글이 깨짐.
				BufferReader : 입력을 효율적으로 보내줌. Scanner와 비슷. / BufferWriter의 경우는 출력. println()과 비슷
				
			*/


			// 수신된 첫번째 문자열을 닉네임으로 지정합니다.
			name = reader.readLine();		// 파일을 한줄 한줄 읽기.
			sendAll("#" + name + "님이 들어오셨습니다");
			

			// 확실하진 않지만 readLine의 경우 Thread.stop()기능이 있어서 
			// 데이터가 들어오지 않으면 올 때 까지 멈춰있음.
			while(true) {
				String str = reader.readLine();
				// 그렇기 때문에 데이터가 들어오지 않으면 이 단계에서 멈추어져 있음.

				// NULL값이 들어오면 종료
				if(str == null) {
					break;
				}
				
				// 수신된 메시지 앞에 대화명을 붙여서 모든 클라이언트로 보냅니다.
				sendAll(name + ">" + str);
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			list.remove(writer);
			// 해당 사용자가 채팅을 종료했다는 메시지를 모든 클라이언트로 보냅니다.
			sendAll("#" + name + "님이 나가셨습니다");
			
			try {
				socket.close();
				// 소켓을 닫음. 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void sendAll(String str) {
		for (PrintWriter writer : list) {
			// 서버에 연결된 모든 클라이언트로 똑같은 메세지를 보냅니다.
			System.out.println(str);
			writer.println(str);
			writer.flush();
			// println을 한다고 가는게 아니라 flush를 해 줘야 전송 됨.
			// flush를 안 하면 계속 쌓여있음.
		}
	}

}

public class ChattingServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			// 소켓을 여는것(서버를 여는것). IP는 서버 실행하는 컴퓨터의 IP
			// 7777의 경우는 여는 포트. (NodeJs와 리눅스에서 배운내용과 비슷)
			serverSocket = new ServerSocket(7777);
			
			// 클라이언트가 접속할 때마다 별도의 소켓을 생성하고,
			// 메시지의 수발신 처리를 위한 스레드를 만들고 바로 실행합니다.
			while(true) {
				// while문의 경우는 한 번만 실행될 게 아니기 때문.
				Socket socket = serverSocket.accept();
				// 클라이언트가 접속하면 이걸로 확인.
				// 들어오지 않으면 오류가 아니라 들어올 때 까지 대기.
				// 그렇기 때문에 무한 반복을 하지 않고 클라가 돌아올 때만 대기.
				
				Thread thread = new EachClientThread(socket);
				thread.start();
			}
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}