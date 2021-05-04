package j210416.ch15;

import java.util.*;
public class PriorityQueueTest2 {
    public static void main(String[] args)
    {
        // test1();
        test2();
    }

    private static void test1()
    {
        Queue<Integer> q=new PriorityQueue<>();

        // 무작위로 1에서 100사이의 10개의 정수를 넣자.
        Random random=new Random();
        for(int i=0; i<10; i++)
        {
            int val=random.nextInt(100)+1;
            q.offer(val);
        }

        // 큐 안의 내용을 출력해 보고,
        System.out.println(q);

        // 큐의 원소를 하나씩 순서대로 빼 보자.

        while(q.size() > 0)
        {
            System.out.println(q.poll());
        }


    }

    private static void test2()
    {
        /*
            우선순위 큐에 드어갈 원소를 정렬하는 방법은 2가지가 있다.
            1. 그 원소의 클래스 Comparable 인터페이스를 구현하는 것.
            2. 우선순위 큐에게 그 원소를 비교하는 방법을 따로 알려주는 것.
                -> Comparator 인터페이스를 구현하는 것이다.
            참고로, 원소가 Comparable 인터페이스를 구현한 객체이고
                우선순위 큐에서 원소를 비교하는 방법도 따로 알려주면
                내가 알려준 방법으로 정렬
        */

        // 자바에서 람다 : 오직 하나의 추상 메소드만을 가진 인터페이스의 구현체
        MyTaskComparator comp=new MyTaskComparator();
        // Queue<MyTask> q=new PriorityQueue<>(comp);
        Queue<MyTask> q=new PriorityQueue<>(
            (o1, o2) -> o2.priority - o1.priority
        );
        q.add(new MyTask(5,"작업 1"));
        q.add(new MyTask(1,"작업 2"));
        q.add(new MyTask(2,"작업 3"));
        q.add(new MyTask(7,"작업 4"));
        q.add(new MyTask(8,"작업 5"));

        while(q.size() > 0)
        {
            MyTask task=q.poll();
            System.out.println(task);
        }

        
    }

}


class MyTask implements Comparable<MyTask>
{
    int priority;
    String desc;

    public MyTask(int priority, String desc)
    {
        this.priority=priority;
        this.desc=desc;
    }

    @Override
    public String toString()
    {
        return "[priority : " + priority + ", desc : " + desc + "]";
    }

    // 첫 번째 방법
    @Override
    public int compareTo(MyTask o) {
        // TODO Auto-generated method stub
        // 내가 크면 양수, 같으면 0, 작으면 음수


        return this.priority - o.priority;  // 오름 차순
    }
}

class MyTaskComparator implements Comparator<MyTask>
{

    @Override
    public int compare(MyTask o1, MyTask o2) {
        // TODO Auto-generated method stub
        return o1.desc.compareTo(o2.desc);
    }
    
}