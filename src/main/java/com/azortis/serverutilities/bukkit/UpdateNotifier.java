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

package com.azortis.serverutilities.bukkit;

import com.azortis.serverutilities.common.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UpdateNotifier implements Listener {

    private final ServerUtilities plugin;
    private final UpdateChecker updateChecker;

    public UpdateNotifier(ServerUtilities plugin, UpdateChecker updateChecker){
        this.plugin = plugin;
        this.updateChecker = updateChecker;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(plugin.getPermissionManager().hasPermission(event.getPlayer(), PermissionManager.Permission.ADMIN)){
            Player player = event.getPlayer();
            if(updateChecker.isUnreleased()){
                player.sendMessage(ChatColor.RED + "[ServerUtilities] You're using an unreleased version(v" + plugin.getPluginVersion().getVersionString() + "). Please proceed with caution.");
            } else if(updateChecker.isUpdateAvailable()){
                player.sendMessage(ChatColor.GREEN + "[ServerUtilities] A new update is available(v" + updateChecker.getSpigotVersion().getVersionString() + ")");
                player.sendMessage(ChatColor.GREEN + "You can download it here: You can download it here: https://www.spigotmc.org/resources/77011/");
            }
        }
    }

}
