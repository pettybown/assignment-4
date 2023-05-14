# assignment-4
### Function: hash
Description: This function takes a key of type K and returns the hash value of the key. It uses the hashCode() method of the key object and performs modulo operation with M (size of the hash table) to determine the index where the key-value pair will be stored.

Code:
```java
private int hash(K key){
        return Math.abs(key.hashCode()) % M;
    }
```

### Function: put
Description: This function is used to insert a key-value pair into the hash table. It calculates the index using the hash function, and if the chain at that index is null, it creates a new LinkedList to store multiple key-value pairs. It then iterates over the chain to check if the key already exists. If found, it updates the value; otherwise, it adds a new HashNode with the given key and value.

Code:
```java
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
```

### Function: get
Description: This function is used to retrieve the value associated with a given key from the hash table. It calculates the index using the hash function and then iterates over the chain at that index to find the matching key. If found, it returns the corresponding value; otherwise, it returns null.

Code:
```java
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
```

### Function: remove
Description: This function is used to remove a key-value pair from the hash table. It calculates the index using the hash function and then iterates over the chain at that index to find the matching key. If found, it removes the corresponding HashNode from the chain, decrements the size, and returns the value; otherwise, it returns null.

Code:
```java
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
```

### Function: contains
Description: This function checks if the hash table contains a specific value. It iterates over all the chains in the hash table and checks if any HashNode's value matches the given value. If found, it returns true; otherwise, it returns false.

Code:
```java
public boolean contains(V value){
        for (LinkedList<HashNode<K, V>> bucket : chain) {
            for (HashNode<K, V> entry : bucket) {
                if (entry.value.equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }
    
```

### Function: getKey
```java
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
```
Description: This function retrieves the key associated with a specific value in the hash table. It iterates over all the chains in the hash table and checks if any HashNode's value matches the given value

### Function: printBucketSizes
```java
public void printBucketSizes() {
        for (int i = 0; i < M; i++) {
            LinkedList<HashNode<K, V>> bucket = chain[i];
            System.out.println("Bucket " + i + " size: " + bucket.size());
        }
    }
```
Description: This function shows amount of elements in each bucket
