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
import com.azortis.serverutilities.bungee.settings.modules.ServerSwitchCommandSettings;
import com.azortis.serverutilities.bungee.settings.SettingsManager;
import com.azortis.serverutilities.common.PluginVersion;
import com.azortis.serverutilities.common.UpdateChecker;
import net.md_5.bungee.api.plugin.Plugin;

public final class ServerUtilitiesProxy extends Plugin {

    private PluginVersion pluginVersion;
    private Metrics metrics;
    private SettingsManager settingsManager;

    @Override
    public void onEnable() {
        this.pluginVersion = PluginVersion.getVersionFromString(getDescription().getVersion());
        UpdateChecker updateChecker = new UpdateChecker(pluginVersion);
        if(updateChecker.hasFailed()){
            getLogger().severe("Failed to check for updates!");
        } else if(updateChecker.isUpdateAvailable()){
            getLogger().info("A new version(v" + updateChecker.getSpigotVersion().getVersionString() + ") is available on spigot!");
            getLogger().info("You can download it here: https://www.spigotmc.org/resources/77011/");
        } else if(updateChecker.isUnreleased()){
            getLogger().warning("You're using an unreleased version(v" + pluginVersion.getVersionString() + "). Please proceed with caution.");
        }
        this.metrics = new Metrics(this, 7085);
        this.settingsManager = new SettingsManager(this);
        if(settingsManager.getProxySettings().getServerCommandSettings().isEnabled()){
            for (ServerSwitchCommandSettings.Command serverSwitchCommand : settingsManager.getProxySettings().getServerCommandSettings().getCommands()){
                getProxy().getPluginManager().registerCommand(this, new ServerSwitchCommand(serverSwitchCommand));
            }
        }
    }

    public PluginVersion getPluginVersion() {
        return pluginVersion;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }
}