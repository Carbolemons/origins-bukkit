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
package me.swagpancakes.originsbukkit.util;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Ghost factory.
 *
 * @author SwagPannekaker
 */
public class GhostFactory {

    private final UtilHandler utilHandler;
    private static final String GHOST_TEAM_NAME = "Ghosts";
    private static final OfflinePlayer[] EMPTY_PLAYERS = new OfflinePlayer[0];
    private Team ghostTeam;
    private final Set<String> ghosts = new HashSet<String>();

    /**
     * Gets util handler.
     *
     * @return the util handler
     */
    public UtilHandler getUtilHandler() {
        return utilHandler;
    }

    /**
     * Instantiates a new Ghost factory.
     *
     * @param utilHandler the util handler
     */
    public GhostFactory(UtilHandler utilHandler) {
        this.utilHandler = utilHandler;
        init();
    }

    /**
     * Init.
     */
    private void init() {
        createGetTeam();
    }

    /**
     * Create get team.
     */
    private void createGetTeam() {
        ScoreboardManager scoreboardManager = getUtilHandler().getPlugin().getServer().getScoreboardManager();

        if (scoreboardManager != null) {
            Scoreboard board = scoreboardManager.getMainScoreboard();

            ghostTeam = board.getTeam(GHOST_TEAM_NAME);

            if (ghostTeam == null) {
                ghostTeam = board.registerNewTeam(GHOST_TEAM_NAME);
            }
            ghostTeam.setCanSeeFriendlyInvisibles(true);
        }
    }

    /**
     * Clear members.
     */
    public void clearMembers() {
        if (ghostTeam != null) {
            for (OfflinePlayer player : getMembers()) {
                ghostTeam.removePlayer(player);
            }
        }
    }

    /**
     * Add player.
     *
     * @param player the player
     */
    public void addPlayer(Player player) {
        if (!ghostTeam.hasPlayer(player)) {
            ghostTeam.addPlayer(player);
        }
    }

    /**
     * Is ghost boolean.
     *
     * @param player the player
     *
     * @return the boolean
     */
    public boolean isGhost(Player player) {
        return player != null && hasPlayer(player) && ghosts.contains(player.getName());
    }

    /**
     * Has player boolean.
     *
     * @param player the player
     *
     * @return the boolean
     */
    public boolean hasPlayer(Player player) {
        return ghostTeam.hasPlayer(player);
    }

    /**
     * Sets ghost.
     *
     * @param player  the player
     * @param isGhost the is ghost
     */
    public void setGhost(Player player, boolean isGhost) {
        if (!hasPlayer(player))
            addPlayer(player);

        if (isGhost) {
            ghosts.add(player.getName());
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 255, false, false));
        } else {
            ghosts.remove(player.getName());
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
    }

    /**
     * Remove player.
     *
     * @param player the player
     */
    public void removePlayer(Player player) {
        ghostTeam.removePlayer(player);
    }

    /**
     * Get ghosts offline player [ ].
     *
     * @return the offline player [ ]
     */
    public OfflinePlayer[] getGhosts() {
        Set<OfflinePlayer> players = new HashSet<OfflinePlayer>(ghostTeam.getPlayers());

        players.removeIf(offlinePlayer -> !ghosts.contains(offlinePlayer.getName()));
        return toArray(players);
    }

    /**
     * Get members offline player [ ].
     *
     * @return the offline player [ ]
     */
    public OfflinePlayer[] getMembers() {
        return toArray(ghostTeam.getPlayers());
    }

    /**
     * To array offline player [ ].
     *
     * @param players the players
     *
     * @return the offline player [ ]
     */
    private OfflinePlayer[] toArray(Set<OfflinePlayer> players) {
        if (players != null) {
            return players.toArray(new OfflinePlayer[0]);
        } else {
            return EMPTY_PLAYERS;
        }
    }
}