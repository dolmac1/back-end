package com.example.hello.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path="/hello") //http://localhost:9090/api/get/hello
    public String getHello(){
        return "get hello";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET) //이 방식으로 하면 get, post 등 모든 메소드를 다 허용하기 때문에 method를 지정해주어야함
    //get http://localhost:9090/api/get/hi
    public String getHi() {
        return "get hi";
    }//이방법은 예전에 사용하던 방법임


    //path variable을 설정하는 방법
    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}") //변화하는 값을 받아올 때에는 이런 방법으로 사용
    public String pathVariable(@PathVariable String name){
        System.out.println(name);
        return name;
    }

    //query parameter를 사용하는 방법
    //http://localhost:9090/api/get/query-param?user=chovy&email=dolmac@naver.com&age=27
    @GetMapping(path="/query-param")
    public  String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry ->{
           System.out.println(entry.getKey());
           System.out.println(entry.getValue());
           System.out.println("\n");

           sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }

    //query parameter에 받을 값을 지정해서 선언해주는 방법법
   @GetMapping(path="query-param-sec")
    public  String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Integer age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+email+age;
    }
}
