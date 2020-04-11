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

package com.azortis.serverutilities.bukkit;

import com.azortis.serverutilities.bukkit.commands.MainCommand;
import com.azortis.serverutilities.bukkit.commands.SpawnCommand;
import com.azortis.serverutilities.bukkit.listeners.PlayerJoinListener;
import com.azortis.serverutilities.bukkit.listeners.PlayerMoveListener;
import com.azortis.serverutilities.bukkit.listeners.PlayerQuitListener;
import com.azortis.serverutilities.bukkit.listeners.PlayerRespawnListener;
import com.azortis.serverutilities.bukkit.settings.SettingsManager;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerUtilities extends JavaPlugin {

    private Metrics metrics;
    private PermissionManager permissionManager;
    private SettingsManager settingsManager;

    @Override
    public void onEnable(){
        if (!Bukkit.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            this.getLogger().severe("PlaceholderAPI isn't present, please install PlaceholderAPI! Shutting down...");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.metrics = new Metrics(this, 7085);
        this.settingsManager = new SettingsManager(this);
        this.permissionManager = new PermissionManager();

        new MainCommand(this);
        new SpawnCommand(this);
        new PlayerJoinListener(this);
        new PlayerQuitListener(this);
        new PlayerMoveListener(this);
        new PlayerRespawnListener(this);
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }

    public PermissionManager getPermissionManager() {
        return permissionManager;
    }

    public void sendPlayerMessage(Player receiver, Player placeholderPlayer, String messagePath){
        String rawMessage = settingsManager.getMessageSettings().getMessage(messagePath);
        String message = PlaceholderAPI.setPlaceholders(placeholderPlayer, rawMessage);
        if(message.startsWith("[JSON]") && Bukkit.getServer().getPluginManager().isPluginEnabled("ProtocolLib")){
            String jsonString = message.replaceFirst("[JSON]", "").trim();
            BaseComponent[] baseComponents = ComponentSerializer.parse(jsonString);
            receiver.spigot().sendMessage(baseComponents);
        }
        receiver.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
