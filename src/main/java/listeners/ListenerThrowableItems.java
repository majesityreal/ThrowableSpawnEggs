package listeners;

import java.util.HashMap;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import wrappers.Wrapper;


public class ListenerThrowableItems implements Listener {
	
	private Plugin plugin;
	private Wrapper wrapper;
	
	public ListenerThrowableItems(Plugin plugin, Wrapper wrapper) {
		this.plugin=plugin;
		this.wrapper=wrapper;
	}
	
  	HashMap<Egg, EntityType> eggs = new HashMap<Egg, EntityType>();
  
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		wrapper.onPlayerInteract(e);
	}

	public EntityType getSpawnedType(Material m) {
		return wrapper.getSpawnedType(m);
	}

	@EventHandler
	public void onEggLand(ProjectileHitEvent e) {
		wrapper.onEggLand(e);
	}
			    
	@EventHandler
	public void onEntityTarget(EntityTargetEvent e) {
		wrapper.onEntityTarget(e);
	}
	
	@EventHandler
	public void onSpawn(CreatureSpawnEvent e) {
		wrapper.onSpawn(e);
	}
	
}

/*
	
	Material.BAT_SPAWN_EGG;
	Material.BEE_SPAWN_EGG;
	Material.BLAZE_SPAWN_EGG;
	Material.CAT_SPAWN_EGG;
	Material.CAVE_SPIDER_SPAWN_EGG;
	Material.CHICKEN_SPAWN_EGG;
	Material.COD_SPAWN_EGG;
	Material.COW_SPAWN_EGG;
	Material.CREEPER_SPAWN_EGG;
	Material.DOLPHIN_SPAWN_EGG;
	Material.DONKEY_SPAWN_EGG;
	Material.DROWNED_SPAWN_EGG;
	Material.ELDER_GUARDIAN_SPAWN_EGG;
	Material.ENDERMAN_SPAWN_EGG;
	Material.ENDERMITE_SPAWN_EGG;
	Material.EVOKER_SPAWN_EGG;
	Material.FOX_SPAWN_EGG;
	Material.GHAST_SPAWN_EGG;
	Material.GUARDIAN_SPAWN_EGG;
	Material.HOGLIN_SPAWN_EGG;
	Material.HORSE_SPAWN_EGG;
	Material.HUSK_SPAWN_EGG;
	Material.LLAMA_SPAWN_EGG;
	Material.MAGMA_CUBE_SPAWN_EGG;
	Material.MOOSHROOM_SPAWN_EGG;
	Material.MULE_SPAWN_EGG;
	Material.OCELOT_SPAWN_EGG;
	Material.PANDA_SPAWN_EGG;
	Material.PARROT_SPAWN_EGG;
	Material.PHANTOM_SPAWN_EGG;
	Material.PIG_SPAWN_EGG;
	Material.PIGLIN_SPAWN_EGG;
	Material.PILLAGER_SPAWN_EGG;
	Material.POLAR_BEAR_SPAWN_EGG
	Material.PUFFERFISH_SPAWN_EGG
	Material.RABBIT_SPAWN_EGG;
	Material.RAVAGER_SPAWN_EGG;
	Material.SALMON_SPAWN_EGG;
	Material.SHEEP_SPAWN_EGG;
	Material.SHULKER_SPAWN_EGG;
	Material.SILVERFISH_SPAWN_EGG;
	Material.SKELETON_HORSE_SPAWN_EGG;
	Material.SKELETON_SPAWN_EGG;
	Material.SLIME_SPAWN_EGG;
	Material.SPIDER_SPAWN_EGG;
	Material.SQUID_SPAWN_EGG;
	Material.STRAY_SPAWN_EGG;
	Material.STRIDER_SPAWN_EGG;
	Material.TRADER_LLAMA_SPAWN_EGG;
	Material.TROPICAL_FISH_SPAWN_EGG;
	Material.TURTLE_SPAWN_EGG;
	Material.VEX_SPAWN_EGG;
	Material.VILLAGER_SPAWN_EGG;
	Material.VINDICATOR_SPAWN_EGG;
	Material.WANDERING_TRADER_SPAWN_EGG;
	Material.WITCH_SPAWN_EGG;
	Material.WITHER_SKELETON_SPAWN_EGG;
	Material.WOLF_SPAWN_EGG;
	Material.ZOGLIN_SPAWN_EGG;
	Material.ZOMBIE_HORSE_SPAWN_EGG;
	Material.ZOMBIE_SPAWN_EGG;
	Material.ZOMBIE_VILLAGER_SPAWN_EGG;
	Material.ZOMBIFIED_PIGLIN_SPAWN_EGG;
*/