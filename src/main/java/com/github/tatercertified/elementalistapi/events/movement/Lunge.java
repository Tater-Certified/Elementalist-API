package com.github.tatercertified.elementalistapi.events.movement;

import com.github.tatercertified.elementalistapi.util.EntityUtils;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class Lunge {

    protected ServerPlayerEntity user;
    protected double lift_multiplier;
    public Lunge(ServerPlayerEntity user, double lift_multiplier) {
        this.user = user;
        this.lift_multiplier = lift_multiplier;
        ServerPlayerEntity enemy = findClosestEntity();
        if (enemy != null) {
            System.out.println(calcVelocity(enemy));
            user.setVelocity(calcVelocity(enemy));
            user.velocityModified = true;
        } else {
            System.out.println(calcVelocity());
            user.setVelocity(calcVelocity());
            user.velocityModified = true;
        }
    }

    private Vec3d calcVelocity(ServerPlayerEntity enemy) {
        return new Vec3d((enemy.getX() - user.getX()), enemy.getY() - user.getY() + lift_multiplier, (enemy.getZ() - user.getZ()));
    }

    private Vec3d calcVelocity() {
        float f = -MathHelper.sin(user.getYaw() * 0.17453292F) * MathHelper.cos(user.getPitch() * 0.17453292F);
        float g = -MathHelper.sin((float) (user.getPitch() * lift_multiplier * 0.17453292F));
        float h = MathHelper.cos(user.getYaw() * 0.17453292F) * MathHelper.cos(user.getPitch() * 0.17453292F);
        return new Vec3d(f, g, h);
    }

    private ServerPlayerEntity findClosestEntity() {
        List<ServerPlayerEntity> players = (List<ServerPlayerEntity>) EntityUtils.quickGrabNearEntities(user, user.getBlockPos(), 200, ServerPlayerEntity.class);
        ServerPlayerEntity nearest = null;
        double distance = 0;
        for (ServerPlayerEntity player : players) {
            double distance1 = player.distanceTo(user);
            if (nearest == null || distance1 < distance) {
                nearest = player;
                distance = distance1;
            }
        }
        return nearest;
    }
}
