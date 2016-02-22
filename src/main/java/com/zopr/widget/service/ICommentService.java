package com.zopr.widget.service;

import com.zopr.widget.model.AppInfo;
import com.zopr.widget.model.Comment;

import java.util.List;

/**
 * Created by zorana on 2/21/16.
 */
public interface ICommentService {

    /**
     * Get database connection status
     * @return AppInfo record
     */
    public AppInfo getDBStatus();


    /**
     * Get all available comments from database
     * @return List of comments or null
     */
    public List<Comment> getAllComments();


    /**
     * Add new comment
     *
     * @param c Comment record to save
     * @return id of newly created comment object
     */
    public Integer addComment(Comment c);
}
