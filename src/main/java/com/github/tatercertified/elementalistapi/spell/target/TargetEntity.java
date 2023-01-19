package com.github.tatercertified.elementalistapi.spell.target;

import com.github.tatercertified.elementalistapi.spell.BasicProjectileSpell;
import eu.pb4.polymer.core.api.entity.PolymerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TargetEntity extends PersistentProjectileEntity implements PolymerEntity {

    protected float speed;
    protected BasicProjectileSpell spell;
    protected double distance = 100;
    protected ServerPlayerEntity user;
    public Vec3d start_pos;
    public TargetEntity(EntityType<ArrowEntity> entityType, World world, float speed, BasicProjectileSpell spell, ServerPlayerEntity user) {
        super(entityType, world);
        this.speed = speed;
        this.spell = spell;
        this.user = user;
    }
    public TargetEntity(EntityType<ArrowEntity> entityType, World world, float speed, BasicProjectileSpell spell, ServerPlayerEntity user, double distance) {
        super(entityType, world);
        this.speed = speed;
        this.spell = spell;
        this.user = user;
        this.distance = distance;
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

    @Override
    public void tick() {
        if (checkDistance()) {
            spell.onBlockCollision(user, this.getPos());
            this.remove(RemovalReason.DISCARDED);
        }
        super.tick();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        spell.onBlockCollision(user, blockHitResult.getPos());
        this.remove(RemovalReason.DISCARDED);
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (entityHitResult.getEntity() instanceof LivingEntity) {
            spell.onEntityCollision(user, (LivingEntity) entityHitResult.getEntity());
        }
        this.remove(RemovalReason.DISCARDED);
        super.onEntityHit(entityHitResult);
    }

    /**
     * Checks if the distance limit has been reached
     * @return true if distance limit is hit
     */
    private boolean checkDistance() {
        return this.distanceTraveled == distance;
    }
}
