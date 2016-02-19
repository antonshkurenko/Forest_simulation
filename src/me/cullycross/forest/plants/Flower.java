package me.cullycross.forest.plants;

import me.cullycross.forest.Forest;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Flower extends Plant implements Bloomable {

  @Override public void simulate() {
    super.simulate();

    if(rnd.nextBoolean()) {
      bloom();
    }
  }

  @Override public void seed(Forest homeland) {
    super.seed(homeland);
    System.out.println("Flower was seeded in the " + homeland);
  }

  @Override public void bloom() {
    System.out.println("Flower blooms");
  }

  @Override protected void grow() {
    System.out.println("Flower grows");
  }

  public static final class FlowerFactory implements PlantFactory {

    @Override public Plant createPlant() {
      return new Flower();
    }
  }
}
