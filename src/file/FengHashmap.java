package file;

import java.util.ArrayList;
import java.util.List;

public class FengHashmap<K, V> {


    private HashEntry[] hashEntries = new HashEntry[10000];

    /**
     * 封装我们的hashMap的键值对
     * @param <K>
     * @param <V>
     */
    class HashEntry<K, V> {
        K key;
        V value;
        HashEntry next;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        //根据key计算hashcode，得出该key存放得index下标位置
        int index = key.hashCode() % hashEntries.length; //每个key得hashcode是不变的
//        HashEntry<K, V> hashEntry = new HashEntry<>(key, value);
        HashEntry newBashEntry = new HashEntry(key,value);

        HashEntry hashEntry = hashEntries[index];
        if (hashEntry == null) {
            hashEntries[index] = newBashEntry;
            return;
        }
        //尾插法
        hashEntry.next = newBashEntry;

    }

    public V get(K key) {
        //根据key查询我们得键值对时间复杂度是为o1
        int index = key.hashCode() % hashEntries.length;

        //遍历链表
        for (HashEntry hashEntry = hashEntries[index]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.key.equals(key) || hashEntry.key == key) {
                return (V) hashEntry.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FengHashmap<Object, String> map = new FengHashmap<>();
        map.put("a", "冯镠霖");
        map.put(97, "冯镠霖1");
        System.out.println(map.get(97));
    }
}
