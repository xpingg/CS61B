
public class ArrayDequeTest
{

    public static void testAddFirst()
    {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque();
        ArrayDeque.addFirst(0);
        System.out.println(ArrayDeque.get(0)) ;
        System.out.println(ArrayDeque.removeFirst()) ;
        ArrayDeque.addLast(3);
        ArrayDeque.addLast(4);
        ArrayDeque.addFirst(5);
        System.out.println(ArrayDeque.removeFirst());
        System.out.println(ArrayDeque.get(1));
        System.out.println(ArrayDeque.get(1));
        System.out.println(ArrayDeque.removeFirst());
        System.out.println(ArrayDeque.get(0));

    }
    public static void main(String[] args)
    {
        testAddFirst();
    }

}
