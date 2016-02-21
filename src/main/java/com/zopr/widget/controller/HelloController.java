package com.zopr.widget.controller;

import com.zopr.widget.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zorana on 2/21/16.
 */
@Controller
public class HelloController extends BaseController {

    @Autowired
    public CommentService commentService;

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Heeeeeeello world!");
        return "hello";
    }


}
