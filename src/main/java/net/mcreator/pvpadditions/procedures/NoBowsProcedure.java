package net.mcreator.pvpadditions.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.pvpadditions.init.PvpAdditionsModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NoBowsProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getEntity().level(), event.getTarget());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(PvpAdditionsModGameRules.ENABLE_BOWS) == false) {
			if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		} else if (world.getLevelData().getGameRules().getBoolean(PvpAdditionsModGameRules.ENABLE_BOWS) == true) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(0);
		}
	}
}
