import java.util.Random;
public class Main {

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable<MyTestingClass, String>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int val = rand.nextInt(0, 9999999);
            hashTable.put(new MyTestingClass(val), "Student " + val);
        }


    }
}
