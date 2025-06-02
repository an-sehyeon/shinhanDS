package com.shinhan.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

// 전역적으로 예외처리
@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String exceptionProcess(Exception ex, Model model,HttpServletRequest request) {
		System.out.println("예외가 발생한 class 이름 : " + ex.getClass().getName());
		model.addAttribute("errorMessage", ex.getMessage());
		model.addAttribute("url",request.getRequestURL());
		return "error/error500";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView noHandler404(HttpServletRequest request) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("error/error404");
			mv.addObject("url",request.getRequestURL());
			mv.addObject("message","URL 확인하세요");
		return mv;
	}
	
	// 400 Bad Request 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> f_400(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("요청 데이터가 유효하지 않습니다.");
    }
    
    // 415 Unsupported Media Type 처리
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<String> f_415(HttpMediaTypeNotSupportedException ex) {
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body("지원하지 않는 미디어 타입입니다.");
    }
}
