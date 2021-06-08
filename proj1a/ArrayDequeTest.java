
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
        ArrayDeque.addFirst(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.addLast(2);
        ArrayDeque.removeFirst()  ;
        ArrayDeque.removeFirst() ;
        System.out.println(ArrayDeque.get(0));
        System.out.println(ArrayDeque.get(0));
        ArrayDeque.addLast(7);
        ArrayDeque.addLast(8);
        ArrayDeque.removeFirst()    ;
        ArrayDeque.addLast(10);
        ArrayDeque.removeFirst()    ;
        ArrayDeque.removeFirst()    ;
        ArrayDeque.removeLast()   ;
        ArrayDeque.addLast(14);
        System.out.println(ArrayDeque.get(0));
    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
