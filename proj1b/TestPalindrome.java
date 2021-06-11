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
    }

    @Test
    public void testIsPalindrome()
    {
         CharacterComparator cc = new OffByOne();
         assertTrue(palindrome.isPalindrome("flake",cc));
         assertTrue(palindrome.isPalindrome("eeaeeaee"));
    }

}
