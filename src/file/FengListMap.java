package file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FengListMap<K, V> {

    /**
     * 存放我们的 Entry
     */
    private List<HashEntry> hashEntries = new ArrayList<>();

    /**
     * 封装我们的hashMap的键值对
     * @param <K>
     * @param <V>
     */
    class HashEntry<K, V> {
        K key;
        V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        HashEntry hashEntry = new HashEntry<>(key, value);
        hashEntries.add(hashEntry); // 放入到数组中
    }
    
    public V get(K key) {
        for (HashEntry hashEntry : hashEntries) {
            if (hashEntry.key.equals(key)) {
                return (V) hashEntry.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FengListMap<String, String> map = new FengListMap<>();
        map.put("fengliulin", "1");
        map.put("fengliulin1", "1");

        System.out.println(map.get("fengliulin"));


    }
}
