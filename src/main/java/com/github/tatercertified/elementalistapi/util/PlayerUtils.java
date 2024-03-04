package com.github.tatercertified.elementalistapi.util;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class PlayerUtils {

    public static Vec3d getTargetBlockPos(ServerPlayerEntity player, double max_distance) {
        HitResult hitResult = player.raycast(max_distance, 1.0f, false);
        return hitResult.getPos();
    }

    public static Vec3d getTargetBlockPos(ServerPlayerEntity player, double max_distance, BasicSpellEvent block, BasicSpellEvent entity, BasicSpellEvent miss) {
        HitResult hitResult = player.raycast(max_distance, 1.0f, false);
        Vec3d pos = hitResult.getPos();
        if (hitResult.getType() == HitResult.Type.BLOCK && block != null) {
            block.setPosition(pos);
            block.setReference(player);
            block.event();
        } else if (hitResult.getType() == HitResult.Type.ENTITY && entity != null) {
            entity.setPosition(pos);
            entity.setReference(player);
            entity.event();
        } else if (miss != null) {
            miss.setPosition(pos);
            miss.setReference(player);
            miss.event();
        }
        return pos;
    }

    public static BlockPos vec3dToBlockPos(Vec3d vec3d) {
        return new BlockPos((int) Math.round(vec3d.x), (int) Math.round(vec3d.y), (int) Math.round(vec3d.z));
    }
}
