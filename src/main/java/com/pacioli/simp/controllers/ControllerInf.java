package com.pacioli.simp.controllers;

import com.pacioli.simp.entity.Currency;
import com.pacioli.simp.entity.SeansInf;
import com.pacioli.simp.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class ControllerInf {
    @GetMapping("/seansInf")
    public String getSeansInf(Model model){
        SeansInf seansInf = new SeansInf();
        seansInf.readFile();
        model.addAttribute("sesInf", seansInf);
        return "SeansInfo";
    }

    @GetMapping("/userFulSeansInf")
    public String getFullSeansInf(Model model){
        UserInfo userInfo = new UserInfo();
        userInfo.readFile();
        userInfo.setPrenom("User");
        userInfo.setNom("Foo");
        model.addAttribute("usInfTot", userInfo);
        return "fulUsSeansInf";
    }

    @GetMapping("/uuid")
    @ResponseBody
    public UUID createReturnUiid(){
      UUID u = UUID.randomUUID();
      return u;
    }

    @GetMapping("/exchange")
    @ResponseBody
    public Currency randomExchange(){
        Currency c = new Currency();
        c.setRate(Math.random());
        return c;
    }

    @GetMapping("/exchange/{currency}")
    @ResponseBody
    public Currency exchangeCurrency(@PathVariable String currency){
        Currency c = new Currency();
        c.setRate(Math.random());
        c.setCurrency(currency);
        return c;
    }

//    public String home(){
//        return "SeansInfo";
//    }
}
