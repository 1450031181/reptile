package com.test.demo.controller;

import com.test.demo.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 爬虫demo
 * @author Fbin
 * @date 2019/12/17
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private IUserService userService;

    @GetMapping("/test")
    public void detail() {
        userService.test();
    }

}
