/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.starwars;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.RestrictionEffect;
import mage.abilities.keyword.MonstrosityAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 *
 * @author Styxo
 */
public class MantellianSavrip extends CardImpl {

    public MantellianSavrip(UUID ownerId) {
        super(ownerId, 145, "Mantellian Savrip", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{3}{G}{G}");
        this.expansionSetCode = "SWS";
        this.subtype.add("Mantellian");
        this.subtype.add("Berserker");
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // {5}{G}{G}: Monstrosity 3.
        this.addAbility(new MonstrosityAbility("{5}{G}{G}", 3));

        // Creatures with power less than Mantellian Savrip's power can't block it.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new MantellianSavripRestrictionEffect()));

    }

    public MantellianSavrip(final MantellianSavrip card) {
        super(card);
    }

    @Override
    public MantellianSavrip copy() {
        return new MantellianSavrip(this);
    }
}

class MantellianSavripRestrictionEffect extends RestrictionEffect {

    public MantellianSavripRestrictionEffect() {
        super(Duration.WhileOnBattlefield);
        staticText = "Creatures with power less than {this}'s power can't block it";
    }

    public MantellianSavripRestrictionEffect(final MantellianSavripRestrictionEffect effect) {
        super(effect);
    }

    @Override
    public boolean applies(Permanent permanent, Ability source, Game game) {
        return permanent.getId().equals(source.getSourceId());
    }

    @Override
    public boolean canBeBlocked(Permanent attacker, Permanent blocker, Ability source, Game game) {
        return (blocker.getPower().getValue() >= attacker.getPower().getValue());
    }

    @Override
    public MantellianSavripRestrictionEffect copy() {
        return new MantellianSavripRestrictionEffect(this);
    }
}
