package GoogleAntiGrief;

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
        Googler G = new Googler();

        G.Googler(p.getName(), true, null, null);
    }

}
