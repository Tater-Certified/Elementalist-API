package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.util.ServerPlayerEntityAccessor;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class BasicSpell {

    protected int level;
    protected int cooldown;
    public int active_cooldown;
    public boolean usable;
    protected String name;

    public BasicSpell(int level, int cooldown, String name) {
        this.level = level;
        this.cooldown = cooldown;
        this.name = name;
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
