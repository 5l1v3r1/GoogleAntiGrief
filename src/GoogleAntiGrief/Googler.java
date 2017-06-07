package GoogleAntiGrief;


import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jsoup.Jsoup;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rick on 5-6-17.
 */
public class Googler {

    String prefix = ChatColor.RED+"[GoogleAntiGrief] "+ChatColor.WHITE;
    List<String> keywords = Arrays.asList("ban", "hack","grief","report");


    public void Googler(String PlayerName, Boolean Broadcast, CommandSender Sender, String[] args){

        Bukkit.broadcastMessage(prefix+"Looking up "+PlayerName);

        if(args !=null){
            String[] a = Arrays.copyOfRange(args, 1, args.length);      //Removes the fist item and converts it to a list
            keywords = Arrays.asList(a);
        }

        try{

            String google = "https://www.google.com/search?q=";
            String search = PlayerName;
            String charset = "UTF-8";


            String test = Jsoup.connect(google+URLEncoder.encode(search, charset)).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com").get().toString().toLowerCase();

            for(String s:keywords){
                int i = StringUtils.countMatches(test, s.toLowerCase());
                String msg = prefix+"Mentions of '"+s+"': "+i;

                if(Broadcast){
                    Bukkit.broadcastMessage(msg);
                }else{
                    Sender.sendMessage(msg);
                }
            }



        }catch(Exception e){
            //todo log exception

        }
    }

}
