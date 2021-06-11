import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne
{
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars()
    {
        OffByOne offByOne = new OffByOne();
        assertTrue(offByOne.equalChars('a','b'));
    }

}
