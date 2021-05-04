package j210409.ch15;


import java.util.*;
public class setTest2 {
    public static void main(String[] args)
    {
        testPriorityQueue();
    }

    private static void test1()
    {
        /*
            합집합 : addAll()
            교집합 : retainAll()
            차집합 : removeAll()
        */

        /*
            set1 : {1,3,4,5,7,9,10}
            set2 : {2,4,10}
            set1 intersectionSet set2 : {1,2,3,4,5,7,9,10}
            set1 difference set2 : {4,10}
            set + set2 : {1,3,5,7,9}
        */

        
        Integer[] arr1={1,3,4,5,7,9,10};
        List<Integer> list1=Arrays.asList(arr1);
        Set<Integer> set1=new HashSet<>(list1);
        
        Integer[] arr2={2,4,10};
        List<Integer> list2=Arrays.asList(arr2);
        Set<Integer> set2=new HashSet<>(list2);

        // 합집합

        // set1.addAll(set2);  // 원본데이터가 합집합이 된 데이터로 변경
        Set<Integer> unionSet=new HashSet<>(set1);  // 원본을 유지하기 위해 set1과 같은 set을 만든다.
        unionSet.addAll(set2);
        System.out.println("합집합 : " +unionSet);

        // 교집합
        Set<Integer> intersectionSet=new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("교집합 : "+intersectionSet);

        // 차집합
        Set<Integer> difference=new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("차집합 : " +difference);

        boolean flag = set1.containsAll(set2); // return : boolean 값 set1에 set2 값이 다 있으면 true

        if(flag)
            System.out.printf("집합 %s는 집합 %s의 모든 원소를 포함합니다.",set1,set2);
        else
            System.out.printf("집합 %s는 집합 %s의 모든 원소를 포함하지 않습니다.",set1,set2);
    }

    // 우선 순위 큐
    private static void testPriorityQueue()
    {
        Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return (o1.intValue() - o2.intValue() )* -1;
            }
        });
        for(int i=10; i>0; i--)
            queue.offer(i);
        
        // System.out.println(queue);  // 무작위로 출력
        for(Integer n : queue) System.out.print(n + " ");

        System.out.println();

        // Integer는 내부적으로 Comparable가 있어서 정렬 할 수 있음
        queue.offer(1); // 중복 가능
        int length=queue.size();
        for(int i=0; i<length; i++)
            System.out.println((i+1) + "번 째 원소 : " + queue.poll()); // poll 하면 순서대로 나옴
        
        System.out.println();


    }

    
}
