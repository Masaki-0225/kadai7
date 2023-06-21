package com.kadai.kadai7;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class UserController {

    public String URL = "http://localhost:8080";

    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody @Valid CreateForm form) {
        //登録処理は省略
        URI url = UriComponentsBuilder.fromUriString(URL)
                .path("/names/id")//id部分は実際に登録された際に発行したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body("登録完了！！！");
    }

    @GetMapping("/names")
    public String name(@RequestParam(value = "name", defaultValue = "ぬる") String name) {
        return "Mr." + name;
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>>
    update(@PathVariable("id") int id, @RequestBody @Valid UpdateForm updateForm) {
        //更新処理は省略
        return ResponseEntity.ok(Map.of("message", "更新完了！！！"));
    }

    @DeleteMapping("names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "削除しました！！！"));
    }

}
