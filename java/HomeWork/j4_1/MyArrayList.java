package HomeWork.j4_1;


import java.util.Iterator;

public class MyArrayList <T> implements Iterable{
    Object[] array;
    private int capacity=10;
    private int size=0;


    public MyArrayList(){
        array=new Object[10];
    }

    public int size()
    {return size;}
    public void add(T value){
        

        if(size >= capacity){
            int incresedCapacity = (int)(capacity * 1.5);
            T[] tempArray=(T[]) new Object[incresedCapacity];
            // for(int i=0; i<size; i++)
            //     tempArray[i]=array[i];   // 비효율 적
            System.arraycopy(array,0,tempArray,0,size);
            array=tempArray;
            capacity=incresedCapacity;
        }
        array[size++]=value;
    }

    public T get(int idx){
        if(idx <=size)
            return (T)array[idx];
        else
            return null;
    }

    // 중간에 하는 추가하고 삭제하는 것
    public void add(T value, int idx)
    {
        //  만약 공간이 부족할 경우 확장, 위의 add와 똑같다.
        if(size>=capacity)
        {
            int incresedCapacity = (int)(capacity * 1.5);
            T[] tempArray=(T[]) new Object[incresedCapacity];
            System.arraycopy(array,0,tempArray,0,size);
            array=tempArray;
            capacity=incresedCapacity;
        }

        
        // T[] addArray=(T[]) new Object[capacity];    // 배열을 자르고 뒷 부분을 저장할 배열 생성
        // System.arraycopy(array, idx, addArray, 0, capacity-idx);    // array의 idx 부분 부터 addArray의 0 번째 부분부터 array의 capacity-idx 길이 만큼 복사
        // array[idx]=value;   // array의 idx 부분에 value 값으로 수정
        // int addArrayN=0;    // 아래의 addArray 배열의 위치를 하나씩 옮겨줄 변수

        


        // //  array의 value값이 들어간 idx 다음 부분인 idx+1 부분 부터 addArray에 저장된 나머지 뒷 부분을 넣어 주는 작업
        // for(int i=idx+1; i<idx+(capacity-idx); i++)
        // {
        //     array[i]=addArray[addArrayN];
        //     addArrayN++;
        // }


        // 교수님 방법
        for(int i=capacity-1; i>=idx; i--)
            array[i+1]=array[i];
        
        array[idx]=value;

        size++;     // 값이 하나 추가 됬으니 size도 1 증가


    }

    public void remove(int idx)
    {
        if(idx>0 && idx<capacity)
        {
            int idxArray=idx-1;         // 배열은 0부터 시작하기 때문에 -1을 해줘야 원하는 부분을 삭제 가능
            for(int i=idxArray+1; i<array.length; i++)  // 삭제하고 싶은 부분의 다음 부분 부터 끝까지를 불러 옴
                array[i-1]=array[i];    // 삭제 하고 싶은 부분을 그 앞에 부분 부터 하나씩 덮어 씌우기
        
            size--;                 // 1 감소
        }
        else if (idx<=0)
            System.out.println("0보단 크게");
        else
            System.out.println("너무 큼");
        
    }

    // array 배열 표시 부분
    public void showArray()
    {
        if (array[0]==null)
            System.out.println("null");
        else
            for(int i=0; i<array.length; i++)
            {
                if(array[i] ==null)
                    break;
                System.out.print(array[i] + " ");
            }
            
    }
    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}

