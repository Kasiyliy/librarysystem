package com.sberteam.librarysustem.controllers;

import netscape.security.ForbiddenTargetException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
        return new ModelAndView("error/404");
    }

    @ExceptionHandler(ForbiddenTargetException.class)
    public ModelAndView handleError403(HttpServletRequest request, Exception e)   {
        return new ModelAndView("error/403");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception e)   {
        return new ModelAndView("error/500");
    }
}
