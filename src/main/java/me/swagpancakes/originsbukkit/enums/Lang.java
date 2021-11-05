package me.swagpancakes.originsbukkit.enums;

import me.swagpancakes.originsbukkit.util.ChatUtils;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * The enum Lang.
 */
public enum Lang {
    /**
     * Human title lang.
     */
    HUMAN_TITLE("Lang.Origins.Human.Title", "&fHuman"),
    /**
     * The Human description.
     */
    HUMAN_DESCRIPTION("Lang.Origins.Human.Description",
            "",
            "&7A regular human. Your",
            "&7ordinary Minecraft",
            "&7experience awaits."),
    /**
     * Enderian title lang.
     */
    ENDERIAN_TITLE("Lang.Origins.Enderian.Title", "&fEnderian"),
    /**
     * The Enderian description.
     */
    ENDERIAN_DESCRIPTION("Lang.Origins.Enderian.Description",
            "",
            "&7Born as sons and daughters of the Ender Dragon,",
            "&7Enderians are capable of teleporting but are",
            "&7vulnerable to water.",
            "",
            "&f&nTeleportation",
            "&7Whenever you want, you may throw an ender pearl",
            "&7using an &6Ability Sceptre &7which deals no",
            "&7damage, allowing you to teleport.",
            "",
            "&f&nHydrophobia",
            "&7You receive damage over time while in contact",
            "&7with water.",
            "",
            "&f&nScared of Gourds",
            "&7You are afraid of pumpkins.",
            ""),
    /**
     * Merling title lang.
     */
    MERLING_TITLE("Lang.Origins.Merling.Title", "&fMerling"),
    /**
     * The Merling description.
     */
    MERLING_DESCRIPTION("Lang.Origins.Merling.Description",
            "",
            "&7These natural inhabitants of the ocean are not",
            "&7used to being out of the water for too long.",
            "",
            "&f&nGills",
            "&7You can breathe underwater, but not on land.",
            "",
            "&f&nWet Eyes",
            "&7Your vision underwater is perfect.",
            "",
            "&f&nAqua Affinity",
            "&7You may break blocks underwater as others do on",
            "&7land.",
            "",
            "&f&nFins",
            "&7Your underwater speed is increased.",
            ""),
    /**
     * Phantom title lang.
     */
    PHANTOM_TITLE("Lang.Origins.Phantom.Title", "&fPhantom"),
    /**
     * The Phantom description.
     */
    PHANTOM_DESCRIPTION("Lang.Origins.Phantom.Description",
            "",
            "&7As half-human and half-phantom offspring, these",
            "&7creatures can switch between a Phantom and a",
            "&7normal form.",
            "",
            "&f&nTransparent",
            "&7You can become transparent/invisible using an",
            "&6Ability Sceptre&7.",
            "",
            "&f&nTransformation",
            "&7You can switch anytime between a phantom and a human",
            "&7using an &6Ability Sceptre&7.",
            "",
            "&f&nPhotoallergic",
            "&7You begin to burn in daylight if you are not invisible.",
            "",
            "&f&nFast Metabolism",
            "&7Being phantomized causes you to become hungry",
            "",
            "&f&nFragile",
            "&7You have 3 less hearts of health than humans.",
            ""),
    /**
     * Elytrian title lang.
     */
    ELYTRIAN_TITLE("Lang.Origins.Elytrian.Title", "&fElytrian"),
    /**
     * The Elytrian description.
     */
    ELYTRIAN_DESCRIPTION("Lang.Origins.Elytrian.Description",
            "",
            "&7Often flying around in the winds, Elytrians are",
            "&7uncomfortable when they don't have enough space",
            "&7above their head.",
            "",
            "&f&nWinged",
            "&7You have Elytra wings without needing to equip any.",
            "",
            "&f&nGift of the Winds",
            "&7Every 30 seconds, you are able to launch about 20",
            "&7blocks up into the air.",
            "",
            "&f&nAerial Combatant",
            "&7You deal substantially more damage while in Elytra",
            "&7flight.",
            "",
            "&f&nNeed for Mobility",
            "&7You can not wear any heavy armor (armor with protection",
            "&7values higher than chainmail).",
            "",
            "&f&nClaustrophobia",
            "&7Being somewhere with a low ceiling for too long will",
            "&7weaken you and make you slower.",
            "",
            "&f&nBrittle Bones",
            "&7You take more damage from falling or flying into blocks.",
            ""),
    /**
     * Blazeborn title lang.
     */
    BLAZEBORN_TITLE("Lang.Origins.Blazeborn.Title", "&fBlazeborn"),
    /**
     * The Blazeborn description.
     */
    BLAZEBORN_DESCRIPTION("Lang.Origins.Blazeborn.Description",
            "",
            "&7Late descendants of the Blaze, the Blazeborn are naturally",
            "&7immune to the perils of the Nether.",
            "",
            "&f&nFire Immunity",
            "&7You are immune to all types of fire damage.",
            "",
            "&f&nNether Inhabitant",
            "&7Your natural spawn will be in the Nether.",
            "",
            "&f&nBurning Wrath",
            "&7When on fire, you deal additional damage with your attacks.",
            "",
            "&f&nHot Blooded",
            "&7Due to your hot body, venoms burn up, making you immune",
            "&7to poison and hunger status effects.",
            "",
            "&f&nHydrophobia",
            "&7You receive damage over time while in contact",
            "&7with water.",
            ""),
    /**
     * Avian title lang.
     */
    AVIAN_TITLE("Lang.Origins.Avian.Title", "&fAvian"),
    /**
     * The Avian description.
     */
    AVIAN_DESCRIPTION("Lang.Origins.Avian.Description",
            "",
            "&7The Avian race has lost their ability to fly a",
            "&7long time ago. Now these peaceful creatures can",
            "&7be seen gliding from one place to another.",
            "",
            "&f&nFeatherweight",
            "&7You fall as gently to the ground as a feather",
            "&7would, unless you sneak.",
            "",
            "&f&nFresh Air",
            "&7When sleeping, your bed needs to be at an altitude",
            "&7of atleast 86 blocks, so you can breathe fresh air.",
            "",
            "&f&nTailwind",
            "&7You are a little bit quicker on foot than others.",
            "",
            "&f&nOviparous",
            "&7Whenever you wake up in the morning, you will lay an",
            "&7egg.",
            "",
            "&f&nVegetarian",
            "&7You can't digest any meat.",
            ""),
    /**
     * Arachnid title lang.
     */
    ARACHNID_TITLE("Lang.Origins.Arachnid.Title", "&fArachnid"),
    /**
     * The Arachnid description.
     */
    ARACHNID_DESCRIPTION("Lang.Origins.Arachnid.Description",
            "",
            "&7Their climbing abilities and the ability to trap their",
            "&7foes in spiderweb make Arachnid perfect hunters.",
            "",
            "&f&nClimbing",
            "&7You are able to climb up any kind of wall, not just",
            "&7ladders.",
            "",
            "&f&nMaster of Webs",
            "&7You navigate cobweb perfectly, and are able to climb",
            "&7in them. When you hit an enemy in melee, they get",
            "&7stuck in cobweb for a while. Non-arthropods stuck in",
            "&7cobweb will be sensed by you. You are able to craft",
            "&7cobweb from string.",
            "",
            "&f&nCarnivore",
            "&7Your diet is restricted to meat, you can't eat",
            "&7vegetables.",
            "",
            "&f&nFragile",
            "&7You have 3 less hearts of health than humans.",
            ""),
    /**
     * Shulk title lang.
     */
    SHULK_TITLE("Lang.Origins.Shulk.Title", "&fShulk"),
    /**
     * The Shulk description.
     */
    SHULK_DESCRIPTION("Lang.Origins.Shulk.Description",
            "",
            "&7Related to Shulkers, the bodies of the Shulk are",
            "&7outfitted with a protective shell-like skin.",
            "",
            "&f&nShulker Inventory",
            "&7You have access to an additional 9 slots of",
            "&7inventory, which keep the items on death.",
            "",
            "&f&nSturdy Skin",
            "&7Even without wearing armor, your skin provides",
            "&7natural protection.",
            "",
            "&f&nStrong Arms",
            "&7You are strong enough to break natural stones",
            "&7without using a pickaxe.",
            "",
            "&f&nUnwieldy",
            "&7The way your hands are formed provide no way of",
            "&7holding a shield upright.",
            "",
            "&f&nLarge Appetite",
            "&7You exhaust much quicker than others, thus",
            "&7requiring you to eat more.",
            ""),
    /**
     * Feline title lang.
     */
    FELINE_TITLE("Lang.Origins.Feline.Title", "&fFeline"),
    /**
     * The Feline description.
     */
    FELINE_DESCRIPTION("Lang.Origins.Feline.Description",
            "",
            "&7With their cat-like appearance, the Feline scare",
            "&7creepers away. With the dexterity of cats, they",
            "&7always land safely on their feet.",
            "",
            "&f&nAcrobatics",
            "&7You never take fall damage, no matter from which",
            "&7height you fall.",
            "",
            "&f&nStrong Ankles",
            "&7You are able to jump higher by jumping while",
            "&7sprinting.",
            "",
            "&f&nNine Lives",
            "&7You have 1 less heart of health than humans.",
            "",
            "&f&nWeak Arms",
            "&7When not under the effect of a strength potion,",
            "&7you can only mine natural stone if there are at",
            "&7most 2 other natural stone blocks adjacent to it.",
            "",
            "&f&nCatlike Appearance",
            "&7Creepers are scared of you and will only explode",
            "&7if you attack them first.",
            "",
            "&f&nNocturnal",
            "&7You can slightly see in the dark when not in water.",
            ""),
    /**
     * The No permission command.
     */
    NO_PERMISSION_COMMAND("Lang.Player.Messages.Error.Commands.No-Permission",
            "&cI'm sorry, but you do not have permission to perform this command. " +
                    "Please contact the server administrators if you believe that this is in error."),
    /**
     * The Player origin already selected.
     */
    PLAYER_ORIGIN_ALREADY_SELECTED("Lang.Player.Messages.Error.Player-Origin-Already-Selected",
            "&cYou have already chosen this origin! &e(%player_current_origin%)"),
    /**
     * The Player origin update.
     */
    PLAYER_ORIGIN_UPDATE("Lang.Player.Messages.Info.Player-Origin-Update",
            "&aYou updated your origin into &e(%player_selected_origin%)"),
    /**
     * The Player origin ability use.
     */
    PLAYER_ORIGIN_ABILITY_USE("Lang.Player.Messages.Info.Player-Origin-Ability-Use",
            "&aYou used your %player_current_origin% ability."),
    /**
     * The Player origin ability cooldown.
     */
    PLAYER_ORIGIN_ABILITY_COOLDOWN("Lang.Player.Messages.Error.Player-Origin-Ability-Cooldown",
            "&cThis ability is on cool-down (%seconds_left% seconds)."),
    /**
     * The Merling bossbar air breathing timer title.
     */
    MERLING_BOSSBAR_AIR_BREATHING_TIMER_TITLE("Lang.Origins.Merling.Bossbar.Air-Breathing-Timer-Title", "Air Breathing - %time-left%"),
    /**
     * The Merling bossbar drowning title.
     */
    MERLING_BOSSBAR_DROWNING_TITLE("Lang.Origins.Merling.Bossbar.Drowning-Title", "&cWarning: You're Drowning!");

    private static YamlConfiguration LANG;
    private final String Path;
    private final Object defaultValue;

    Lang(final String Path, final Object defaultValue) {
        this.Path = Path;
        this.defaultValue = defaultValue;
    }

    Lang(final String Path, final String... defaultValue) {
        this.Path = Path;
        this.defaultValue = defaultValue;
    }

    /**
     * Sets file.
     *
     * @param lang the lang
     */
    public static void setFile(YamlConfiguration lang) {
        LANG = lang;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return ChatUtils.format(LANG.getString(this.Path, (String) this.defaultValue));
    }

    /**
     * To string list string [ ].
     *
     * @return the string [ ]
     */
    public String[] toStringList() {
        return ChatUtils.formatList(LANG.getStringList(this.Path).toArray(new String[0]));
    }

    /**
     * To boolean boolean.
     *
     * @return the boolean
     */
    public boolean toBoolean() {
        return LANG.getBoolean(this.Path);
    }

    /**
     * To long long.
     *
     * @return the long
     */
    public long toLong() {
        return LANG.getLong(this.Path);
    }

    /**
     * To double double.
     *
     * @return the double
     */
    public double toDouble() {
        return LANG.getDouble(this.Path);
    }

    /**
     * To int int.
     *
     * @return the int
     */
    public int toInt() {
        return LANG.getInt(this.Path);
    }

    /**
     * Gets default value.
     *
     * @return the default value
     */
    public Object getDefaultValue() {
        return this.defaultValue;
    }

    /**
     * Get default string list value string [ ].
     *
     * @return the string [ ]
     */
    public String[] getDefaultStringListValue() {
        return (String[]) this.defaultValue;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getPath() {
        return this.Path;
    }
}
