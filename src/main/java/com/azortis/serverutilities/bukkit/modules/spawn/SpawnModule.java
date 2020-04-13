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

import com.azortis.serverutilities.bukkit.Module;
import com.azortis.serverutilities.bukkit.ServerUtilities;
import com.azortis.serverutilities.bukkit.modules.spawn.settings.SpawnLocations;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SpawnModule implements Module {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private final ServerUtilities plugin;
    private final File spawnLocationsFile;
    private SpawnLocations spawnLocations;

    public SpawnModule(ServerUtilities plugin){
        this.plugin = plugin;
        plugin.getLogger().info("Loading spawnLocations...");
        spawnLocationsFile = new File(plugin.getDataFolder(), "spawnLocations");
        if(!spawnLocationsFile.exists()){
            plugin.getLogger().info("spawnLocations.json doesn't exist, creating one...");
            plugin.saveResource("spawnLocations.json", false);
        }
        try{
            spawnLocations = gson.fromJson(new FileReader(spawnLocationsFile), SpawnLocations.class);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        new SpawnListener(plugin, this);
        new SpawnCommand(plugin, this);
    }

    public SpawnLocations getSpawnLocations() {
        return spawnLocations;
    }

    @Override
    public String getName() {
        return "Spawn";
    }

    @Override
    public boolean enabled() {
        return plugin.getSettingsManager().getSettings().getSpawnSettings().isEnabled();
    }

    @Override
    public void reload() {
        try{
            spawnLocations = gson.fromJson(new FileReader(spawnLocationsFile), SpawnLocations.class);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
