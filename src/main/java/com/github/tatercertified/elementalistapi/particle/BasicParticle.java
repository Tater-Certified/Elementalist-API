package com.github.tatercertified.elementalistapi.particle;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BasicParticle extends BasicSpellEvent {

    protected ParticleEffect particle;

    public BasicParticle(int start_tick, int duration, ParticleEffect particle) {
        super(start_tick, duration);
        this.particle = particle;
    }

    @Override
    public boolean tick() {
        createParticle();
        return super.tick();
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
    public void createParticle() {
        ServerWorld world = target.getServer().getWorld(target.getWorld().getRegistryKey());
        assert world != null;
        world.spawnParticles(particle, getPos().x, getPos().y, getPos().z, 1, 0, 0, 0, 1.0);
    }
}
