package com.github.tatercertified.elementalistapi.spell.target;

import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import eu.pb4.polymer.core.api.entity.PolymerEntity;
import net.minecraft.entity.EntityType;
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
    protected BasicSpell spell;
    protected double distance = 100;
    public Vec3d start_pos;
    public TargetEntity(EntityType<ArrowEntity> entityType, World world, float speed, BasicSpell spell) {
        super(entityType, world);
        this.speed = speed;
        this.spell = spell;
    }
    public TargetEntity(EntityType<ArrowEntity> entityType, World world, float speed, BasicSpell spell, double distance) {
        super(entityType, world);
        this.speed = speed;
        this.spell = spell;
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
            hitBlock();
        }
        super.tick();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        hitBlock();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        hitEntity();
        super.onEntityHit(entityHitResult);
    }

    /**
     * Checks if the distance limit has been reached
     * @return true if distance limit is hit
     */
    private boolean checkDistance() {
        return this.distanceTraveled == distance;
    }

    private void hitBlock() {
        //hitBlock event
        this.remove(RemovalReason.DISCARDED);
    }

    private void hitEntity() {
        //hitEntity event
        this.remove(RemovalReason.DISCARDED);
    }
}
