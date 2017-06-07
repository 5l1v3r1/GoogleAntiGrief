package GoogleAntiGrief;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by rick on 5-6-17.
 */
public class MainClass extends JavaPlugin {

    String prefix = ChatColor.RED+"[GoogleAntiGrief] "+ChatColor.WHITE;

    @Override
    public void onEnable(){
        Bukkit.getLogger().info(prefix+"GoogleAntiGrief loaded");
        getServer().getPluginManager().registerEvents(new LoginListener(), this);
    }

    @Override
    public void onDisable(){

    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args){

        if(cmd.getName().equals("vet")){
            if(args.length <2){
                return false;
            }else{
                Googler G = new Googler();
                G.Googler(args[0], false, s, args);
                return true;
            }

        }

        return false;
    }



}
