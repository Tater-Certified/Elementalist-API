package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.util.ServerPlayerEntityAccessor;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BasicSpell {

    protected int level;
    protected int cooldown;
    public int active_cooldown;
    public boolean usable;
    protected String name;
    public ArrayList<BasicParticle> particleEffects;

    /**
     * Basic spell for all other spell types
     * @param level level of spell
     * @param cooldown cooldown in ticks
     * @param name name of the spell
     * @param particleEffects optional particle effects; set null to disable
     */
    public BasicSpell(int level, int cooldown, String name, ArrayList<BasicParticle> particleEffects) {
        this.level = level;
        this.cooldown = cooldown;
        this.name = name;
        this.particleEffects = particleEffects;
        resetCooldown();
    }

    /**
     * Fires when the wand is clicked
     */
    public void onCast(ServerPlayerEntity user, World world) {
        usable = false;
        ((ServerPlayerEntityAccessor)user).used_spells().add(this);
    }

    /**
     * Resets cooldown to default
     */
    public void resetCooldown() {
        this.active_cooldown = cooldown;
        this.usable = true;
    }

    /**
     * Returns the name of the spell
     * @return Returns spell name as a String
     */
    public String getSpellName() {
        return name;
    }

    /**
     * Returns the cooldown of the spell
     * @return Returns spell cooldown as int
     */
    public int getCooldown() {
        return cooldown;
    }
}
