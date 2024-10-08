import java.util.HashMap;

class LC146{
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }


    public static class LRUCache {
        static class Node {
            int key;
            int val;
            Node prev;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        int cap;
        HashMap<Integer, Node> m = new HashMap<>();

        public LRUCache(int capacity) {
            cap = capacity;
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(Node newnode) {
            Node temp = head.next;

            newnode.next = temp;
            newnode.prev = head;

            head.next = newnode;
            temp.prev = newnode;
        }

        private void deleteNode(Node delnode) {
            Node prevv = delnode.prev;
            Node nextt = delnode.next;

            prevv.next = nextt;
            nextt.prev = prevv;
        }

        public int get(int key) {
            if (m.containsKey(key)) {
                Node resNode = m.get(key);
                int ans = resNode.val;

                m.remove(key);
                deleteNode(resNode);
                addNode(resNode);

                m.put(key, head.next);
                return ans;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (m.containsKey(key)) {
                Node curr = m.get(key);
                m.remove(key);
                deleteNode(curr);
            }

            if (m.size() == cap) {
                m.remove(tail.prev.key);
                deleteNode(tail.prev);
            }

            addNode(new Node(key, value));
            m.put(key, head.next);
        }
    }
}