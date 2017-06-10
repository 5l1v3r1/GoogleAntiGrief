package GoogleAntiGrief;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Created by rick on 5-6-17.
 */
public class MainClass extends JavaPlugin {

    @Override
    public void onEnable(){
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
