package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.util.ServerPlayerEntityAccessor;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BasicRapidFireSpell extends BasicProjectileSpell{

    protected int count;
    public int active_count;
    protected int fire_delay;
    public int active_fire_delay;

    public BasicRapidFireSpell(int level, int cooldown, String name, double distance, float speed, int count, int fire_delay, ArrayList<BasicParticle> particleEffects) {
        super(level, cooldown, name, distance, speed, particleEffects);
        this.count = count;
        this.fire_delay = fire_delay;
        this.active_fire_delay = fire_delay;
        this.active_count = count;
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        super.onCast(user, world);
        ((ServerPlayerEntityAccessor)user).spell_delays().add(this);
        active_count--;
    }

    /**
     * Resets the fire delay
     */
    public void resetFireDelay() {
        this.active_fire_delay = fire_delay;
    }

    /**
     * Launches a new Target Entity
     * @param user Entity using the summoner
     * @param world user's world
     * @return If the launch attempt was successful
     */
    public boolean launchNewTargetEntity(ServerPlayerEntity user, World world) {
        if (active_count != 0) {
            active_count--;
            launchProjectile(user, world);
            return true;
        }
        active_count = count;
        return false;
    }
}
