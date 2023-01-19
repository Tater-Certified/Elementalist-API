package com.github.tatercertified.elementalistapi.mixin;

import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public abstract class PersistentProjectileEntityMixin extends ProjectileEntity {

    public PersistentProjectileEntityMixin(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * Makes TargetEntities not have gravity applied
     * @return returns original variable if not a TargetEntity
     */
    @ModifyArg(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;multiply(D)Lnet/minecraft/util/math/Vec3d;"))
    private double inject(double d) {
        if (((Object) this) instanceof TargetEntity) {
            return 1.00f;
        } else {
            return d;
        }
    }

    /**
     * Makes sure to prevent the arrow damaging entities
     */
    @Inject(method = "onEntityHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;ceil(D)I"), cancellable = true)
    private void onEntityHit(EntityHitResult entityHitResult, CallbackInfo ci) {
        if (((Object) this) instanceof TargetEntity) {
            ci.cancel();
        }
    }
}
