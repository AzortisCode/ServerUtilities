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

package com.azortis.serverutilities.bukkit;

import org.bukkit.entity.Player;

public class PermissionManager {

    public boolean hasPermission(Player player, Permission permission) {
        if (player.isOp() || player.hasPermission("serverutilities." + Permission.ADMIN)) return true;
        return player.hasPermission(permission.getPermissionNode());
    }

    public enum Permission {
        SPAWN("spawn"),
        SPAWN_SET("spawn.set"),
        ADMIN("admin");

        private final String permissionNode;

        Permission(String permissionNode) {
            this.permissionNode = permissionNode;
        }

        public String getPermissionNode() {
            return "serverutilities." + permissionNode;
        }

    }
}
