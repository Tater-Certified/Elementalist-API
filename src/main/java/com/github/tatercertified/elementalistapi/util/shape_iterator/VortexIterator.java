package com.github.tatercertified.elementalistapi.util.shape_iterator;

import net.minecraft.util.math.Vec3d;

import java.util.Iterator;

public class VortexIterator implements Iterator<Vec3d>, ShapeIterator {
    private final double radius;
    private final int totalPoints;
    private Vec3d centerPos;
    private int currentPoint;

    public VortexIterator(double radius, int totalPoints) {
        this.radius = radius;
        this.totalPoints = totalPoints;
        this.currentPoint = 0;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = currentPoint < totalPoints;

        if (!hasNext) {
            this.currentPoint = 0;
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
            double phi = Math.acos(1 - 2.0 * currentPoint / totalPoints); // Polar angle
            double theta = Math.sqrt(totalPoints * Math.PI) * 2.0 * Math.PI * currentPoint / totalPoints; // Azimuthal angle

            double x = centerPos.x + radius * Math.sin(phi) * Math.cos(theta);
            double y = centerPos.y + radius * Math.sin(phi) * Math.sin(theta);
            double z = centerPos.z + radius * Math.cos(phi);

            currentPoint++;

            return new Vec3d(x, y, z);
        }
        return null;
    }
}
