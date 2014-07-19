package mod.industrialProcessing.work.recipe.builder;

import java.util.ArrayList;

import mod.industrialProcessing.fluids.FluidIP;
import mod.industrialProcessing.work.recipe.HeatRecipe;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.PoweredHeatRecipe;
import mod.industrialProcessing.work.recipe.PoweredRecipe;
import mod.industrialProcessing.work.recipe.Recipe;
import mod.industrialProcessing.work.recipe.slots.RecipeInputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputFluidSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class RecipeBuilder {
	ArrayList<IMappedBuilder<RecipeInputInventorySlot>> inventoryInputs = new ArrayList<IMappedBuilder<RecipeInputInventorySlot>>();
	ArrayList<IMappedBuilder<RecipeInputFluidSlot>> fluidInputs = new ArrayList<IMappedBuilder<RecipeInputFluidSlot>>();

	ArrayList<IMappedBuilder<RecipeOutputInventorySlot>> inventoryOutputs = new ArrayList<IMappedBuilder<RecipeOutputInventorySlot>>();
	ArrayList<IMappedBuilder<RecipeOutputFluidSlot>> fluidOutputs = new ArrayList<IMappedBuilder<RecipeOutputFluidSlot>>();

	protected int inventorySlot = 0;
	protected int fluidSlot = 0;
	protected int[] inventorySlotMap;
	protected int[] tankSlotMap;
	protected float powerRequired = 0;
	protected float heatRequired;
	protected int workRequired = 100;

	public RecipeBuilder withInventorySlotMap(int[] slotMap) {
		inventorySlotMap = slotMap;
		return this;
	}

	public RecipeBuilder withTankSlotMap(int[] slotMap) {
		tankSlotMap = slotMap;
		return this;
	}

	public RecipeBuilder withPower(float amount) {
		powerRequired = amount;
		return this;
	}

	public RecipeBuilder withHeat(float amount) {
		heatRequired = amount;
		return this;
	}

	public RecipeBuilder withWork(int work) {
		workRequired = work;
		return this;
	}

	public RecipeBuilder withInventoryInput(final int slot, final Item item, final int amount) {
		IMappedBuilder<RecipeInputInventorySlot> mapBuilder = new IMappedBuilder<RecipeInputInventorySlot>() {

			@Override
			public RecipeInputInventorySlot getSlot(int mappedSlot) {
				return new RecipeInputInventorySlot(mappedSlot, item, amount);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		inventoryInputs.add(mapBuilder);
		inventorySlot = slot;
		return this;
	}

	public RecipeBuilder withInventoryInput(final int slot, final ItemStack item) {
		IMappedBuilder<RecipeInputInventorySlot> mapBuilder = new IMappedBuilder<RecipeInputInventorySlot>() {

			@Override
			public RecipeInputInventorySlot getSlot(int mappedSlot) {
				return new RecipeInputInventorySlot(mappedSlot, item);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};
		inventoryInputs.add(mapBuilder);
		inventorySlot = slot;
		return this;
	}

	public RecipeBuilder withInventoryInput(final int slot, final Item item, final int metadata, final int amount) {
		IMappedBuilder<RecipeInputInventorySlot> mapBuilder = new IMappedBuilder<RecipeInputInventorySlot>() {

			@Override
			public RecipeInputInventorySlot getSlot(int mappedSlot) {
				return new RecipeInputInventorySlot(mappedSlot, item, metadata, amount);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		inventoryInputs.add(mapBuilder);
		inventorySlot = slot;
		return this;
	}

	public RecipeBuilder withInventoryInput(final int slot, final Block block, final int metadata, final int amount) {
		IMappedBuilder<RecipeInputInventorySlot> mapBuilder = new IMappedBuilder<RecipeInputInventorySlot>() {

			@Override
			public RecipeInputInventorySlot getSlot(int mappedSlot) {
				return new RecipeInputInventorySlot(mappedSlot, block, metadata, amount);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		inventoryInputs.add(mapBuilder);
		inventorySlot = slot;
		return this;
	}

	public RecipeBuilder withInventoryInput(final int slot, final String oreDictionary, final int amount) {
		IMappedBuilder<RecipeInputInventorySlot> mapBuilder = new IMappedBuilder<RecipeInputInventorySlot>() {

			@Override
			public RecipeInputInventorySlot getSlot(int mappedSlot) {
				return new RecipeInputInventorySlot(mappedSlot, oreDictionary, amount);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		inventoryInputs.add(mapBuilder);
		inventorySlot = slot;
		return this;
	}

	public RecipeBuilder withFluidInput(int slot, FluidIP fluid, int amount) {
		// TODO: fluid ID!
		return withFluidInput(slot, fluid.getFluid(), amount);
	}

	public RecipeBuilder withFluidInput(final int slot, final String fluidDictionary, final int amount) {
		IMappedBuilder<RecipeInputFluidSlot> mapBuilder = new IMappedBuilder<RecipeInputFluidSlot>() {

			@Override
			public RecipeInputFluidSlot getSlot(int mappedSlot) {
				return new RecipeInputFluidSlot(mappedSlot, fluidDictionary, amount);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		fluidInputs.add(mapBuilder);
		fluidSlot = slot;
		return this;
	}

	public RecipeBuilder withFluidInput(final int slot, final Fluid fluid, final int amount) {
		IMappedBuilder<RecipeInputFluidSlot> mapBuilder = new IMappedBuilder<RecipeInputFluidSlot>() {

			@Override
			public RecipeInputFluidSlot getSlot(int mappedSlot) {
				return new RecipeInputFluidSlot(mappedSlot, fluid, amount);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		fluidInputs.add(mapBuilder);
		fluidSlot = slot;
		return this;
	}

	public RecipeBuilder withFluidInput(final int slot, final FluidStack fluid) {
		IMappedBuilder<RecipeInputFluidSlot> mapBuilder = new IMappedBuilder<RecipeInputFluidSlot>() {

			@Override
			public RecipeInputFluidSlot getSlot(int mappedSlot) {
				return new RecipeInputFluidSlot(mappedSlot, fluid);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		fluidInputs.add(mapBuilder);
		fluidSlot = slot;
		return this;
	}

	public RecipeBuilder withFluidOutput(final int slot, final FluidStack output) {

		IMappedBuilder<RecipeOutputFluidSlot> mapBuilder = new IMappedBuilder<RecipeOutputFluidSlot>() {

			@Override
			public RecipeOutputFluidSlot getSlot(int mappedSlot) {
				return new RecipeOutputFluidSlot(mappedSlot, output.amount, output.amount, output.getFluid());
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		fluidOutputs.add(mapBuilder);
		fluidSlot = slot;
		return this;
	}

	public RecipeBuilder withFluidOutput(final int slot, FluidIP fluid, int amount) {
		return withFluidOutput(slot, fluid, amount, amount);
	}

	public RecipeBuilder withFluidOutput(final int slot, FluidIP fluid, int minAmount, int maxAmount) {
		return withFluidOutput(slot, fluid.getFluid(), minAmount, maxAmount);
	}

	public RecipeBuilder withFluidOutput(final int slot, final Fluid fluid, final int minAmount, final int maxAmount) {
		IMappedBuilder<RecipeOutputFluidSlot> mapBuilder = new IMappedBuilder<RecipeOutputFluidSlot>() {

			@Override
			public RecipeOutputFluidSlot getSlot(int mappedSlot) {
				return new RecipeOutputFluidSlot(mappedSlot, maxAmount, minAmount, fluid);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		fluidOutputs.add(mapBuilder);
		fluidSlot = slot;
		return this;
	}

	public RecipeBuilder withInventoryOutput(int slot, Item item, int amount) {
		return withInventoryOutput(slot, item, amount, amount, 0.5);
	}

	public RecipeBuilder withInventoryOutput(final int slot, final Item item, final int minAmount, final int maxAmount, final double distributionCenter) {
		IMappedBuilder<RecipeOutputInventorySlot> mapBuilder = new IMappedBuilder<RecipeOutputInventorySlot>() {

			@Override
			public RecipeOutputInventorySlot getSlot(int mappedSlot) {
				return new RecipeOutputInventorySlot(mappedSlot, item, maxAmount, minAmount, distributionCenter);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		inventoryOutputs.add(mapBuilder);
		inventorySlot = slot;
		return this;
	}

	public RecipeBuilder withInventoryOutput(final int slot, final Block block, final int minAmount, final int maxAmount, final double distributionCenter) {
		IMappedBuilder<RecipeOutputInventorySlot> mapBuilder = new IMappedBuilder<RecipeOutputInventorySlot>() {

			@Override
			public RecipeOutputInventorySlot getSlot(int mappedSlot) {
				return new RecipeOutputInventorySlot(mappedSlot, block, maxAmount, minAmount, distributionCenter);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};

		inventoryOutputs.add(mapBuilder);
		inventorySlot = slot;
		return this;
	}

	protected int mapInventorySlot(int slot) {
		if (inventorySlotMap == null)
			return slot;
		return inventorySlotMap[slot];
	}

	protected int mapTankSlot(int slot) {
		if (tankSlotMap == null)
			return slot;
		return tankSlotMap[slot];
	}

	public IMachineRecipe getMachineRecipe() {
		Recipe recipe;
		if (powerRequired > 0)
			if (heatRequired > 0)
				recipe = getPoweredHeatRecipe();
			else
				recipe = getPoweredRecipe();
		else if (heatRequired > 0)
			recipe = getHeatRecipe();
		else
			recipe = getRecipe();

		recipe.workRequired = workRequired;

		recipe.inputFluids = new RecipeInputFluidSlot[this.fluidInputs.size()];
		recipe.inputs = new RecipeInputInventorySlot[this.inventoryInputs.size()];
		recipe.outputFluids = new RecipeOutputFluidSlot[this.fluidOutputs.size()];
		recipe.outputs = new RecipeOutputInventorySlot[this.inventoryOutputs.size()];

		populate(recipe.inputFluids, this.fluidInputs, this.tankSlotMap);
		populate(recipe.outputFluids, this.fluidOutputs, this.tankSlotMap);

		populate(recipe.inputs, this.inventoryInputs, this.inventorySlotMap);
		populate(recipe.outputs, this.inventoryOutputs, this.inventorySlotMap);

		return recipe;
	}

	protected <T> void populate(T[] array, ArrayList<IMappedBuilder<T>> mappers, int[] map) {
		for (int i = 0; i < array.length; i++) {
			IMappedBuilder<T> mapper = mappers.get(i);
			int slot = mapper.getSlot();
			if (map != null)
				slot = map[slot];
			array[i] = mapper.getSlot(slot);
		}
	}

	protected Recipe getRecipe() {
		return new Recipe();
	}

	protected Recipe getHeatRecipe() {
		HeatRecipe heatRecipe = new HeatRecipe();
		heatRecipe.heatRequired = heatRequired;
		return heatRecipe;
	}

	protected Recipe getPoweredRecipe() {

		PoweredRecipe recipe = new PoweredRecipe();
		recipe.powerRequired = this.powerRequired;
		return recipe;
	}

	protected Recipe getPoweredHeatRecipe() {
		PoweredHeatRecipe recipe = new PoweredHeatRecipe();
		recipe.powerRequired = powerRequired;
		recipe.heatRequired = heatRequired;
		return recipe;
	}
}
