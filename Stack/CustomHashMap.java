package Stack;

class Entry {
    int key, value;
    Entry next;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap {
    final static int SIZE = 10;
    Entry[] table = new Entry[SIZE];

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Entry head = table[index];
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        Entry newEntry = new Entry(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public Integer get(int key) {
        int index = hash(key);
        Entry head = table[index];
        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 100);
        map.put(11, 110);
        System.out.println(map.get(1));
        System.out.println(map.get(11));
        System.out.println(map.get(2));
    }
}
