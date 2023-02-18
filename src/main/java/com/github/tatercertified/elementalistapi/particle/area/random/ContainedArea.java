package com.github.tatercertified.elementalistapi.particle.area.random;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class ContainedArea extends BasicParticle {

    public ContainedArea(int start_tick, int duration, ParticleEffect particle) {
        super(start_tick, duration, particle);
    }

    /**
     * Created by skyjay1
     * Spawns the given number of particles at random positions inside a cube.
     * This is the fastest and least resource-intensive particle spawning method
     * because it sends a single packet to the client for any number of particles.
     * @param world the world
     * @param particle the particle
     * @param center the center position
     * @param radius the maximum distance on each axis from the center position
     * @param count the number of particles
     * @param motion the maximum particle motion
     */
    public void insideCube(final ServerWorld world, final ParticleEffect particle, final Vec3d center, final double radius, final int count, final double motion) {
        world.spawnParticles(particle, center.getX(), center.getY(), center.getZ(), count, radius, radius, radius, motion);
    }
}
