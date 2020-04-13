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

import java.util.ArrayList;

public class SpawnTimeoutSettings {

    private boolean cancelTimeoutOnDamage;
    private boolean cancelTimeoutOnMove;
    private boolean applyOthersTimeoutOnSendOther;
    private ArrayList<SpawnTimeout> timeouts;

    public boolean getCancelTimeoutOnDamage() {
        return cancelTimeoutOnDamage;
    }

    public void setCancelTimeoutOnDamage(boolean cancelTimeoutOnDamage) {
        this.cancelTimeoutOnDamage = cancelTimeoutOnDamage;
    }

    public boolean getCancelTimeoutOnMove() {
        return cancelTimeoutOnMove;
    }

    public void setCancelTimeoutOnMove(boolean cancelTimeoutOnMove) {
        this.cancelTimeoutOnMove = cancelTimeoutOnMove;
    }

    public boolean getApplyOthersTimeoutOnSendOther() {
        return applyOthersTimeoutOnSendOther;
    }

    public void setApplyOthersTimeoutOnSendOther(boolean applyOthersTimeoutOnSendOther) {
        this.applyOthersTimeoutOnSendOther = applyOthersTimeoutOnSendOther;
    }

    public ArrayList<SpawnTimeout> getTimeouts() {
        return timeouts;
    }

    public void setTimeouts(ArrayList<SpawnTimeout> timeouts) {
        this.timeouts = timeouts;
    }

}
