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
package mage.cards.r;

import java.util.UUID;
import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.effects.keyword.ScryEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.game.permanent.token.Token;

/**
 *
 * @author LevelX2
 */
public class RiseOfEagles extends CardImpl {

    public RiseOfEagles(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{4}{U}{U}");


        // Put two 2/2 blue Bird enchantment creature tokens with flying onto the battlefield. Scry 1.
        this.getSpellAbility().addEffect(new CreateTokenEffect(new RiseOfEaglesBirdToken(), 2));
        this.getSpellAbility().addEffect(new ScryEffect(1));
    }

    public RiseOfEagles(final RiseOfEagles card) {
        super(card);
    }

    @Override
    public RiseOfEagles copy() {
        return new RiseOfEagles(this);
    }
}

class RiseOfEaglesBirdToken extends Token {

    public RiseOfEaglesBirdToken() {
        super("Bird", "2/2 blue Bird enchantment creature tokens with flying");
        this.setOriginalExpansionSetCode("BNG");
        this.setTokenType(2);
        cardType.add(CardType.ENCHANTMENT);
        cardType.add(CardType.CREATURE);
        color.setColor(ObjectColor.BLUE);
        subtype.add("Bird");
        power = new MageInt(2);
        toughness = new MageInt(2);
        addAbility(FlyingAbility.getInstance());
    }
}
