package conuhacks3.fantasyleagueplanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

@Controller
@SpringBootApplication
public class FantasyLeaguePlannerApplication {

	/* Single page application routing */
	@RequestMapping({
			"/",
			"/poolConfig",
			"/poolConfigSoccer"
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

    @RequestMapping(value = "/post/poolConfig", method = RequestMethod.POST)
	@ResponseBody
	public String poolConfig(@RequestBody String json) {
		Gson gson = new Gson();
		PoolConfiguration poolConfiguration = gson.fromJson(json, PoolConfiguration.class);

		// read data from json text file
		String jsonStats = "";
		String fileName = "src/main/java/conuhacks3/fantasyleagueplanner/stats.json";
		// reference to one line at a time
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			System.out.println("reading file...");
			while((line = bufferedReader.readLine()) != null) {
				jsonStats += line;
			}
			bufferedReader.close();
			System.out.println("finished reading file");
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		}
		catch(IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

		Type collectionType = new TypeToken<ArrayList<Player>>(){}.getType();
		ArrayList<Player> players = gson.fromJson(jsonStats, collectionType);
		for(int i = 0; i < players.size(); i++){
			players.get(i).setPoolConfiguration(poolConfiguration);
			players.get(i).setScore();
		}
		Collections.sort(players, new SortByScore());

//		/* Debug */
//		for(int i = 0; i < players.size(); i++)
//			System.out.println(players.get(i).toString());

		/* Build a map of the best 10 players */
		Map<String, Integer> playersMap = new HashMap<>();
		for(int i = 0; i < 20; i++) {
			Player currentPlayer = players.get(i);
			playersMap.put(currentPlayer.getFullName(), currentPlayer.getScore());
		}

		return gson.toJson(playersMap);
	}


    @RequestMapping(value = "/post/poolConfigSoccer", method = RequestMethod.POST)
    @ResponseBody
    public String poolConfigSoccer(@RequestBody String json) {
        Gson gson = new Gson();
        PoolConfigurationSoccer poolConfiguration = gson.fromJson(json, PoolConfigurationSoccer.class);

        return "{}";
    }

	public static void main(String[] args) {
		SpringApplication.run(FantasyLeaguePlannerApplication.class, args);
	}
}
