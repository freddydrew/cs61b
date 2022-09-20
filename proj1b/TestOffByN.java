import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offbyN = new OffByN(5);

    // Your tests go here.
    @Test
    public void testOffByN(){
        assertFalse(offbyN.equalChars('f','d'));
        assertTrue(offbyN.equalChars('a','f'));
        assertTrue(offbyN.equalChars('f','a'));

    }
}
