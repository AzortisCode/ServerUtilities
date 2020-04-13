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

package com.azortis.serverutilities.bukkit.modules.spawn.subcommands;

import com.azortis.azortislib.command.SubCommand;
import com.azortis.azortislib.command.executors.ISubCommandExecutor;
import com.azortis.serverutilities.bukkit.ServerUtilities;
import com.azortis.serverutilities.bukkit.modules.spawn.SpawnModule;
import org.bukkit.command.CommandSender;

public class SpawnDeleteSub implements ISubCommandExecutor {

    private final ServerUtilities plugin;
    private final SpawnModule spawnModule;

    public SpawnDeleteSub(ServerUtilities plugin, SpawnModule spawnModule) {
        this.plugin = plugin;
        this.spawnModule = spawnModule;
    }

    @Override
    public boolean onSubCommand(CommandSender commandSender, SubCommand subCommand, String s, String[] strings) {
        return false;
    }
}
