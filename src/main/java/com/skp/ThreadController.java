package com.skp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ThreadController {

    @GetMapping("/threads")
    public String entry() {
        return "Request processed by thread: " + Thread.currentThread().getName();
    }
}
