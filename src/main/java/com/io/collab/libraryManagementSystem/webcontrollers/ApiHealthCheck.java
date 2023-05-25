package com.io.collab.libraryManagementSystem.webcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ApiHealthCheck {

    @GetMapping("/status")
    public String getHealth()
    {
        return "<html><body><h1>Library Management System Is Up and Running ! </h1></body></html>";
    }
}
