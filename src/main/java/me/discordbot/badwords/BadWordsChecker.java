package me.discordbot.badwords;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static me.discordbot.badwords.BadWordsBlocker.badwords;

public class BadWordsChecker extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String username =  event.getMember().getAsMention();
        if(messageSent[0].equals("!ban")){
            return;
        }
        else{
            for (int i = 0; i < messageSent.length; i++) {
                for (int j = 0; j < badwords.size(); j++) {
                    if(messageSent[i].equalsIgnoreCase(badwords.get(j))){
                        event.getMessage().delete().queue();
                        event.getChannel().sendMessage("Mind your language "+ username).queue();

                        break;
                    }
                }
            }
        }
    }
}
