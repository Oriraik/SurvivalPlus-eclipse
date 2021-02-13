package rainifuns.survival.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import rainifuns.survival.Main;
import rainifuns.survival.U;
import rainifuns.survival.config.Bian;
import rainifuns.survival.config.DataManager;

public class PlayerJoin implements Listener {
    
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
	Player p = e.getPlayer();
	DataManager.addNewPlayer(p.getName());
	//设置玩家的最大血量
	U.setHealth(p, Bian.player_health);
	//如果死亡次数大于配置就踢出去
	if (DataManager.getDead(p.getName())>Bian.max_dead) {
	    e.setJoinMessage(null);
	    if (Bian.spectator_enable) { //如果启用了旁观者模式 就以旁观者进入服务器
		p.setGameMode(GameMode.SPECTATOR);
	    }else {
		p.kickPlayer(U.remake(Bian.kick_message, p.getName()));
	    }
	}
	
    }
    
    @EventHandler//取消玩家离开服务器时的信息提示
    public void onLeave(PlayerQuitEvent e) {
	Player p = e.getPlayer();
	
	if (DataManager.getDead(p.getName())>Bian.max_dead) {
	    e.setQuitMessage(null);
	}
	
    }
    
    public static void reg() {
	Main.getPlugin().getServer().getPluginManager().registerEvents(new PlayerJoin(), Main.getPlugin());
    }
    
}
