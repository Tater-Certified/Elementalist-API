package com.github.tatercertified.elementalistapi.mixin;

import com.github.tatercertified.elementalistapi.util.StatusEffectInstanceInterface;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(StatusEffectInstance.class)
public class StatusEffectInstanceMixin implements StatusEffectInstanceInterface {

    @Shadow @Final private StatusEffect type;

    @Shadow private int duration;

    @Shadow private int amplifier;

    @Shadow private boolean ambient;

    @Shadow private boolean showIcon;

    @Override
    public StatusEffectInstance copy() {
        return new StatusEffectInstance(this.type, this.duration, this.amplifier, this.ambient, this.showIcon);
    }
}
