package de.SteffTek.Playerlist;

import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.SteffTek.SWF.API.Module;

/*
Copyright 2019 SteffTek

Use this file to create your own Modules for the Spigot Web Framework by SteffTek
*/

public class Main extends Module{

	/*
	 Plugin start 
	*/
	@Override
	public void onEnable() {
		//Put everything here that should enable on startup

		//Print out a Message on startup
		System.out.println("Playerlist-Modul activated!");
		
		//Search for your Module-Datapath, create if it doesn't exists
		if(!getDataPath().exists()) {
			getDataPath().mkdirs();
		}
	}
	
	/*
	 Plugin end
	*/
	@Override
	public void onDisable() {
		//Put everything here that should disable on shutdown


	}


	//This function generates the Response the webserver shows. You can use any HTML and JavaScript here
	@Override
	public String generateResponse(String ip, List<String> cookies, Map<String, String> params) {
		
		//Prints out all the cookies in the console
		for(String s : cookies) {
			System.out.println(s);
		}
		
		//Prints out all the GET-Parameters in the console
		for (Map.Entry<String, String> entry : params.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		//Build the Response
		String response = "<h1>This is a Test-Module</h1>";
		
		return response;
	}
	
}
