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

package com.azortis.serverutilities.bukkit.settings;

import com.azortis.serverutilities.bukkit.settings.modules.CommandSettings;
import com.azortis.serverutilities.bukkit.settings.modules.MessageSettings;
import com.azortis.serverutilities.bukkit.settings.modules.spawn.SpawnSettings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class Settings implements Serializable {

    private final transient Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private SpawnSettings spawnSettings;
    private MessageSettings messageSettings;
    private CommandSettings commandSettings;
    private String fileVersion;

    public SpawnSettings getSpawnSettings() {
        return spawnSettings;
    }

    public CommandSettings getCommandSettings() {
        return commandSettings;
    }

    public MessageSettings getMessageSettings() {
        return messageSettings;
    }

    public String getFileVersion() {
        return fileVersion;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

}
