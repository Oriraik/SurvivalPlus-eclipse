package rainifuns.survival.config;

import org.bukkit.Material;

import rainifuns.survival.U;

//  此类集成所有变量
public class Bian {
    
//    玩家最大死亡次数
    public static Integer max_dead = 3;
//    玩家的最大生命值
    public static Double player_health = 2.0;
//    服务器外的玩家是否可以用旁观者的身份加入服务器
    public static Boolean spectator_enable = true;
//    死亡次数到达上限的玩家是踢出服务器 还是转为旁观者模式 T为踢出服务器
    public static Boolean spectator_is_kick = true;
//    是否立即重生
    public static Boolean respawn_force = false;
    public static String last_dead_message = "这是你最后一条命了";
    public static String dead_message = "你当前剩余%dead%次死亡机会";
    public static String kick_message = "您的死亡次数已用尽";
    public static String hat_material = "GLASS";
    public static String set_comm_message = "&6你的死亡次数被重新设置为&a%dead-2%&6次";
    public static String del_comm_message = "&6你的死亡次数减少至&a%dead-2%&6次";
    
    public static void getBianFromConfig() {
	max_dead = DataManager.getConfig().getInt("max-dead");
	player_health = DataManager.getConfig().getDouble("player-health");
	last_dead_message = DataManager.getConfig().getString("last-dead-message");
	dead_message = DataManager.getConfig().getString("dead-message");
	kick_message = DataManager.getConfig().getString("kick-message");
	hat_material = DataManager.getConfig().getString("hat-material");
	set_comm_message = DataManager.getConfig().getString("set-comm-message");
	del_comm_message = DataManager.getConfig().getString("del-comm-message");
	spectator_enable = DataManager.getConfig().getBoolean("spectator-enable");
	spectator_is_kick = DataManager.getConfig().getBoolean("spectator-is-kick");
	respawn_force = DataManager.getConfig().getBoolean("respawn-force");
	try {
	    Material.getMaterial(hat_material);
	} catch (Exception e) {
	    U.log_failed("hat-material设置错误，请仔细检查(不兼容模组)");
	}
    }
}
