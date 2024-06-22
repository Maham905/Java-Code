//VoterTest
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
//FactorialCalculatorTest
import static org.junit.Assert.*;
import org.junit.Test;

public class FactorialCalculatorTest {
    @Test
    public void testFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();
        assertEquals(1, calculator.factorial(1));
        assertEquals(2, calculator.factorial(2));
        assertEquals(6, calculator.factorial(3));
        assertEquals(24, calculator.factorial(4));
        assertEquals(120, calculator.factorial(5));
    }
}

