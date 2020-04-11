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

package com.azortis.serverutilities.bungee.settings.modules;

import java.util.ArrayList;

public class ServerSwitchCommandSettings {

    private boolean enabled;
    private ArrayList<Command> commands;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public void addCommand(Command serverSwitchCommand){
        commands.add(serverSwitchCommand);
    }

    public void removeCommand(Command serverSwitchCommand){
        commands.remove(serverSwitchCommand);
    }

    public static class Command {

        private String name;
        private String permission;
        private ArrayList<String> aliases;
        private String server;

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

        public ArrayList<String> getAliases() {
            return aliases;
        }

        public void setAliases(ArrayList<String> aliases) {
            this.aliases = aliases;
        }

        public void addAlias(String alias){
            aliases.add(alias);
        }

        public void removeAlias(String alias){
            aliases.remove(alias);
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

    }

}