package me.cullycross.forest.plants;

import me.cullycross.forest.Forest;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Grass extends Plant {

  @Override public void seed(Forest homeland) {
    super.seed(homeland);
    System.out.println("Grass was seeded in the " + homeland);
  }

  @Override protected void grow() {
    System.out.println("Grass grows");
  }

  public static final class GrassFactory implements PlantFactory {

    @Override public Plant createPlant() {
      return new Grass();
    }
  }
}
