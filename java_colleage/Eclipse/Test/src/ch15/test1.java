package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test1{
	public static void main(String[] args)
	{
		Map<String, Integer> map=new HashMap<>();
		
		try(BufferedReader reader=new BufferedReader(new FileReader(new File("wordbook.txt"))))
		{
			String word=null;
			while((word=reader.readLine())!=null)
			{
				if(map.get(word)==null)
					map.put(word, 1);
				else
				{
					int i=map.get(word);
					map.put(word, i+1);
				}
			}
		}catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
//		Iterator<String> itor = map.keySet().iterator();
//		while(itor.hasNext())
//		{
//			String key=itor.next();
//			
//			int result= map.get(key);
//			System.out.println(key + " : " + result);
//		}
		for(Map.Entry e : map.entrySet() )
		{
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

	
}
