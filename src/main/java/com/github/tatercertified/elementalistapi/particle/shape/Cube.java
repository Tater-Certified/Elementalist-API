package com.github.tatercertified.elementalistapi.particle.shape;

import com.github.tatercertified.elementalistapi.particle.functions.Linear;
import net.minecraft.particle.ParticleEffect;

public class Cube extends Linear {
    protected int growth;

    public Cube(int start_tick, int duration, int growth, ParticleEffect particle) {
        super(start_tick, duration, particle);
        this.growth = growth;
    }

    @Override
    public boolean tick() {

        return super.tick();
    }

    public void createCube(double length, double width, double height) {
        for (int i = 0; i < length; i++) {
        }
    }
}
