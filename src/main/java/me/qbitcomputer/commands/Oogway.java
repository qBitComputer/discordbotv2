package me.qbitcomputer.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Oogway extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("oogway")) {
            String text1 = event.getOption("text").getAsString();
            String text = text1.replaceAll("\\s", "+");
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Here is your oogway meme!");
            embed.setColor(Color.decode("#0013ca"));
            embed.setImage("https://api.popcat.xyz/oogway?text=" + text);
            event.replyEmbeds(embed.build()).queue();
        }
    }
}