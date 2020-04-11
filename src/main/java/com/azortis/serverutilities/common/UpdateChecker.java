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

package com.azortis.serverutilities.common;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateChecker {

    private PluginVersion spigotVersion;
    private boolean updateAvailable;
    private boolean unreleased;
    private boolean failed = false;

    public UpdateChecker(PluginVersion currentVersion){
        try {
            HttpsURLConnection connection = (HttpsURLConnection) new URL(
                    "https://api.spigotmc.org/legacy/update.php?resource=77011").openConnection();
            connection.setRequestMethod("GET");
            spigotVersion = PluginVersion.getVersionFromString(new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine());
        } catch (Exception ex) {
            failed = true;
        }
        if (spigotVersion == null) {
            failed = true;
            return;
        }
        if (currentVersion.isSame(spigotVersion)) return;
        this.updateAvailable = spigotVersion.isNewerThen(currentVersion);
        this.unreleased = currentVersion.isNewerThen(spigotVersion);
    }

    public PluginVersion getSpigotVersion() {
        return spigotVersion;
    }

    public boolean isUpdateAvailable() {
        return updateAvailable;
    }

    public boolean isUnreleased() {
        return unreleased;
    }

    public boolean hasFailed() {
        return failed;
    }
}
