package hospital.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainApi {

    @GetMapping("/")
    public String goToMain(){
        return "admin/index";
    }

    @GetMapping("/new")
    public String goToNew(){
        return "admin/new";
    }

    @GetMapping("/sidebar")
    public String sidebar(){
        return "layout/sidebar";
    }
}

