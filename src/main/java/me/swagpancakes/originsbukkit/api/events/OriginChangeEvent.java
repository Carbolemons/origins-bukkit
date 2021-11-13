/*
 *     Origins-Bukkit
 *     Copyright (C) 2021 SwagPannekaker
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
package me.swagpancakes.originsbukkit.api.events;

import me.swagpancakes.originsbukkit.enums.Origins;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * The type Origin change event.
 *
 * @author SwagPannekaker
 */
public class OriginChangeEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final Origins oldOrigin;
    private final Origins newOrigin;

    /**
     * Instantiates a new Origin change event.
     *
     * @param player    the player
     * @param oldOrigin the old origin
     * @param newOrigin the new origin
     */
    public OriginChangeEvent(Player player, Origins oldOrigin, Origins newOrigin) {
        this.player = player;
        this.oldOrigin = oldOrigin;
        this.newOrigin = newOrigin;
    }

    /**
     * Gets handlers.
     *
     * @return the handlers
     */
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Gets handler list.
     *
     * @return the handler list
     */
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets new origin.
     *
     * @return the new origin
     */
    public Origins getNewOrigin() {
        return this.newOrigin;
    }

    /**
     * Gets old origin.
     *
     * @return the old origin
     */
    public Origins getOldOrigin() {
        return this.oldOrigin;
    }
}
