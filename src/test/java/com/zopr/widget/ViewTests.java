package com.zopr.widget;

import com.zopr.widget.common.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by zorana on 2/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/test-application-context.xml")
public class ViewTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    //------ Test Hello Page -----------
    @Test
    public void shouldFindHelloPage() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    //------ Test Health  -----------
    @Test
    public void shouldConnectToDatabase() throws Exception {
        String dbStatus = Status.ALIVE.getStatusName();
        this.mockMvc.perform(get("/health")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(dbStatus));
    }

    //------ Test Speakup Page -----------
    @Test
    public void shouldFindSpeakupPage() throws Exception {
        mockMvc.perform(get("/speakup"))
                .andExpect(status().isOk())
                .andExpect(view().name("speakup"));
    }

    @Test
    public void shouldSubmitSuccess() throws Exception {
        this.mockMvc.perform(post("/speakup/add"))
                .andExpect(status().isOk());

    }


}
