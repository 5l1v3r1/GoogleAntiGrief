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
        
        //Todo: Add a function to check the Firstplayedtime against the current time
        //to see if this it the first time the player joined the server.
        G.Googler(p.getName(), true, null, null);
    }

}
