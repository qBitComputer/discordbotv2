package me.qbitcomputer.managers;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class slashCommandManager extends ListenerAdapter {
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commands = new ArrayList<>();
        commands.add(Commands.slash("ping", "You can use this command to make sure the bot is alive :)"));
        commands.add(Commands.slash("drip", "Drippify someone")
                .addOption(OptionType.USER, "user", "Choose someone to drippify", true));
        event.getGuild().updateCommands().addCommands(commands).queue();
    }
}