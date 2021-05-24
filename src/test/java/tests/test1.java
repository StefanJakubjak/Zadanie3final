package tests;

import org.junit.jupiter.api.*;

public class test1 {

    @BeforeEach
    void setUp() {
        
    }

    @AfterEach
    void tearDown() {
        
    }

    @BeforeAll
    static void beforeAll() {
        
    }

    @AfterAll
    static void afterAll() {
        
    }

    @Test
    void simpleAssertion(){
        Assertions.assertEquals(2, 2);
    }
    void simpleAssertion2(){
        Assertions.assertEquals(2, 3);
    }

}
