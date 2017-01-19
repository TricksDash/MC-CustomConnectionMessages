package rocks.tricks.main.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import rocks.tricks.main.Core;

public class Disconnect implements Listener {
	
	private Core plugin;
	
	public Disconnect(Core pl) {
		plugin = pl;
		
	}
	
	@EventHandler
	public void onQuitEvent(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		
	if(player.hasPermission("customjoinmessage.join.admin")) {
		event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("AdminLeave").replaceAll("%P", player.getName().toString())));
		}
	else if(player.hasPermission("customjoinmessage.join.staff")) {
		event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("StaffLeave").replaceAll("%P", player.getName().toString())));
		}
	else if(player.hasPermission("customjoinmessage.join.donator")) {
		event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("DonatorLeave").replaceAll("%P", player.getName().toString())));
		}
	else {
		event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("DefaultLeave").replaceAll("%P", player.getName().toString())));
		}
	}
}
