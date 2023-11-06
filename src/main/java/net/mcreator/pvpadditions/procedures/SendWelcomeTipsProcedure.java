package net.mcreator.pvpadditions.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.pvpadditions.init.PvpAdditionsModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SendWelcomeTipsProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(PvpAdditionsModGameRules.SEND_WELCOME_TIPS_GAMERULE) == false) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(0);
		} else if (world.getLevelData().getGameRules().getBoolean(PvpAdditionsModGameRules.SEND_WELCOME_TIPS_GAMERULE) == true) {
			if (entity.hasPermissions(4)) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p [\"\",{\"text\":\"PvP\",\"bold\":true,\"color\":\"dark_blue\"},{\"text\":\"ADDITIONS >> \",\"bold\":true,\"color\":\"blue\"},{\"text\":\"Welcome, OP\",\"bold\":true,\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"Here is a small guide on how to use this:\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"bold\":true,\"color\":\"gold\"},{\"text\":\"If you want players to be able to use \",\"color\":\"yellow\"},{\"text\":\"shields\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\", do \",\"color\":\"yellow\"},{\"text\":\"/PvPAdditions:EnableShield true\",\"color\":\"light_purple\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"bold\":true,\"color\":\"gold\"},{\"text\":\"If you want players to be able to \",\"color\":\"yellow\"},{\"text\":\"heal\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\", do \",\"color\":\"yellow\"},{\"text\":\"/PvPAdditions:EnableHealing true\",\"color\":\"light_purple\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"bold\":true,\"color\":\"gold\"},{\"text\":\"If you want players to be able to do \",\"color\":\"yellow\"},{\"text\":\"critical hits\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\", do \",\"color\":\"yellow\"},{\"text\":\"/PvPAdditions:EnableCrits true\",\"color\":\"light_purple\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"bold\":true,\"color\":\"gold\"},{\"text\":\"If you want \",\"color\":\"yellow\"},{\"text\":\"PvP Enabled\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\", do \",\"color\":\"yellow\"},{\"text\":\"/PvPAdditions:EnablePvP true\",\"color\":\"light_purple\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"bold\":true,\"color\":\"gold\"},{\"text\":\"If you want players to be able to use \",\"color\":\"yellow\"},{\"text\":\"totems\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\", do \",\"color\":\"yellow\"},{\"text\":\"/PvPAdditions:EnableTotems true\",\"color\":\"light_purple\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"bold\":true,\"color\":\"gold\"},{\"text\":\"If you want to disable \",\"color\":\"yellow\"},{\"text\":\"welcome tips\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\", do \",\"color\":\"yellow\"},{\"text\":\"/PvPAdditions:EnableWelcomeTips false\",\"color\":\"light_purple\"},{\"text\":\"\\n\"},{\"text\":\"Thank you for using \",\"bold\":true,\"color\":\"gold\"},{\"text\":\"PvP\",\"bold\":true,\"color\":\"dark_blue\"},{\"text\":\"ADDITIONS\",\"bold\":true,\"color\":\"blue\"},{\"text\":\"\\n\"},{\"text\":\"Version 1.0\",\"color\":\"gray\"}]");
			}
		}
	}
}
