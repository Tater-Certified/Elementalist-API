package com.github.tatercertified.elementalistapi.particle.functions;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import net.minecraft.particle.ParticleEffect;

public class Sine extends BasicParticle {

    protected double amplitude;
    protected double increment;
    private double x = 0;

    public Sine(int start_tick, int duration, double increment, double amplitude, ParticleEffect particle) {
        super(start_tick, duration, particle);
        this.amplitude = amplitude;
        this.increment = increment;
    }

    @Override
    public boolean tick() {
        double offset = Math.cos(x)*amplitude;
        createParticle(getPos().x, getPos().y + offset, getPos().z, 1, 0.3);
        x = x + increment;
        return super.tick();
    }
}
