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

package com.azortis.serverutilities.bungee.settings;

import com.azortis.azortislib.utils.FileUtils;
import com.azortis.serverutilities.bungee.ServerUtilitiesProxy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@SuppressWarnings("all")
public class SettingsManager {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private ProxySettings proxySettings;
    private final File proxySettingsFile;

    public SettingsManager(ServerUtilitiesProxy plugin){
        if(!plugin.getDataFolder().exists())plugin.getDataFolder().mkdir();
        proxySettingsFile = new File(plugin.getDataFolder(), "proxySettings.json");
        if(!proxySettingsFile.exists()) FileUtils.copy(plugin.getResourceAsStream("proxySettings.json"), proxySettingsFile);
        try {
            proxySettings = gson.fromJson(new FileReader(proxySettingsFile), ProxySettings.class);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        if(!plugin.getPluginVersion().getProxySettingsFileVersion().equals(proxySettings.getFileVersion())){
            plugin.getLogger().severe("You're settingsfile is out of date! Please update otherwise it will break!");
        }
    }

    public ProxySettings getProxySettings() {
        return proxySettings;
    }

    public File getProxySettingsFile() {
        return proxySettingsFile;
    }

    public void saveProxySettings(){
        try{
            final String json = gson.toJson(proxySettings);
            proxySettingsFile.delete();
            Files.write(proxySettingsFile.toPath(), json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void reloadProxySettings(){
        try{
            proxySettings = gson.fromJson(new FileReader(proxySettingsFile), ProxySettings.class);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

}