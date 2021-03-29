package j210329.ch15;

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

        if(size>=capacity)
        {
            int incresedCapacity = (int)(capacity * 1.5);
            T[] tempArray=(T[]) new Object[incresedCapacity];
            System.arraycopy(array,0,tempArray,0,size);
            array=tempArray;
            capacity=incresedCapacity;
        }

        int saveSize=capacity;
        T[] saveArray=(T[]) new Object[capacity];
        System.arraycopy(array, idx, saveArray, 0, saveSize);
        System.out.println(saveArray);

    }

    public void remove(int idx)
    {

    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
