package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
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

    /**
     * Launches the TargetEntity in the direction the user is looking
     * @param user Entity using the summoner
     * @param world user's world
     */
    public void launchProjectile(ServerPlayerEntity user, World world) {
        TargetEntity entity = new TargetEntity(EntityType.ARROW, world, 0.65F, this, user);
        world.spawnEntity(entity);
        Vec3d position = new Vec3d(user.getX(), user.getEyeY() - 0.25, user.getZ());
        entity.setPosition(position);
        entity.start_pos = position;
        entity.setNoGravity(true);
        entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, speed, 1.0F);
    }

    /**
     * Executed when the TargetEntity hits a block or hits its max distance
     */
    public void onBlockCollision(ServerPlayerEntity user, Vec3d location) {
        //Event Here
    }

    /**
     * Executed when the TargetEntity hits an entity
     */
    public void onEntityCollision(ServerPlayerEntity user, LivingEntity damaged) {
        //Event Here
    }
}
