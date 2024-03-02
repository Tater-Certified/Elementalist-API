package com.github.tatercertified.elementalistapi.util.shape_iterator;

import net.minecraft.util.math.Vec3d;

import java.util.Iterator;

public class CubeIterator implements Iterator<Vec3d>, ShapeIterator {

    private final double sideLength;
    private final int totalPoints;
    private Vec3d centerPos;
    private int currentPoint;

    public CubeIterator(double sideLength, int totalPoints) {
        this.sideLength = sideLength;
        this.totalPoints = totalPoints;
        this.currentPoint = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPoint < totalPoints;
    }

    /**
     * Sets the center point of the cube
     * @param centerPos Vec3D of the center
     */
    public void setCenterPos(Vec3d centerPos) {
        this.centerPos = centerPos;
    }

    @Override
    public Vec3d next() {
        if (hasNext() && centerPos != null) {
            int face = currentPoint / (totalPoints / 6); // Determine the current face
            double relativePoint = currentPoint % (totalPoints / 6f) * (2.0 / totalPoints); // Point within the current face

            double x = centerPos.x;
            double y = centerPos.y;
            double z = centerPos.z;

            switch (face) {
                case 0 -> { // Front face
                    x += sideLength / 2;
                    y += sideLength / 2 - sideLength * relativePoint;
                    z += sideLength / 2;
                }
                case 1 -> { // Right face
                    x += sideLength / 2;
                    y += sideLength / 2;
                    z += sideLength / 2 - sideLength * relativePoint;
                }
                case 2 -> { // Back face
                    x += sideLength / 2 - sideLength * relativePoint;
                    y += sideLength / 2;
                    z -= sideLength / 2;
                }
                case 3 -> { // Left face
                    x -= sideLength / 2;
                    y += sideLength / 2 - sideLength * relativePoint;
                    z -= sideLength / 2;
                }
                case 4 -> { // Top face
                    x += sideLength / 2 - sideLength * relativePoint;
                    y += sideLength / 2;
                    z += sideLength / 2;
                }
                case 5 -> { // Bottom face
                    x += sideLength / 2 - sideLength * relativePoint;
                    y -= sideLength / 2;
                    z += sideLength / 2;
                }
            }

            currentPoint++;

            return new Vec3d(x, y, z);
        }
        return null;
    }
}
