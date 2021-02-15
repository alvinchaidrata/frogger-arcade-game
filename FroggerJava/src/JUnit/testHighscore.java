package JUnit;
import static org.junit.jupiter.api.Assertions.*;
import p4_group_8_repo.Highscore;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class testHighscore {
    @Test
    public void testSetScore() throws IOException {
        Highscore test = new Highscore();
        test.setScore(100);
        test.setScore(500);
        assertTrue(test.arr.get(0)>test.arr.get(1));
        assertTrue(test.arr.get(0)==500);
        assertTrue(test.arr.get(1)==100);
        assertTrue(test.arr.get(9)==0);
    }
}
