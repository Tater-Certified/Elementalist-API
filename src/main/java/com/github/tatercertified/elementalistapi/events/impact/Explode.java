package com.github.tatercertified.elementalistapi.events.impact;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Explode {
    /**
     * Makes a boom on impact
     * @param power How powerful to make the explosion. For reference, a tnt is 4.00F
     * @param pos Position of the TargetEntity
     * @param user User launched the TargetEntity
     */
    public Explode(float power, Vec3d pos, ServerPlayerEntity user) {
        user.getWorld().createExplosion(user, pos.x, pos.y, pos.z, power, World.ExplosionSourceType.TNT);
    }
}
