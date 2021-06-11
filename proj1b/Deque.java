public interface Deque<T>
{
    public void addFirst(T item);

    public void addLast(T item);

    public void insert(T x,int position);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

}
