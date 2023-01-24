package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.particle.trail.BasicTrail;
import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import com.github.tatercertified.elementalistapi.summoner.Summoner;
import net.minecraft.particle.ParticleTypes;

import java.util.ArrayList;

public class Wand extends Summoner {

    public static ArrayList<BasicSpell> spells = new ArrayList<>();
    public Wand(Settings settings) {
        super(settings);
    }

    @Override
    public ArrayList<BasicSpell> addSpells() {
        spells.add(new Spell1(1, 80, "Basic Spell 1", null));
        spells.add(new Spell2(2, 200, "Projectile Spell 1", 10, 0.6F, null));
        spells.add(new Spell3(3, 300, "Rapid Fire Spell 1", 10, 0.6F, 60, 2, null));
        spells.add(new Spell4(3, 200, "Explosive Spell 1", 30, 0.6F, null));
        ArrayList<BasicParticle> testParticleSpell = new ArrayList<>();
        testParticleSpell.add(new BasicTrail(0, 800, ParticleTypes.CAMPFIRE_SIGNAL_SMOKE));
        spells.add(new TestParticleSpell(3, 150, "ParticleTestSpell", 30, 0.6F, testParticleSpell));
        return spells;
    }
}
