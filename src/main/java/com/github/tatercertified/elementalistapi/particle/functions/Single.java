package com.github.tatercertified.elementalistapi.particle.functions;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import net.minecraft.particle.ParticleEffect;

public class Single extends BasicParticle {

    public Single(int start_tick, int duration, ParticleEffect particle) {
        super(start_tick, duration, particle);
    }

    @Override
    public boolean tick() {
        createParticle(getPos().x, getPos().y, getPos().z, 1, 1.0);
        return super.tick();
    }
}
