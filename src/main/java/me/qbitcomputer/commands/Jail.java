package me.qbitcomputer.commands;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Jail extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("jail")) {
            EmbedBuilder embed = new EmbedBuilder();
            Dotenv dotenv = Dotenv.load();
            embed.setColor(Color.decode("#0013ca"));
            embed.setTitle("You jailed " + event.getOption("user").getAsUser().getName() + "!");
            embed.setImage("https://api.popcat.xyz/jail?image=" + event.getOption("user").getAsUser().getAvatarUrl());
            event.replyEmbeds(embed.build()).queue();
        }
    }
}