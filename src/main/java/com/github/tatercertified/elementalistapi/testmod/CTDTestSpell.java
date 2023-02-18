package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.time.KillTargetEntity;
import com.github.tatercertified.elementalistapi.particle.ctdengine.CTDEngine;
import com.github.tatercertified.elementalistapi.spell.BasicStaticSpell;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;

public class CTDTestSpell extends BasicStaticSpell {
    /**
     * Basic spell for stationary Spells
     *
     * @param level    level of spell
     * @param cooldown cooldown in ticks
     * @param name     name of the spell
     */
    public CTDTestSpell(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        ArrayList<Vec3d> points = new ArrayList<>();
        points.add(new Vec3d(0,4,0));
        points.add(new Vec3d(0,4,0));
        points.add(new Vec3d(12,0,0));
        events.add(new CTDEngine(0, 600, ParticleTypes.ELECTRIC_SPARK, points));
        events.add(new KillTargetEntity(601, 0));
    }
}
