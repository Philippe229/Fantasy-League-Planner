package conuhacks3.fantasyleagueplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class FantasyLeaguePlannerApplication {

	/* Single page application routing */
	@RequestMapping({
			"/",
	})
	public String redirectOnReload() {
		return "forward:/index.html";
	}


	public static void main(String[] args) {
		SpringApplication.run(FantasyLeaguePlannerApplication.class, args);
	}
}
