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
package me.swagpancakes.originsbukkit.listeners.origins;

import me.swagpancakes.originsbukkit.OriginsBukkit;
import me.swagpancakes.originsbukkit.api.events.PlayerOriginInitiateEvent;
import me.swagpancakes.originsbukkit.enums.Config;
import me.swagpancakes.originsbukkit.enums.Lang;
import me.swagpancakes.originsbukkit.enums.Origins;
import me.swagpancakes.originsbukkit.util.ChatUtils;
import me.swagpancakes.originsbukkit.util.Origin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The type Avian.
 *
 * @author SwagPannekaker
 */
public class Avian extends Origin implements Listener {

    private final OriginsBukkit plugin;

    /**
     * Instantiates a new Avian.
     *
     * @param plugin the plugin
     */
    public Avian(OriginsBukkit plugin) {
        super(Config.ORIGINS_AVIAN_MAX_HEALTH.toDouble(), 0.25f, 0.1f);
        this.plugin = plugin;
        init();
    }

    /**
     * Gets origin identifier.
     *
     * @return the origin identifier
     */
    @Override
    public String getOriginIdentifier() {
        return "Avian";
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    @Override
    public String getAuthor() {
        return "SwagPannekaker";
    }

    /**
     * Gets origin icon.
     *
     * @return the origin icon
     */
    @Override
    public Material getOriginIcon() {
        return Material.FEATHER;
    }

    /**
     * Is origin icon glowing boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isOriginIconGlowing() {
        return false;
    }

    /**
     * Gets origin title.
     *
     * @return the origin title
     */
    @Override
    public String getOriginTitle() {
        return Lang.AVIAN_TITLE.toString();
    }

    /**
     * Get origin description string [ ].
     *
     * @return the string [ ]
     */
    @Override
    public String[] getOriginDescription() {
        return Lang.AVIAN_DESCRIPTION.toStringList();
    }

    /**
     * Init.
     */
    private void init() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        registerOrigin(getOriginIdentifier());
    }

    /**
     * Avian join.
     *
     * @param event the event
     */
    @EventHandler
    public void avianJoin(PlayerOriginInitiateEvent event) {
        Player player = event.getPlayer();
        String origin = event.getOrigin();

        if (Objects.equals(origin, Origins.AVIAN.toString())) {
            player.setHealthScale(Config.ORIGINS_AVIAN_MAX_HEALTH.toDouble());
            player.setWalkSpeed(0.25F);
            avianSlowFalling(player);
        }
    }

    /**
     * Avian slow falling.
     *
     * @param player the player
     */
    public void avianSlowFalling(Player player) {
        UUID playerUUID = player.getUniqueId();

        if (Objects.equals(plugin.storageUtils.getPlayerOrigin(playerUUID), Origins.AVIAN.toString())) {
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.SLOW_FALLING,
                    Integer.MAX_VALUE,
                    0,
                    false,
                    false));
        }
    }

    /**
     * On avian slow falling toggle.
     *
     * @param event the event
     */
    @EventHandler
    public void onAvianSlowFallingToggle(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if (Objects.equals(plugin.storageUtils.getPlayerOrigin(playerUUID), Origins.AVIAN.toString())) {
            if (player.isGliding()) {
                if (!player.isSneaking()) {
                    player.setVelocity(player.getVelocity().setY(0));
                    player.addPotionEffect(new PotionEffect(
                            PotionEffectType.SLOW_FALLING,
                            Integer.MAX_VALUE,
                            0,
                            false,
                            false));
                } else {
                    player.removePotionEffect(PotionEffectType.SLOW_FALLING);
                }
            } else {
                if (player.isSneaking()) {
                    player.setVelocity(player.getVelocity().setY(0));
                    player.addPotionEffect(new PotionEffect(
                            PotionEffectType.SLOW_FALLING,
                            Integer.MAX_VALUE,
                            0,
                            false,
                            false));
                } else {
                    player.removePotionEffect(PotionEffectType.SLOW_FALLING);
                }
            }
        }
    }

    /**
     * On avian slow falling elytra toggle.
     *
     * @param event the event
     */
    @EventHandler
    public void onAvianSlowFallingElytraToggle(EntityToggleGlideEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Player) {
            Player player = (Player) entity;
            UUID playerUUID = player.getUniqueId();

            if (Objects.equals(plugin.storageUtils.getPlayerOrigin(playerUUID), Origins.AVIAN.toString())) {
                if (!player.isGliding()) {
                    if (player.isSneaking()) {
                        player.setVelocity(player.getVelocity().setY(0));
                        player.addPotionEffect(new PotionEffect(
                                PotionEffectType.SLOW_FALLING,
                                Integer.MAX_VALUE,
                                0,
                                false,
                                false));
                    } else {
                        player.removePotionEffect(PotionEffectType.SLOW_FALLING);
                    }
                } else {
                    if (!player.isSneaking()) {
                        player.setVelocity(player.getVelocity().setY(0));
                        player.addPotionEffect(new PotionEffect(
                                PotionEffectType.SLOW_FALLING,
                                Integer.MAX_VALUE,
                                0,
                                false,
                                false));
                    } else {
                        player.removePotionEffect(PotionEffectType.SLOW_FALLING);
                    }
                }
            }
        }
    }

    /**
     * On avian sleep.
     *
     * @param event the event
     */
    @EventHandler
    public void onAvianSleep(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        Block bed = event.getBed();
        Location bedLocation = bed.getLocation();
        double bedLocationY = bedLocation.getY();

        if (Objects.equals(plugin.storageUtils.getPlayerOrigin(playerUUID), Origins.AVIAN.toString())) {
            if (bedLocationY < 86) {
                event.setCancelled(true);
            }
        }
    }

    /**
     * On avian bed respawn point set.
     *
     * @param event the event
     */
    @EventHandler
    public void onAvianBedRespawnPointSet(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        Action action = event.getAction();
        Block clickedBlock = event.getClickedBlock();

        if (Objects.equals(plugin.storageUtils.getPlayerOrigin(playerUUID), Origins.AVIAN.toString())) {
            if (action == Action.RIGHT_CLICK_BLOCK) {
                if (clickedBlock != null && clickedBlock.getLocation().getY() < 86 && Tag.BEDS.isTagged(clickedBlock.getType())) {
                    event.setCancelled(true);
                }
            }
        }
    }

    /**
     * On avian egg lay.
     *
     * @param event the event
     */
    @EventHandler
    public void onAvianEggLay(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        PlayerInventory playerInventory = player.getInventory();
        UUID playerUUID = player.getUniqueId();
        World world = player.getWorld();
        long getWorldTime = world.getTime();

        if (Objects.equals(plugin.storageUtils.getPlayerOrigin(playerUUID), Origins.AVIAN.toString())) {
            if (getWorldTime == 0) {
                if (playerInventory.firstEmpty() == -1) {
                    world.dropItem(location, new ItemStack(Material.EGG, 1));
                    ChatUtils.sendPlayerMessage(player, "&cYour inventory was full, so we dropped your egg on the ground.");
                } else {
                    playerInventory.addItem(new ItemStack(Material.EGG, 1));
                }
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("You laid an egg!"));
            }
        }
    }

    /**
     * Avian anti slow falling effect remove.
     *
     * @param event the event
     */
    @EventHandler
    public void avianAntiSlowFallingEffectRemove(EntityPotionEffectEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Player) {
            Player player = (Player) entity;
            UUID playerUUID = player.getUniqueId();
            PotionEffect oldEffect = event.getOldEffect();
            EntityPotionEffectEvent.Cause cause = event.getCause();

            if (Objects.equals(plugin.storageUtils.getPlayerOrigin(playerUUID), Origins.AVIAN.toString())) {
                if (oldEffect != null) {
                    if (oldEffect.getType().equals(PotionEffectType.SLOW_FALLING) && cause != EntityPotionEffectEvent.Cause.PLUGIN) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    /**
     * Avian eating disabilities.
     *
     * @param event the event
     */
    @EventHandler
    public void avianEatingDisabilities(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        Material material = event.getItem().getType();
        List<Material> materials = Arrays.asList(
                Material.COOKED_BEEF,
                Material.COOKED_COD,
                Material.COOKED_CHICKEN,
                Material.COOKED_MUTTON,
                Material.COOKED_RABBIT,
                Material.COOKED_PORKCHOP,
                Material.COOKED_SALMON,
                Material.BEEF,
                Material.COD,
                Material.CHICKEN,
                Material.MUTTON,
                Material.RABBIT,
                Material.PORKCHOP,
                Material.SALMON,
                Material.TROPICAL_FISH,
                Material.PUFFERFISH,
                Material.ROTTEN_FLESH);

        if (Objects.equals(plugin.storageUtils.getPlayerOrigin(playerUUID), Origins.AVIAN.toString())) {
            if (materials.contains(material)) {
                event.setCancelled(true);
            }
        }
    }
}
