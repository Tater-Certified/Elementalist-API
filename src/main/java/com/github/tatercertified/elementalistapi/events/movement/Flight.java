package com.github.tatercertified.elementalistapi.events.movement;

import com.github.tatercertified.elementalistapi.events.BasicDelayedSpellEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class Flight extends BasicDelayedSpellEvent {
    protected ServerPlayerEntity user;
    public Flight(int start_tick, int duration, ServerPlayerEntity reference) {
        super(start_tick, duration, reference);
        this.user = reference;
    }

    @Override
    public void event() {
        if (!user.hasNoGravity()) {
            user.setNoGravity(true);
            user.setVelocity(new Vec3d(user.getVelocity().x,2,user.getVelocity().z));
            user.velocityModified = true;
        }
        if (user.isSneaking()) {
            user.setVelocity(new Vec3d(user.getVelocity().x, -0.1, user.getVelocity().z));
            user.velocityModified = true;
        }
        if (user.getPitch() == -90) {
            user.setVelocity(user.getVelocity().x, 0.1, user.getVelocity().z);
            user.velocityModified = true;
        }
    }

    @Override
    public void finished() {
        user.setNoGravity(false);
    }
}
