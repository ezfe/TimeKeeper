TimeKeeper - a Forge mod
=============

TimeKeeper Mod for Minecraft 1.6.2

This mod will sync the Minecraft time to the time outside. Keep in mind sunsets probably won't be perfectly synced, because minecraft sunsets don't vary based on seasons or location. However, the game will be running on a 24 hour cycle, and keep in sync, meaning you can sleep through night. In your bed.

##Installation

1. Install forge (http://files.minecraftforge.net). This mod was last tested and built with 9.10.0.804.

2. Put the downloaded zip into minecraft/mods (where minecraft is your minecraft folder). You can find information on locating your minecraft folder here: http://hopper.minecraft.net/help/finding-minecraft-data-folder/


##To get started in a new world, you have two options:

With NEI:

1. Turn on cheat mode

2. Find the "Time Keeper" block, give it to yourself, and place it in the world.

Without NEI:

1. If your world doesn't have cheats enabled, open it to LAN with cheats on.

2. Type /gamemode @p 1

3. Go to the redstone tab, and give yourself one Time Keeper. Place it in the world.

It has no recipe, and you only need one per world. However the chunk needs to stay loaded, so placing it spawn is helpful.

You shouldn't need to do anything else. If you notice the mod is causing significant lag (or any other issue), create an issue on Github, and I will look into it :) (https://github.com/ezfe/TimeKeeper/issues)

##Config and Time Offsets

You can find the config in minecraft/config. It is called "EzTimeKeeper.cfg. There are currently two config options. These are the block ID and the time offset.

Time Offsets allow you to change the time in game. For instance, if you always play at night, perhaps you want to reverse the time scale. If you set the time offset to 12000 then it will be day during the night, and night during the day. Minecraft time runs on a 24000 tick cycle. Meaning adding 12000 will set it ahead half a cycle. (Day -> Night, or vice versa)

The block ID can be changed if you experience conflicts. This is the same with all mods.

Last updated August 23, 2013
