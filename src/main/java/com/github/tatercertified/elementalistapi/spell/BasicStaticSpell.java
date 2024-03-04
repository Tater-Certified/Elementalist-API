package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.events.time.KillTargetEntity;
import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BasicStaticSpell extends BasicSpell {

    public Vec3d pos;

    /**
     * Basic spell for stationary Spells
     *
     * @param level    level of spell
     * @param cooldown cooldown in ticks
     * @param name     name of the spell
     */
    public BasicStaticSpell(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    /**
     * Basic spell for stationary Spells
     *
     * @param level    level of spell
     * @param cooldown cooldown in ticks
     * @param name     name of the spell
     * @param pos      position of the spell
     */
    public BasicStaticSpell(int level, int cooldown, String name, Vec3d pos) {
        super(level, cooldown, name);
        this.pos = pos;
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        if (pos == null) {
            this.pos = user.getPos();
        }
        super.onCast(user, world);
    }

    @Override
    public void addEvents() {
        events.add(new KillTargetEntity(this.cooldown, 1));
    }
}
