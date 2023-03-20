package me.discordbot.badwords;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class BadWordsBlocker extends ListenerAdapter {
    static ArrayList<String> badwords = new ArrayList<String>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)){
            return;
        }

        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if(messageSent[0].equals("!ban")){
            System.out.println("Ban detected");
            if(messageSent.length==1){
                event.getChannel().sendMessage("Write the word you want to ban in this format !ban badword").queue();
            }else{
            badwords.add(messageSent[1]);
            event.getChannel().sendMessage("Badword added").queue();
        }
        }

    }



}
