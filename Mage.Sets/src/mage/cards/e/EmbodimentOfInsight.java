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
package mage.cards.e;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.LandfallAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.continuous.BecomesCreatureTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityControlledEffect;
import mage.abilities.keyword.HasteAbility;
import mage.abilities.keyword.VigilanceAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterLandPermanent;
import mage.filter.predicate.mageobject.CardTypePredicate;
import mage.filter.predicate.permanent.ControllerPredicate;
import mage.game.permanent.token.Token;
import mage.target.common.TargetLandPermanent;

/**
 *
 * @author fireshoes
 */
public class EmbodimentOfInsight extends CardImpl {

    private static final FilterPermanent filterLandCreatures = new FilterPermanent("Land creatures");
    private static final FilterLandPermanent filterLand = new FilterLandPermanent("land you control");

    static {
        filterLandCreatures.add(new CardTypePredicate(CardType.LAND));
        filterLandCreatures.add(new CardTypePredicate(CardType.CREATURE));
        filterLand.add(new ControllerPredicate(TargetController.YOU));

    }

    public EmbodimentOfInsight(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{4}{G}");
        this.subtype.add("Elemental");
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // Vigilance
        this.addAbility(VigilanceAbility.getInstance());

        // Land creatures you control have vigilance.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new GainAbilityControlledEffect(VigilanceAbility.getInstance(), Duration.WhileOnBattlefield, filterLandCreatures)));

        // <i>Landfall</i> - Whenever a land enters the battlefield under you control, you may have target land you control
        // become a 3/3 Elemental creature with haste until end of turn. It's still a land.
        Ability ability = new LandfallAbility(new BecomesCreatureTargetEffect(new EmbodimentOfInsightToken(), false, true, Duration.EndOfTurn), true);
        ability.addTarget(new TargetLandPermanent(filterLand));
        this.addAbility(ability);
    }

    public EmbodimentOfInsight(final EmbodimentOfInsight card) {
        super(card);
    }

    @Override
    public EmbodimentOfInsight copy() {
        return new EmbodimentOfInsight(this);
    }
}

class EmbodimentOfInsightToken extends Token {

    public EmbodimentOfInsightToken() {
        super("", "3/3 Elemental creature with haste");
        this.cardType.add(CardType.CREATURE);

        this.subtype.add("Elemental");
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);
        this.addAbility(HasteAbility.getInstance());
    }
}
