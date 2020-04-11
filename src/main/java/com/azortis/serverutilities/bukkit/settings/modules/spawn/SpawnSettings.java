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

package com.azortis.serverutilities.bukkit.settings.modules.spawn;

import com.azortis.serverutilities.bukkit.settings.modules.CommandSettings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class SpawnSettings {

    private boolean enabled;
    private SpawnLocation location;
    private SpawnTeleportSettings spawnTeleportSettings;
    private CommandSettings commandSettings;

    public boolean isSpawnSet(){
        return !location.world.equals("");
    }

    public Location getSpawnLocation(){
        return location.getLocation();
    }

    public void setSpawnLocation(Location location){
        this.location.setLocation(location);
    }

    public SpawnTeleportSettings getSpawnTeleportSettings() {
        return spawnTeleportSettings;
    }

    public CommandSettings getCommandSettings() {
        return commandSettings;
    }

    private static class SpawnLocation {

        private String world;
        private double x;
        private double y;
        private double z;
        private float yaw;
        private float pitch;

        private Location getLocation(){
            return new Location(Bukkit.getWorld(world), x, y ,z ,yaw ,pitch);
        }

        private void setLocation(@NotNull Location location){
            world = location.getWorld().getName();
            x = location.getX();
            y = location.getY();
            z = location.getZ();
            yaw = location.getYaw();
            pitch = location.getPitch();
        }

    }

}
