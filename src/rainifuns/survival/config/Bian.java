package rainifuns.survival.config;

import org.bukkit.Material;

import rainifuns.survival.U;

//  ���༯�����б���
public class Bian {
    
//    ��������������
    public static Integer max_dead = 3;
//    ��ҵ��������ֵ
    public static Double player_health = 2.0;
    public static String last_dead_message = "���������һ������";
    public static String dead_message = "�㵱ǰʣ��%dead%����������";
    public static String kick_message = "���������������þ�";
    public static String hat_material = "GLASS";
    public static String set_comm_message = "&6���������������������Ϊ&a%dead%&6��";
    public static String del_comm_message = "&6�����������������&a%dead%&6��";
    
    public static void getBianFromConfig() {
	max_dead = DataManager.getConfig().getInt("max-dead");
	player_health = DataManager.getConfig().getDouble("player-health");
	last_dead_message = DataManager.getConfig().getString("last-dead-message");
	dead_message = DataManager.getConfig().getString("dead-message");
	kick_message = DataManager.getConfig().getString("kick-message");
	hat_material = DataManager.getConfig().getString("hat-material");
	set_comm_message = DataManager.getConfig().getString("set-comm-message");
	del_comm_message = DataManager.getConfig().getString("del-comm-message");
	try {
	    Material.getMaterial(hat_material);
	} catch (Exception e) {
	    U.log_failed("hat-material���ô�������ϸ���(������ģ��)");
	}
    }
}
