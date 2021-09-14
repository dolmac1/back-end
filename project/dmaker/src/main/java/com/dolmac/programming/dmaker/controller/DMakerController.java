package com.dolmac.programming.dmaker.controller;

import com.dolmac.programming.dmaker.dto.CreateDeveloper;
import com.dolmac.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController //bean 에 등록하는데 타입은 restcontroller인 것 (컨트롤러인데 리스폰스 바디를 붙여주는 것)
@ToString
public class DMakerController {
    private final DMakerService dMakerService;

    /*    DMakerController       DMakerService           DeveloperRepository
        ========== Spring Application ===================================*/
    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        //GET /developers HTTP/1.1 로 들어오면 여기를 탐
        log.info("GET /developers HTTP/1.1");//로그 찍어줌

        return Arrays.asList("dolmac", "chovy", "bdd");// 화면에 리스트를 리턴해줌
    }

    @PostMapping("/create-developers")
    public CreateDeveloper.Response createDevelopers(
            @RequestBody CreateDeveloper.Request request
            ) {
        //GET /developers HTTP/1.1 로 들어오면 여기를 탐
        log.info("POST /create-developers HTTP/1.1");//로그 찍어줌
        log.info("request = ",request);
        return dMakerService.createDeveloper (request);

        //return Collections.singletonList("dolmac");// 화면에 리스트를 리턴해줌
    }
}
