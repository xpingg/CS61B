
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> A = new ArrayDeque();
        A.addFirst(4);
        A.addFirst(5);
        A.addLast(3);
        A.addFirst(8);
        A.addLast(7);
        A.addLast(6);
        A.addFirst(0);
        A.addFirst(9);
        A.addFirst(423);
        A.addLast(433);
        A.removeFirst();

        A.printDeque();

    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
