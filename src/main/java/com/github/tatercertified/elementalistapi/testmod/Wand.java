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
        spells.add(new Spell1(1, 80, "Spell 1"));
        spells.add(new Spell2(2, 200, "Spell 2", 10, 0.6F));
        spells.add(new Spell2(3, 300, "Spell 3", 10, 0.6F));
        return spells;
    }
}
