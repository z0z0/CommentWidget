package com.zopr.widget;

import com.zopr.widget.model.Comment;
import com.zopr.widget.service.ICommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-application-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class ServiceTests {

    private final Logger logger = LoggerFactory.getLogger( ServiceTests.class );


    @Autowired
    @Qualifier(value = "commentService")
    ICommentService commentService;

    @Test
    public void souldInitializeService() {
        assertNotNull(commentService);
    }

    @Test
    public void shouldListAllComments() {
        boolean isException = false;
        try {
            commentService.getAllComments();
            assertTrue(true);
        } catch (Exception e) {
            isException = true;
            logger.error("EXCEPTION: " + e.getMessage());
        }
        assertFalse("Unhandled exception!", isException);
    }

    @Test
    @Rollback(true)
    public void shouldSaveComment() {
        Timestamp timestamp= new Timestamp(new Date().getTime());
        Comment comment = new Comment();
        comment.setName("TestServiceSaveCommentName");
        comment.setText("TestServiceSaveCommentText");
        comment.setPosted(timestamp);
        Integer id  = commentService.addComment(comment);
        assertTrue("Should return either id or the whole object ", id!=null);

    }

}
