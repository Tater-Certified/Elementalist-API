package com.github.tatercertified.elementalistapi.particle.ctdengine;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
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
    private final ArrayList<Integer> ticks_times = new ArrayList<>();
    private final ArrayList<Double> distances = new ArrayList<>();
    private int counter = 0;
    private final Vec3d origin = new Vec3d(0,0,0);

    public CTDExecutor(EntityType<? extends SnowballEntity> entityType, World world, Vec3d start, ArrayList<Vec3d> goals, int ticks, ParticleEffect particle, boolean persistent_particles) {
        super(entityType, world);
        this.start = start;
        this.goals = goals;
        this.ticks = ticks;
        this.particle = particle;
        this.persistent_particles = persistent_particles;
        speed = calcSpeed();
        current_goal = goals.get(0);
        cached_velocity = calcVelocity();
        calcTickTimes();
    }

    @Override
    protected void onCollision(HitResult hitResult) {
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
    }

    /**
     * Main Function for CTDExecutors. Traces paths.
     */
    public void draw() {
        if (updateCounter()) {
            if (hasNext()) {
                current_goal = goals.get(goals.indexOf(current_goal) + 1);
                cached_velocity = calcVelocity();
            }
        }
        this.getServer().getWorld(world.getRegistryKey()).spawnParticles(particle, this.getX(), this.getY(), this.getZ(), 1, 0, 0, 0, 1.0);
        this.setVelocity(cached_velocity);
    }

    private Vec3d calcVelocity() {
        return new Vec3d(current_goal.x * speed, current_goal.y * speed, current_goal.z * speed);
    }

    private double calcSpeed() {
        double distance = 0;
        for (Vec3d goal : goals) {
            double temp_distance = goal.distanceTo(origin);
            distances.add(temp_distance);
            distance = temp_distance + distance;
        }
        return distance / ticks;
    }

    private void calcTickTimes() {
        for (Double distance : distances) {
            ticks_times.add((int) Math.round(distance/speed));
        }
    }

    /**
     * Counts the amount of time between points
     * @return If it shouldn't continue on the same path
     */
    private boolean updateCounter() {
        int max = ticks_times.get(goals.indexOf(current_goal));
        if (counter >= max) {
            counter = 0;
            return true;
        }
        counter++;
        return false;
    }

    /**
     * Checks if an ArrayList has another index
     * @return if ArrayList has another index
     */
    private boolean hasNext() {
        int index = goals.indexOf(current_goal);
        return goals.size() - 1 >= index + 1;
    }
}
