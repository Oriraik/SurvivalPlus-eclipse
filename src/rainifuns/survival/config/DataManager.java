package rainifuns.survival.config;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;

import rainifuns.survival.Main;
import rainifuns.survival.U;

public class DataManager {
    
//    生死簿<玩家,已经死亡的次数>
    private static HashMap<String,Integer> Obituary = new HashMap<>();
    private static FileConfiguration c;
    
//    返回玩家的当前死亡次数
    public static Integer getDead(String name) {
	return Obituary.get(name);
    }
    
//    玩家死亡次数+1
    public static void deadPlayer(String name) {
	addNewPlayer(name);
	Obituary.put(name, Obituary.get(name)+1);
    }
    
//    往Map中添加新的玩家数据
    public static void addNewPlayer(String name) {
	if (isContain(name)) return;
	Obituary.put(name, 0);
    }
    
//    返回玩家是否已经在Map中
    public static boolean isContain(String name) {
	if (Obituary.containsKey(name)) return true;
	return false;
    }
    
//    返回HashMap
    public static HashMap<String,Integer> getMap() {return Obituary;}
    
//    返回配置文件
    public static FileConfiguration getConfig() {return c;}
    
//    加载配置文件
    public static void initConfig() {
	Main.getPlugin().saveDefaultConfig();
//	重新读取配置文件
	c = Main.getPlugin().getConfig();
	Bian.getBianFromConfig();
	U.log_success("配置文件加载成功");
//	读取玩家数据入Map
	if (c.getConfigurationSection("player")!=null) {
	    for (String name : c.getConfigurationSection("player").getKeys(false)) {
		Obituary.put(name, c.getInt("player."+name));
	    }
	}
	U.log_success("玩家数据导入成功");
    }
    
    public static void saveConfig() {
	Obituary.forEach((k,v) -> {
	    c.set("player."+k, v);
	});
	Main.getPlugin().saveConfig();
	U.log_success("成功保存配置文件");
    }
    
}
