import java.util.LinkedList;

public class MyHashTable <K, V> {
        private static class HashNode<K,V>{
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

        int index = hash(key);
        if (chain[index] == null){
            chain[index] = new LinkedList<HashNode<K, V>>();
        }
        LinkedList<HashNode<K, V>> bucket = chain[index];

        for (HashNode<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update the value if the key already exists
                return;
            }
        }

        bucket.add(new HashNode<>(key, value)); // Add a new entry if the key doesn't exist
    }
    public V get(K key){
        int index = hash(key);
        LinkedList<HashNode<K, V>> bucket = chain[index];

        for (HashNode<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }
    public V remove(K key){
        int index = hash(key);
        LinkedList<HashNode<K, V>> bucket = chain[index];

        for (HashNode<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                V value = entry.value;
                bucket.remove(entry);
                return value;
            }
        }

        return null;
    }
    public boolean contains(V value){
        for (LinkedList<HashNode<K, V>> bucket : chain) {
            for (HashNode<K, V> entry : bucket) {
                if (entry.value.equals(value)) {
                    return true;
                }
            }
        }

        return false;}
        public K getKey(V value){
            for (LinkedList<HashNode<K, V>> bucket : chain) {
                for (HashNode<K, V> entry : bucket) {
                    if (entry.value.equals(value)) {
                        return entry.key;
                    }
                }
            }

            return null;
        }
    public void printBucketSizes() {
        for (int i = 0; i < M; i++) {
            LinkedList<HashNode<K, V>> bucket = chain[i];
            System.out.println("Bucket " + i + " size: " + bucket.size());
        }
    }

}
