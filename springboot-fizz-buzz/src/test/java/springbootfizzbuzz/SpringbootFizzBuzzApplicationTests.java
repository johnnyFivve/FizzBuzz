package springbootfizzbuzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import springbootfizzbuzz.service.FizzBuzzService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest(classes = FizzBuzzService.class)
@RunWith(SpringRunner.class)
public class SpringbootFizzBuzzApplicationTests {

    @TestConfiguration
    static class FuzzBizzServiceImplTestContextConfiguration {

        @Bean
        public FizzBuzzService fuzzBuzzService() {
            return new FizzBuzzService();
        }
    }
    @Autowired
    FizzBuzzService fizzBuzzService;

    @org.junit.Test
    public void testNull(){
        assertFalse(null, fizzBuzzService.accept(null));
    }

    @org.junit.Test
    public void testStringForNumbers(){
        assertEquals(false, fizzBuzzService.accept("asdf"));
    }

    @org.junit.Test
    public void testStringForPositiveNumbers(){
        assertEquals(false, fizzBuzzService.accept("-12"));
    }

    @org.junit.Test
    public void testStringInvalid(){
        assertEquals(false, fizzBuzzService.accept(""));
    }

    @org.junit.Test
    public void testNonZeroStart(){
        assertEquals(false, fizzBuzzService.accept("02318974"));
    }

    @org.junit.Test
    public void testFizz(){
        assertEquals("Fizz", fizzBuzzService.perform("3"));
        System.out.println("User Input is 3 we got " + fizzBuzzService.perform("3"));
    }

    @org.junit.Test
    public void testBuzz(){
        assertEquals("Buzz", fizzBuzzService.perform("5"));
        System.out.println("User Input is 5 we got " + fizzBuzzService.perform("5"));
    }

    @org.junit.Test
    public void testFizzBuzz(){
        assertEquals("FizzBuzz", fizzBuzzService.perform("15"));
        System.out.println("User Input is 15 we got " + fizzBuzzService.perform("15"));
    }

    // Random TestCases
    @Test
    public void testUnexpected(){
        assertEquals("Fizz", fizzBuzzService.perform("6"));
        assertEquals("Fizz", fizzBuzzService.perform("9"));
        assertEquals("Buzz", fizzBuzzService.perform("5"));
        assertEquals("Buzz", fizzBuzzService.perform("10"));
    }

}
