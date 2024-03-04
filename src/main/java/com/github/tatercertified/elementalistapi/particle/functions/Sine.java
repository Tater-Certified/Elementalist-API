package com.github.tatercertified.elementalistapi.particle.functions;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;

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
    public boolean tick(Entity user) {
        double offset = Math.cos(x)*amplitude;
        Vec3d pos = this.getTargetPosition();
        createParticle(pos.x, pos.y + offset, pos.z, user, 1, 0.3);
        x = x + increment;
        return super.tick(user);
    }
}
