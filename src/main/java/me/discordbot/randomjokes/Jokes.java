package me.discordbot.randomjokes;

import io.chucknorris.client.ChuckNorrisClient;
import io.chucknorris.client.Joke;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import me.discordbot.Main;
import java.util.ArrayList;
import java.util.List;

public class Jokes extends ListenerAdapter {
    public String tells_a_joke(){
        ChuckNorrisClient client = new ChuckNorrisClient();
        Joke joke = client.getRandomJoke();
        String s = joke.getValue();
        return s;

    }
    public String replace_chuck(String s){
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equalsIgnoreCase("Chuck")){
                arr[i] = "44gamers";
            }
            if(arr[i].equalsIgnoreCase("Norris")||arr[i].equalsIgnoreCase("Norris'")||arr[i].equalsIgnoreCase("Norris,")){
                arr[i] = "";
            }
        sb.append(arr[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        System.out.println("Slash");
        String comnd = event.getName();
        if (comnd.equals("joke")){
            String joke = tells_a_joke();
            String joke_modified = replace_chuck(joke);
            event.reply(joke_modified).queue();

        }
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> CommandData = new ArrayList<>();
        CommandData.add(Commands.slash("joke","Tells a joke"));
        event.getGuild().updateCommands().addCommands(CommandData).queue();
    }


}
