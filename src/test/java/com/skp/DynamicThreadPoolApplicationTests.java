package com.skp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DynamicThreadPoolApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testThreadPoolAdjustment() throws Exception {
        // Simulate multiple requests to test the dynamic thread pool
        for (int i = 0; i < 100; i++) {
            mockMvc.perform(get("/api/threads"))
                    .andExpect(status().isOk());
        }

        // Further assertions can be added here to check pool size, etc.
    }
}
