package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import com.github.tatercertified.elementalistapi.summoner.Summoner;

import java.util.ArrayList;

public class Wand extends Summoner {

    public static ArrayList<BasicSpell> spells = new ArrayList<>();
    public Wand(Settings settings) {
        super(settings);
    }

    @Override
    public ArrayList<BasicSpell> addSpells() {
        spells.add(new Spell1(1, 80, "Basic Spell 1"));
        spells.add(new Spell2(2, 200, "Projectile Spell 1", 10, 0.6F));
        spells.add(new Spell3(3, 300, "Rapid Fire Spell 1", 10, 0.6F, 60, 2));
        return spells;
    }
}
