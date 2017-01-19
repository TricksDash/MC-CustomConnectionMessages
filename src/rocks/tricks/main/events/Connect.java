package rocks.tricks.main.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import rocks.tricks.main.Core;

public class Connect implements Listener {
	
	//* Created by Tricks 17th April 2016 *\\
	
	private Core plugin;
	
	public Connect(Core pl) {
		plugin = pl;
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
	if(player.hasPermission("customjoinmessage.join.admin")) {
		event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("AdminJoin").replaceAll("%P", player.getName().toString())));
		}
	else if(player.hasPermission("customjoinmessage.join.staff")) {
		event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("StaffJoin").replaceAll("%P", player.getName().toString())));
		}
	else if(player.hasPermission("customjoinmessage.join.donator")) {
		event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("DonatorJoin").replaceAll("%P", player.getName().toString())));
		}
	else{
		event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("DefaultJoin").replaceAll("%P", player.getName().toString())));
		}
	}
}
