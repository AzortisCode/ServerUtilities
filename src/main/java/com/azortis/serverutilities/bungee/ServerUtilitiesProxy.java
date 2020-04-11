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

package com.azortis.serverutilities.bungee;

import com.azortis.serverutilities.bungee.commands.ServerSwitchCommand;
import com.azortis.serverutilities.bungee.settings.SettingsManager;
import com.azortis.serverutilities.bungee.settings.servercommands.ServerCommand;
import net.md_5.bungee.api.plugin.Plugin;

public final class ServerUtilitiesProxy extends Plugin {

    private Metrics metrics;
    private SettingsManager settingsManager;

    @Override
    public void onEnable() {
        this.metrics = new Metrics(this, 7085);
        this.settingsManager = new SettingsManager(this);
        if(settingsManager.getProxySettings().getServerCommandSettings().isEnabled()){
            for (ServerCommand serverCommand : settingsManager.getProxySettings().getServerCommandSettings().getCommands()){
                getProxy().getPluginManager().registerCommand(this, new ServerSwitchCommand(serverCommand));
            }
        }
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }
}