package com.github.tatercertified.elementalistapi.particle.ctdengine;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;

public class CTDEngine extends BasicParticle {
    protected ArrayList<Vec3d> points;
    protected int duration;
    private CTDExecutor executor;

    /**
     * Connect the Dots Engine. Traces paths to the specified points
     * @param start_tick tick to start tracing
     * @param duration number of ticks to trace
     * @param particle particle displayed as a trail
     * @param points ArrayList of Vec3ds or "points"
     */
    public CTDEngine(int start_tick, int duration, ParticleEffect particle, ArrayList<Vec3d> points) {
        super(start_tick, duration, particle);
        this.points = points;
        this.duration = duration;
    }

    @Override
    public void event() {
        if (executor == null) {
            executor = new CTDExecutor(EntityType.SNOWBALL, target.getWorld(), target.getPos(), points, duration, particle,false);
            target.getWorld().spawnEntity(executor);
            executor.setPosition(target.getPos());
            executor.setNoGravity(true);
        }
        executor.draw();
        executor.velocityDirty = true;
    }

    @Override
    public void finished() {
        executor.remove(Entity.RemovalReason.DISCARDED);
        target.remove(Entity.RemovalReason.DISCARDED);
    }
}
