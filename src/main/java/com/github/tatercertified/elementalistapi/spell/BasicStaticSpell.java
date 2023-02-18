package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BasicStaticSpell extends BasicSpell{

    public TargetEntity entity;

    /**
     * Basic spell for stationary Spells
     *
     * @param level    level of spell
     * @param cooldown cooldown in ticks
     * @param name     name of the spell
     */
    public BasicStaticSpell(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        placeMarkerTargetEntity(user, world);
        super.onCast(user, world);
    }

    /**
     * Creates a static TargetEntity for reference
     * @param user ServerPlayerEntity using the Spell
     * @param world User's World
     */
    private void placeMarkerTargetEntity(ServerPlayerEntity user, World world) {
        entity = new TargetEntity(EntityType.ARROW, world, 0.65F, this, user);
        entity.setOwner(user);
        world.spawnEntity(entity);
        entity.setNoGravity(true);
        entity.setInvulnerable(true);
        Vec3d position = new Vec3d(user.getX(), user.getEyeY() - 0.25, user.getZ());
        entity.setPosition(position);
    }
}
