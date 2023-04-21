package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import org.junit.jupiter.api.Assumptions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // this annotation makes only one instance will be created no matter how many method you have
@DisplayName("When running MathUtils")
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
    }

    @Nested
    @DisplayName("Add method")
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("when adding two positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should returns the right sum");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            assertEquals(expected, actual, () -> "should returns the right sum " + expected + "but returned " + actual);
        }
    }

    @Test
    @Tag("Circle")
    void testComputeCircleArea() {
        assertEquals(Math.PI * 100, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Test
    @Tag("Math")
    @DisplayName("Multiply method")
    void testMultiply() {
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testReporter);
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
                );
    }


//    @Test
//    @EnabledOnOs(OS.MAC) // It is automatically disabled except MAC operating system
//    @DisplayName("Divide Method")
//    void testDivide() {
//        boolean isServerUp = false;
//        assumeTrue(isServerUp);
//        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), "Cannot divide by zero");
//    }

    @Test
    @Disabled // this annotation is used when we have to disable a particular test and no interruption in building
    @DisplayName("TDD method, Should not run")
    void testDisable(){
        fail("This test should be disabled");
    }


    // Conditional Execution
//    @EnabledOnOs(OS.LINUX)
//    @EnabledOnJre(JRE.JAVA_11)
//    @EnabledIf
//    @EnabledIfSystemProperties
//    @EnabledIfEnvironmentVariable


    // Handling External Factors



}