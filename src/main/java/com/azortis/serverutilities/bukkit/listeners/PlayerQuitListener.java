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

package com.azortis.serverutilities.bukkit.listeners;

import com.azortis.serverutilities.bukkit.ServerUtilities;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private ServerUtilities plugin;

    public PlayerQuitListener(ServerUtilities plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        if(!plugin.getSettingsManager().getMessageSettings().getDisableQuitMessage()){
            if(plugin.getSettingsManager().getMessageSettings().getUseCustomQuitMessage()){
                event.setQuitMessage("");
                for (Player player : Bukkit.getOnlinePlayers()){
                    plugin.sendPlayerMessage(player, event.getPlayer(), "customQuitMessage");
                }
            }
        }else {
            event.setQuitMessage("");
        }
    }

}
