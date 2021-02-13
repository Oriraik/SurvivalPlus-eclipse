package rainifuns.survival;

import org.bukkit.plugin.java.JavaPlugin;

import rainifuns.survival.config.DataManager;
import rainifuns.survival.events.EntitySpawn;
import rainifuns.survival.events.PlayerDead;
import rainifuns.survival.events.PlayerJoin;

public class Main extends JavaPlugin{
    
    public static final String prefixA = "°ÏbSurvivalPlus °Ïe> °Ïa";
    public static final String prefixC = "°ÏbSurvivalPlus °Ïe> °Ïc";
    
    public static Main main;
    
    @Override
    public void onEnable() {
	main = this;
	getServer().getConsoleSender().sendMessage(prefixA + "≤Âº˛“—º”‘ÿ");
	DataManager.initConfig();
	regEvent();
	getServer().getPluginCommand("survivalplus").setExecutor(new SuCommand());
    }
    
    @Override
    public void onDisable() {
	DataManager.saveConfig();
    }
    
    public static void regEvent() {
	PlayerDead.reg();
	PlayerJoin.reg();
	EntitySpawn.reg();
    }
    
    public static Main getPlugin() {return main;}
}
