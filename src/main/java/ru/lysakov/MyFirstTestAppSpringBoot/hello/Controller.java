package ru.lysakov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class Controller {
    ArrayList<String> mas = null;
    HashMap< Integer, String> hashMap = null;
    @GetMapping("/hello")
    public String hello(@RequestParam(value="name",
    defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public void UpdateList(@RequestParam String str) {
        if (mas == null) {
            mas = new ArrayList<>();
        }
        mas.add(str);
    }
    @GetMapping("/show-array")
    public String showList() {
        if (mas == null) {
            return "[]";
        }
        return mas.toString();
    }

    @GetMapping("/update-map")
    public void UpdateHashMap(@RequestParam Integer number, String str) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(number, str);
    }
    @GetMapping("/show-map")
    public String showHashMap() {
        if (hashMap == null) {
            return "[]";
        }
        return hashMap.toString();
    }

    @GetMapping("/show-all-lenght")
    public Integer showAllLenght() {
        if ((hashMap != null) & (mas != null)) {
            return mas.size()+hashMap.size();
        }
        return null;
    }
}
