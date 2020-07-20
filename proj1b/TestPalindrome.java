import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
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
    public void testPalindrome1() {
        String temp = "acbbca";
        boolean actual = true;
        boolean expected = palindrome.isPalindrome(temp);
        assertEquals(expected, actual);
    }

    @Test
    public void testPalindrome2() {
        String temp = "stupid";
        boolean actual = false;
        boolean expected = palindrome.isPalindrome(temp);
        assertEquals(expected, actual);
    }
}
