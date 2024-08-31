package me.qbitcomputer;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    private ShardManager shardManager;

    public Main() throws LoginException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("TOKEN");
        String status = dotenv.get("STATUS");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching(status));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT);
        shardManager = builder.build();
        shardManager.addEventListener(
                new slashcommandmanager()
        );


    }

    public static void main(String[] args) {
        try {
            Main bot = new Main();
        } catch (LoginException e) {
            System.out.println("Bot token invalid!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}