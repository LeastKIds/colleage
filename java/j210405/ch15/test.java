package j210405.ch15;

import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args)
    {
        test4();
    }

    private static void test1()
    {
        // HashSet
        // 순서 없고, 중복 허용 하지 않는 집합 HashSet...

        // Set<String> set=new HashSet<>();         // HashSet은 중복 X, 순서 X
        // Set<String> set = new LinkedHashSet<>();    // LinkedHashSet은 중복 X, 순서 O
        Set<String> set = new TreeSet<>(new Comparator<String>(){   // TreeSet은 중복 X, 정렬 O
            public int compare(String o1, String o2)                // 값을 비교 하기 위해 Comparator 인터페이스 구현
            {
                return o2.compareTo(o1);        // 역순으로 정렬
            }
        });                 

        // set.add() 에 boolean 값을 리턴해준다. 들어가면 true 안 들어가면 false
        String[] strArr={"단어","중복","구절","중복"};
        for(String s : strArr)
            if(set.add(s) == false)
                System.out.println(s + "는(은) 이미 존재하는 값 ...!");

        System.out.println(set);
        
        Iterator<String> iter=set.iterator();

        while(iter.hasNext())       // 체크해주지 않으면 Exception이 일어남
        {
            System.out.println(iter.next());
        }
    }

    private static void test2()
    {
        Set<Integer> set=new TreeSet<>();
        Random random=new Random();
        while(set.size()<6)
        {
            set.add((1+random.nextInt(45)));
            // System.out.println(1+random.nextInt(44));
        }
        System.out.println(set);
    }

    private static void test3()
    {
        Set<String> set=new HashSet<>();
        int save=0;
        
            File file=new File("./j210405/ch15/wordbook.txt");
            try(BufferedReader bufReader=new BufferedReader(new FileReader(file))){     // text 파일 읽어오기
                String line="";
                while((line=bufReader.readLine()) != null)                              // .readLine() : 한줄 씩 가져 오기
                {
                    if(!set.add(line))
                        save++;
                }
            }catch (FileNotFoundException e)
            {
    
            }catch (IOException e)
            {
                System.out.println(e);
            }

            
        

        System.out.println(set);
        System.out.println(save);
    }

    private static void test4()
    {
        Map<String, Integer> map=new HashMap();
        File file=new File("./j210405/ch15/wordbook.txt");
        try(BufferedReader bufReader=new BufferedReader(new FileReader(file))){     // text 파일 읽어오기
            String line="";
            while((line=bufReader.readLine()) != null)                              // .readLine() : 한줄 씩 가져 오기
            {
                Integer n=map.get(line);
                if(n==null)
                    map.put(line,1);
                else
                    map.put(line,n+1);
            }
        }catch (FileNotFoundException e)
        {

        }catch (IOException e)
        {
            System.out.println(e);
        }

        Set<String> set=map.keySet();
        Iterator<String> iter=set.iterator();
        while(iter.hasNext())
        {
            String key=iter.next();
            Integer value=map.get(key);
            System.out.println(key + " : " + value);
        }
    }


}
