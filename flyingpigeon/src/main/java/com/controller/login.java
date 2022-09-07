package com.controller;
import com.dao.userdao;
import com.domain.result;
import com.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class login {

    private String name;

    @Autowired
    private userdao userdao;

    @GetMapping("/{username}/{password}")
    public result select(@PathVariable String username,@PathVariable String password){
        user user = userdao.select(username,password);
        if (user!=null){
            name=username;
            return new result(true);
        }else {
            return new result(false);
        }
    }

    @GetMapping("/{username}")
    public result addbeforeselect(@PathVariable String username){
        user user = userdao.addbeforeselect(username);
        if (user!=null){
            return new result(false);
        }else {
            return new result(true);
        }
    }

    @GetMapping
    public result getusername(){
        return new result(name);
    }

    @PostMapping
    public result add(@RequestBody user u){
        userdao.add(u);
        return new result(true);
    }
}
