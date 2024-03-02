package com.github.tatercertified.elementalistapi.util.shape_iterator;

import net.minecraft.util.math.Vec3d;

import java.util.Iterator;

public class SphereIterator implements Iterator<Vec3d>, ShapeIterator {
    private final double radius;
    private final int totalPoints;
    private Vec3d centerPos;
    private int currentPoint;
    private int currentPointHorizontal;

    public SphereIterator(double radius, int totalPoints) {
        this.radius = radius;
        this.totalPoints = totalPoints;
        this.currentPoint = 0;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = currentPoint < totalPoints;

        if (!hasNext) {
            this.currentPoint = 0;
            this.currentPointHorizontal = 0;
        }

        return hasNext;
    }

    /**
     * Sets the center point of the sphere
     * @param centerPos Vec3D of the center
     */
    @Override
    public void setCenterPos(Vec3d centerPos) {
        this.centerPos = centerPos;
    }

    @Override
    public Vec3d next() {
        if (hasNext() && centerPos != null) {
            double angleVertical = 2.0 * Math.PI * currentPoint / totalPoints;
            double x = centerPos.x + radius * Math.cos(angleVertical);
            double y = centerPos.y + radius * Math.sin(angleVertical);

            // Rotate the point around the y-axis
            double angleHorizontal = 2.0 * Math.PI * currentPointHorizontal / 6;

            double newX = x * Math.cos(angleHorizontal) + centerPos.z * Math.sin(angleHorizontal);
            double newZ = -x * Math.sin(angleHorizontal) + centerPos.z * Math.cos(angleHorizontal);

            if (currentPointHorizontal < 6 - 1) {
                currentPointHorizontal++;
            } else {
                currentPointHorizontal = 0;
                currentPoint++;
            }

            return new Vec3d(newX, y, newZ);
        }
        return null;
    }
}
