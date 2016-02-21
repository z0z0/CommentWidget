package com.zopr.widget;

import com.zopr.widget.dao.jdbc.JdbcCommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by zorana on 2/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/test-application-context.xml")
public class JdbcTests {

    private final Logger logger = LoggerFactory.getLogger(JdbcTests.class);
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    JdbcCommentRepository jdbcCommentRepository;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }


    @Test
    public void shouldGetAllComments() {
        boolean isException = false;
        try {
            jdbcCommentRepository.getAll();
            assertTrue(true);
        } catch (Exception e) {
            isException = true;
            logger.error("EXCEPTION: " + e.getMessage());
        }
        assertFalse("Unhandled exception!", isException);
    }

}
