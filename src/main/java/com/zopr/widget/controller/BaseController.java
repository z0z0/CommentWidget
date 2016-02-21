package com.zopr.widget.controller;

/**
 * Created by zorana on 2/21/16.
 */
public class BaseController {

    /**
     * Redirect method
     * @param requestMapping String Part of the path to redirect to
     * @return  String path to redirect to
     */
    protected String redirect( String requestMapping ) {
        StringBuilder redirectViewPath = new StringBuilder();
        redirectViewPath.append( "redirect:" );
        redirectViewPath.append( requestMapping );
        return redirectViewPath.toString();
    }

}
