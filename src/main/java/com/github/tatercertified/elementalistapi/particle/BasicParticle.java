package com.github.tatercertified.elementalistapi.particle;

import net.minecraft.particle.ParticleEffect;

public class BasicParticle {

    protected int start_tick;
    protected int duration;
    private int stop_tick;
    protected ParticleEffect particle;
    public BasicParticle(int start_tick, int duration, ParticleEffect particle) {
        this.start_tick = start_tick;
        this.duration = duration;
        stop_tick = start_tick + duration;
        this.particle = particle;
    }

    /**
     * Executes particle ticking
     * @return If the particle should continue being ticked
     */
    public boolean tickParticle() {
        //Execute per-tick code here

        stop_tick--;
        return stop_tick != start_tick;
    }
}
