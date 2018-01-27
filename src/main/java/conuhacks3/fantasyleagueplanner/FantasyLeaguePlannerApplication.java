package conuhacks3.fantasyleagueplanner;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class FantasyLeaguePlannerApplication {

	/* Single page application routing */
	@RequestMapping({
			"/",
			"/poolConfig"
	})
	public String redirectOnReload() {
		return "forward:/index.html";
	}

    /* Example REST endpoint */
    @RequestMapping("/get/example")
    @ResponseBody
    public String getProducts(){
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
        map.put("test key", "test value");
        return gson.toJson(map);
    }


	public static void main(String[] args) {
		SpringApplication.run(FantasyLeaguePlannerApplication.class, args);
	}
}
