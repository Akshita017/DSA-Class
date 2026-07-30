import java.util.*;
class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int k, int v){
        this.key = k;
        this.value = v;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer, Node> mp;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.next = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        remove(node);
        insertAtFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node temp = mp.get(key);
            temp.value = value;
            remove(temp);
            insertAtFront(temp);
        }else{ 
            if(mp.size() == capacity){
                Node lru = tail.prev;
                remove(lru);
                mp.remove(lru.key);
            }
            Node n = new Node(key, value);
            insertAtFront(n);
            mp.put(key, n);

        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */