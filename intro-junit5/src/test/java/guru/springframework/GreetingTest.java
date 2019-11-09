package guru.springframework;

import org.junit.jupiter.api.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    public static void beforeClass(){
        System.out.println("Before- i am only called once!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In before each...");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void helloWorld1() {
        System.out.println(greeting.helloWorld("Beth"));
    }

    @Test
    void helloWorld2() {
        System.out.println(greeting.helloWorld("Jesse"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("In after each...");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("After- i am only called once!");
    }
}