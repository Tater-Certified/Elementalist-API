package com.github.tatercertified.elementalistapi.events.area;

import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;

public class GrabNearEntities {
    /**
     * Quickly grabs the specified Entities within a general radius
     * @param user ServerPlayerEntity using the Spell
     * @param pos Pos of the center of the search
     * @param radius Radius of the search
     * @param entity Type of Entity class to search for
     * @return Returns a List of all Entities found
     */
    public List<? extends  Entity> quickGrabNearEntities(ServerPlayerEntity user, BlockPos pos, int radius, Class<? extends net.minecraft.entity.Entity> entity) {
        Box area = new Box(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));
        List<? extends Entity> entities = user.getWorld().getNonSpectatingEntities(entity, area);
        entities.remove(user);
        return entities;
    }


    /**
     * Thoroughly searches a radius (Slightly more performance heavy than quickGrabNearEntities)
     * @param user ServerPlayerEntity using the Spell
     * @param pos Pos of the center of the search
     * @param radius Radius of the search
     * @param entity Type of Entity class to search for
     * @return Returns a List of all Entities found
     */
    public List<? extends  Entity> thoroughGrabNearEntities(ServerPlayerEntity user, BlockPos pos, int radius, Class<? extends net.minecraft.entity.Entity> entity) {
        Box area = new Box(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));
        List<? extends  Entity> entities = user.getWorld().getNonSpectatingEntities(entity, area);
        entities.remove(user);
        entities.removeIf(entity1 -> !pos.isWithinDistance(entity1.getPos(), radius));
        return entities;
    }
}
