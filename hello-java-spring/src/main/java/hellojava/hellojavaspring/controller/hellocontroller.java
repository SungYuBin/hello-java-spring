package hellojava.hellojavaspring.controller;

import com.fasterxml.jackson.module.paramnames.ParameterNamesAnnotationIntrospector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.lang.reflect.Parameter;

//controller 는 그냥 연결하는 다리수준입니다, 데이터를 넘기고 뭐 그런정도죠
@Controller
public class hellocontroller {
   @GetMapping("second")
    public String hello(Model model){
       model.addAttribute("second","what");
    return "second";
   }

   @GetMapping("mvctest")
    public String mvctest(@RequestParam("name") String name, Model model)
   {
       model.addAttribute(name);
        return "mvc";
   }

   public void buttonOnclick()
   {
       JOptionPane aa=new JOptionPane();
       aa.showMessageDialog(null, "게으른 주인장 블로그에 오신것을 환영합니다.");
   }

}
