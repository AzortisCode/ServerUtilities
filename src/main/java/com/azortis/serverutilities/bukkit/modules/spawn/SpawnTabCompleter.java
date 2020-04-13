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

import com.azortis.azortislib.command.Command;
import com.azortis.azortislib.command.executors.ITabCompleter;
import com.azortis.serverutilities.bukkit.ServerUtilities;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SpawnTabCompleter implements ITabCompleter {

    private ServerUtilities plugin;
    private SpawnModule spawnModule;

    public SpawnTabCompleter(ServerUtilities plugin, SpawnModule spawnModule) {
        this.plugin = plugin;
        this.spawnModule = spawnModule;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings, Location location) {
        return null;
    }
}
