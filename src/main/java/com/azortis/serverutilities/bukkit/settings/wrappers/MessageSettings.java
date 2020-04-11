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

import java.util.Map;

@SuppressWarnings("all")
public class MessageSettings extends SettingsWrapper {

    private Map<String, Object> messageMap;

    public MessageSettings(SettingsManager parent, Object settingsMap, Object messageMap) {
        super(parent, settingsMap, "messageSettings");
        this.messageMap = (Map<String, Object>) messageMap;
    }

    public String getMessage(String messagePath) {
        return (String) messageMap.get(messagePath);
    }

    public void setMessage(String messagePath, String message) {
        messageMap.remove(messagePath);
        messageMap.put(messagePath, message);
    }

    public boolean getDisableJoinMessage(){
        return getBoolean("disableJoinMessage", null);
    }

    public void setDisableJoinMessage(boolean disableJoinMessage){
        setBoolean("disableJoinMessage", disableJoinMessage, null);
    }

    public boolean getUseCustomJoinMessage(){
        return getBoolean("useCustomJoinMessage", null);
    }

    public void setUseCustomJoinMessage(boolean useCustomJoinMessage){
        setBoolean("useCustomJoinMessage", useCustomJoinMessage, null);
    }

    public boolean getDisableQuitMessage(){
        return getBoolean("disableQuitMessage", null);
    }

    public void setDisableQuitMessage(boolean disableQuitMessage){
        setBoolean("disableQuitMessage", disableQuitMessage, null);
    }

    public boolean getUseCustomQuitMessage(){
        return getBoolean("useCustomQuitMessage", null);
    }

    public void setUseCustomQuitMessage(boolean useCustomQuitMessage){
        setBoolean("useCustomJoinMessage", useCustomQuitMessage, null);
    }

}
