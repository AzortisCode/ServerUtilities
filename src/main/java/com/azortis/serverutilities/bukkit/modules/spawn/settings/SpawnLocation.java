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

package com.azortis.serverutilities.bukkit.modules.spawn.settings;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Objects;

public class SpawnLocation {

    private String name;
    private String permission;
    private int weight;
    private boolean isDefault,isFirstJoinOnly;
    private String worldName;
    private double x,y,z;
    private float yaw,pitch;
    private SpawnTeleportSettings teleportSettings;

    public SpawnLocation(String name, String permission, int weight, boolean isDefault, boolean isFirstJoinOnly, Location location) {
        this.name = name;
        this.permission = permission;
        this.weight = weight;
        this.isDefault = isDefault;
        this.isFirstJoinOnly = isFirstJoinOnly;
        this.worldName = Objects.requireNonNull(location.getWorld()).getName();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
        this.teleportSettings = new SpawnTeleportSettings();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isFirstJoinOnly() {
        return isFirstJoinOnly;
    }

    public void setFirstJoinOnly(boolean firstJoinOnly) {
        isFirstJoinOnly = firstJoinOnly;
    }

    public Location getLocation(){
        return new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);
    }

    public void setLocation(Location location){
        worldName = Objects.requireNonNull(location.getWorld()).getName();
        x = location.getX();
        y = location.getY();
        z = location.getZ();
        yaw = location.getYaw();
        pitch = location.getPitch();
    }

    public SpawnTeleportSettings getTeleportSettings() {
        return teleportSettings;
    }

}
