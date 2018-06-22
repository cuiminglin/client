package com.cui.controller;

import com.cui.Exception.BaseException;
import com.cui.entity.User;
import com.cui.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by cuiminglin on 2018/4/27.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/showUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "integer"),
    })
    public ResponseEntity<User> toIndex(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/demo")
    public ModelAndView html() throws Exception ,BaseException{
   //     throw  new Exception();
        throw  new BaseException();
//        ModelAndView view = new ModelAndView("/firstdemo");
//        return view;
    }

}