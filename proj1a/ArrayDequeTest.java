
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
        ArrayDeque.addFirst(0);
        ArrayDeque.addFirst(1);
        System.out.println(ArrayDeque.removeLast());    ;
        ArrayDeque.addLast(3);
        System.out.println(ArrayDeque.removeFirst());   ;
        System.out.println(ArrayDeque.removeLast());    ;
        ArrayDeque.addLast(6);
        System.out.println(ArrayDeque.removeLast());     ;
        ArrayDeque.addLast(8);
        ArrayDeque.addLast(9);
        ArrayDeque.addLast(10);
        ArrayDeque.addLast(11);
        ArrayDeque.addFirst(12);
        System.out.println(ArrayDeque.removeLast());      ;
        System.out.println(ArrayDeque.get(2));     ;
        System.out.println(ArrayDeque.removeFirst());    ;
        ArrayDeque.addLast(16);
        System.out.println(ArrayDeque.get(1))    ;
        ArrayDeque.addLast(18);
        System.out.println(ArrayDeque.removeLast());      ;
        System.out.println(ArrayDeque.removeFirst());    ;
        ArrayDeque.addFirst(21);
        System.out.println(ArrayDeque.removeLast());    ;
    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
