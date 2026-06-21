package com.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testAssertions() {

        // Check equality
        assertEquals(5, 2 + 3);

        // Check true condition
        assertTrue(5 > 3);

        // Check false condition
        assertFalse(5 < 3);

        // Check null value
        assertNull(null);

        // Check non-null value
        assertNotNull(new Object());
    }
}