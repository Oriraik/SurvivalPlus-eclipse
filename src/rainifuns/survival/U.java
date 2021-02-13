package rainifuns.survival;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import rainifuns.survival.config.DataManager;

// ������
public class U {
    
//    ����̨�����Ϣ,�ɹ�
    public static void log_success(String message) {
	Main.getPlugin().getServer().getConsoleSender().sendMessage(Main.prefixA + message);
    }

//    ����̨�����Ϣ,ʧ��
    public static void log_failed(String message) {
	Main.getPlugin().getServer().getConsoleSender().sendMessage(Main.prefixC + message);
    }
    
//    ����ĳ����ҵ��������ֵ
    public static void setHealth(Player player, Double health) {
	player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
    }
    
//    ����������ָ��ı�����ʾ
    public static String remake(String message, String player_name) {
	
	message = message.replaceAll("&", "��");
	message = message.replaceAll("%player%", player_name);
	message = message.replaceAll("%dead%", DataManager.getDead(player_name)+"");
	
	return message;
    }
}
