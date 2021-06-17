
package q6;
import java.util.*;
public class ByeJava {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("1이상의 정수를 입력하시오(종료는 -1): ");
			int n = input.nextInt();
			if (n == -1) break;
			String java = makeJava(n);
			System.out.println(java);
		}
		input.close();
		System.out.println("프로그램을 종료합니다.");
	}
	
	private static String makeJava(int n) {
		String result = "";
		
		// 여기에 구현하시오...
		
		return result;
	}
}
