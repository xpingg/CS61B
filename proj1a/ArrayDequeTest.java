
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
        ArrayDeque.addFirst(0);
        ArrayDeque.addLast(1);
        System.out.println(ArrayDeque.removeLast());      ;
        System.out.println(ArrayDeque.get(0));  ;
        System.out.println(ArrayDeque.removeLast());  ;
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        System.out.println(ArrayDeque.removeLast() );   ;
        ArrayDeque.addFirst(8);
        ArrayDeque.addLast(9);
        ArrayDeque.addFirst(10);
        System.out.println(ArrayDeque.removeLast());      ;
        System.out.println(ArrayDeque.get(1));     ;
        ArrayDeque.addFirst(13);
        System.out.println(ArrayDeque.get(0));      ;
        System.out.println(ArrayDeque.removeFirst());   ;
        System.out.println(ArrayDeque.removeFirst())  ;
    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
