
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pvpadditions.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PvpAdditionsModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> ENABLE_HEALING_GAMERULE = GameRules.register("enableHealingGamerule", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> ENABLE_SHIELD_GAMERULE = GameRules.register("enableShield", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> ENABLE_PV_P_GAMERULE = GameRules.register("enablePvPGamerule", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> ENABLE_TOTEMS_GAMERULE = GameRules.register("enableTotemsGamerule", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> ENABLE_BOWS = GameRules.register("enableBows", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> SEND_WELCOME_TIPS_GAMERULE = GameRules.register("sendWelcomeTipsGamerule", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}
