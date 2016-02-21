package com.zopr.widget.controller;

import com.zopr.widget.model.AppInfo;
import com.zopr.widget.model.Comment;
import com.zopr.widget.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Widget Controller handles comments loading
 */

@Controller

public class CommentController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);



    @Autowired
    public CommentService commentService;


    // Checks database connection
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public @ResponseBody AppInfo getDBStatus() {

        logger.info("Start getDBStatus");
        return commentService.getDBStatus();
    }

    // Loads all comments from the database
    @RequestMapping( value="/speakup", method = RequestMethod.GET )
    public String listComments(Model model) {

        logger.info("Start listComments");
        model.addAttribute("comment", new Comment());
        model.addAttribute("listComments", this.commentService.getAllComments());
        return "speakup";

    }

    // Add new comment
    @RequestMapping(value="/speakup/add", method = RequestMethod.POST)
    public String addComment(@ModelAttribute("comment") Comment comment){

        logger.info("Start addComment");
        this.commentService.addComment(comment);
        //clean up form data


        return super.redirect( "/speakup");

    }


}