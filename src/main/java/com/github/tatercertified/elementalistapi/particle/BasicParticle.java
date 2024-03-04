package com.github.tatercertified.elementalistapi.particle;

import com.github.tatercertified.elementalistapi.events.BasicDelayedSpellEvent;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BasicParticle extends BasicDelayedSpellEvent {

    protected ParticleEffect particle;

    public BasicParticle(int start_tick, int duration, ParticleEffect particle) {
        super(start_tick, duration);
        this.particle = particle;
    }

    /**
     * Summons a particle in the specified World
     * @param x X pos
     * @param y Y pos
     * @param z Z pos
     * @param world World to summon the particle
     * @param count Amount of particles
     * @param speed Playback speed
     */
    public void createParticle(double x, double y, double z, ServerWorld world, int count, double speed) {
        world.spawnParticles(particle, x, y, z, count, 0, 0, 0, speed);
    }

    /**
     * Summons a particle in the same World as the reference Entity
     * @param x X pos
     * @param y Y pos
     * @param z Z pos
     * @param count Amount of particles
     * @param speed Playback speed
     */
    public void createParticle(double x, double y, double z, int count, double speed) {
        this.reference.getServer().getWorld(this.reference.getWorld().getRegistryKey()).spawnParticles(particle, x, y, z, count, 0, 0, 0, speed);
    }

    /**
     * Summons a particle in the same World as the reference Entity
     * @param x X pos
     * @param y Y pos
     * @param z Z pos
     * @param entity Entity to reference
     * @param count Amount of particles
     * @param speed Playback speed
     */
    public void createParticle(double x, double y, double z, Entity entity, int count, double speed) {
        entity.getServer().getWorld(entity.getWorld().getRegistryKey()).spawnParticles(particle, x, y, z, count, 0, 0, 0, speed);
    }

    /**
     * Summons a particle at the Entity's location
     * @param entity Entity to reference
     * @param count Amount of particles
     * @param speed Playback speed
     */
    public void createParticle(Entity entity, int count, double speed) {
        entity.getServer().getWorld(entity.getWorld().getRegistryKey()).spawnParticles(this.particle, entity.getX(), entity.getY(), entity.getZ(), count, 0, 0, 0, speed);
    }
}
