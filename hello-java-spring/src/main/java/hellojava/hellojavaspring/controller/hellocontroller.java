package hellojava.hellojavaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//controller 는 그냥 연결하는 다리수준입니다, 데이터를 넘기고 뭐 그런정도죠
@Controller
public class hellocontroller {
   @GetMapping("second")
    public String hello(Model model){
       model.addAttribute("second","what");
    return "second";
   }

   @GetMapping("mvctest")
    public String mvctest(@RequestParam("test") String string1, Model model)
   {
        model.addAttribute("test",string1);
        return "mvctest";
   }


}
