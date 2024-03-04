package com.github.tatercertified.elementalistapi.events.movement;

import com.github.tatercertified.elementalistapi.events.BasicDelayedSpellEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class Flight extends BasicDelayedSpellEvent {
    public Flight(int start_tick, int duration, ServerPlayerEntity reference) {
        super(start_tick, duration, reference);
    }

    @Override
    public void event() {
        if (!reference.hasNoGravity()) {
            reference.setNoGravity(true);
            reference.setVelocity(new Vec3d(reference.getVelocity().x,2,reference.getVelocity().z));
            reference.velocityModified = true;
        }
        if (reference.isSneaking()) {
            reference.setVelocity(new Vec3d(reference.getVelocity().x, -0.1, reference.getVelocity().z));
            reference.velocityModified = true;
        }
        if (reference.getPitch() == -90) {
            reference.setVelocity(reference.getVelocity().x, 0.1, reference.getVelocity().z);
            reference.velocityModified = true;
        }
    }

    @Override
    public void finished() {
        reference.setNoGravity(false);
    }
}
