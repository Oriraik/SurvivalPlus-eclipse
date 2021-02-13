package rainifuns.survival.config;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;

import rainifuns.survival.Main;
import rainifuns.survival.U;

public class DataManager {
    
//    ������<���,�Ѿ������Ĵ���>
    private static HashMap<String,Integer> Obituary = new HashMap<>();
    private static FileConfiguration c;
    
//    ������ҵĵ�ǰ��������
    public static Integer getDead(String name) {
	return Obituary.get(name);
    }
    
//    �����������+1
    public static void deadPlayer(String name) {
	addNewPlayer(name);
	Obituary.put(name, Obituary.get(name)+1);
    }
    
//    ��Map������µ��������
    public static void addNewPlayer(String name) {
	if (isContain(name)) return;
	Obituary.put(name, 0);
    }
    
//    ��������Ƿ��Ѿ���Map��
    public static boolean isContain(String name) {
	if (Obituary.containsKey(name)) return true;
	return false;
    }
    
//    ����HashMap
    public static HashMap<String,Integer> getMap() {return Obituary;}
    
//    ���������ļ�
    public static FileConfiguration getConfig() {return c;}
    
//    ���������ļ�
    public static void initConfig() {
	Main.getPlugin().saveDefaultConfig();
//	���¶�ȡ�����ļ�
	c = Main.getPlugin().getConfig();
	Bian.getBianFromConfig();
	U.log_success("�����ļ����سɹ�");
//	��ȡ���������Map
	if (c.getConfigurationSection("player")!=null) {
	    for (String name : c.getConfigurationSection("player").getKeys(false)) {
		Obituary.put(name, c.getInt("player."+name));
	    }
	}
	U.log_success("������ݵ���ɹ�");
    }
    
    public static void saveConfig() {
	Obituary.forEach((k,v) -> {
	    c.set("player."+k, v);
	});
	Main.getPlugin().saveConfig();
	U.log_success("�ɹ����������ļ�");
    }
    
}
