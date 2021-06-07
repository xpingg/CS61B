
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(1);
        System.out.println(ArrayDeque.get(1));
        ArrayDeque.addLast(3);
        System.out.println(ArrayDeque.removeLast());
        ArrayDeque.addLast(5);
        System.out.println(ArrayDeque.removeLast());
        System.out.println(ArrayDeque.removeFirst());
        System.out.println(ArrayDeque.get(0));
        ArrayDeque.addLast(9);
        ArrayDeque.addLast(10);
        ArrayDeque.addFirst(11);
        System.out.println(ArrayDeque.removeLast());
        System.out.println(ArrayDeque.get(0));
        System.out.println(ArrayDeque.get(0)) ;
        System.out.println(ArrayDeque.removeFirst());
        System.out.println(ArrayDeque.removeFirst());
    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
