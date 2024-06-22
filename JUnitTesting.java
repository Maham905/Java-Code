import static org.junit.Assert.*;
import org.junit.Test;

public class VoterTest {
    @Test
    public void testVoterCreation() {
        Voter voter = new Voter("John Doe", "12345");
        assertEquals("John Doe", voter.getName());
        assertEquals("12345", voter.getId());
    }
}
