package springbootfizzbuzz;

import springbootfizzbuzz.service.FizzBuzzService;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;


public class FizzbuzzTest {
    FizzBuzzService fizzBuzzService = new FizzBuzzService();

    @Test
    public void testNull(){
        assertFalse(null, fizzBuzzService.accept(null));
    }

    @Test
    public void testStringForNumbers(){
        assertEquals(false, fizzBuzzService.accept("asdf"));
    }

    @Test
    public void testStringForPositiveNumbers(){
        assertEquals(false, fizzBuzzService.accept("-12"));
    }

    @Test
    public void testStringInvalid(){
        assertEquals(false, fizzBuzzService.accept(""));
    }

    @Test
    public void testNonZeroStart(){
        assertEquals(false, fizzBuzzService.accept("02318974"));
    }

    @Test
    public void testFizz(){
        assertEquals("Fizz", fizzBuzzService.perform("3"));
        System.out.println("User Input is 3 we got " + fizzBuzzService.perform("3"));
    }

    @Test
    public void testBuzz(){
        assertEquals("Buzz", fizzBuzzService.perform("5"));
        System.out.println("User Input is 5 we got " + fizzBuzzService.perform("5"));
    }

    @Test
    public void testFizzBuzz(){
        assertEquals("FizzBuzz", fizzBuzzService.perform("15"));
        System.out.println("User Input is 15 we got " + fizzBuzzService.perform("15"));
    }

    // Random TestCases found online
    @Test
    public void testUnexpected(){
        assertEquals("Fizz", fizzBuzzService.perform("3"));
        assertEquals("Fizz", fizzBuzzService.perform("6"));
        assertEquals("Fizz", fizzBuzzService.perform("9"));
        assertEquals("Buzz", fizzBuzzService.perform("5"));
        assertEquals("Buzz", fizzBuzzService.perform("10"));
    }
}
