package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.events.BasicDelayedSpellEvent;
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
    private int uses;

    public ArrayList<BasicDelayedSpellEvent> events = new ArrayList<>();

    /**
     * Basic spell for all other spell types
     * @param level level of spell
     * @param cooldown cooldown in ticks
     * @param name name of the spell
     */
    public BasicSpell(int level, int cooldown, String name) {
        this.level = level;
        this.cooldown = cooldown;
        this.name = name;
        resetCooldown();
        addEvents();
    }

    /**
     * Fires when the wand is clicked
     */
    public void onCast(ServerPlayerEntity user, World world) {
        usable = false;
        ((ServerPlayerEntityAccessor)user).used_spells().add(this);
    }

    /**
     * Is called when the cooldown is active, but the user is trying to use the item
     */
    public void onClickDuringCooldown(ServerPlayerEntity user, World world) {
        this.uses++;
    }

    /**
     * Resets cooldown to default
     */
    public void resetCooldown() {
        this.active_cooldown = cooldown;
        this.uses = 0;
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

    /**
     * Returns the amount of uses during cooldown
     * @return Integer of uses
     */
    public int getUses() {
        return this.uses;
    }

    /**
     * @return Returns all BasicSpellEvents in a Spell
     */
    public ArrayList<BasicDelayedSpellEvent> listEvents() {
        return events;
    }

    /**
     * Adds BasicSpellEvents to events ArrayList
     */
    public void addEvents() {
        //Add Events here
    }
}
