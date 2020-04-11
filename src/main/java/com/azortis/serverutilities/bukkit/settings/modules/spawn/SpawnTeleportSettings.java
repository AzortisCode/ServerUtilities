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

public class SpawnTeleportSettings {

    private boolean onFirstJoin;
    private boolean onJoin;
    private boolean onRespawn;
    private BelowY onBelowY;

    public boolean isOnFirstJoin() {
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

    public boolean getOnBelowY(){
        return onBelowY.isEnabled();
    }

    public void setOnBelowY(boolean onBelowY){
        this.onBelowY.setEnabled(onBelowY);
    }

    public int getBelowYValue(){
        return onBelowY.getYValue();
    }

    public void setBelowYValue(int belowYLevel){
        onBelowY.setYValue(belowYLevel);
    }

    private static class BelowY{

        private boolean enabled;
        private int y;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public int getYValue() {
            return y;
        }

        public void setYValue(int yValue) {
            y = yValue;
        }
    }

}
