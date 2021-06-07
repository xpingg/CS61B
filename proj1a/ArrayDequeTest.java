
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(1);
        System.out.println(ArrayDeque.removeFirst());   ;
        System.out.println(ArrayDeque.removeLast())  ;
        ArrayDeque.addLast(4);
        System.out.println(ArrayDeque.get(0)) ;    ;
        ArrayDeque.addFirst(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addLast(8);
        ArrayDeque.addLast(9);
        ArrayDeque.addLast(10);
        ArrayDeque.addFirst(11);
        System.out.println(ArrayDeque.get(0));     ;
        ArrayDeque.addLast(13);
        System.out.println(ArrayDeque.get(5));      ;
    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
