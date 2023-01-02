package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class BasicProjectileSpell extends BasicSpell{

    protected double distance;
    protected float speed;

    public BasicProjectileSpell(int level, int cooldown, String name, double distance, float speed) {
        super(level, cooldown, name);
        this.distance = distance;
        this.speed = speed;
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        launchProjectile(user, world);
        super.onCast(user, world);
    }

    private void launchProjectile(ServerPlayerEntity user, World world) {
        //TODO Make the target entity actually summon :p
        TargetEntity entity = (TargetEntity) EntityType.Builder.create((type, world1) -> new TargetEntity(EntityType.ARROW, world, speed), SpawnGroup.MISC).build("target").spawnFromItemStack(user.getWorld(), ItemStack.EMPTY, user, user.getBlockPos().up(), SpawnReason.NATURAL, true, false);
        assert entity != null;
        entity.setPosition(user.getX(), user.getEyeY() - 0.25, user.getZ());
        entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, speed, 1.0F);
    }
}
