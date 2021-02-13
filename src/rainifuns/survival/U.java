package rainifuns.survival;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import rainifuns.survival.config.DataManager;

// 工具类
public class U {
    
//    控制台输出消息,成功
    public static void log_success(String message) {
	Main.getPlugin().getServer().getConsoleSender().sendMessage(Main.prefixA + message);
    }

//    控制台输出消息,失败
    public static void log_failed(String message) {
	Main.getPlugin().getServer().getConsoleSender().sendMessage(Main.prefixC + message);
    }
    
//    设置某个玩家的最大生命值
    public static void setHealth(Player player, Double health) {
	player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
    }
    
//    根据玩家名字更改变量显示
    public static String remake(String message, String player_name) {
	
	message = message.replaceAll("&", "§");
	message = message.replaceAll("%player%", player_name);
	message = message.replaceAll("%dead%", DataManager.getDead(player_name)+"");
	
	return message;
    }
}
