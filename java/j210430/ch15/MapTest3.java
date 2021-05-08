package j210430.ch15;

import java.util.*;
public class MapTest3 {
    public static void main(String[] args)
    {
        Map<String, Map<String, String>> phoneBook=new TreeMap<>();
        Map<String,String> aBan=new TreeMap<>();
        Map<String,String> bBan=new TreeMap<>();
        aBan.put("김A","123-123-123");
        aBan.put("이A","124-124-124");
        bBan.put("김B","234-234-234");
        bBan.put("이B","235-235-235");

        phoneBook.put("A반", aBan);
        phoneBook.put("B반",bBan);

        Set<Map.Entry<String, Map<String,String>>> entrySet= phoneBook.entrySet();
        Iterator<Map.Entry<String, Map<String,String>>> iter1=entrySet.iterator();

        while(iter1.hasNext())
        {
            Map.Entry<String,Map<String,String>> entry=iter1.next();
            System.out.println(entry.getKey());

            Map<String,String> pb= entry.getValue();

            Set<Map.Entry<String,String>> phones=pb.entrySet();

            Iterator<Map.Entry<String,String>> iter2= phones.iterator();
            while(iter2.hasNext())
            {
                Map.Entry<String, String> phone=iter2.next();

                System.out.println(phone.getKey() + " : " + phone.getValue());
            }
            System.out.println("\n");
        }
    }

}
