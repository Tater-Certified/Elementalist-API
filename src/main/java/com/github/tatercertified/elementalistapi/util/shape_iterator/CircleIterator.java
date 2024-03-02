package com.github.tatercertified.elementalistapi.util.shape_iterator;

import net.minecraft.util.math.Vec3d;

import java.util.Iterator;

public class CircleIterator implements Iterator<Vec3d>, ShapeIterator {

    private final double radius;
    private final int totalPoints;
    private Vec3d centerPos;
    private int currentPoint;

    public CircleIterator(double radius, int totalPoints) {
        this.radius = radius;
        this.totalPoints = totalPoints;
        this.currentPoint = 0;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = this.currentPoint < this.totalPoints;

        if (!hasNext) {
            this.currentPoint = 0;
        }

        return hasNext;
    }

    /**
     * Sets the center point of the circle
     * @param centerPos Vec3D of the center
     */
    @Override
    public void setCenterPos(Vec3d centerPos) {
        this.centerPos = centerPos;
    }

    @Override
    public Vec3d next() {

        if (this.hasNext() && centerPos != null) {
            double angle = 2.0 * Math.PI * currentPoint / this.totalPoints;
            double x = this.centerPos.x + radius * Math.cos(angle);
            double z = this.centerPos.z + radius * Math.sin(angle);

            currentPoint++;

            return new Vec3d(x, this.centerPos.y, z);
        }
        return null;
    }
}
