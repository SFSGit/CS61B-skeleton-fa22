package deque;

public class ArrayDeque <T> {
    private T[] items;
    private int size;
    int nextFirst;
    int nextLast;
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    private void resize(int capacity){
        T[] newArray = (T[]) new Object[capacity];
        int itemIndex  = (nextFirst + 1) % items.length;
        for (int i = 0; i < this.size; i++){
            newArray[i] = items[itemIndex];
            itemIndex = (itemIndex + 1) % items.length;
        }
        items = newArray;
        nextFirst = items.length - 1;
        nextLast = this.size;
    }
    public void addFirst(T item){
        if (this.size == items.length){
            resize(size*2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }
    public void addLast(T item){
        if (this.size == items.length){
            resize(size*2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public int size(){
        return this.size;
    }
    public void printDeque(){
        int itemIndex = (nextFirst + 1) % items.length;
        for (int i = 1; i<=this.size; i++){
            System.out.print(items[itemIndex] + " ");
            itemIndex = (itemIndex + 1) % items.length;
        }
        System.out.println();
    }
    public T removeFirst(){
        if (this.size == 0){
            return null;
        }
        if(items.length >= 16 && this.size < items.length/4 ){
            resize(items.length/4);
        }
        int firstItemIndex = (nextFirst + 1) % items.length;
        T x = items[firstItemIndex];
        items[firstItemIndex] = null;
        this.nextFirst = firstItemIndex;
        this.size -= 1;
        return x;
    }
    public T removeLast(){
        if (this.size == 0){
            return null;
        }
        if(items.length >= 16 && this.size < items.length/4 ){
            resize(items.length/4);
        }
        int lastItemIndex = (nextLast - 1 + items.length) % items.length;
        T x = items[lastItemIndex];
        items[lastItemIndex] = null;
        this.nextLast = lastItemIndex;
        this.size -= 1;
        return x;
    }
    public T get(int index){
        if (index >= this.size){
            return null;
        }
        int firstItemIndex = (nextFirst + 1) % items.length;
        int getItemIndex = (firstItemIndex + index) % items.length;
        return items[getItemIndex];
    }
    public boolean equals(Object o){
        if (o instanceof ArrayDeque) {
            ArrayDeque<T> ob = (ArrayDeque<T>) o;
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
}
