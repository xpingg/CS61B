
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
        ArrayDeque.addFirst(0);
        System.out.println(ArrayDeque.removeFirst());
        ArrayDeque.addFirst(2);
        ArrayDeque.addLast(3);
        ArrayDeque.size();
        System.out.println(ArrayDeque.removeLast());



    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
