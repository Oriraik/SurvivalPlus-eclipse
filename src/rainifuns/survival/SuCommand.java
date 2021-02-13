package rainifuns.survival;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import rainifuns.survival.config.DataManager;

public class SuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
	
	if (args.length==3) {
	    
	    switch(args[0]) {
	    
	    case "set":
		try {
		    String player = args[1];
		    int dead = Integer.valueOf(args[2]);
		    DataManager.setPlayerDead(player, dead);
		} catch (Exception e) {
		    sender.sendMessage(Main.prefixC + "����������ֿ������� ");
		    help(sender);
		}
		break;
	    case "del":
		try {
		    String player = args[1];
		    int dead = Integer.valueOf(args[2]);
		    DataManager.delDeadCount(player, dead);
		} catch (Exception e) {
		    sender.sendMessage(Main.prefixC + "����������ֿ������� ");
		    help(sender);
		}
		break;
	    default:
		help(sender);
		break;
	    }
	    
	}else {
	    help(sender);
	}
	
	return false;
    }
    
    
    public void help(CommandSender sender) {
	sender.sendMessage("��e===========��6ָ����� �������¡�e============");
	sender.sendMessage("��a/survivalplus set <name> <number>  ��d������ҵ��ۼ���������");
	sender.sendMessage("��a/survivalplus del <name> <number>  ��d������ҵ��ۼ���������");
	sender.sendMessage("��e=================================");
    }
}
