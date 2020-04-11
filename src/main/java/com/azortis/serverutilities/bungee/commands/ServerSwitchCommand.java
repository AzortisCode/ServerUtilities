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

package com.azortis.serverutilities.bungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerSwitchCommand extends Command {

    private final String serverName;

    public ServerSwitchCommand(com.azortis.serverutilities.bungee.settings.serverswitchcommands.ServerSwitchCommand serverSwitchCommand) {
        super(serverSwitchCommand.getName(), serverSwitchCommand.getPermission(), String.valueOf(serverSwitchCommand.getAliases()));
        this.serverName = serverSwitchCommand.getServer();
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(commandSender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer)commandSender;
            ServerInfo target = ProxyServer.getInstance().getServerInfo(serverName);
            player.connect(target);
        }
    }
}
