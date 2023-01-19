package com.github.tatercertified.elementalistapi.mixin;

import com.github.tatercertified.elementalistapi.spell.BasicRapidFireSpell;
import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import com.github.tatercertified.elementalistapi.summoner.Summoner;
import com.github.tatercertified.elementalistapi.util.ServerPlayerEntityAccessor;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.ListIterator;


@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity implements ServerPlayerEntityAccessor {

    @Shadow public abstract void sendMessage(Text message);
    public ArrayList<BasicSpell> spells = new ArrayList<>();
    public ArrayList<BasicRapidFireSpell> delay = new ArrayList<>();

    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        tickCooldowns();
        tickRapidFireDelays();
        tickSpellHUD();
    }

    @Override
    public ArrayList<BasicSpell> used_spells() {
        return spells;
    }

    @Override
    public ArrayList<BasicRapidFireSpell> spell_delays() {
        return delay;
    }

    /**
     * Ticks all active cooldowns
     */
    public void tickCooldowns() {
        if (!spells.isEmpty()) {
            ListIterator<BasicSpell> iterator = spells.listIterator();
            while (iterator.hasNext()) {
                BasicSpell spell = iterator.next();
                if(spell.active_cooldown != 0) {
                    spell.active_cooldown--;
                } else {
                    spell.resetCooldown();
                    iterator.remove();
                }
            }
        }
    }

    /**
     * Ticks all active rapid fire spell delays
     */
    public void tickRapidFireDelays() {
        if (!delay.isEmpty()) {
            ListIterator<BasicRapidFireSpell> iterator = delay.listIterator();
            while (iterator.hasNext()) {
                BasicRapidFireSpell spell = iterator.next();
                if(spell.active_fire_delay != 0) {
                    spell.active_fire_delay--;
                } else {
                    spell.resetFireDelay();
                    if (!spell.launchNewTargetEntity(((ServerPlayerEntity)(Object)this), world)) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    /**
     * Ticks the visual HUD above the hotbar
     */
    public void tickSpellHUD() {
        Item holding = this.getMainHandStack().getItem();
        if (holding instanceof Summoner) {
            BasicSpell current_spell = ((Summoner) holding).current_spell;
            String cooldown =  " | " + current_spell.active_cooldown;
            if (cooldown.equals(" | " + current_spell.getCooldown())) {
                cooldown = "";
            }
            this.sendMessage(Text.literal(current_spell.getSpellName() + cooldown), true);
        }
    }
}
