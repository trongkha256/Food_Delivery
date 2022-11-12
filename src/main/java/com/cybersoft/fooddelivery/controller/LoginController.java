package com.cybersoft.fooddelivery.controller;

import com.cybersoft.fooddelivery.entity.Users;
import com.cybersoft.fooddelivery.payload.ResponseData;
import com.cybersoft.fooddelivery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//   "/api/login" => POST;
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserService userService;

    //Nhận vào 2 tham số username va password
    /*
    * {
    *    statusCode : 200,
    *    isSuccess: true,
    *    data: {
    *       "id": 1,
            "email": "nguyenvana@gmail.com",
            "fullname": "Nguyễn Văn A",
            "password": "123456",
            "avatar": "",
            "roleId": 1
    *    }
    * }
    * */

    @PostMapping("")
    public Object login(
            @RequestParam("email") String email,
            @RequestParam("password") String password
            ){
        ResponseData responseData = new ResponseData();
        responseData.setStatusCode(200);

//        List<Users> list = userService.getUsersByEmailAndPassword(email,password);
        List<Map<?,Object>> list = userService.getUsers();
        responseData.setSuccess(list != null);
        responseData.setData(list);

        return responseData;
    }

    @PostMapping("/email")
    public Object loginEmail(@RequestParam("email") String email){
        return userService.getUsersByEmail(email);
    }

}
