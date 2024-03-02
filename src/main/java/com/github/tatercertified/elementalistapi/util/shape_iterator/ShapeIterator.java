package com.github.tatercertified.elementalistapi.util.shape_iterator;

import net.minecraft.util.math.Vec3d;

public interface ShapeIterator {
    void setCenterPos(Vec3d centerPos);
    boolean hasNext();
    Vec3d next();
}
