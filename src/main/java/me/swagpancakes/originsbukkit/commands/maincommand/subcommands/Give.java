/*
 * Origins-Bukkit - Origins for Bukkit and forks of Bukkit.
 * Copyright (C) 2021 SwagPannekaker
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.swagpancakes.originsbukkit.commands.maincommand.subcommands;

import me.swagpancakes.originsbukkit.commands.maincommand.MainCommand;
import me.swagpancakes.originsbukkit.enums.Permissions;
import me.swagpancakes.originsbukkit.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Give.
 *
 * @author SwagPannekaker
 */
public class Give {

    private final MainCommand mainCommand;

    /**
     * Gets main command.
     *
     * @return the main command
     */
    public MainCommand getMainCommand() {
        return mainCommand;
    }

    /**
     * Instantiates a new Give.
     *
     * @param mainCommand the main command
     */
    public Give(MainCommand mainCommand) {
        this.mainCommand = mainCommand;
    }

    /**
     * Give sub command.
     *
     * @param sender  the sender
     * @param command the command
     * @param label   the label
     * @param args    the args
     */
    public void GiveSubCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission(Permissions.GIVE.toString())) {
                if (args.length == 1) {
                    ChatUtils.sendCommandSenderMessage(sender, "&cNot enough arguments. Usage: /origins give <player>" + " <item>");
                } else if (args.length == 2) {
                    ChatUtils.sendCommandSenderMessage(sender, "&cNot Enough Arguments. Usage: /origins give " + args[1] + " <item>");
                } else if (args.length == 3) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if (target != null) {
                        String item = args[2];

                        switch (item) {
                            case "minecraft:origin_ball":
                            case "origin_ball":
                                target.getInventory().addItem(getMainCommand().getCommandHandler().getPlugin().getItemHandler().getOriginBall().getItemStack());
                                break;
                        }
                    } else {
                        ChatUtils.sendCommandSenderMessage(sender, "&cPlayer " + args[1] + " not found. Player must be online to do this.");
                    }
                } else if (args.length == 4) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if (target != null) {
                        String item = args[2];
                        try {
                            int amount = Integer.parseInt(args[3]);

                            switch (item) {
                                case "minecraft:origin_ball":
                                case "origin_ball":
                                    getMainCommand().getCommandHandler().getPlugin().getItemHandler().getOriginBall().getItemStack().setAmount(amount);
                                    target.getInventory().addItem(getMainCommand().getCommandHandler().getPlugin().getItemHandler().getOriginBall().getItemStack());
                                    getMainCommand().getCommandHandler().getPlugin().getItemHandler().getOriginBall().getItemStack().setAmount(1);
                                    break;
                            }
                        } catch (IllegalArgumentException e) {
                            ChatUtils.sendCommandSenderMessage(sender, "&cAmount must be a number.");
                        }
                    } else {
                        ChatUtils.sendCommandSenderMessage(sender, "&cPlayer " + args[1] + " not found. Player must be online to do this.");
                    }
                } else {
                    ChatUtils.sendCommandSenderMessage(sender, "&cToo many arguments. Usage: /origins give <player> <item> <amount>");
                }
            }
        } else {
            if (args.length == 1) {
                ChatUtils.sendCommandSenderMessage(sender, "&c[Origins-Bukkit] Not enough arguments. Usage: /origins give <player>" + " <item>");
            } else if (args.length == 2) {
                ChatUtils.sendCommandSenderMessage(sender, "&c[Origins-Bukkit] Not Enough Arguments. Usage: /origins give " + args[1] + " <item>");
            } else if (args.length == 3) {
                Player target = Bukkit.getPlayer(args[1]);

                if (target != null) {
                    String item = args[2];

                    switch (item) {
                        case "minecraft:origin_ball":
                        case "origin_ball":
                            target.getInventory().addItem(getMainCommand().getCommandHandler().getPlugin().getItemHandler().getOriginBall().getItemStack());
                            break;
                    }
                } else {
                    ChatUtils.sendCommandSenderMessage(sender, "&c[Origins-Bukkit] Player " + args[1] + " not found. Player must be online to do this.");
                }
            } else if (args.length == 4) {
                Player target = Bukkit.getPlayer(args[1]);

                if (target != null) {
                    String item = args[2];
                    try {
                        int amount = Integer.parseInt(args[3]);

                        switch (item) {
                            case "minecraft:origin_ball":
                            case "origin_ball":
                                getMainCommand().getCommandHandler().getPlugin().getItemHandler().getOriginBall().getItemStack().setAmount(amount);
                                target.getInventory().addItem(getMainCommand().getCommandHandler().getPlugin().getItemHandler().getOriginBall().getItemStack());
                                getMainCommand().getCommandHandler().getPlugin().getItemHandler().getOriginBall().getItemStack().setAmount(1);
                                break;
                        }
                    } catch (IllegalArgumentException e) {
                        ChatUtils.sendCommandSenderMessage(sender, "&c[Origins-Bukkit] Amount must be a number.");
                    }
                } else {
                    ChatUtils.sendCommandSenderMessage(sender, "&c[Origins-Bukkit] Player " + args[1] + " not found. Player must be online to do this.");
                }
            } else {
                ChatUtils.sendCommandSenderMessage(sender, "&c[Origins-Bukkit] Too many arguments. Usage: /origins give <player> <item> <amount>");
            }
        }
    }

    /**
     * Give sub command tab complete list.
     *
     * @param sender  the sender
     * @param command the command
     * @param alias   the alias
     * @param args    the args
     *
     * @return the list
     */
    public List<String> GiveSubCommandTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> empty = new ArrayList<>();

        if (sender instanceof Player) {
            if (sender.hasPermission(Permissions.GIVE.toString())) {
                if (args.length == 1) {
                    List<String> subCommand = new ArrayList<>();
                    subCommand.add("give");

                    return subCommand;
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("give")) {
                        List<String> playerNames = new ArrayList<>();
                        Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                        Bukkit.getServer().getOnlinePlayers().toArray(players);
                        for (Player player : players) {
                            playerNames.add(player.getName());
                        }

                        return playerNames;
                    }
                } else if (args.length == 3) {
                    if (args[0].equalsIgnoreCase("give")) {
                        List<String> itemList = new ArrayList<>();
                        for (String item : getMainCommand().getCommandHandler().getPlugin().getItemHandler().getItems()) {
                            if (item.startsWith(args[2])) {
                                itemList.add(item);
                            }
                        }

                        return itemList;
                    }
                }
            }
        } else {
            if (args.length == 1) {
                List<String> subCommand = new ArrayList<>();
                subCommand.add("give");

                return subCommand;
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("give")) {
                    List<String> playerNames = new ArrayList<>();
                    Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                    Bukkit.getServer().getOnlinePlayers().toArray(players);
                    for (Player player : players) {
                        playerNames.add(player.getName());
                    }

                    return playerNames;
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("give")) {
                    List<String> itemList = new ArrayList<>();
                    for (String item : getMainCommand().getCommandHandler().getPlugin().getItemHandler().getItems()) {
                        if (item.startsWith(args[2])) {
                            itemList.add(item);
                        }
                    }

                    return itemList;
                }
            }
        }
        return empty;
    }
}
