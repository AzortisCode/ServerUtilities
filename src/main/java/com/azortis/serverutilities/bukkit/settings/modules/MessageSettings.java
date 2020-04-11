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

    private boolean disableJoinMessages;
    private boolean useCustomJoinMessages;
    private boolean disableQuitMessages;
    private boolean useCustomQuitMessages;

    public boolean isDisableJoinMessages() {
        return disableJoinMessages;
    }

    public void setDisableJoinMessages(boolean disableJoinMessages) {
        this.disableJoinMessages = disableJoinMessages;
    }

    public boolean isUseCustomJoinMessages() {
        return useCustomJoinMessages;
    }

    public void setUseCustomJoinMessages(boolean useCustomJoinMessages) {
        this.useCustomJoinMessages = useCustomJoinMessages;
    }

    public boolean isDisableQuitMessages() {
        return disableQuitMessages;
    }

    public void setDisableQuitMessages(boolean disableQuitMessages) {
        this.disableQuitMessages = disableQuitMessages;
    }

    public boolean isUseCustomQuitMessages() {
        return useCustomQuitMessages;
    }

    public void setUseCustomQuitMessages(boolean useCustomQuitMessages) {
        this.useCustomQuitMessages = useCustomQuitMessages;
    }
}
