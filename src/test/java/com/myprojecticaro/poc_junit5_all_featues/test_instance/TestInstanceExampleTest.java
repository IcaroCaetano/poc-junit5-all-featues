package com.myprojecticaro.poc_junit5_all_featues.test_instance;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("TestInstance Demonstration")
class TestInstanceExampleTest {

    private int counter;
    private String sharedResource;

    @BeforeAll
    void setupAll() {
        System.out.println("BeforeAll - Initializing shared resource");
        sharedResource = "CONNECTED";
    }

    @BeforeEach
    void setup() {
        System.out.println("BeforeEach - Resetting counter");
        counter = 0;
    }

    @Test
    @DisplayName("Test 1 - Counter should start at 0")
    void testCounterStartsAtZero() {
        assertEquals(0, counter);
    }

    @Test
    @DisplayName("Test 2 - Counter increments correctly")
    void testCounterIncrement() {
        counter++;
        assertEquals(1, counter);
    }

    @Test
    @DisplayName("Test 3 - Shared resource should be available")
    void testSharedResource() {
        assertNotNull(sharedResource);
        assertEquals("CONNECTED", sharedResource);
    }

    @Test
    @DisplayName("Test 4 - Demonstrate shared state across tests")
    void testSharedState() {
        counter++;
        assertTrue(counter > 0);
    }

    @Nested
    @DisplayName("Nested Tests - State sharing")
    class NestedTests {

        @Test
        void shouldModifySharedCounter() {
            counter += 5;
            assertEquals(5, counter);
        }

        @Test
        void shouldSeeModifiedCounter() {
            System.out.println("Counter value: " + counter);
        }
    }

    @RepeatedTest(3)
    @DisplayName("Repeated Test with shared instance")
    void repeatedTest(RepetitionInfo info) {
        counter++;
        System.out.println("Repetition " + info.getCurrentRepetition() + 
                           " - Counter: " + counter);
        assertTrue(counter >= 1);
    }

    @AfterAll
    void tearDownAll() {
        System.out.println("AfterAll - Cleaning up");
        sharedResource = null;
    }
}