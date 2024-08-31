package me.qbitcomputer.commands;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Sadcat extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("sadcat")) {
            String text1 = event.getOption("text1").getAsString();
            String text = text1.replaceAll("\\s", "+");
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Here is your SadCat meme!");
            embed.setColor(Color.decode("#0013ca"));
            embed.setImage("https://api.popcat.xyz/sadcat?text=" + text);
            event.replyEmbeds(embed.build()).queue();
        }
    }
}