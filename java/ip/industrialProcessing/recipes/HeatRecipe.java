package ip.industrialProcessing.recipes;

public class HeatRecipe extends Recipe implements IHeatRecipe {

    public float heatRequired;

    @Override
    public float getHeatRequired() { 
	return heatRequired;
    }

}
