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

package com.azortis.serverutilities.bukkit.settings.wrappers;

import com.azortis.serverutilities.bukkit.settings.SettingsManager;
import com.azortis.serverutilities.bukkit.settings.SettingsWrapper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.List;

@SuppressWarnings("all")
public class SpawnSettings extends SettingsWrapper {

    private CommandSettings commandSettings;

    public SpawnSettings(SettingsManager parent, Object settingsMap){
        super(parent, settingsMap, "spawnSettings");
        commandSettings = new CommandSettings(getSection("commandSettings"));
    }

    public boolean isEnabled(){
        return getBoolean("enabled", null);
    }

    public void setEnabled(boolean enabled){
        setBoolean("enabled", enabled, null);
    }

    public Location getLocation(){
        SettingsSection locationSection = getSection("location");
        World world = Bukkit.getWorld(getString("world", locationSection));
        double x = getDouble("x", locationSection);
        double y = getDouble("y", locationSection);
        double z = getDouble("z", locationSection);
        float yaw = getFloat("yaw", locationSection);
        float pitch = getFloat("pitch", locationSection);
        return new Location(world, x, y, z, yaw, pitch);
    }

    public void setLocation(Location location){
        SettingsSection locationSettings = getSection("location");
        setString("world", location.getWorld().getName(), locationSettings);
        setDouble("x", location.getX(), locationSettings);
        setDouble("y", location.getY(), locationSettings);
        setDouble("z", location.getZ(), locationSettings);
        setFloat("yaw", location.getYaw(), locationSettings);
        setFloat("pitch", location.getPitch(), locationSettings);
    }

    public boolean isSpawnSet(){
        return !getString("world", getSection("location")).equals("");
    }

    public boolean getSpawnTeleportOnFirstJoin(){
        return getBoolean("firstJoin", getSection("spawnTeleport"));
    }

    public void setSpawnTeleportOnFirstJoin(boolean spawnTeleportOnFirstJoin){
        setBoolean("firstJoin", spawnTeleportOnFirstJoin, getSection("spawnTeleport"));
    }

    public boolean getSpawnTeleportOnJoin(){
        return getBoolean("join", getSection("spawnTeleport"));
    }

    public void setSpawnTeleportOnJoin(boolean spawnTeleportOnJoin){
        setBoolean("join", spawnTeleportOnJoin, getSection("spawnTeleport"));
    }

    public boolean getSpawnTeleportOnRespawn(){
        return getBoolean("respawn", getSection("spawnTeleport"));
    }

    public void setSpawnTeleportOnRespawn(boolean spawnTeleportOnRespawn){
        setBoolean("join", spawnTeleportOnRespawn, getSection("spawnTeleport"));
    }

    public boolean getSpawnTeleportOnBelowY(){
        return getBoolean("enabled", getSection("spawnTeleport").getSubSection("below-y"));
    }

    public void setSpawnTeleportOnBelowY(boolean spawnTeleportOnBelowY){
        setBoolean("enabled", spawnTeleportOnBelowY, getSection("spawnTeleport").getSubSection("below-y"));
    }

    public double getBelowY(){
        return getDouble("y-value", getSection("spawnTeleport").getSubSection("below-y"));
    }

    public void setBelowY(double belowY){
        setDouble("y-value", belowY, getSection("spawnTeleport").getSubSection("below-y"));
    }

    public CommandSettings getCommandSettings(){
        return commandSettings;
    }

    public class CommandSettings {

        private SettingsSection commandSection;

        CommandSettings(SettingsSection commandSection){
            this.commandSection = commandSection;
        }

        public boolean isEnabled(){
            return getBoolean("enabled", commandSection);
        }

        public void setEnabled(boolean enabled){
            setBoolean("enabled", enabled, commandSection);
        }

        public String getName(){
            return getString("name", commandSection);
        }

        public void setName(String name){
            setString("name", name, commandSection);
        }

        public String getDescription(){
            return getString("description", commandSection);
        }

        public void setDescription(String description){
            setString("description", description, commandSection);
        }

        public String getUsage(){
            return getString("usage", commandSection);
        }

        public void setUsage(String usage){
            setString("usage", usage, commandSection);
        }

        public List<String> getAliases() {
            return getStringList("aliases", commandSection);
        }

        public void setAliases(List<String> aliases) {
            setStringList("aliases", aliases, commandSection);
        }

    }
}
