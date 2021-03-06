package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.SetType;

import java.util.GregorianCalendar;
import mage.constants.Rarity;
import java.util.List;
import mage.ObjectColor;
import mage.cards.CardGraphicInfo;
import mage.cards.FrameStyle;

/**
 *
 * @author magenoxx
 */
public class Unhinged extends ExpansionSet {
    private static final Unhinged fINSTANCE = new Unhinged();

    public static Unhinged getInstance() {
        return fINSTANCE;
    }

    private Unhinged() {
        super("Unhinged", "UNH", "mage.sets.unhinged", new GregorianCalendar(2004, 11, 20).getTime(), SetType.JOKESET);
        cards.add(new SetCardInfo("Forest", 140, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(FrameStyle.UNH_FULL_ART_BASIC, false)));
        cards.add(new SetCardInfo("Island", 137, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(FrameStyle.UNH_FULL_ART_BASIC, false)));
        cards.add(new SetCardInfo("Mountain", 139, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(FrameStyle.UNH_FULL_ART_BASIC, false)));
        cards.add(new SetCardInfo("Plains", 136, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(FrameStyle.UNH_FULL_ART_BASIC, false)));
        cards.add(new SetCardInfo("Swamp", 138, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(FrameStyle.UNH_FULL_ART_BASIC, false)));
    }
}
