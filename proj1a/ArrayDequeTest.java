
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(1);
        ArrayDeque.addLast(2);
        System.out.println(ArrayDeque.get(1));      ;
        ArrayDeque.addLast(4);
        System.out.println(ArrayDeque.removeFirst());     ;
        ArrayDeque.addFirst(6);
        System.out.println(ArrayDeque.removeLast());     ;
        System.out.println(ArrayDeque.removeFirst());    ;
        System.out.println(ArrayDeque.get(1));
    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
