import java.util.LinkedList;

public class MyHashTable <K, V> {
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode <K, V> next;

        public HashNode (K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString (){
            return "{" + key + " " + value + "}";
        }
    }
    private LinkedList<HashNode<K, V>>[] chain;
    private int M = 11;
    private int size;
    public MyHashTable(){
        chain = new LinkedList[M];
        size = 0;

    }
    public MyHashTable (int m){
        this.M = m;
        chain = new LinkedList[M];
        size = 0;
    }
    private int hash(K key){
        return Math.abs(key.hashCode()) % M;

    }
    public void  put(K key, V value){
    }
    public V get(K key){
    }
    public V remove(K key){
    }
    public boolean contains(V value){
    return true;
    }
        public K getKey(V value){
        }

}
