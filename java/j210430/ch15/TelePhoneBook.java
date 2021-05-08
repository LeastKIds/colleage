package j210430.ch15;

import java.util.*;
public class TelePhoneBook {
    
    public static void main(String[] args)
    {
        Map<String, Map> group=new HashMap<>();
        Map<String, Student> groupA=new TreeMap<>();
        Map<String, Student> groupB=new TreeMap<>();

        groupA.put("김A",new Student("김A","123-123-123"));
        groupA.put("이A",new Student("이A","124-124-124"));

        groupB.put("김B",new Student("김B","234-234-234"));
        groupB.put("이B",new Student("이B","235-235-235"));

        group.put("WDJ-A",groupA);
        group.put("WDJ-B",groupB);

        // System.out.println(group.get("WDJ-A"));
        // System.out.println(group.get("WDJ-B"));

        // System.out.println(group.get("WDJ-A").get("김A"));

        // Map<String, Student> test=group.get("WDJ-B");

        // System.out.println(test.get("이B"));

        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("A or B ? ");
            String ban=sc.nextLine();
            if(ban.equals("exit"))
            {
                break;
            }else if(group.get(ban)==null)
            {
                System.out.println("그런반은 없어");
                continue;
            }
            System.out.println("who?");
            String name=sc.nextLine();
            if(group.get(ban).get(name) == null)
            {
                System.out.println("그런 사람 없어");
                System.out.println(name);
            }
            System.out.println(name.equals("김A"));
            Map<String, Student> selectGroup=group.get(ban);
            System.out.println(selectGroup.get(name));
            System.out.println(selectGroup.get("김A"));


            // System.out.println(group.get(ban));


        }
    }
    
}

class Student
{
    private String name;
    private String number;
    public Student(String name, String number)
    {
        this.name=name;
        this.number=number;
    }

    @Override
    public String toString()
    {
        return "[name : " + name + ", number : " + number + "]";
    }
}
