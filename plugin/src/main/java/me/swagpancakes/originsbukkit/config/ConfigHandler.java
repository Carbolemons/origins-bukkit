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
package me.swagpancakes.originsbukkit.config;

import com.tchristofferson.configupdater.ConfigUpdater;
import me.swagpancakes.originsbukkit.OriginsBukkit;
import me.swagpancakes.originsbukkit.enums.Config;
import me.swagpancakes.originsbukkit.enums.Lang;
import me.swagpancakes.originsbukkit.util.ChatUtils;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

/**
 * The type Config handler.
 *
 * @author SwagPannekaker
 */
public class ConfigHandler {

    private final OriginsBukkit plugin;
    private YamlConfiguration CONFIG;
    private File CONFIG_FILE;
    private YamlConfiguration LANG;
    private File LANG_FILE;

    /**
     * Gets plugin.
     *
     * @return the plugin
     */
    public OriginsBukkit getPlugin() {
        return plugin;
    }

    /**
     * Gets config.
     *
     * @return the config
     */
    public YamlConfiguration getConfig() {
        return CONFIG;
    }

    /**
     * Gets config file.
     *
     * @return the config file
     */
    public File getConfigFile() {
        return CONFIG_FILE;
    }

    /**
     * Gets lang.
     *
     * @return the lang
     */
    public YamlConfiguration getLang() {
        return LANG;
    }

    /**
     * Gets lang file.
     *
     * @return the lang file
     */
    public File getLangFile() {
        return LANG_FILE;
    }

    /**
     * Instantiates a new Config handler.
     *
     * @param plugin the plugin
     */
    public ConfigHandler(OriginsBukkit plugin) {
        this.plugin = plugin;
        init();
    }

    /**
     * Init.
     */
    private void init() {
        loadConfigurationFiles();
    }

    /**
     * Load configuration files.
     */
    public void loadConfigurationFiles() {
        if (!getPlugin().getDataFolder().exists()) {
            getPlugin().getDataFolder().mkdir();
        }
        ChatUtils.sendConsoleMessage("&3[Origins-Bukkit] Loading files...");
        try {
            loadConfig();
            loadLang();
        } catch (Exception event) {
            event.printStackTrace();
            ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] There was an error loading the files.");
        }
        ChatUtils.sendConsoleMessage("&a[Origins-Bukkit] Successfully loaded the files.");
    }

    /**
     * Load config.
     */
    public void loadConfig() {
        File configFile = new File(getPlugin().getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            ChatUtils.sendConsoleMessage("&3[Origins-Bukkit] The config.yml file was not found. Creating one...");
            try {
                configFile.createNewFile();
                InputStream defaultConfigStream = getPlugin().getResource("config.yml");
                if (defaultConfigStream != null) {
                    YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultConfigStream));
                    defaultConfig.save(configFile);
                    try {
                        ConfigUpdater.update(getPlugin(), "config.yml", configFile, (List<String>) null);
                    } catch (IOException event) {
                        event.printStackTrace();
                    }
                    Config.setFile(defaultConfig);
                    ChatUtils.sendConsoleMessage("&a[Origins-Bukkit] Successfully created the config.yml file");
                }
            } catch (IOException event) {
                event.printStackTrace();
                ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] Couldn't create config file.");
                ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] This is a fatal error. Now disabling.");
                getPlugin().disablePlugin();
            }
        }
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(configFile);
        for (Config item : Config.values()) {
            if (yamlConfiguration.getString(item.getPath()) == null) {
                yamlConfiguration.set(item.getPath(), item.getDefaultValue());
            }
        }
        Config.setFile(yamlConfiguration);
        CONFIG = yamlConfiguration;
        CONFIG_FILE = configFile;
        try {
            yamlConfiguration.save(getConfigFile());
        } catch (IOException event) {
            event.printStackTrace();
            ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] Failed to save lang.yml.");
            ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] this stack trace to <your name>.");
        }
        try {
            ConfigUpdater.update(getPlugin(), "config.yml", configFile, Collections.singletonList("Config.Recipes.Origin-Ball.Ingredients"));
        } catch (IOException event) {
            event.printStackTrace();
        }
        YamlConfiguration.loadConfiguration(configFile);
    }

    /**
     * Load lang.
     */
    public void loadLang() {
        File langFile = new File(getPlugin().getDataFolder(), "lang.yml");
        if (!langFile.exists()) {
            ChatUtils.sendConsoleMessage("&3[Origins-Bukkit] The lang.yml file was not found. Creating one...");
            try {
                langFile.createNewFile();
                InputStream defaultConfigStream = getPlugin().getResource("lang.yml");
                if (defaultConfigStream != null) {
                    YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultConfigStream));
                    defaultConfig.save(langFile);
                    try {
                        ConfigUpdater.update(getPlugin(), "lang.yml", langFile, (List<String>) null);
                    } catch (IOException event) {
                        event.printStackTrace();
                    }
                    Lang.setFile(defaultConfig);
                    ChatUtils.sendConsoleMessage("&a[Origins-Bukkit] Successfully created the lang.yml file");
                }
            } catch (IOException event) {
                event.printStackTrace();
                ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] Couldn't create language file.");
                ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] This is a fatal error. Now disabling.");
                getPlugin().disablePlugin();
            }
        }
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(langFile);
        for (Lang item : Lang.values()) {
            if (yamlConfiguration.getString(item.getPath()) == null) {
                yamlConfiguration.set(item.getPath(), item.getDefaultValue());
            }
        }
        Lang.setFile(yamlConfiguration);
        LANG = yamlConfiguration;
        LANG_FILE = langFile;
        try {
            yamlConfiguration.save(getLangFile());
        } catch (IOException event) {
            event.printStackTrace();
            ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] Failed to save lang.yml.");
            ChatUtils.sendConsoleMessage("&c[Origins-Bukkit] this stack trace to <your name>.");
        }
        try {
            ConfigUpdater.update(getPlugin(), "lang.yml", langFile, (List<String>) null);
        } catch (IOException event) {
            event.printStackTrace();
        }
        YamlConfiguration.loadConfiguration(langFile);
    }

    /**
     * Reload files.
     */
    public void reloadFiles() {
        if (!getPlugin().getDataFolder().exists()) {
            getPlugin().getDataFolder().mkdir();
        }
        try {
            loadConfig();
            loadLang();
        } catch (Exception event) {
            event.printStackTrace();
        }
    }
}
