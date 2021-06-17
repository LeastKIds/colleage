package q1;

import java.io.*;
import java.util.*;

public class StudentFromFile {
	static Map<String, Student> stdMap = new HashMap<>();
	
	public static void main(String[] args) {
		String content = getFileContent("students.txt");
		System.out.println("���� ���� ����");
		System.out.print(content);
		System.out.println("���� ���� ��");
		
		buildStduentInfoFromFile("students.txt");
		System.out.println("###################################");
		System.out.println("�л� ���� ���� �Ϸ� ~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("###################################");
		
		System.out.println("2020112 �л� ����: " + stdMap.get("2020112"));
		System.out.println("2020116 �л� ����: " + stdMap.get("2020112"));
	}
	
	private static void buildStduentInfoFromFile(String fileName) {
		/*
		 * getFileContent �޼��� ����
		 * ������ ������ �� ���� ������ �Ʒ��� �ݺ��Ѵ�. 
		 * 	1. Student ��ü�� �����Ѵ�. 
		 * 	2. �� ���ξ� �д´�. 
		 * 	3. StringTokenizer�� �̿��� token�� �и��Ѵ�. 
		 * 	4. token���� Student ��ü�� ��� ���� ������ ������ �����Ѵ�. 
		 * 	5. <�й�, Student ��ü>�� ��  stdMap�� �����Ѵ�. 
		 */
		
		// ���⿡ �����Ͻÿ�...
		
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
