package me.discordbot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import net.dv8tion.jda.api.utils.FileUpload;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.io.File;

public class NewMember extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        System.out.println("Member joined");
        String name = event.getMember().getUser().getName();
        JDA client = event.getJDA();
        final List<TextChannel> channels = client.getTextChannelsByName("welcome",true);

        TextChannel channel = channels.get(0);
        String servername = event.getGuild().getName();
        String username = event.getMember().getAsMention();
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("WELCOME "+username+" TO "+servername);
        embed.setColor(Color.magenta);
        embed.setImage("https://media.giphy.com/media/hr4Ljjyj0L9RYlihLr/giphy.gif");

        channel.sendMessageEmbeds(embed.build()).queue();



    }
}
