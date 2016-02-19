package me.cullycross.forest.plants;

import me.cullycross.forest.Forest;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Tree extends Plant implements Bloomable {

  @Override public void simulate() {
    super.simulate();

    if(rnd.nextBoolean()) {
      bloom();
    }
  }

  @Override public void seed(Forest homeland) {
    super.seed(homeland);
    System.out.println("Tree was seeded in the " + homeland);
  }

  @Override public void bloom() {
    System.out.println("Tree blooms");
  }

  @Override protected void grow() {
    System.out.println("Tree grows");
  }

  public static final class TreeFactory implements PlantFactory {

    @Override public Plant createPlant() {
      return new Tree();
    }
  }
}
