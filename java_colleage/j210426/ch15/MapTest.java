package j210426.ch15;

import java.util.*;

public class MapTest {
    
    public static void main(String[] args)
    {
        test1();
    }

    private static void test1()
    {
        ArrayList<Student> list=new ArrayList<>();
        Random random=new Random();

        for(int i=0; i<10; i++)
        {
            list.add(new Student("이름"+i, random.nextInt(100)+1));
        }

        System.out.println(list);
        
        // Collections.sort(list);
        sort(list);
        System.out.println("정렬중~~");
        System.out.println(list);
    }

    private static <T extends Comparable<T>> void sort(List<T> list)
    {
        /*
            select sort
        */
        /* 
            list에 0번 부터 마지막 index 원소 까지 다음을 반복
            현재의 index를 i라 하자
            min = i

            list의 i+1번 인덱스부터 마지막 인덱스의 원소까지 다음을 반복
                중첩 반복문의 현재 인덱스를 j라 하자.
                if(min 인덱스의 원소 값보다 j 인덱스의 원소값이 작으면)
                    min = j
            
            i번째 인덱스와 min 번째 인덱스의 값을 swap
        */

        for(int i=0; i<list.size(); i++)
        {
            int min=1;
            for(int j=i+1; j<list.size(); j++)
            {
                if(list.get(min).compareTo(list.get(j))>0)
                    min=j;
            }
            // min 변수가 가르키는 위치의 원소가 남아있는 원소 중 가장 작은 값

            // swap(list.get(min),list.get(i)); // 불가능
            swap(list,min,i);
        }
        
        

    }

    private static <T extends Comparable<T>> void swap(List<T>list, int i, int j)
    {
        T tmp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,tmp);
    }
}

class Student implements Comparable<Student>
{
    private String name;
    private int grade;

    public Student(String name, int grade)
    {
        super();
        this.name = name;
        this.grade=grade;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return this.grade - o.grade;
    }

    @Override
    public String toString()
    {
        return "[name : " + name + ", grade : " + grade + "]";
    }
}
