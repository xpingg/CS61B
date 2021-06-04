public class LinkedListDeque<T>
{
    private class typeNode
    {
        T item;
        typeNode prev;
        typeNode next;

        public typeNode(T _item, typeNode _prev, typeNode _next) {
            item = _item;
            prev = _prev;
            next = _next;
        }

    }

    private typeNode sentinel;

    private int size = 0;

    public LinkedListDeque()
    {
        sentinel = new typeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item)
    {
        typeNode addedNode = new typeNode(item, null, null);
        addedNode.prev = sentinel;
        addedNode.next = sentinel.next;
        sentinel.next.prev = addedNode;
        sentinel.next = addedNode;
        size++;
    }

    public void addLast(T item)
    {
        typeNode addedNode = new typeNode(item, null, null);
        addedNode.prev = sentinel.prev;
        addedNode.next = sentinel;
        sentinel.prev.next = addedNode;
        sentinel.prev = addedNode;
        size++;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public void printDeque()
    {
        typeNode p = sentinel;
        while(p.next!=sentinel)
        {
            p = p.next;
            System.out.print(p.item);
            System.out.print(" ");
        }
    }

    public T removeFirst()
    {
        if(sentinel.next != sentinel)
        {
            size--;
        }
        T returnItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;

        return returnItem;
    }

    public T removeLast()
    {
        if(sentinel.next != sentinel)
        {
            size--;
        }
        T returnItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        return returnItem;
    }

    public T get(int index)
    {
        typeNode p = sentinel.next;
        T returnItem = p.item;
        int currentIndex = 0;
        while(p.next != sentinel && currentIndex < index)
        {
            p = p.next;
            returnItem = p.item;
            currentIndex++;
        }

        return returnItem;

    }

    private T getRecursive(int index,typeNode p)
    {
        if(index == 0 || p.next == sentinel)
        {
            return p.next.item;
        }
        else
        {
            return getRecursive(index - 1,p.next);
        }

    }

    public T getRecursive(int index)
    {
        return getRecursive(index,sentinel);
    }



}


