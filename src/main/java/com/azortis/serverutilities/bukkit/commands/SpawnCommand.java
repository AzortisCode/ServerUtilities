/*
 * A handy set of utilities for your Minecraft servers
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

package com.azortis.serverutilities.bukkit.commands;

import com.azortis.azortislib.command.Command;
import com.azortis.azortislib.command.CommandInjector;
import com.azortis.azortislib.command.builders.CommandBuilder;
import com.azortis.azortislib.command.executors.ICommandExecutor;
import com.azortis.serverutilities.bukkit.ServerUtilities;
import com.azortis.serverutilities.bukkit.PermissionManager;
import com.azortis.serverutilities.bukkit.settings.modules.CommandSettings;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements ICommandExecutor{

    private ServerUtilities plugin;

    public SpawnCommand(ServerUtilities plugin){
        this.plugin = plugin;
        CommandSettings commandSettings = plugin.getSettingsManager().getSettings().getSpawnSettings().getCommandSettings();
        if(commandSettings.isEnabled()) {
            Command command = new CommandBuilder()
                    .setName(commandSettings.getName())
                    .setDescription(commandSettings.getDescription())
                    .setUsage(commandSettings.getUsage())
                    .addAliases(commandSettings.getAliases())
                    .setPermission(PermissionManager.Permission.SPAWN.getPermissionNode())
                    .setPlugin(plugin)
                    .setExecutor(this).build();
            CommandInjector.injectCommand("serverutilities", command, false);
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if((commandSender instanceof Player)){
            Player player = (Player)commandSender;
            if(command.getAlias(label) != null && command.getAlias(label).getFunction().equals("set")){
                if (plugin.getPermissionManager().hasPermission(player, PermissionManager.Permission.SPAWN_SET)) {
                    setSpawn(player);
                    return true;
                } else {
                    plugin.sendPlayerMessage(player, player, "noPermission");
                    return false;
                }
            }
            if(args.length == 0){
                if(plugin.getPermissionManager().hasPermission(player, PermissionManager.Permission.SPAWN)){
                    if(plugin.getSettingsManager().getSettings().getSpawnSettings().isSpawnSet()) {
                        player.teleport(plugin.getSettingsManager().getSettings().getSpawnSettings().getSpawnLocation());
                        plugin.sendPlayerMessage(player, player, "teleportedToSpawn");
                        return true;
                    }else{
                        plugin.sendPlayerMessage(player, player, "spawnNotSet");
                        return false;
                    }
                }
            }else if(args.length == 1) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (plugin.getPermissionManager().hasPermission(player, PermissionManager.Permission.SPAWN_SET)) {
                        setSpawn(player);
                        return true;
                    } else {
                        plugin.sendPlayerMessage(player, player, "noPermission");
                        return false;
                    }
                }
            }else {
                plugin.sendPlayerMessage(player, player, "invalidUsage");
                return false;
            }
        }
        commandSender.sendMessage(ChatColor.RED + "Sender must be a player!");
        return false;
    }

    private void setSpawn(Player player){
        Location location = player.getLocation();
        plugin.getSettingsManager().getSettings().getSpawnSettings().setSpawnLocation(location);
        plugin.getSettingsManager().saveSettings();
        plugin.getSettingsManager().reloadSettingsFile();
        plugin.sendPlayerMessage(player, player, "spawnSet");
    }

}
