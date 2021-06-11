import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Array;

public class TestArrayDequeGold
{
    @Test
    public void testArrayDequeGold()
    {
        StudentArrayDeque<Integer> tA= new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sA = new ArrayDequeSolution<>();

        ArrayDequeSolution<String> recordA = new ArrayDequeSolution<>();

        int numberOfDeque = 0;

        for(int i = 0;i < 50000; i++)
        {
            double randomNumber = StdRandom.uniform();
            if(randomNumber < 0.25)
            {
                tA.addFirst(i);
                sA.addFirst(i);
                numberOfDeque++;
                String beRecorded = "addFirst(" + String.valueOf(i) + ")";
                recordA.addFirst(beRecorded);
            }
            else if(randomNumber < 0.5)
            {
                tA.addLast(i);
                sA.addLast(i);
                numberOfDeque++;
                String beRecorded = "addLast(" + String.valueOf(i) + ")";
                recordA.addFirst(beRecorded);
            }
            else if(randomNumber < 0.75)
            {
                if(numberOfDeque > 0)
                {
                    Integer tAI = tA.removeFirst();
                    Integer sAI = sA.removeFirst();
                    String beRecorded = "removeFirst()";
                    recordA.addFirst(beRecorded);

                    String maybeWrong = "\n";
                    for(int index = 0; index < recordA.size() - 1; index++)
                    {
                        maybeWrong = maybeWrong + recordA.get(recordA.size() - 1 -index) + "\n";
                    }
                    maybeWrong = maybeWrong + recordA.get(0);

                    assertEquals(maybeWrong,tAI,sAI);
                    numberOfDeque--;
                }
                else
                {
                    tA.addFirst(i);
                    sA.addFirst(i);
                    numberOfDeque++;
                    String beRecorded = "addFirst(" + String.valueOf(i) + ")";
                    recordA.addFirst(beRecorded);
                }

            }
            else
            {
                if(numberOfDeque > 0)
                {
                    Integer tAI = tA.removeLast();
                    Integer sAI = sA.removeLast();
                    String beRecorded = "removeLast()";
                    recordA.addFirst(beRecorded);

                    String maybeWrong = "\n";
                    for(int index = 0; index < recordA.size() - 1; index++)
                    {
                        maybeWrong = maybeWrong + recordA.get(recordA.size() - 1 - index) + "\n";
                    }
                    maybeWrong = maybeWrong + recordA.get(0);

                    
                    assertEquals(maybeWrong,tAI,sAI);
                    numberOfDeque--;
                }
                else
                {
                    tA.addLast(i);
                    sA.addLast(i);
                    numberOfDeque++;
                    String beRecorded = "addLast(" + String.valueOf(i) + ")";
                    recordA.addFirst(beRecorded);
                }
            }
        }

    }

}
