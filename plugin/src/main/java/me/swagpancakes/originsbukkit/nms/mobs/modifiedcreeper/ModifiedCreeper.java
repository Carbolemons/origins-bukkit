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
package me.swagpancakes.originsbukkit.nms.mobs.modifiedcreeper;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

/**
 * The interface Modified creeper interface.
 */
public interface ModifiedCreeper {

    /**
     * Spawn modified creeper.
     *
     * @param location the location
     */
    void spawnModifiedCreeper(Location location);

    /**
     * Is modified creeper boolean.
     *
     * @param entity the entity
     *
     * @return the boolean
     */
    boolean isModifiedCreeper(Entity entity);
}
