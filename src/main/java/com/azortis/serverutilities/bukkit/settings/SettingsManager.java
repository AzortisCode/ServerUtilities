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

package com.azortis.serverutilities.bukkit.settings;

import com.azortis.serverutilities.bukkit.ServerUtilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@SuppressWarnings("all")
public class SettingsManager {

    private Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private File settingsFile;
    private File messageFile;
    private Settings settings;
    private Messages messages;

    public SettingsManager(ServerUtilities plugin) {
        plugin.getLogger().info("Loading settings...");
        if (plugin.getDataFolder().exists()) plugin.getDataFolder().mkdir();
        settingsFile = new File(plugin.getDataFolder(), "settings.json");
        messageFile = new File(plugin.getDataFolder(), "messages.json");
        if (!settingsFile.exists()){
            plugin.getLogger().info("Creating new settings file...");
            plugin.saveResource(settingsFile.getName(), false);
        }
        if (!messageFile.exists()){
            plugin.getLogger().info("Creating new message file...");
            plugin.saveResource(messageFile.getName(), false);
        }
        try {
            settings = gson.fromJson(new FileReader(settingsFile), Settings.class);
            messages = gson.fromJson(new FileReader(messageFile), Messages.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Settings getSettings() {
        return settings;
    }

    public File getSettingsFile() {
        return settingsFile;
    }

    public void saveSettings() {
        try{
            final String json = gson.toJson(settings);
            settingsFile.delete();
            Files.write(settingsFile.toPath(), json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void reloadSettingsFile() {
        try {
            settings = gson.fromJson(new FileReader(settingsFile), Settings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Messages getMessages() {
        return messages;
    }

    public File getMessageFile() {
        return messageFile;
    }

    public void saveMessageFile() {
        try {
            final String json = gson.toJson(messages);
            messageFile.delete();
            Files.write(messageFile.toPath(), json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadMessageFile() {
        try {
            messages = gson.fromJson(new FileReader(messageFile), Messages.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}