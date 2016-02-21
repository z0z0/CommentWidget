package com.zopr.widget.dao.mapper;

import com.zopr.widget.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zorana on 2/20/16.
 */
public class CommentMapper implements RowMapper<Comment> {

    /**
     * Maps database row into Comment model class
     * @param rs - result row
     * @param rowNum - row number
     * @return Comment object
     * @throws SQLException
     */
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setName(rs.getString("name"));
        comment.setText(rs.getString("text"));
        comment.setPosted(rs.getDate("posted"));
        return comment;
    }
}
