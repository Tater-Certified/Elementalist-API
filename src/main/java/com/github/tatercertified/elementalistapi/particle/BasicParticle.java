package com.github.tatercertified.elementalistapi.particle;

import com.github.tatercertified.elementalistapi.events.BasicDelayedSpellEvent;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class BasicParticle extends BasicDelayedSpellEvent {

    protected ParticleEffect particle;

    public BasicParticle(int start_tick, int duration, ParticleEffect particle) {
        super(start_tick, duration);
        this.particle = particle;
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
    public void createParticle(double x, double y, double z, int count, double speed) {
        ServerWorld world = target.getServer().getWorld(target.getWorld().getRegistryKey());
        assert world != null;
        world.spawnParticles(particle, x, y, z, count, 0, 0, 0, speed);
    }
}
