package ch15;

import java.util.HashSet;
import java.util.*;

public class test {
	public static void main(String[] args)
	{
		Set<String> s = new HashSet<>();
		String[] sample = { "�ܾ�", "�ߺ�", "����","�ߺ�" };
		
		for(String sT : sample)
		{
			if(!s.add(sT))
				System.out.println("�ߺ�����");
			System.out.println(sT);
		}
	}
}
