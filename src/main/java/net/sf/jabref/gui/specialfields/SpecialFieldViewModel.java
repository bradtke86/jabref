package net.sf.jabref.gui.specialfields;

import java.util.Objects;

import javax.swing.Icon;

import net.sf.jabref.gui.IconTheme;
import net.sf.jabref.gui.JabRefFrame;
import net.sf.jabref.logic.l10n.Localization;
import net.sf.jabref.model.entry.specialfields.SpecialField;
import net.sf.jabref.model.entry.specialfields.SpecialFieldValue;


public class SpecialFieldViewModel {

    private final SpecialField field;

    public SpecialFieldViewModel(SpecialField field){
        Objects.requireNonNull(field);
        this.field = field;
    }

    public SpecialFieldAction getSpecialFieldAction(SpecialFieldValue value, JabRefFrame frame){
        return new SpecialFieldAction(frame, field, value.getFieldValue().orElse(null),
                // if field contains only one value, it has to be nulled
                // otherwise, another setting does not empty the field
                field.getValues().size() == 1,
                Localization.lang(field.getLocalizationKey()));
    }

    public Icon getRepresentingIcon() {
        switch (field) {
            case PRINTED:
                return IconTheme.JabRefIcon.PRINTED.getSmallIcon();
            case PRIORITY:
                return IconTheme.JabRefIcon.PRIORITY.getSmallIcon();
            case QUALITY:
                return IconTheme.JabRefIcon.QUALITY.getSmallIcon();
            case RANK:
                return IconTheme.JabRefIcon.RANKING.getIcon();
            case READ_STATUS:
                return IconTheme.JabRefIcon.READ_STATUS.getSmallIcon();
            case RELEVANCE:
                return IconTheme.JabRefIcon.RELEVANCE.getSmallIcon();
            default:
                throw new IllegalArgumentException("There is no icon mapping for special field " + field);
        }
    }
}
