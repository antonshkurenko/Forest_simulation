package me.cullycross.forest.animals.herbivorous;

import java.util.List;
import me.cullycross.forest.Forest;
import me.cullycross.forest.animals.Animal;
import me.cullycross.forest.animals.AnimalFactory;
import me.cullycross.forest.animals.Herbivorous;
import me.cullycross.forest.plants.Plant;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Deer extends Animal implements Herbivorous {

  @Override public void simulate() {
    super.simulate();

    final List<Plant> plants = home.getPlants();

    if(plants.size() > 0) {
      final Plant plant = plants.get(rnd.nextInt(plants.size()));
      eat(plant);
    } else {
      die();
    }
  }

  @Override public void born(Forest homeland) {
    super.born(homeland);
    System.out.println("Deer was borned in the " + homeland);
  }

  @Override public void move(Forest destination) {
    System.out.println("Deer moves from the " + home + " to the " + destination);
    super.move(destination);
  }

  @Override public void die() {
    super.die();
    System.out.println("Deer dies in the " + home);
  }

  @Override public void eat(Plant plant) {
    System.out.println("Deer eats " + plant);
    plant.setEaten();
  }

  public static final class DeerFactory implements AnimalFactory {

    @Override public Animal createAnimal() {
      return new Deer();
    }
  }
}
