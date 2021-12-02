/*
 * Origins-Bukkit - Origins for Bukkit and forks of Bukkit.
 * Copyright (C) 2021 SwagPannekaker
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package me.swagpancakes.originsbukkit.enums;

/**
 * The enum Permissions.
 */
public enum Permissions {
    ADMIN("origins.admin"),
    USER("origins.user"),
    UPDATE("origins.commands.update"),
    PRUNE("origins.commands.prune"),
    RELOAD("origins.commands.reload"),
    GIVE("origins.commands.give");

    private final Object value;

    /**
     * Instantiates a new Permissions.
     *
     * @param value the value
     */
    Permissions(final Object value) {
        this.value = value;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return (String) this.value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Object getValue() {
        return this.value;
    }
}
