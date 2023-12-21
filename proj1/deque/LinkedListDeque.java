package deque;

public class LinkedListDeque <T> {
    private class LinkNode {
        T item;
        LinkNode prev;
        LinkNode next;
        public LinkNode(T item,LinkNode prev,LinkNode next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
        public LinkNode(){
            this.item = null;
            this.prev = this;
            this.next = this;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }

        public void setPrev(LinkNode prev) {
            this.prev = prev;
        }
    }
    private LinkNode sentinel;
    private int size;
    public LinkedListDeque(){
        this.sentinel = new LinkNode();
        this.size = 0;
    }
    public void addFirst(T item){
        LinkNode newNode = new LinkNode(item,this.sentinel,this.sentinel.next);
        LinkNode lastNextFirst = this.sentinel.next;
        lastNextFirst.setPrev(newNode);
        this.sentinel.next = newNode;
        this.size += 1;
    }
    public void addLast(T item){
        LinkNode newNode = new LinkNode(item,this.sentinel.prev,this.sentinel);
        LinkNode lastPrevLast = this.sentinel.prev;
        lastPrevLast.setNext(newNode);
        this.sentinel.prev = newNode;
        this.size += 1;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public int size(){
        return this.size;
    }
    public void printDeque(){
        LinkNode curNode = this.sentinel.next;
        while (curNode != this.sentinel){
            System.out.print(curNode.item + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }
    public T removeFirst(){
        if (this.size == 0){
            return null;
        }
        T firstItem = this.sentinel.next.item;
        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.prev = this.sentinel;
        size -= 1;
        return firstItem;
    }
    public T removeLast(){
        if (this.size == 0){
            return null;
        }
        T lastItem = this.sentinel.prev.item;
        this.sentinel.prev = this.sentinel.prev.prev;
        this.sentinel.prev.next = this.sentinel;
        size -= 1;
        return lastItem;
    }
    public T get(int index){
        if (index >= this.size){
            return null;
        }
        LinkNode curNode = this.sentinel.next;
        while (index != 0){
            curNode = curNode.next;
            index -= 1;
        }
        return curNode.item;
    }
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque) {
            LinkedListDeque<T> ob = (LinkedListDeque<T>) o;
            for (int i = 0; i < ob.size(); i++) {
                boolean flag = ob.get(i).equals(this.get(i));
                if (!flag) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    public T getRecursive(int index){
        if (this.size == 0 && index >= this.size){
            return null;
        }else{
            return getRecursiveHelper(index, this.sentinel.next);
        }

    }
    private T getRecursiveHelper(int index,LinkNode sentinel){
        if (index == 0){
            return sentinel.item;
        }else{
            return getRecursiveHelper(index--, sentinel.next);
        }
    }
}
