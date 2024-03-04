package com.github.tatercertified.elementalistapi.particle.functions;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;

public class Single extends BasicParticle {

    public Single(int start_tick, int duration, ParticleEffect particle) {
        super(start_tick, duration, particle);
    }

    @Override
    public boolean tick(Entity user) {
        Vec3d pos = this.getReferencePosition();
        createParticle(pos.x, pos.y, pos.z, user, 1, 1.0);
        return super.tick(user);
    }
}
