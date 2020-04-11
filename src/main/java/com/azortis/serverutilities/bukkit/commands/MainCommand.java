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
import com.azortis.serverutilities.bukkit.settings.wrappers.CommandSettings;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements ICommandExecutor {

    private ServerUtilities plugin;

    public MainCommand(ServerUtilities plugin){
        this.plugin = plugin;
        CommandSettings commandSettings = plugin.getSettingsManager().getCommandSettings();
        if(commandSettings.getEnabled()) {
            Command command = new CommandBuilder()
                    .setName(commandSettings.getName())
                    .setDescription(commandSettings.getDescription())
                    .setUsage(commandSettings.getUsage())
                    .addAliases(commandSettings.getAliases())
                    .setPermission(PermissionManager.Permission.ADMIN.getPermissionNode())
                    .setPlugin(plugin)
                    .setExecutor(this).build();
            CommandInjector.injectCommand("serverutilities", command, false);
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(commandSender instanceof Player){
            Player player = (Player)commandSender;
            if(plugin.getPermissionManager().hasPermission(player, PermissionManager.Permission.ADMIN)){
                if(args.length == 0){
                    player.sendMessage(ChatColor.RED + "ServerUtilities " + ChatColor.GRAY + "made by " + ChatColor.RED + "Azortis");
                    return true;
                }else if(args.length == 1 && args[0].equals("reload")){
                    plugin.getSettingsManager().reloadSettingsFile();
                    plugin.getSettingsManager().reloadMessageFile();
                    plugin.sendPlayerMessage(player, player, "pluginReloaded");
                    return true;
                }else {
                    plugin.sendPlayerMessage(player, player, "invalidUsage");
                    return false;
                }
            }else{
                plugin.sendPlayerMessage(player, player, "noPermission");
                return false;
            }
        }
        commandSender.sendMessage(ChatColor.RED + "Sender must be a player!");
        return false;
    }
}
