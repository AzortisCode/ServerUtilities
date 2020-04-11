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

package com.azortis.serverutilities.bungee.settings;

import com.azortis.serverutilities.bungee.settings.modules.ServerSwitchCommandSettings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class ProxySettings implements Serializable {

    private final transient Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private ServerSwitchCommandSettings serverSwitchCommandSettings;
    private String fileVersion;

    public ServerSwitchCommandSettings getServerCommandSettings() {
        return serverSwitchCommandSettings;
    }

    public String getFileVersion() {
        return fileVersion;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}