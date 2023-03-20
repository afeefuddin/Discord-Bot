package me.discordbot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Helloevent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
       String[] messageSent = event.getMessage().getContentRaw().split(" ");
       String name = event.getMember().getUser().getName();
       if(messageSent[0].equalsIgnoreCase("Hi") || messageSent[0].equalsIgnoreCase("Hello"))
       if(messageSent[1].equalsIgnoreCase("44gamers")){
           event.getChannel().sendMessage("Hi " +  name).queue();
       }

    }
}
