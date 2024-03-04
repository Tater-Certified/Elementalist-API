package com.github.tatercertified.elementalistapi.events.impact;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Explode extends BasicSpellEvent {
    private final float power;
    private final Entity user;

    /**
     * Makes a boom on impact
     * @param power How powerful to make the explosion. For reference, a tnt is 4.00F
     * @param user User launched the TargetEntity
     */
    public Explode(float power, Entity user) {
        this.power = power;
        this.user = user;
    }

    @Override
    public void event() {
        super.event();
        user.getWorld().createExplosion(user, position.x, position.y, position.z, power, World.ExplosionSourceType.TNT);
    }
}
