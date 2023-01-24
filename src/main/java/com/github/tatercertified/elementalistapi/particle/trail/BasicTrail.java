package com.github.tatercertified.elementalistapi.particle.trail;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BasicTrail extends BasicParticle {

    public TargetEntity target = null;

    public BasicTrail(int start_tick, int duration, ParticleEffect particle) {
        super(start_tick, duration, particle);
    }

    @Override
    public boolean tickParticle() {
        createParticleTrail();
        if (target != null && !target.isRemoved()) {
            return false;
        }
        return super.tickParticle();
    }


    /**
     * Gets the current position of the TargetEntity
     * @return Vec3d of the position
     */
    public Vec3d getPos() {
        return target.getPos();
    }

    /**
     * Summons a particle for the trail
     */
    public void createParticleTrail() {
        World world = target.world;
        world.addParticle(particle, getPos().x, getPos().y, getPos().z, 0, 0,0);
    }
}
