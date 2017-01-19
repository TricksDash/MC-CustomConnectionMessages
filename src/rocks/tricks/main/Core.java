package rocks.tricks.main;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.tricks.main.events.Connect;
import rocks.tricks.main.events.Disconnect;

public class Core extends JavaPlugin {
	
	//* Created by Tricks 17th April 2016 *\\

	public void onEnable() {
	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	registerEvents();
	registerConfig();

	logger.info(pdfFile.getName() + "Has been enabled - Version " + pdfFile.getVersion());
	}

public void onDisable() {
	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	logger.info(pdfFile.getName() + "Has been disabled - Version " + pdfFile.getVersion());
	}

public void registerEvents() {
	PluginManager pm = getServer().getPluginManager();
	
	pm.registerEvents(new Connect(this), this);
	pm.registerEvents(new Disconnect(this), this);
	}

public void registerConfig() {
	getConfig().options().copyDefaults(true);
	saveDefaultConfig();
	}
}

