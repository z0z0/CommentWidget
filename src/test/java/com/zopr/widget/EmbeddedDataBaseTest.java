package com.zopr.widget;

import com.zopr.widget.dao.jdbc.JdbcCommentRepository;
import com.zopr.widget.model.Comment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by zorana on 2/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/embedded-test-app-context.xml")
public class EmbeddedDataBaseTest {

    private MockMvc mockMvc;

    @Autowired
    @Qualifier("embeddedCommentRepository")
    private JdbcCommentRepository repository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void shouldGetPopulatedComments() {

        //repository should be instantiated in test-application-context by the embedded db
        Assert.assertNotNull(repository);

        List<Comment> comments = repository.getAll();

        //comments list should be populated by
        Assert.assertNotNull(comments);

        //go through the list
        for (Comment comment:comments) {
            //neither comment
            Assert.assertNotNull(comment);
            // nor one of its fields in db should ever be null
            Assert.assertNotNull(comment.getId());
            Assert.assertNotNull(comment.getName());
            Assert.assertFalse(comment.getName().isEmpty());
            Assert.assertNotNull(comment.getText());
            Assert.assertFalse(comment.getText().isEmpty());
            Assert.assertNotNull(comment.getPosted());
            //nor should id exist id = -1
            Assert.assertEquals(-1, comment.getId().intValue());
        }

    }

}
