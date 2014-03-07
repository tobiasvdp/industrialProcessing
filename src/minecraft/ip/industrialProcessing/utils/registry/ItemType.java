package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.utils.Language;

public enum ItemType {
    item, damage, fluid, paintbrush, tool, weapon, ingot, food, dyes, vanilla, ore;

    public String getDisplayName() {
        String unlocalized = "IP.BlockType." + this.toString();
        String localized = Language.getLocalizedString(unlocalized);

        if (localized.equals(unlocalized))
            return "§4§m" + this.toString().toUpperCase() + "§r";
        return localized;
    }
}
