package rainifuns.survival.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;

import rainifuns.survival.Main;
import rainifuns.survival.config.Bian;

public class EntitySpawn implements Listener {
    
    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
	if (e.getEntity() instanceof Monster) {
	    LivingEntity le = (LivingEntity) e.getEntity();
	    if (le.getType().equals(EntityType.ZOMBIE)|le.getType().equals(EntityType.ZOMBIE_VILLAGER)|le.getType().equals(EntityType.SKELETON)|le.getType().equals(EntityType.STRAY)|le.getType().equals(EntityType.HUSK)) {
		le.getEquipment().setHelmet(getItem(Bian.hat_material));
	    }
	}
    }
    
    public static void reg() {
	Main.getPlugin().getServer().getPluginManager().registerEvents(new EntitySpawn(), Main.getPlugin());
    }
    
    private ItemStack getItem(String m) {
	return (new ItemStack(Material.matchMaterial(m)));
    }
}
