package LRUCache;

public class LRUCacheExample {
    public static void main(String[] args) {
        LRUCache<String, Integer> lru = new LRUCache<String, Integer>(3);
        lru.put("A", 1);
        lru.put("B", 2);
        lru.put("C", 3);
        lru.get("A"); // A becomes MRU
        lru.put("D", 4); // B is LRU, should be evicted

        lru.printMap();
        System.out.println();
        lru.printList();
    }
}
