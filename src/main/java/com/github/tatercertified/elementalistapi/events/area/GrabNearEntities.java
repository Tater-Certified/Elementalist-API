package com.github.tatercertified.elementalistapi.events.area;

import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;

public class GrabNearEntities {
    /**
     * Quickly grabs the LivingEntities within a general radius
     * @param user ServerPlayerEntity using the Spell
     * @param pos Pos of the center of the search
     * @param radius Radius of the search
     * @return Returns a List of all LivingEntities found
     */
    public List<LivingEntity> quickGrabNearEntities(ServerPlayerEntity user, BlockPos pos, double radius) {
        Box area = new Box(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));
        List<LivingEntity> entities = user.getWorld().getNonSpectatingEntities(LivingEntity.class, area);
        entities.remove(user);
        return entities;
    }

    /**
     * Thoroughly searches a radius (Slightly more performance heavy than quickGrabNearEntities)
     * @param user ServerPlayerEntity using the Spell
     * @param pos Pos of the center of the search
     * @param radius Radius of the search
     * @return Returns a List of all LivingEntities found
     */
    public List<LivingEntity> thoroughGrabNearEntities(ServerPlayerEntity user, BlockPos pos, double radius) {
        Box area = new Box(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));
        List<LivingEntity> entities = user.getWorld().getNonSpectatingEntities(LivingEntity.class, area);
        entities.remove(user);
        entities.removeIf(entity -> !pos.isWithinDistance(entity.getPos(), radius));
        return entities;
    }
}
