import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);

        d = palindrome.wordToDeque("peRSiflage");
        actual = "";
        for (int i = 0; i < "peRSiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("peRSiflage", actual);

        d = palindrome.wordToDeque("persiflag!e");
        actual = "";
        for (int i = 0; i < "persiflag!e".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflag!e", actual);



        d = palindrome.wordToDeque("");
        actual = "";
        for (int i = 0; i < d.size(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("",actual);



    }

    @Test
    public void testIsPalindrome()
    {
         CharacterComparator cc = new OffByOne();
         assertTrue(palindrome.isPalindrome("flake",cc));
         assertTrue(palindrome.isPalindrome("eeaeeaee"));
    }

}
