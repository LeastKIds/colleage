package j210507.ch15;


import java.util.*;
import java.io.*;
public class PropertiesTest {
    public static void main(String[] args)
    {
        // Map<String, String> env= System.getenv();
        // Set<String> keys= env.keySet();
        // for(String key : keys)
        //     System.out.println(key + " : " + env.get(key));


        // Properties는 <key, value>의 타입이 각 각 String으로 고정된
        // 일종의 Map 객체이다.
        Properties props=new Properties();

        // props.put("name","홍길동");
        // props.put("age","20");
        try(FileReader reader=new FileReader("./j210507/ch15/dict.props"))
        {
            props.load(reader);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        Set<Object> keys=props.keySet();
        for(Object key : keys)
        {
            System.out.println(key + " : " + props.get(key));
        }

        props.put("123","456");
        try (PrintWriter out=new PrintWriter(new File("./j210507/ch15/dict.props"))){
            props.store(out,"My Dictionary");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    
    }
}
