package wrappers;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class LTE1_16 implements Wrapper {
	
	private Plugin plugin;
	HashMap<Egg, EntityType> eggs = new HashMap<Egg, EntityType>();
	
	public LTE1_16(Plugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
	    if (player.hasPermission("tse.use") && ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)))) {
	      if (event.getItem() == null) {
			  return;
		  }
	      ItemStack item = event.getItem();
	      Material megg = item.getType();
	      if(!plugin.getConfig().getBoolean(getSpawnedType(megg).toString())) {
	    	  return;
	        }
	      Egg egg = (Egg)event.getPlayer().launchProjectile(Egg.class);
	      egg.setItem(new ItemStack(item));
	      this.eggs.put(egg, getSpawnedType(megg));
	      GameMode gm = event.getPlayer().getGameMode();
	      if (gm.equals(GameMode.SURVIVAL) || gm == GameMode.ADVENTURE) {
	        if (item.getAmount() > 1) {
	          item.setAmount(item.getAmount() - 1);
	        } else {
	          player.getInventory().remove(item);
	        }  
	      }
	      event.setCancelled(true);
	    } 
	}

	@Override
	public EntityType getSpawnedType(Material m) {
		switch(m) {
		case BAT_SPAWN_EGG: return EntityType.BAT;
		case BEE_SPAWN_EGG: return EntityType.BEE;
		case BLAZE_SPAWN_EGG: return EntityType.BLAZE;
		case CAT_SPAWN_EGG: return EntityType.CAT;
		case CAVE_SPIDER_SPAWN_EGG: return EntityType.CAVE_SPIDER;
		case CHICKEN_SPAWN_EGG: return EntityType.CHICKEN;
		case COD_SPAWN_EGG: return EntityType.COD;
		case COW_SPAWN_EGG: return EntityType.COW;
		case CREEPER_SPAWN_EGG: return EntityType.CREEPER;
		case DOLPHIN_SPAWN_EGG: return EntityType.DOLPHIN;
		case DONKEY_SPAWN_EGG: return EntityType.DONKEY;
		case DROWNED_SPAWN_EGG: return EntityType.DROWNED;
		case ELDER_GUARDIAN_SPAWN_EGG: return EntityType.ELDER_GUARDIAN;
		case ENDERMAN_SPAWN_EGG: return EntityType.ENDERMAN;
		case ENDERMITE_SPAWN_EGG: return EntityType.ENDERMITE;
		case EVOKER_SPAWN_EGG: return EntityType.EVOKER;
		case FOX_SPAWN_EGG: return EntityType.FOX;
		case GHAST_SPAWN_EGG: return EntityType.GHAST;
		case GUARDIAN_SPAWN_EGG: return EntityType.GUARDIAN;
		case HOGLIN_SPAWN_EGG: return EntityType.HOGLIN;
		case HORSE_SPAWN_EGG: return EntityType.HORSE;
		case HUSK_SPAWN_EGG: return EntityType.HUSK;
		case LLAMA_SPAWN_EGG: return EntityType.LLAMA;
		case MAGMA_CUBE_SPAWN_EGG: return EntityType.MAGMA_CUBE;
		case MOOSHROOM_SPAWN_EGG: return EntityType.MUSHROOM_COW;
		case MULE_SPAWN_EGG: return EntityType.MULE;
		case OCELOT_SPAWN_EGG: return EntityType.OCELOT;
		case PANDA_SPAWN_EGG: return EntityType.PANDA;
		case PARROT_SPAWN_EGG: return EntityType.PARROT;
		case PHANTOM_SPAWN_EGG: return EntityType.PHANTOM;
		case PIG_SPAWN_EGG: return EntityType.PIG;
		case PIGLIN_SPAWN_EGG: return EntityType.PIGLIN;
		case PILLAGER_SPAWN_EGG: return EntityType.PILLAGER;
		case POLAR_BEAR_SPAWN_EGG: return EntityType.POLAR_BEAR;
		case PUFFERFISH_SPAWN_EGG: return EntityType.PUFFERFISH;
		case RABBIT_SPAWN_EGG: return EntityType.RABBIT;
		case RAVAGER_SPAWN_EGG: return EntityType.RAVAGER;
		case SALMON_SPAWN_EGG: return EntityType.SALMON;
		case SHEEP_SPAWN_EGG: return EntityType.SHEEP;
		case SHULKER_SPAWN_EGG: return EntityType.SHULKER;
		case SILVERFISH_SPAWN_EGG: return EntityType.SILVERFISH;
		case SKELETON_HORSE_SPAWN_EGG: return EntityType.SKELETON_HORSE;
		case SKELETON_SPAWN_EGG: return EntityType.SKELETON;
		case SLIME_SPAWN_EGG: return EntityType.SLIME;
		case SPIDER_SPAWN_EGG: return EntityType.SPIDER;
		case SQUID_SPAWN_EGG: return EntityType.SQUID;
		case STRAY_SPAWN_EGG: return EntityType.STRAY;
		case STRIDER_SPAWN_EGG: return EntityType.STRIDER;
		case TRADER_LLAMA_SPAWN_EGG: return EntityType.TRADER_LLAMA;
		case TROPICAL_FISH_SPAWN_EGG: return EntityType.TROPICAL_FISH;
		case TURTLE_SPAWN_EGG: return EntityType.TURTLE;
		case VEX_SPAWN_EGG: return EntityType.VEX;
		case VILLAGER_SPAWN_EGG: return EntityType.VILLAGER;
		case VINDICATOR_SPAWN_EGG: return EntityType.VINDICATOR;
		case WANDERING_TRADER_SPAWN_EGG: return EntityType.WANDERING_TRADER;
		case WITCH_SPAWN_EGG: return EntityType.WITCH;
		case WITHER_SKELETON_SPAWN_EGG: return EntityType.WITHER_SKELETON;
		case WOLF_SPAWN_EGG: return EntityType.WOLF;
		case ZOGLIN_SPAWN_EGG: return EntityType.ZOGLIN;
		case ZOMBIE_HORSE_SPAWN_EGG: return EntityType.ZOMBIE_HORSE;
		case ZOMBIE_SPAWN_EGG: return EntityType.ZOMBIE;
		case ZOMBIE_VILLAGER_SPAWN_EGG: return EntityType.ZOMBIE_VILLAGER;
		case ZOMBIFIED_PIGLIN_SPAWN_EGG: return EntityType.ZOMBIFIED_PIGLIN;
		default: return EntityType.PIG;
		}
	}

	@Override
	public void onEggLand(ProjectileHitEvent e) {
		if(e.getEntity() instanceof Egg && e.getEntity().getShooter() instanceof Player) {
			Egg egg = (Egg) e.getEntity();
		    if (this.eggs.containsKey(egg)) {
		    	
		    Location loc = null;
			if(e.getHitBlock()!=null) {
				// does some location math in order to not have the entity actually spawn IN the block
				loc = e.getEntity().getLocation();
				Block hitBlock = e.getHitBlock();
				if(Math.abs(loc.getX()-hitBlock.getX())<0.5) {
					if(loc.getX()<hitBlock.getX()) {
						loc.add(-0.5, 0.0, 0.0);
					} else {
						loc.add(0.5,0.0,0.0);
					}
				}
				if(Math.abs(loc.getZ()-hitBlock.getZ())<0.5) {
					if(loc.getZ()<hitBlock.getZ()) {
						loc.add(0.0, 0.0, -0.5);
					} else {
						loc.add(0.0,0.0,0.5);
					}
				}
			}
			else if(e.getHitEntity()!=null) {
				loc = e.getHitEntity().getLocation().add(Math.random()*0.5, 0.5, Math.random()*0.5);
			}
				//loc.add(new Location(egg.getWorld(),(double)e.getHitBlockFace().getModX(),(double)e.getHitBlockFace().getModY(),(double)e.getHitBlockFace().getModZ()));
			      EntityType entityType = this.eggs.get(egg);
			     
			      // this spawns in the actual entity
			    	  Entity ent = egg.getWorld().spawnEntity(loc, entityType);
		    		  
			    	  if(plugin.getConfig().getBoolean("use player names")) {
			    		  ent.setCustomName(((Player)e.getEntity().getShooter()).getName());
				    	  ent.setCustomNameVisible(true);
			    	  }
		    		  
			      }
			}
	}

	@Override
	public void onEntityTarget(EntityTargetEvent e) {
		if(!plugin.getConfig().getBoolean("entities target owner")) {
			if(e.getTarget() instanceof Player) {
				if(e.getTarget().getName().equals(e.getEntity().getCustomName())) {
					e.setCancelled(true);
				}
			}
		} else {
			e.setCancelled(false);
		}
	}

	@Override
	public void onSpawn(CreatureSpawnEvent e) {
		if(e.getEntityType()==EntityType.CHICKEN && (e.getSpawnReason() == SpawnReason.DISPENSE_EGG|| e.getSpawnReason() == SpawnReason.EGG)) {
			e.setCancelled(true);
		}
	}

	
	
}
