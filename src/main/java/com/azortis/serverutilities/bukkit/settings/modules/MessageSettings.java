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

package com.azortis.serverutilities.bukkit.settings.modules;

public class MessageSettings {

    private boolean disableJoinMessage;
    private boolean useCustomJoinMessage;
    private boolean disableQuitMessage;
    private boolean useCustomQuitMessage;

    public boolean getDisableJoinMessage() {
        return disableJoinMessage;
    }

    public void setDisableJoinMessage(boolean disableJoinMessage) {
        this.disableJoinMessage = disableJoinMessage;
    }

    public boolean isUseCustomJoinMessage() {
        return useCustomJoinMessage;
    }

    public void setUseCustomJoinMessage(boolean useCustomJoinMessage) {
        this.useCustomJoinMessage = useCustomJoinMessage;
    }

    public boolean getDisableQuitMessage() {
        return disableQuitMessage;
    }

    public void setDisableQuitMessage(boolean disableQuitMessage) {
        this.disableQuitMessage = disableQuitMessage;
    }

    public boolean getUseCustomQuitMessage() {
        return useCustomQuitMessage;
    }

    public void setUseCustomQuitMessage(boolean useCustomQuitMessage) {
        this.useCustomQuitMessage = useCustomQuitMessage;
    }
}
