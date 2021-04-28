package ch15;

import java.util.HashSet;
import java.util.*;

public class test {
	public static void main(String[] args)
	{
		Set<String> s = new HashSet<>();
		String[] sample = { "단어", "중복", "구절","중복" };
		
		for(String sT : sample)
		{
			if(!s.add(sT))
				System.out.println("중복됬음");
			System.out.println(sT);
		}
	}
}
