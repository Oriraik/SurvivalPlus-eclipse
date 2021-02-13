package rainifuns.survival.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import rainifuns.survival.Main;
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
	if (b==a) {//��ʣ���һ����
	    p.sendMessage(Bian.last_dead_message);
	}else if (b<a) {//���������Ļ���
	    p.sendMessage(Bian.dead_message.replaceAll("%dead%", String.valueOf(a-b)));
	}else {//û������������
	    p.kickPlayer(Bian.kick_message);
	}
    }
    
    public static void reg() {
	Main.getPlugin().getServer().getPluginManager().registerEvents(new PlayerDead(), Main.getPlugin());
    }
}
