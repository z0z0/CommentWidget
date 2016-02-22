package com.zopr.widget;

import com.zopr.widget.dao.jdbc.JdbcCommentRepository;
import com.zopr.widget.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by zorana on 2/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-application-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class JdbcTests {

    private final Logger logger = LoggerFactory.getLogger(JdbcTests.class);

    @Autowired
    JdbcCommentRepository jdbcCommentRepository;


    @Test
    public void shouldInitializeRepository() {
        assertNotNull(jdbcCommentRepository);
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

    @Test
    @Rollback(true)
    public void shouldSaveComment() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Comment comment = new Comment();
        comment.setName("Test JDBC SaveCommentName");
        comment.setText("Test JDBC SaveCommentText");
        comment.setPosted(timestamp);
        Integer id = jdbcCommentRepository.saveComment(comment);
        assertTrue("Should return either id or the whole object ", id!=null);
    }

}
