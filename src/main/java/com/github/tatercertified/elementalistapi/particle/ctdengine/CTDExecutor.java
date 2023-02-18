package com.github.tatercertified.elementalistapi.particle.ctdengine;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CTDExecutor extends SnowballEntity {
    protected Vec3d start;
    protected ArrayList<Vec3d> goals;
    protected int ticks;
    protected boolean persistent_particles;
    private Vec3d cached_velocity;
    private final double speed;
    private Vec3d current_goal;
    private final ParticleEffect particle;

    public CTDExecutor(EntityType<? extends SnowballEntity> entityType, World world, Vec3d start, ArrayList<Vec3d> goals, int ticks, ParticleEffect particle, boolean persistent_particles) {
        super(entityType, world);
        this.start = start;
        this.goals = goals;
        this.ticks = ticks;
        this.particle = particle;
        this.persistent_particles = persistent_particles;
        speed = calcSpeed();
        current_goal = goals.get(0);
        cached_velocity = calcVelocity(new Vec3d(0,0,0));
    }


    /**
     * Main Function for CTDExecutors. Traces paths.
     */
    public void draw() {
        if (this.getPos().distanceTo(current_goal) < 0.1) {
            if (goals.get(goals.indexOf(current_goal) + 1) != null) {
                cached_velocity = calcVelocity(current_goal);
                current_goal = goals.get(goals.indexOf(current_goal) + 1);
            }
        } else {
            this.getServer().getWorld(world.getRegistryKey()).spawnParticles(particle, this.getX(), this.getY(), this.getZ(), 1, 0, 0, 0, 1.0);
            this.setVelocity(cached_velocity);
        }
    }

    private Vec3d calcVelocity(Vec3d start1) {
        return new Vec3d((current_goal.x - start1.x)*speed, (current_goal.y - start1.y)*speed, (current_goal.z - start1.z)*speed);
    }

    private double calcSpeed() {
        Vec3d reference = new Vec3d(0,0,0);
        double distance = 0;
        goals.add(0,reference);
        for (int i = 0; i + 1 < goals.size(); i++) {
            distance = goals.get(i).distanceTo(goals.get(i+1)) + distance;
        }
        goals.remove(0);
        return distance / (ticks / 20F);
    }

}
