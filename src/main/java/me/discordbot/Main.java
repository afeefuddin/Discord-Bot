package me.discordbot;

import io.chucknorris.client.ChuckNorrisClient;
import io.github.cdimascio.dotenv.Dotenv;
import me.discordbot.badwords.BadWordsBlocker;
import me.discordbot.badwords.BadWordsChecker;
import me.discordbot.randomjokes.Jokes;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {
    private static final Dotenv config = Dotenv.configure().load();

    public static void main(String[] args) throws Exception{
        String token = config.get("TOKEN");

        JDA bot = JDABuilder.createDefault(token).enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
      //             .setMemberCachePolicy(MemberCachePolicy.ALL)
      //          .setChunkingFilter(ChunkingFilter.ALL).enableCache(CacheFlag.ROLE_TAGS)
                .build();

        bot.addEventListener(new Helloevent());
        bot.addEventListener(new NewMember());
        bot.addEventListener(new BadWordsBlocker());
        bot.addEventListener(new BadWordsChecker());
        bot.addEventListener(new Jokes());
    }
}