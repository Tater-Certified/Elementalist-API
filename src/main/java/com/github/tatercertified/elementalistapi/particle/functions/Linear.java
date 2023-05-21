package com.github.tatercertified.elementalistapi.particle.functions;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.util.PlayerUtils;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class Linear extends BasicParticle {

    private final double distance;
    private final double distance_between_points;
    private final int ticks;
    private int workable_ticks;
    private BasicSpellEvent block_event;
    private BasicSpellEvent entity_event;
    private BasicSpellEvent miss_event;
    public Linear(int start_tick, int duration, int frequency, double distance, double distance_between_points, ParticleEffect particle) {
        super(start_tick, duration, particle);
        this.distance = distance;
        this.distance_between_points = distance_between_points;
        this.ticks = frequency;
    }

    public Linear(int start_tick, int duration, int frequency, double distance, double distance_between_points, ParticleEffect particle, BasicSpellEvent block_impact, BasicSpellEvent entity_impact, BasicSpellEvent miss_event) {
        super(start_tick, duration, particle);
        this.distance = distance;
        this.distance_between_points = distance_between_points;
        this.ticks = frequency;
        this.block_event = block_impact;
        this.entity_event = entity_impact;
        this.miss_event = miss_event;
    }

    @Override
    public boolean tick() {
        if (workable_ticks <= 0) {
            createLine(target.getPos(), PlayerUtils.getTargetBlockPos((ServerPlayerEntity) target.getOwner(), distance, block_event, entity_event, miss_event), distance_between_points);
            workable_ticks = ticks;
        } else {
            workable_ticks--;
        }
        return super.tick();
    }

    private void createLine(Vec3d start, Vec3d destination, double distanceBetweenPoints) {
        Vec3d direction = destination.subtract(start).normalize();
        double totalDistance = start.distanceTo(destination);

        for (double distance = 0.0; distance < totalDistance; distance += distanceBetweenPoints) {
            Vec3d point = start.add(direction.multiply(distance));
            createParticle(point.x, point.y, point.z, 1, 0);
        }
    }
}
