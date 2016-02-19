package me.cullycross.forest.plants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import me.cullycross.forest.animals.Animal;
import me.cullycross.forest.animals.AnimalFactory;
import me.cullycross.forest.animals.herbivorous.Deer;
import me.cullycross.forest.animals.herbivorous.Rabbit;
import me.cullycross.forest.animals.predators.Bear;
import me.cullycross.forest.animals.predators.Fox;
import me.cullycross.forest.animals.predators.Wolf;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public final class PlantCreator {

  private final Random random = new Random();

  private final List<PlantFactory> factories = new ArrayList<PlantFactory>();

  private static final PlantCreator INSTANCE = new PlantCreator();

  public static PlantCreator getInstance() {
    return INSTANCE;
  }

  private PlantCreator() {
    factories.add(new Flower.FlowerFactory());
    factories.add(new Grass.GrassFactory());
    factories.add(new Tree.TreeFactory());
  }

  public Plant createRandomPlant() {
    return factories.get(random.nextInt(factories.size())).createPlant();
  }
}
