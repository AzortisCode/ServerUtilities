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

    private boolean firstJoin;
    private boolean join;
    private boolean respawn;
    private BelowY belowY;

    public boolean isFirstJoin() {
        return firstJoin;
    }

    public void setFirstJoin(boolean firstJoin) {
        this.firstJoin = firstJoin;
    }

    public boolean isJoin() {
        return join;
    }

    public void setJoin(boolean join) {
        this.join = join;
    }

    public boolean isRespawn() {
        return respawn;
    }

    public void setRespawn(boolean respawn) {
        this.respawn = respawn;
    }

    public boolean isBelowY(){
        return belowY.isEnabled();
    }

    public void setBelowY(boolean belowY){
        this.belowY.setEnabled(belowY);
    }

    public int getBelowYValue(){
        return belowY.getYValue();
    }

    public void setBelowYValue(int belowYLevel){
        belowY.setYValue(belowYLevel);
    }

    private static class BelowY{

        private boolean enabled;
        private int yValue;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public int getYValue() {
            return yValue;
        }

        public void setYValue(int yLevel) {
            yValue = yLevel;
        }
    }

}
