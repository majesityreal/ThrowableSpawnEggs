package wrappers;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface Wrapper {

	void onPlayerInteract(PlayerInteractEvent event);
	EntityType getSpawnedType(Material m);
	void onEggLand(ProjectileHitEvent e);
	
	void onEntityTarget(EntityTargetEvent e);
	void onSpawn(CreatureSpawnEvent e);
	
}
