package com.cui.controller;

import com.cui.Exception.BaseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Created by cuiminglin on 2018/5/7.
 */
//@ControllerAdvice("com.cui.controller")
//@ControllerAdvice(annotations = {RestController.class,Controller.class})

@ControllerAdvice(annotations = Controller.class)
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

//    @ExceptionHandler({BaseException.class})
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
//                                                             HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//
//        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
//            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
//        }
//        return new ResponseEntity<Object>(body, headers, status);
//    }


    //@ExceptionHandler({Exception.class})
    public ResponseEntity<Meta>   handlerException(Exception e) throws IOException {
//        response.setStatus(500);
//        Meta meta = new Meta();
//        meta.setCode(30003);
//        meta.setMessage("");
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().println(meta.toString());
//        response.flushBuffer();
        Meta meta = new Meta();
        meta.setCode(30003);
        meta.setMessage(e.getMessage());

        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);

        return builder.body(meta);


    }
    @ExceptionHandler({Exception.class})
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                                       HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("333");

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<Object>(body, headers, status);
    }
    class Meta {
        private Integer code;
        private String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
