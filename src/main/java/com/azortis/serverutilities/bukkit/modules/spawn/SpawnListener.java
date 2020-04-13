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

import com.azortis.serverutilities.bukkit.ServerUtilities;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {

    private ServerUtilities plugin;
    private SpawnModule spawnModule;

    SpawnListener(ServerUtilities plugin, SpawnModule spawnModule){
        this.plugin = plugin;
        this.spawnModule = spawnModule;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){

    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event){

    }

}
