package hellojava.hellojavaspring.controller;

import com.fasterxml.jackson.module.paramnames.ParameterNamesAnnotationIntrospector;
import hellojava.hellojavaspring.HelloJavaSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.lang.reflect.Parameter;

//controller 는 그냥 연결하는 다리수준입니다, 데이터를 넘기고 뭐 그런정도죠
@Controller
public class hellocontroller {
   @GetMapping("second")
    public String hello(Model model){
    return "second";
   }

   @GetMapping("mvctest")
   public String mvctest(@RequestParam("name") String name, Model model)
   // public String mvctest(@RequestParam(value ="valus", required = false) String name, Model model)
   {
       model.addAttribute("test",name);
        return "mvctest";
   }

   //view로 구조화된 값을 출력하는게 아니라 저 글자 그대로가 출력이 됩니다
    //이걸쓸일은 별로없습니다만..
    @GetMapping("hello-string")
    @ResponseBody //http 에서 통신 프로토콜의 body 부분의 이내용을 직접넣겠다
    public String helloString(@RequestParam("name") String name)
    {
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody //객체가 넘어온다면 json으로 출력, 문자열이 넘어온다면 문자열 그대로 출력합니다.
    public Hello helloApplication(@RequestParam("name") String name)
    {
       Hello hello=new Hello();
       hello.setName(name);
       return hello;
        //화면에 json형태로 넘어오게 됩니다
        //http://localhost:8080/hello-api?name=name
        //결과값이 {"name":"name"}
    }

    static class Hello{
       private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


   public void buttonOnclick()
   {
       JOptionPane aa=new JOptionPane();
       aa.showMessageDialog(null, "게으른 주인장 블로그에 오신것을 환영합니다.");
   }

}
