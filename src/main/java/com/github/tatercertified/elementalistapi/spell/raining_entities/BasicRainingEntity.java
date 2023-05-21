package com.github.tatercertified.elementalistapi.spell.raining_entities;

import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BasicRainingEntity extends ItemDisplayElement {
    private final BlockPos target;
    private final int ticks;
    private final World world;
    public BasicRainingEntity(ItemStack stack, BlockPos target, int ticks, World world) {
        super(stack);
        this.target = target;
        this.ticks = ticks;
        this.world = world;
    }

    public Vec3d calculateVelocity() {
        Vec3d currentPosition = this.getPos();
        double deltaX = target.getX() - currentPosition.getX();
        double deltaY = target.getY() - currentPosition.getY();
        double deltaZ = target.getZ() - currentPosition.getZ();
        double velocityX = deltaX / ticks;
        double velocityY = deltaY / ticks;
        double velocityZ = deltaZ / ticks;
        return new Vec3d(velocityX, velocityY, velocityZ);
    }

    public Vec3d getPos() {
        return this.asEntity().getPos();
    }

    public void setVelocity(Vec3d velocity) {
        this.asEntity().setVelocity(velocity);
    }

    public void setRotation(float pitch, float yaw) {
        Entity current = this.asEntity();
        current.setPitch(pitch);
        current.setYaw(yaw);
        current.prevPitch = pitch;
        current.prevYaw = yaw;
    }

    public Entity asEntity() {
        return world.getEntityById(this.getEntityId());
    }

    public void faceTowardsTarget() {
        double deltaX = target.getX() - this.asEntity().getX();
        double deltaY = target.getY() - this.asEntity().getEyeY();
        double deltaZ = target.getZ() - this.asEntity().getZ();

        double horizontalDistance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
        double yaw = Math.atan2(deltaZ, deltaX) * (180.0 / Math.PI) - 90.0;
        double pitch = -Math.atan2(deltaY, horizontalDistance) * (180.0 / Math.PI);

        this.setRotation((float) pitch, (float) yaw);
    }
}
