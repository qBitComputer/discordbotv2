package me.qbitcomputer.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Drake extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("drake")) {
            String text1 = event.getOption("text1").getAsString();
            String text12 = text1.replaceAll("\\s", "+");
            String text2 = event.getOption("text2").getAsString();
            String text22 = text1.replaceAll("\\s", "+");
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Here is your drake meme!");
            embed.setColor(Color.decode("#0013ca"));
            embed.setImage("https://api.popcat.xyz/drake?text1=" + text12 + "&text2=" + text22);
            event.replyEmbeds(embed.build()).queue();
        }
    }
}