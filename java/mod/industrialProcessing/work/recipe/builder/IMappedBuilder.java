package mod.industrialProcessing.work.recipe.builder;


public interface IMappedBuilder<T> {
	int getSlot();
	T getSlot(int mappedSlot);
}
