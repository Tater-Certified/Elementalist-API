package com.github.tatercertified.elementalistapi.spell.target;

import eu.pb4.polymer.core.api.entity.PolymerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class TargetEntity extends PersistentProjectileEntity implements PolymerEntity {

    protected float speed;

    public TargetEntity(EntityType<ArrowEntity> entityType, World world, float speed) {
        super(entityType, world);
        this.speed = speed;
    }

    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    public void setVelocity(double x, double y, double z, float speed, float divergence) {
        super.setVelocity(x, y, z, this.speed, divergence);
    }

    @Override
    public EntityType<?> getPolymerEntityType(ServerPlayerEntity player) {
        return EntityType.ARROW;
    }
}
