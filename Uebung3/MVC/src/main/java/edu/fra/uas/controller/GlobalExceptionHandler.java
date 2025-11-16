package edu.fra.uas.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    private final Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(HttpServletRequest req, MissingServletRequestParameterException exception) {
        log.debug("handleMissingParams() is called");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.addObject("timestamp", new Date().toString());
		mav.addObject("status", 500);

		mav.setViewName("support");
		return mav;
    }

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseBody
	public ModelAndView handleTypeMismatchException(HttpServletRequest req,TypeMismatchException typeMismatchException) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("message", "Type Mismatch Exception: " + typeMismatchException.getMessage());
		mav.addObject("exception", typeMismatchException);
		mav.addObject("url", req.getRequestURL());
		mav.addObject("timestamp", new Date().toString());
		mav.addObject("status", 500);
		mav.setViewName("support");
		return mav;
	}

}
