public class ArrayDeque<T> implements Deque<T>
{
    private T[] itemsFirst;
    private T[] itemsLast;


    private int nextFirst = 0;
    private int nextLast = 0;
    private int thisFirst = -1;
    private int thisLast = -1;
    private int firstValidAtFirst = 0;
    private int firstValidAtLast = 0;

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

    @Override
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
    @Override
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


    public void insert(T x,int position)
    {
        if(position < 0)
        {
            return;
        }

        if(position <= firstSize)
        {
            if(nextFirst > itemsFirst.length - 1)
            {
                expandSizeFirst(itemsFirst.length * 2);
            }
            int numberOfMove = position;
            while(numberOfMove > 0)
            {
                itemsFirst[nextFirst - (position - numberOfMove)] = itemsFirst[thisFirst - (position - numberOfMove)];
                numberOfMove--;
            }
            itemsFirst[thisFirst - position + 1] = x;
            nextFirst++;
            thisFirst++;
            firstSize++;
        }
        else
        {
            if(nextLast > itemsLast.length - 1)
            {
                expandSizeLast(itemsLast.length * 2);
            }
            int numberOfMove = size() - position;
            while(numberOfMove > 0)
            {
                itemsLast[nextLast - ((size() - position) - numberOfMove)] = itemsLast[thisLast - ((size() - position) - numberOfMove)];
                numberOfMove--;
            }
            itemsLast[thisLast - Math.max(0,(size() - position)) + 1] = x;
            nextLast++;
            thisLast++;
            lastSize++;
        }

    }

    @Override
    public boolean isEmpty()

    {
        return firstSize + lastSize == 0;
    }

    @Override
    public int size()
    {
        return firstSize + lastSize;
    }

    @Override
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
            System.arraycopy(itemsFirst,firstValidAtFirst,temp,0,newCapacity);
            thisLast = -1;

            thisFirst = thisFirst - firstValidAtFirst;
            nextFirst = thisFirst + 1;
            firstValidAtFirst = 0;

        }
        else
        {
            System.arraycopy(itemsFirst, firstValidAtFirst, temp, 0, newCapacity);
            thisFirst = thisFirst - firstValidAtFirst;
            nextFirst = thisFirst + 1;
            firstValidAtFirst = 0;
        }
        itemsFirst = temp;


    }

    private void halfSizeLast(int newCapacity)
    {

        T[] temp = (T[]) new Object[newCapacity];

        if(thisFirst < 0)
        {
            System.arraycopy(itemsLast,firstValidAtLast,temp,0,newCapacity);
            thisFirst = -1;
            thisLast = thisLast - firstValidAtLast;
            nextLast = thisLast + 1;
            firstValidAtLast = 0;
        }
        else
        {
            System.arraycopy(itemsLast, firstValidAtLast, temp, 0, newCapacity);
            thisLast = thisLast - firstValidAtLast;
            nextLast = thisLast + 1;
            firstValidAtLast = 0;
        }
        itemsLast = temp;


    }

    @Override
    public T removeFirst() {
        if (isEmpty())
        {
            return null;
        }

        T returnResult;

        if(thisFirst >= 0)
        {
            returnResult = itemsFirst[thisFirst];
            if ((thisFirst + 1 - firstValidAtFirst) / (double) itemsFirst.length <= 0.5 && itemsFirst.length > 4)
            {
                halfSizeFirst(itemsFirst.length / 2);
            }
            thisFirst--;
            nextFirst--;
            firstSize--;
            if(firstSize == 0)
            {
                firstValidAtFirst = 0;
                thisFirst = -1;
                nextFirst = 0;
                if(thisLast < 0)
                {
                    thisLast = -1;
                }
            }
        }
        else
        {
            if(-(thisFirst + 1) < firstValidAtLast)
            {
                thisFirst = - firstValidAtLast - 1;
            }
            returnResult = itemsLast[-(thisFirst+1)];
            if ((thisLast + 1 - firstValidAtLast) / (double) itemsLast.length <= 0.5 && itemsLast.length > 4)
            {
                halfSizeLast(itemsLast.length / 2);
            }

            thisFirst--;
            lastSize--;
            if(lastSize == 0)
            {
                thisLast = -1;
                nextLast = 0;
                thisFirst = -1;
            }
            firstValidAtLast = - thisFirst - 1;

        }

        return returnResult;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
        {
            return null;
        }

        T returnResult;

        if(thisLast >= 0)
        {
            returnResult = itemsLast[thisLast];
            if ((thisLast + 1 - firstValidAtLast) / (double) itemsLast.length <= 0.5 && itemsLast.length > 4)
            {
                halfSizeLast(itemsLast.length / 2);
            }
            thisLast--;
            nextLast--;
            lastSize--;
            if(lastSize == 0)
            {
                firstValidAtLast = 0;
                thisLast = -1;
                nextLast = 0;
                if(thisFirst < 0)
                {
                    thisFirst = -1;
                }
            }
        }
        else
        {
            if(-(thisLast + 1) < firstValidAtFirst)
            {
                thisLast = -firstValidAtFirst - 1;
            }
            returnResult = itemsFirst[-(thisLast+1)];
            if ((thisFirst + 1 - firstValidAtFirst)/ (double) itemsFirst.length <= 0.5 && itemsFirst.length > 4)
            {
                halfSizeFirst(itemsFirst.length / 2);
            }
            thisLast--;
            firstSize--;
            if(firstSize == 0)
            {
                thisFirst = -1;
                nextFirst = 0;
                thisLast = -1;
            }
            firstValidAtFirst = - thisLast - 1;
        }

        return returnResult;
    }

    @Override
    public T get(int index)
    {
        if (index < 0 || index > size() - 1)
        {
            return null;
        }

        if(index <= firstSize - 1)
        {
            return itemsFirst[-index + thisFirst];
        }
        else
        {
            if(thisFirst >= 0)
            {
                index = size() - 1 - index;
                return itemsLast[thisLast - index];
            }
            else
            {
                return itemsLast[Math.max(firstValidAtLast,-(thisFirst+1))+index];
            }
        }



    }









}


