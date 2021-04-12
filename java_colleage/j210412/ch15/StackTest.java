package j210412.ch15;

import java.util.*;
public class StackTest {
    public static void main(String[] args)
    {
        // test1();
        // test2();
        checkExpression();
    }

    private static void test1()
    {
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<10; i++)
            stack.push((char)('A'+i));

        // System.out.println(stack);
        // System.out.println(stack.peek());
        // System.out.println(stack.peek());
        // System.out.println(stack.peek());
        // System.out.println(stack.peek());
        // System.out.println(stack.pop());        
        // System.out.println(stack.peek());
        // System.out.println(stack);

        while(stack.size()>0)
        {
            Character nextVal=stack.pop();
            System.out.println(nextVal);
        }
        System.out.println(stack);


        
    }

    private static void test2()
    {
        String str="APPLE, GRAPE, BANANA, STRAWBERRY";
        StringTokenizer st=new StringTokenizer(str, ", ");
        while(st.hasMoreTokens())
        {
            System.out.println("[" + st.nextToken() + "]");
        }
    }

    private static void checkExpression()
    {
        System.out.println("수식을 입력하세요.");
        Scanner sc=new Scanner(System.in);

        String exp=sc.nextLine();

        StringTokenizer st=new StringTokenizer(exp);    // default : 공백 기준
        Stack <String> stack=new Stack<>();
        while(st.hasMoreTokens())
        {
            // System.out.println(st.nextToken());
            // ( 이면 stack에 push
            // ) 면 stack에
            // stack이 empty인지 확인하고, empty가 아니면 pop
            // empty면 잘못된 식
            // 잘못된 식임을 출력하고... return
            // System.out.println(nextVal);

            String nextVal=st.nextToken();

            if(nextVal.equals("("))
                stack.push(nextVal);

            else if(nextVal.equals(")"))
            {
                if(stack.empty())
                {
                    System.out.println("잘못된 식입니다.");
                    return;
                }
                else
                    stack.pop();
            }
                
            


            
        }

        // stack이 empty이면 유효한 식임을 출력
        // 그렇지 않으면 잘못된 식임을 출력

        if(stack.empty())
            System.out.println("유효한 식입니다.");
        else
            System.out.println("잘못된 식입니다.");
    }
}
