package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.events.movement.Follow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class BasicFollowSpell extends BasicStaticSpell{
    public LivingEntity target;
    /**
     * Basic spell for following Spells
     *
     * @param level      level of spell
     * @param cooldown   cooldown in ticks
     * @param name       name of the spell
     */
    public BasicFollowSpell(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    /**
     * Basic spell for following Spells
     *
     * @param level      level of spell
     * @param cooldown   cooldown in ticks
     * @param name       name of the spell
     * @param target     target of the spell
     */
    public BasicFollowSpell(int level, int cooldown, String name, LivingEntity target) {
        super(level, cooldown, name);
        this.target = target;
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        if (target == null) {
            this.target = user;
        }
        super.onCast(user, world);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new Follow(0, Integer.MAX_VALUE));
    }
}
