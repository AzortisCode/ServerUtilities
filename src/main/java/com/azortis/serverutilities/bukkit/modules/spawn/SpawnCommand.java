/*
 * A handy set of utilities for your Minecraft server
 *     Copyright (C) 2020  Azortis
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.azortis.serverutilities.bukkit.modules.spawn;

import com.azortis.azortislib.command.Alias;
import com.azortis.azortislib.command.Command;
import com.azortis.azortislib.command.CommandInjector;
import com.azortis.azortislib.command.SubCommand;
import com.azortis.azortislib.command.builders.CommandBuilder;
import com.azortis.azortislib.command.builders.SubCommandBuilder;
import com.azortis.azortislib.command.executors.ICommandExecutor;
import com.azortis.serverutilities.bukkit.PermissionManager;
import com.azortis.serverutilities.bukkit.ServerUtilities;
import com.azortis.serverutilities.bukkit.modules.spawn.settings.SpawnLocation;
import com.azortis.serverutilities.bukkit.modules.spawn.settings.SpawnSettings;
import com.azortis.serverutilities.bukkit.modules.spawn.subcommands.SpawnDeleteSub;
import com.azortis.serverutilities.bukkit.modules.spawn.subcommands.SpawnSendSub;
import com.azortis.serverutilities.bukkit.modules.spawn.subcommands.SpawnSetSub;
import com.azortis.serverutilities.bukkit.settings.common.CommandSettings;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class SpawnCommand implements ICommandExecutor {

    private final ServerUtilities plugin;
    private final SpawnModule spawnModule;
    private SpawnSetSub spawnSetSub;
    private SpawnDeleteSub spawnDeleteSub;
    private SpawnSendSub spawnSendSub;

    SpawnCommand(ServerUtilities plugin, SpawnModule spawnModule){
        this.plugin = plugin;
        this.spawnModule = spawnModule;
        CommandSettings commandSettings = plugin.getSettingsManager().getSettings().getSpawnSettings().getCommandSettings();
        if(commandSettings.isEnabled()){
            spawnSetSub = new SpawnSetSub(plugin, spawnModule);
            spawnDeleteSub = new SpawnDeleteSub(plugin, spawnModule);
            spawnSendSub = new SpawnSendSub(plugin, spawnModule);
            Command command = new CommandBuilder()
                    .setName(commandSettings.getName())
                    .setDescription(commandSettings.getDescription())
                    .setUsage(commandSettings.getUsage())
                    .addAliases(commandSettings.getAliases())
                    .setPermission(PermissionManager.Permission.SPAWN.getPermissionNode())
                    .addSubCommand(new SubCommandBuilder().setName("set").setExecutor(spawnSetSub))
                    .addSubCommand(new SubCommandBuilder().setName("delete").setExecutor(spawnDeleteSub))
                    .addSubCommand(new SubCommandBuilder().setName("send").setExecutor(spawnSendSub))
                    .setPlugin(plugin)
                    .setExecutor(this)
                    .setTabCompleter(new SpawnTabCompleter(plugin,spawnModule)).build();
            CommandInjector.injectCommand("serverutilities", command, false);
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        SpawnSettings spawnSettings = plugin.getSettingsManager().getSettings().getSpawnSettings();
        if(commandSender instanceof ConsoleCommandSender){
            if(command.getAlias(label) != null){
                commandSender.sendMessage("Invalid usage! " + command.getName() + " <player> [spawnName]");
                return true;
            }
            if(args.length > 0 && args.length < 3) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    commandSender.sendMessage("Invalid target!");
                    return true;
                }
                String name = "";
                if(args.length == 2){
                    name = args[1];
                }
                ArrayList<SpawnLocation> spawnLocations = spawnModule.getSpawnLocations().getLocations();
                if(spawnLocations.isEmpty()){
                    commandSender.sendMessage("No spawn set!");
                    return true;
                }
                SpawnLocation spawnLocation = null;
                int highestWeight = 1;
                for (SpawnLocation spawnLocation1 : spawnLocations){
                    if(!name.equals("")){
                        if(spawnLocation1.getName().equals(name))spawnLocation = spawnLocation1;
                        break;
                    }
                    if(plugin.getPermissionManager().hasPermissionForSpawn(player, spawnLocation1.getName())){
                        if(highestWeight < spawnLocation1.getWeight()){
                            spawnLocation = spawnLocation1;
                            highestWeight = spawnLocation1.getWeight();
                        }
                    } else if(spawnLocation1.isDefault() && highestWeight == 1)spawnLocation = spawnLocation1;
                }
                if(spawnLocation == null){
                    if(args.length == 2){
                        commandSender.sendMessage("Invalid spawn name!");
                        return true;
                    }
                    commandSender.sendMessage("No default spawn set!");
                    return true;
                }
                player.teleport(spawnLocation.getLocation());
                HashMap<String, String> commandPlaceholders = new HashMap<>();
                commandPlaceholders.put("spawnName", spawnLocation.getName());
                plugin.sendPlayerMessage(player, player, "teleportedToSpawnByOther", commandPlaceholders);
            }else {
                commandSender.sendMessage("Invalid usage! " + command.getName() + " <player> [spawnName]");
            }
            return true;
        } else if(commandSender instanceof Player){
            Player player = (Player)commandSender;
            Alias alias = command.getAlias(label);
            if(alias != null){
                assert command.getSubCommands() != null;
                for (SubCommand subCommand : command.getSubCommands()){
                    if(alias.getFunction().equals(subCommand.getName())){
                        return subCommand.execute(commandSender, label, args);
                    }
                }
            }
            if(plugin.getPermissionManager().hasPermission(player, PermissionManager.Permission.SPAWN)){
                if(args.length == 0){
                    SpawnLocation spawnLocation;
                    int highestWeight = 1;
                    if(spawnModule.getSpawnLocations().getLocations().isEmpty()){
                        plugin.sendPlayerMessage(player, player, "noSpawnSet", null);
                        return true;
                    }
                    for (SpawnLocation spawnLocation1 : spawnModule.getSpawnLocations().getLocations()){
                        if(plugin.getPermissionManager().hasPermissionForSpawn(player, spawnLocation1.getName())){
                            if(spawnLocation1.getWeight() > highestWeight){
                                spawnLocation = spawnLocation1;
                                highestWeight = spawnLocation1.getWeight();
                            }
                        } else if(spawnLocation1.isDefault() && highestWeight == 1)spawnLocation = spawnLocation1;
                    }

                }
            }else {
                plugin.sendPlayerMessage(player, player, "noPermission", null);
                return true;
            }
        } else {
            commandSender.sendMessage("Command sender must be a player!");
        }
        return false;
    }
}
