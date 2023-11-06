package net.mcreator.pvpadditions.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.pvpadditions.init.PvpAdditionsModGameRules;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class NoTotemsSetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		if (BoolArgumentType.getBool(arguments, "TrueOrFalse") == true) {
			world.getLevelData().getGameRules().getRule(PvpAdditionsModGameRules.ENABLE_TOTEMS_GAMERULE).set(true, world.getServer());
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/tellraw @p [\"\",{\"text\":\"PvP\",\"bold\":true,\"color\":\"dark_blue\"},{\"text\":\"ADDITIONS >> \",\"bold\":true,\"color\":\"blue\"},{\"text\":\"Action Successful\",\"color\":\"green\"}]");
		} else if (BoolArgumentType.getBool(arguments, "TrueOrFalse") == false) {
			world.getLevelData().getGameRules().getRule(PvpAdditionsModGameRules.ENABLE_TOTEMS_GAMERULE).set(false, world.getServer());
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/tellraw @p [\"\",{\"text\":\"PvP\",\"bold\":true,\"color\":\"dark_blue\"},{\"text\":\"ADDITIONS >> \",\"bold\":true,\"color\":\"blue\"},{\"text\":\"Action Successful\",\"color\":\"green\"}]");
		}
	}
}
