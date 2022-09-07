package com.controller;
import com.dao.maindao;
import com.domain.message;
import com.domain.msg;
import com.domain.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class main {

    @Autowired
    private maindao maindao;

    @GetMapping("/{username}")
    public result selectmessage(@PathVariable String username){
        List<message> messageList = maindao.selectmessage(username);
        return new result(true,messageList);
    }

    @PostMapping
    public result add(@RequestBody msg m){
        maindao.add(m);
        return new result(true);
    }

    @DeleteMapping("/{username}")
    public result delete(@PathVariable String username){
        maindao.delete(username);
        return new result(true);
    }
}
