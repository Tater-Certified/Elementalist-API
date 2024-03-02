package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.events.time.KillTargetEntity;
import com.github.tatercertified.elementalistapi.util.EntityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.List;

public class BasicOffensiveSpell extends BasicStaticSpell {

    private final int searchRadius;
    private final Class<? extends net.minecraft.entity.Entity> entityType;
    private final StatusEffectInstance effect;

    /**
     * Basic spell for giving effects to nearby Entities
     *
     * @param level    level of spell
     * @param cooldown cooldown in ticks
     * @param name     name of the spell
     * @param searchRadius the radius in blocks that the game searches for entities
     * @param entityType the type of entity to search for
     * @param effect the type of effect to apply
     */
    public BasicOffensiveSpell(int level, int cooldown, String name, int searchRadius, Class<? extends net.minecraft.entity.Entity> entityType, StatusEffectInstance effect) {
        super(level, cooldown, name);
        this.searchRadius = searchRadius;
        this.entityType = entityType;
        this.effect = effect;
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        List<? extends Entity> list = EntityUtils.quickGrabNearEntities(user, user.getBlockPos(), this.searchRadius, this.entityType, false);

        for (Entity entity : list) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setStatusEffect(this.effect, user);
            }
        }

        super.onCast(user, world);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new KillTargetEntity(this.cooldown, 0));
    }
}