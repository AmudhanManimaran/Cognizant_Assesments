package com.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        // Step 1 - Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2 - Stub the method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3 - Inject mock into service and call the method
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Verify the result matches the stubbed value
        assertEquals("Mock Data", result);
        System.out.println("Fetched data: " + result);
    }
}