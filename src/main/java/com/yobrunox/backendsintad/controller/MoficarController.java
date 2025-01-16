package com.yobrunox.backendsintad.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class MoficarController {


    @GetMapping("update")
    public ResponseEntity<String> getMoficar() {
        return ResponseEntity.ok("GAAAAAAAAAAA");
    }
}
