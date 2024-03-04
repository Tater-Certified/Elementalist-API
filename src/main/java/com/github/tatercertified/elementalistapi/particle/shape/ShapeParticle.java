package com.github.tatercertified.elementalistapi.particle.shape;

import com.github.tatercertified.elementalistapi.particle.functions.Single;
import com.github.tatercertified.elementalistapi.util.shape_iterator.ShapeIterator;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;

public class ShapeParticle extends Single {

    private final ShapeIterator shapeIterator;

    public ShapeParticle(int start_tick, int duration, ParticleEffect particle, ShapeIterator shapeIterator) {
        super(start_tick, duration, particle);
        this.shapeIterator = shapeIterator;
    }

    @Override
    public boolean tick(Entity user) {

        this.shapeIterator.setCenterPos(this.getReferencePosition());

        while (this.shapeIterator.hasNext()) {
            Vec3d vec3d = this.shapeIterator.next();
            this.createParticle(vec3d.x, vec3d.y, vec3d.z, user, 1, 0);
        }

        return super.tick(user);
    }
}
