package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @GetMapping("/greeting")//greeting là tên đường dẫn của phương thức mapping
    //@RequestMapping(name = "/hello", method = RequestMethod.GET) là cách kiểu cũ của @GetMapping("/hello")
    //GetMapping tương đương với 1 doGet. Lưu ý: POST chỉ dùng khi submit, còn GET dùng khi hiển thị
    public String greeting(@RequestParam(name = "name", required = false) String name, Model model) {//required = false dùng để khi tham chiếu đến không truyền tham số vẫn chậy được
        model.addAttribute("name", name);
        return "index";//index là tên trang mình muốn trỏ đến để hiển thị;
    }

    @GetMapping("/index")
    public String hello() {
        ModelAndView modelAndView = new ModelAndView("hello");//đây là constructor để tạo đường dẫn đến trang cần hiển thị <=> đoạn code trên, nhưng tiện hơn
        return "hello";
    }
}
