package LRUCache;

import java.util.HashMap;

public class LRUCache<K, V> {

    private static class Node<K, V> {
        private K key;
        private V value;
        Node<K, V> prev, next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    private final Node<K, V> head, tail;
    private final HashMap<K, Node<K, V>> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node<K, V>(null, null);
        this.tail = new Node<K, V>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);

        if (node == null)
            return null;

        /*
         * the node is the most recently used.So, add it to the rightmost of the list
         */
        removeFromList(node);
        addToList(node);
        return node.getValue();

    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);

        /*
        * key exists in the map. So update the new value to mapped node,
        * remove the node from list and
        * add it again because it is the most recently used now.
        */
        if (node != null) {
            node.value = value;
            removeFromList(node);
            addToList(node);
        }
        /*
        * Node is null. That means new node to be created and added to the list.
        * If list is full (size is equal to capacity), the lru node should be removed form list and
        * key should be removed from map first.
        * Then new node should be inserted into list
        * update map with the key.
        */
        else {
            if (map.size() >= capacity) {
                Node<K, V> lru = head.next;
                removeFromList(lru);
                map.remove(lru.getKey());
            }

            node = new Node<K, V>(key, value);
            addToList(node);
            map.put(key, node);
        }
    }

    // first one is LRU and last one is MRU
    private void addToList(Node<K, V> target) {
        target.prev = tail.prev;
        target.next = tail;
        tail.prev.next = target;
        tail.prev = target;
    }

    private K removeFromList(Node<K, V> target) {
        target.next.prev = target.prev;
        target.prev.next = target.next;
        return target.getKey();
    }

    public void printMap() {
        map.forEach(((key, value) -> {
            System.out.println("Key: " + key + "\tvalue: " + value.getValue());
        }));
    }
    public void printList() {
        Node<K, V> node = head.next;

        while (node.key != null) {
            System.out.println("Node key: " + node.getKey() + "\tNode value: " + node.getValue());
            node = node.next;
        }
    }
}
