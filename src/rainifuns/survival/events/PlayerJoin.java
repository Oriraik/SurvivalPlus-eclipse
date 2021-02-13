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
	//������ҵ����Ѫ��
	U.setHealth(p, Bian.player_health);
	//������������������þ��߳�ȥ
	if (DataManager.getDead(p.getName())>Bian.max_dead) {
	    e.setJoinMessage(null);
	    if (Bian.spectator_enable) { //����������Թ���ģʽ �����Թ��߽��������
		p.setGameMode(GameMode.SPECTATOR);
	    }else {
		p.kickPlayer(U.remake(Bian.kick_message, p.getName()));
	    }
	}
	
    }
    
    @EventHandler//ȡ������뿪������ʱ����Ϣ��ʾ
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
