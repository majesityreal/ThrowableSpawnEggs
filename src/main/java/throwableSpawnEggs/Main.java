package throwableSpawnEggs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import listeners.ListenerThrowableItems;
import net.md_5.bungee.api.ChatColor;
import wrappers.LTE1_15;
import wrappers.LTE1_16;
import wrappers.Wrapper;

public class Main extends JavaPlugin {

	List<String> entities = new ArrayList<String>();
	public Wrapper wrapper;
	
	@Override
	public void onEnable() {
		 String version = Bukkit.getBukkitVersion().split("-")[0];
		if ("1.16.1".equals(version)) {
			wrapper = new LTE1_16(this);
		} else if ("1.15.2".equals(version)) {
			wrapper = new LTE1_15(this);
		} else {
			getLogger().severe("Unsupported version");
			Bukkit.getPluginManager().disablePlugin(this);
		}
		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new ListenerThrowableItems(this, wrapper), this);
		getLogger().info(ChatColor.GOLD + "ThrowableSpawnEggs" + ChatColor.AQUA + " has been enabled!");
	}
	
	@Override
	public void onDisable() {
	}
	
	public Wrapper getWrapper() {
		return wrapper;
	}
	
}
