package com.zopr.widget.service;

import com.zopr.widget.common.Status;
import com.zopr.widget.dao.jdbc.JdbcCommentRepository;
import com.zopr.widget.model.AppInfo;
import com.zopr.widget.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zorana on 2/21/16.
 */
@Service
@Qualifier( value = "commentService" )
public class CommentService {


    @Autowired
    private JdbcCommentRepository jdbcCommentRepository;

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class.getName());


    public AppInfo getDBStatus() {
        AppInfo appInfo = new AppInfo();
        try {
            String dbStatus = null;
            if (jdbcCommentRepository != null) {
                dbStatus = jdbcCommentRepository.getDbStatus();
            } else {
                logger.error("Database repository should be set.");
            }
            appInfo.setStatus(dbStatus == null ? Status.DEAD.getStatusName() : Status.ALIVE.getStatusName());
            appInfo.setConnectionString(dbStatus);

        } catch (Exception e) {
            logger.error("Error while checking database status ", e);
            appInfo.setStatus(Status.DEAD.getStatusName());
            appInfo.setConnectionString("Error while checking database status");
        }

        return appInfo;
    }

    public List<Comment> getAllComments() {
        return jdbcCommentRepository.getAll();
    }
}
