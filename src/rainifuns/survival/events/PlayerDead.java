package rainifuns.survival.events;

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
	if (b==a) {//��ʣ���һ����
	    p.sendMessage(U.remake(Bian.last_dead_message, p.getName()));
	}else if (b<a) {//���������Ļ���
	    p.sendMessage(U.remake(Bian.dead_message, p.getName()));
	}else {//û������������
	    p.kickPlayer(U.remake(Bian.dead_message, p.getName()));
	}
    }
    
    public static void reg() {
	Main.getPlugin().getServer().getPluginManager().registerEvents(new PlayerDead(), Main.getPlugin());
    }
}
