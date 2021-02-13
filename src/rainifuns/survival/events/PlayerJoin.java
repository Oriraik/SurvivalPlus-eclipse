package rainifuns.survival.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import rainifuns.survival.Main;
import rainifuns.survival.U;
import rainifuns.survival.config.Bian;
import rainifuns.survival.config.DataManager;

public class PlayerJoin implements Listener {
    
    @EventHandler
    public void onDead(PlayerJoinEvent e) {
	Player p = e.getPlayer();
	DataManager.addNewPlayer(p.getName());
	//设置玩家的最大血量
	U.setHealth(p, Bian.player_health);
	//如果死亡次数大于配置就踢出去
	if (DataManager.getDead(p.getName())>Bian.max_dead) {
	    p.kickPlayer(Bian.kick_message);
	}
	
    }
    
    public static void reg() {
	Main.getPlugin().getServer().getPluginManager().registerEvents(new PlayerJoin(), Main.getPlugin());
    }
    
}
