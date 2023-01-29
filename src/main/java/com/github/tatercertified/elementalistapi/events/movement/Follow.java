package com.github.tatercertified.elementalistapi.events.movement;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class Follow extends BasicSpellEvent {
    public Follow(int start_tick, int duration) {
        super(start_tick, duration);
    }

    @Override
    public void event() {
        if (target != null) {
            final ServerPlayerEntity reference = (ServerPlayerEntity) target.getOwner();
            Vec3d position = new Vec3d(reference.getX(), reference.getEyeY() - 0.25, reference.getZ());
            target.setPosition(position);
        }
    }
}
