package com.zopr.widget.dao.jdbc;

import com.zopr.widget.dao.mapper.CommentMapper;
import com.zopr.widget.model.Comment;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Created by zorana on 2/21/16.
 */
public class JdbcCommentRepository extends JdbcBaseRepository {


    private static final String SQL_SELECT_ALL = "select * from comment order by id desc";
    private static final String SQL_INSERT_INTO = "insert into comment (name, text, posted) values (?,?,?)";

    public JdbcCommentRepository() {
        super();
    }

    public JdbcCommentRepository(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * Gets all existing comments
     *
     * @return Mapped List of Comment objects
     */
    @Transactional
    public List<Comment> getAll() {
        List<Comment> comments = jdbcTemplate.query(SQL_SELECT_ALL, new CommentMapper());
        return comments;
    }

    /**
     * Save Comment object to the database
     *
     * @param comment Comment record to save
     */
    @Transactional
    public Integer saveComment(final Comment comment) {

        //save timestamp in postresql's timestam format
        final Timestamp timestamp = new Timestamp(new Date().getTime());

        KeyHolder holder = new GeneratedKeyHolder();

        //Use PreparedStatement to fetch the newly saved id
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_INTO, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, comment.getName());
                ps.setString(2, comment.getText());
                ps.setTimestamp(3, timestamp);
                return ps;
            }
        }, holder);

        Integer newCommentId = holder.getKeys().size() > 1 ? (Integer) holder.getKeys().get("id") : holder.getKey().intValue();

        return newCommentId;
    }
}
