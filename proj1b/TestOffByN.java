import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestOffByN {
    static CharacterComparator OffByN;

    @Test
    public void testEqualChars() {
        OffByN = new OffByN(3);
        assertTrue(OffByN.equalChars('a', 'd'));
        assertTrue(OffByN.equalChars('g', 'd'));
        assertFalse(OffByN.equalChars('a', 'a'));
    }

}
