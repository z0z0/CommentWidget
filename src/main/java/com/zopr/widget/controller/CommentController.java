package com.zopr.widget.controller;

import com.zopr.widget.model.AppInfo;
import com.zopr.widget.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Widget Controller handles comments loading
 */

@Controller
@RequestMapping("/commentWidget")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);



    @Autowired
    public CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public
    @ResponseBody
    AppInfo getDBStatus() {
        logger.info("Start getDBStatus");
        return commentService.getDBStatus();
    }

    @RequestMapping(value = "/speakup", method = RequestMethod.GET)
    public String listComments(Model model) {
        logger.info("Start listComments");

        model.addAttribute("listComments", this.commentService.getAllComments());
        return "speakup";

    }

}