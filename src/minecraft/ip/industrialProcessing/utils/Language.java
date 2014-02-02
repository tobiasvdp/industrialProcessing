package ip.industrialProcessing.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class Language {
    public static String getLocalizedString(String unlocalized) {
	LanguageRegistry registry = LanguageRegistry.instance();
	String localized = registry.getStringLocalization(unlocalized);
	if (localized == null || localized.isEmpty()) {
	    localized = registry.getStringLocalization(unlocalized, "en_US");

	    if (localized == null || localized.isEmpty())
		return unlocalized;
	    return localized;
	} else
	    return localized;
    }
}
