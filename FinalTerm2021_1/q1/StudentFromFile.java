package q1;

import java.io.*;
import java.util.*;

public class StudentFromFile {
	static Map<String, Student> stdMap = new HashMap<>();
	
	public static void main(String[] args) {
		String content = getFileContent("students.txt");
		System.out.println("파일 내용 시작");
		System.out.print(content);
		System.out.println("파일 내용 끝");
		
		buildStduentInfoFromFile("students.txt");
		System.out.println("###################################");
		System.out.println("학생 정보 구축 완료 ~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("###################################");
		
		System.out.println("2020112 학생 정보: " + stdMap.get("2020112"));
		System.out.println("2020116 학생 정보: " + stdMap.get("2020112"));
	}
	
	private static void buildStduentInfoFromFile(String fileName) {
		/*
		 * getFileContent 메서드 참고
		 * 파일의 내용을 다 읽을 때까지 아래를 반복한다. 
		 * 	1. Student 객체를 생성한다. 
		 * 	2. 한 라인씩 읽는다. 
		 * 	3. StringTokenizer를 이용해 token을 분리한다. 
		 * 	4. token들을 Student 객체의 멤버 변수 값으로 적절히 설정한다. 
		 * 	5. <학번, Student 객체>를 맵  stdMap에 저장한다. 
		 */
		
		// 여기에 구현하시오...
		
	}
	
	private static String getFileContent(String fileName) {
		String result = "";
		try(FileInputStream fstream = new FileInputStream("students.txt")) {
			InputStreamReader fr = new InputStreamReader(fstream, "UTF-8");
			BufferedReader bf = new BufferedReader(fr);
			String line = null;
			
			while((line = bf.readLine()) != null) {
				result = result + line + "\n";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
