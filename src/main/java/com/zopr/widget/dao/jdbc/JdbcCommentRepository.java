package com.zopr.widget.dao.jdbc;

import com.zopr.widget.dao.mapper.CommentMapper;
import com.zopr.widget.model.Comment;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by zorana on 2/21/16.
 */
public class JdbcCommentRepository extends JdbcBaseRepository {

    private static final String SQL_SELECT_ALL = "select * from comment order by id desc";

    public JdbcCommentRepository () {
        super();
    }

    public JdbcCommentRepository(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * Gets all existing comments
     * @return List of Comment objects
     */
    @Transactional
    public List<Comment> getAll() {
        List<Comment> comments = jdbcTemplate.query(SQL_SELECT_ALL, new CommentMapper());
        return comments;
    }
}
