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

public class SpawnTeleportSettings {

    private boolean onFirstJoin; // Will override onJoin
    private boolean onJoin;
    private boolean onRespawn;
    private boolean onRespawnOverrideHomes;
    private boolean onRespawnOverrideSpawnPoint;
    private boolean onBelowY;
    private int onBelowYValue;

    public SpawnTeleportSettings() {
        this.onFirstJoin = false;
        this.onJoin = false;
        this.onRespawn = false;
        this.onRespawnOverrideHomes = false;
        this.onRespawnOverrideSpawnPoint = false;
        this.onBelowY = false;
        this.onBelowYValue = 0;
    }

    public boolean getOnFirstJoin() {
        return onFirstJoin;
    }

    public void setOnFirstJoin(boolean onFirstJoin) {
        this.onFirstJoin = onFirstJoin;
    }

    public boolean getOnJoin() {
        return onJoin;
    }

    public void setOnJoin(boolean onJoin) {
        this.onJoin = onJoin;
    }

    public boolean getOnRespawn() {
        return onRespawn;
    }

    public void setOnRespawn(boolean onRespawn) {
        this.onRespawn = onRespawn;
    }

    public boolean getOnRespawnOverrideHomes() {
        return onRespawnOverrideHomes;
    }

    public void setOnRespawnOverrideHomes(boolean onRespawnOverrideHomes) {
        this.onRespawnOverrideHomes = onRespawnOverrideHomes;
    }

    public boolean getOnRespawnOverrideSpawnPoint() {
        return onRespawnOverrideSpawnPoint;
    }

    public void setOnRespawnOverrideSpawnPoint(boolean onRespawnOverrideSpawnPoint) {
        this.onRespawnOverrideSpawnPoint = onRespawnOverrideSpawnPoint;
    }

    public boolean getOnBelowY() {
        return onBelowY;
    }

    public void setOnBelowY(boolean onBelowY) {
        this.onBelowY = onBelowY;
    }

    public int getOnBelowYValue() {
        return onBelowYValue;
    }

    public void setOnBelowYValue(int onBelowYValue) {
        this.onBelowYValue = onBelowYValue;
    }
}
