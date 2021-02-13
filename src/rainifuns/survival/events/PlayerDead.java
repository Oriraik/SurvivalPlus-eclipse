package rainifuns.survival.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import rainifuns.survival.Main;
import rainifuns.survival.U;
import rainifuns.survival.config.Bian;
import rainifuns.survival.config.DataManager;

public class PlayerDead implements Listener {
    
    @EventHandler
    public void onDead(PlayerDeathEvent e) {
	Player p = e.getEntity();
	DataManager.addNewPlayer(p.getName());
	DataManager.deadPlayer(p.getName());
	int a = Bian.max_dead;
	int b = DataManager.getDead(p.getName());
	if (Bian.respawn_force) p.spigot().respawn();
	if (b==a) {//还剩最后一条命
	    p.sendMessage(U.remake(Bian.last_dead_message, p.getName()));
	}else if (b<a) {//还有死亡的机会
	    p.sendMessage(U.remake(Bian.dead_message, p.getName()));
	}else {//没有死亡机会了
	    if (Bian.spectator_is_kick) {
		p.kickPlayer(U.remake(Bian.kick_message, p.getName()));
	    }else {
		p.setGameMode(GameMode.SPECTATOR);
	    }
	}
    }
    
    public static void reg() {
	Main.getPlugin().getServer().getPluginManager().registerEvents(new PlayerDead(), Main.getPlugin());
    }
}
