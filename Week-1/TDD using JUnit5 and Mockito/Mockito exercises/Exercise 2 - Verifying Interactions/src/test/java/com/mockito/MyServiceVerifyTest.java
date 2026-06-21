package com.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class MyServiceVerifyTest {

    @Test
    void testVerifyInteraction() {

        // Step 1 - Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2 - Call the method with the mock injected
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3 - Verify that getData() was actually called
        verify(mockApi).getData();
        System.out.println("Verified: getData() was called on the mock.");
    }
}