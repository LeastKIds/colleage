package j210409.ch15;

import java.util.*;
public class DequeTest {
    public static void main(String[] args)
    {
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=1; i<=10; i++)
            // dq.push(i);  // stack 으로 쌓임  // dq.addFirst()
            dq.add(i);      // dq.addList(i)
            // dq.addFirst(i);
            // dq.addLast(i);

        while(dq.size()>0)
        {
            // Integer val=dq.poll();  // first in first out
            Integer val=dq.pollLast();  // Last in first out
            // poll(), pollFirst()
            System.out.print(val + " ");
        }

        System.out.println();
    }
}
