package net.sf.jabref.logic.specialfields;

import java.util.Objects;

import net.sf.jabref.logic.l10n.Localization;
import net.sf.jabref.model.entry.SpecialFieldValue;

public class SpecialFieldLocalization {

    // this is just to satisfy our own localization tests, since they will not detect if a variable is passed into Localization.lang()
    static {
        Localization.lang("Printed");
        Localization.lang("Priority");
        Localization.lang("Quality");
        Localization.lang("Rank");
        Localization.lang("Read status");
        Localization.lang("Relevance");
    }

    public static String getMenuString(SpecialFieldValue value) {
        Objects.requireNonNull(value.getActionName());

        switch(value.getActionName()){
            case "togglePrinted":
                return Localization.lang("Toggle print status");
            case "clearPriority":
                return Localization.lang("Clear priority");
            case "setPriority1":
                return Localization.lang("Set priority to high");
            case "setPriority2":
                return Localization.lang("Set priority to medium");
            case "setPriority3":
                return Localization.lang("Set priority to low");
            case "qualityAssured":
                return Localization.lang("Toggle quality assured");
            case "clearRank":
                return Localization.lang("Clear rank");
            case "clearReadStatus":
                return Localization.lang("Clear read status");
            case "setReadStatusToRead":
                return Localization.lang("Set read status to read");
            case "setReadStatusToSkimmed":
                return Localization.lang("Set read status to skimmed");
            case "toggleRelevance":
                return Localization.lang("Toggle relevance");
            default:
                return "";
        }
    }
}
