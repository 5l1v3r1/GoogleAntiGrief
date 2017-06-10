package GoogleAntiGrief;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;


/**
 * Created by rick on 5-6-17.
 */
public class LoginListener implements Listener {


    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent e){

        Player p = e.getPlayer();
        OfflinePlayer op = Bukkit.getOfflinePlayer(p.getUniqueId()); //hasPlayedBefore() only works on offline players

        Googler G = new Googler();

        if(! op.hasPlayedBefore()){
            G.Googler(p.getName(), true, null, null);
        }
    }

}
