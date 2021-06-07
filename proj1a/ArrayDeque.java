public class ArrayDeque<T>
{
    private T[] items;
    private int size;


    private int nextFirst;
    private int nextLast;


    private int edge;
    private int capacity;
    private int expandTimes;

    private static int dumpSize = 8;

    private int[] jumpTableFirst = new int[30];
    private int[] jumpTableLast = new int[30];

    private int[] jumpBackTableFirst = new int[30];

    private int[] numberOfFirst = new int[30];


    private int firstWorkingAt = 0;



    public ArrayDeque()
    {
        items = (T[])new Object[dumpSize];
        size = 0;


        nextFirst = 3;
        nextLast = 4;

        edge = 0;
        capacity = 8;
        expandTimes = 0;
    }

    public void expandSize(int newCapacity)
    {

        T[] temp = (T[]) new Object[newCapacity];
        System.arraycopy(items,0,temp,0,size);
        items = temp;
        edge = size;

        jumpTableFirst[expandTimes] = nextFirst;
        jumpTableLast[expandTimes] = nextLast;

        nextFirst = size + 3;
        nextLast = size + 4;

        expandTimes++;



    }

    public void addFirst(T item)
    {
        if(size == items.length)
        {
            expandSize(size * 2);
        }

        items[nextFirst] = item;

        if(nextFirst == edge)
        {
            nextFirst = items.length - 1;
        }
        else
        {
            nextFirst--;
        }


        int sizeLog = (int) (Math.log(size) / Math.log(2));

        if(sizeLog < 3)
        {
            firstWorkingAt = 0;
        }
        else
        {
            firstWorkingAt = sizeLog - 2;
        }

        size++;
        numberOfFirst[firstWorkingAt]++;
    }

    public void addLast(T item)
    {
        if(size == items.length)
        {
            expandSize(size * 2);
        }

        items[nextLast] = item;
        thisLast = nextLast;
        if(nextLast == items.length - 1)
        {
            nextLast = edge;
        }
        else
        {
            nextLast++;
        }
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
        int tempExpandTimes = expandTimes - 1;
        int tempNextFirst = nextFirst;
        int occupied = size - edge;
        while(occupied != 0)
        {
            if(tempNextFirst + 1 == items.length)
            {
                tempNextFirst = edge - 1;
            }
            System.out.print(items[++tempNextFirst]);
            System.out.print(" ");
            occupied--;
        }

        if(expandTimes == 0)
        {
            return;
        }


        tempNextFirst = jumpTableFirst[tempExpandTimes];

        int loopSize = items.length / 4;



        while(tempExpandTimes > 0)
        {
            if(tempExpandTimes == 1)
            {
                loopSize = dumpSize;
            }
            int tempLoopSize = loopSize;

            while(tempLoopSize != 0)
            {
                if(tempNextFirst + 1 == loopSize * 2)
                {
                    tempNextFirst = loopSize - 1;
                }
                System.out.print(items[++tempNextFirst]);
                System.out.print(" ");
                tempLoopSize--;
            }
            loopSize = loopSize / 2;
            tempExpandTimes--;
            tempNextFirst = jumpTableFirst[tempExpandTimes];

        }

        tempNextFirst = jumpTableFirst[0];
        for(int index = 0;index < dumpSize;index++)
        {
            if(tempNextFirst + 1 == dumpSize)
            {
                tempNextFirst = -1;
            }
            System.out.print(items[++tempNextFirst]);
            System.out.print(" ");
        }



    }

    public void halfSize(int newCapacity)
    {
        expandTimes--;
        T[] temp = (T[]) new Object[newCapacity];
        System.arraycopy(items,0,temp,0,newCapacity);
        items = temp;
        edge = edge / 2;
        if(expandTimes == 0)
        {
            edge = 0;
        }

    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size / (double) items.length < 0.5 && items.length > 8) {
            halfSize(items.length / 2);
        }

        int currentFirst;
        int currentNextFirstWorkingAt = Math.max((int)(Math.log(nextFirst+1)/Math.log(2)) - 3,0);
        if(currentNextFirstWorkingAt > firstWorkingAt)
        {
            currentFirst = jumpTableFirst[firstWorkingAt];
        }
        else
        {
            currentFirst = nextFirst;
        }

        currentFirst = (currentFirst++) % (1 << firstWorkingAt + 3);

        nextFirst = currentFirst;
        nextLast = currentFirst;
        size--;
        return items[currentFirst];
    }

    public T removeLast()
    {
        if(size == 0)
        {
            return null;
        }
        if(size/(double)items.length < 0.5 && items.length > 8)
        {
            halfSize(items.length/2);
        }
        if(size == edge)
        {
            nextLast = jumpTableLast[expandTimes];
            nextFirst = nextLast;
        }
        else
        {
            if(nextLast == edge)
            {
                nextLast = items.length - 1;
            }
            else
            {
                nextLast--;
            }
        }

        size--;
        return items[nextLast];
    }
    /*
    public T get(int index)
    {
        if(index < 0 || index > size - 1)
        {
            return null;
        }

        int reverse_index = size - 1 - index;

        int partOfIndex = (int) (Math.log(reverse_index)/Math.log(2));

        nextLast --


    }
    */





}


