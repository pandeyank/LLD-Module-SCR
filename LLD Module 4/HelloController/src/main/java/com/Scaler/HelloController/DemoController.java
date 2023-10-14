package com.Scaler.HelloController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/hello")
    public ResponseEntity run()
    {
        String str="Hello World!";
        return ResponseEntity.ok(str);
    }
    @GetMapping("/person")
    public ResponseEntity hello()
    {
        Person p=new Person("Aman",25,"Hello Gentleman");
        return ResponseEntity.ok(p);

    }
    @GetMapping("/student")
    public ResponseEntity info()
    {
        Student s1=new Student("Aman",26,"AKTU");
        Student s2=new Student("Shyam",28,"IIT");
        return ResponseEntity.ok(s1);
    }
}
