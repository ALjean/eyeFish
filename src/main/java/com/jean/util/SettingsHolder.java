package com.jean.util;

import java.util.HashMap;
import java.util.Map;

import com.jean.enums.ParamNames;

public class SettingsHolder {

    private static String COLOR_DESCRIPTION_BRIGHT = "eye.fish.bait.color.description.brihgt";
    private static String COLOR_DESCRIPTION_WHITE = "eye.fish.bait.color.description.white";
    private static String COLOR_DESCRIPTION_NATURAL = "eye.fish.bait.color.description.natural";
    private static String COLOR_DESCRIPTION_DARK = "eye.fish.bait.color.description.dark";

    private static String TASTE_DESCRIPTION_MEAT = "eye.fish.bait.taste.description.meat";
    private static String TASTE_DESCRIPTION_SPICY = "eye.fish.bait.taste.description.spicy";
    private static String TASTE_DESCRIPTION_FRUIT = "eye.fish.bait.taste.description.fruit";

/*    private static String SPEED_DESCRIPTION_ULTRAFAST;
    private static String SPEED_DESCRIPTION_FAST;
    private static String SPEED_DESCRIPTION_MEDIUM;
    private static String SPEED_DESCRIPTION_SLOW;

    private static String WEIGHT_DESCRIPTION_ULTRALIGHT;
    private static String WEIGHT_DESCRIPTION_LIGHT;
    private static String WEIGHT_DESCRIPTION_MEDIUM;
    private static String WEIGHT_DESCRIPTION_HEAVY;

    private static String DEEP_DESCRIPTION_POP_UP;
    private static String DEEP_DESCRIPTION_TOP;
    private static String DEEP_DESCRIPTION_MIDDLE;
    private static String DEEP_DESCRIPTION_BOTTOM;*/

    private Map<BaitSetting, Qualifier> baitColors;
    private Map<BaitSetting, Qualifier> baitTaste;

    public SettingsHolder(Map<BaitSetting, Qualifier> baitColors, Map<BaitSetting, Qualifier> baitTaste) {

	this.baitColors = new HashMap<BaitSetting, Qualifier>();

	baitColors.put(new BaitSetting("Bright color", System.getProperty(COLOR_DESCRIPTION_BRIGHT)),
		new Qualifier(new ParameterName(ParamNames.CLOUD_LEVEL.name(), 3), 75, 100));
	baitColors.put(new BaitSetting("White color", System.getProperty(COLOR_DESCRIPTION_WHITE)),
		new Qualifier(new ParameterName(ParamNames.CLOUD_LEVEL.name(), 3), 45, 74));
	baitColors.put(new BaitSetting("Natural color", System.getProperty(COLOR_DESCRIPTION_NATURAL)),
		new Qualifier(new ParameterName(ParamNames.CLOUD_LEVEL.name(), 3), 25, 44));
	baitColors.put(new BaitSetting("Dark color", System.getProperty(COLOR_DESCRIPTION_DARK)),
		new Qualifier(new ParameterName(ParamNames.CLOUD_LEVEL.name(), 3), 0, 24));
	
	baitColors.put(new BaitSetting("Bright color", System.getProperty(COLOR_DESCRIPTION_BRIGHT)),
		new Qualifier(new ParameterName(ParamNames.DEEP_LEVEL.name(), 1), 4.5, 100));
	baitColors.put(new BaitSetting("White color", System.getProperty(COLOR_DESCRIPTION_WHITE)),
		new Qualifier(new ParameterName(ParamNames.CLOUD_LEVEL.name(), 10), 45, 74));
	baitColors.put(new BaitSetting("Natural color", System.getProperty(COLOR_DESCRIPTION_NATURAL)),
		new Qualifier(new ParameterName(ParamNames.CLOUD_LEVEL.name(), 10), 25, 44));
	baitColors.put(new BaitSetting("Dark color", System.getProperty(COLOR_DESCRIPTION_DARK)),
		new Qualifier(new ParameterName(ParamNames.CLOUD_LEVEL.name(), 10), 0, 24));

	this.baitTaste = new HashMap<BaitSetting, Qualifier>();

	baitTaste.put(new BaitSetting("Meat taste", System.getProperty(TASTE_DESCRIPTION_MEAT)),
		new Qualifier(new ParameterName(ParamNames.ENVIRONMENT_TEMPERATURE.name(), 70), 0, 16));
	baitTaste.put(new BaitSetting("Spicy taste", System.getProperty(TASTE_DESCRIPTION_SPICY)),
		new Qualifier(new ParameterName(ParamNames.ENVIRONMENT_TEMPERATURE.name(), 70), 16, 23));
	baitTaste.put(new BaitSetting("Fuit taste", System.getProperty(TASTE_DESCRIPTION_FRUIT)),
		new Qualifier(new ParameterName(ParamNames.ENVIRONMENT_TEMPERATURE.name(), 70), 23, 45));
	
	baitTaste.put(new BaitSetting("Meat taste", System.getProperty(TASTE_DESCRIPTION_MEAT)),
		new Qualifier(new ParameterName(ParamNames.WATER_TEMPERATURE.name(), 90), 0, 16));
	baitTaste.put(new BaitSetting("Spicy taste", System.getProperty(TASTE_DESCRIPTION_SPICY)),
		new Qualifier(new ParameterName(ParamNames.WATER_TEMPERATURE.name(), 90), 16, 23));
	baitTaste.put(new BaitSetting("Fuit taste", System.getProperty(TASTE_DESCRIPTION_FRUIT)),
		new Qualifier(new ParameterName(ParamNames.WATER_TEMPERATURE.name(), 90), 23, 38));

    }

    public Map<BaitSetting, Qualifier> getBaitColors() {
        return baitColors;
    }

    public void setBaitColors(Map<BaitSetting, Qualifier> baitColors) {
        this.baitColors = baitColors;
    }

    public Map<BaitSetting, Qualifier> getBaitTaste() {
        return baitTaste;
    }

    public void setBaitTaste(Map<BaitSetting, Qualifier> baitTaste) {
        this.baitTaste = baitTaste;
    }
    
    

}
