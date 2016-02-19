package me.cullycross.forest.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
public final class AnimalCreator {

  private final Random random = new Random();

  private final List<AnimalFactory> factories = new ArrayList<AnimalFactory>();

  private static final AnimalCreator INSTANCE = new AnimalCreator();

  public static AnimalCreator getInstance() {
    return INSTANCE;
  }

  private AnimalCreator() {
    factories.add(new Deer.DeerFactory());
    factories.add(new Rabbit.RabbitFactory());
    factories.add(new Bear.BearFactory());
    factories.add(new Fox.FoxFactory());
    factories.add(new Wolf.WolfFactory());
  }

  public Animal createRandomAnimal() {
    return factories.get(random.nextInt(factories.size())).createAnimal();
  }
}
