public class ArrayDeque<T>
{
    private T[] itemsFirst;
    private T[] itemsLast;


    private int nextFirst = 0;
    private int nextLast = 0;
    private int thisFirst = -1;
    private int thisLast = -1;

    private int firstSize = 0;
    private int lastSize = 0;



    private static int dumpSize = 4;

    public ArrayDeque()
    {
        itemsFirst = (T[])new Object[dumpSize];
        itemsLast = (T[])new Object[dumpSize];

    }

    private void expandSizeFirst(int newCapacity)
    {

        T[] temp = (T[]) new Object[newCapacity];
        System.arraycopy(itemsFirst,0,temp,0,itemsFirst.length);
        itemsFirst = temp;

    }

    public void addFirst(T item)
    {
        if(nextFirst > itemsFirst.length - 1)
        {
            expandSizeFirst(itemsFirst.length * 2);
        }

        itemsFirst[nextFirst] = item;

        thisFirst = nextFirst;

        nextFirst++;

        firstSize++;
    }

    private void expandSizeLast(int newCapacity)
    {

        T[] temp = (T[]) new Object[newCapacity];
        System.arraycopy(itemsLast,0,temp,0, itemsLast.length);
        itemsLast = temp;

    }
    public void addLast(T item)
    {
        if(nextLast > itemsLast.length - 1)
        {
            expandSizeLast(itemsLast.length * 2);
        }

        itemsLast[nextLast] = item;

        thisLast = nextLast;

        nextLast++;

        lastSize++;
    }

    public boolean isEmpty()

    {
        return firstSize + lastSize == 0;
    }

    public int size()
    {
        return firstSize + lastSize;
    }

    public void printDeque()
    {
        int index = 0;
        while(index < size())
        {
            System.out.print(get(index));
            System.out.print(" ");
            index++;
        }

    }

    private void halfSizeFirst(int newCapacity)
    {

        T[] temp = (T[]) new Object[newCapacity];

        if(thisLast < 0)
        {
            System.arraycopy(itemsFirst,-(thisLast+1),temp,0,newCapacity);
            thisLast = -1;
            thisFirst = firstSize / 2 - 1;
            nextFirst = thisFirst + 1;
        }
        else
        {
            System.arraycopy(itemsFirst, 0, temp, 0, newCapacity);
        }
        itemsFirst = temp;


    }

    private void halfSizeLast(int newCapacity)
    {

        T[] temp = (T[]) new Object[newCapacity];

        if(thisFirst < 0)
        {
            System.arraycopy(itemsLast,-(thisFirst+1),temp,0,newCapacity);
            thisFirst = -1;
            thisLast = lastSize / 2 - 1;
            nextLast = thisLast + 1;
        }
        else
        {
            System.arraycopy(itemsLast, 0, temp, 0, newCapacity);
        }
        itemsLast = temp;


    }

    public T removeFirst() {
        if (isEmpty())
        {
            return null;
        }

        T returnResult;

        if(thisFirst >= 0)
        {
            returnResult = itemsFirst[thisFirst];
            if (firstSize / (double) itemsFirst.length <= 0.5 && itemsFirst.length > 4)
            {
                halfSizeFirst(itemsFirst.length / 2);
            }
            thisFirst--;
            nextFirst--;
            firstSize--;
        }
        else
        {
            returnResult = itemsLast[-(thisFirst+1)];
            if (lastSize / (double) itemsLast.length <= 0.5 && itemsLast.length > 4)
            {
                halfSizeLast(itemsLast.length / 2);
            }
            thisFirst--;
            lastSize--;
        }

        return returnResult;
    }


    public T removeLast() {
        if (isEmpty())
        {
            return null;
        }

        T returnResult;

        if(thisLast >= 0)
        {
            returnResult = itemsLast[thisLast];
            if (lastSize / (double) itemsLast.length <= 0.5 && itemsLast.length > 4)
            {
                halfSizeLast(itemsLast.length / 2);
            }
            thisLast--;
            nextLast--;
            lastSize--;
        }
        else
        {
            returnResult = itemsFirst[-(thisLast+1)];
            if (firstSize / (double) itemsFirst.length <= 0.5 && itemsFirst.length > 4)
            {
                halfSizeLast(itemsFirst.length / 2);
            }
            thisLast--;
            firstSize--;
        }

        return returnResult;
    }


    public T get(int index)
    {
        if (index < 0 || index > size() - 1)
        {
            return null;
        }

        if(index <= firstSize - 1)
        {
            return itemsFirst[-index + firstSize - 1];
        }
        else
        {
            index = index - firstSize;
            return itemsLast[index];
        }

    }








}


