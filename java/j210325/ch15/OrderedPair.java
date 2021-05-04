package j210325.ch15;

public class OrderedPair <K,V>{
    private K key;
    private V value;

    public OrderedPair(K key, V value)
    {
        this.key=key;
        this.value=value;
    }

    public K getKey()   {   return key; }
    public V getValue() {   return value;   }
}
