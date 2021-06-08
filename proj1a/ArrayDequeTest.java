import java.lang.reflect.Array;

public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(1);
        System.out.println(ArrayDeque.get(1));     ;
        ArrayDeque.removeFirst()  ;
        ArrayDeque.addFirst(4);
        ArrayDeque.addLast(5);
        ArrayDeque.addLast(6);
        ArrayDeque.removeFirst()  ;
        System.out.println(ArrayDeque.get(1));    ;
        ArrayDeque.removeFirst() ;
        ArrayDeque.removeFirst() ;
   }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
