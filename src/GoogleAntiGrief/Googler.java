package GoogleAntiGrief;


import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jsoup.Jsoup;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rick on 5-6-17.
 */
public class Googler {

    String prefix = ChatColor.BLUE+"[GoogleAntiGrief] "+ChatColor.WHITE;

    List<String> Defaultkeywords = Arrays.asList("ban", "hack","grief","report");
    List<String> keywords = getKeywords();



    public void Googler(String PlayerName, Boolean Broadcast, CommandSender Sender, String[] args){

	if(Broadcast){
	        Bukkit.broadcastMessage(prefix+"Looking up "+PlayerName);
	}else{
		Sender.sendMessage(prefix+"Looking up "+PlayerName);
	}


        if(args !=null){
            String[] a = Arrays.copyOfRange(args, 1, args.length);      //Removes the fist item and converts it to a list
            keywords = Arrays.asList(a);
        }

        try{

            String google = "https://www.google.com/search?q=";
            String search = PlayerName;
            String charset = "UTF-8";


            String result = Jsoup.connect(google+URLEncoder.encode(search, charset)).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com").get().body().text().toLowerCase();

            for(String s:keywords){
                int i = StringUtils.countMatches(result, s.toLowerCase());
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

    public List<String> getKeywords(){

        Plugin Self = Bukkit.getPluginManager().getPlugin("GoogleAntiGrief");

        if(Self.getDataFolder().listFiles()==null||Self.getDataFolder().listFiles().length == 0){
            Self.saveDefaultConfig();
            Bukkit.getLogger().info("[GoogleAntiGrief] Saving default config....");
        }else{

            try{
               return (List<String>) Self.getConfig().getList("keywords");

            }catch(Exception e){
                Bukkit.getLogger().info("[GoogleAntiGrief] config.yml is invalid, using default values.");
            }
        }

        return Defaultkeywords;
    }


}
