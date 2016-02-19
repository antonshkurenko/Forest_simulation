package me.cullycross.forest.animals.predators;

import java.util.List;
import me.cullycross.forest.Forest;
import me.cullycross.forest.animals.Animal;
import me.cullycross.forest.animals.AnimalFactory;
import me.cullycross.forest.animals.Herbivorous;
import me.cullycross.forest.animals.Predator;
import me.cullycross.forest.plants.Plant;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Bear extends Animal implements Herbivorous, Predator {

  @Override public void simulate() {
    super.simulate();

    final List<Plant> plants = home.getPlants();
    final List<Animal> animals = home.getAnimals();
    if (plants.size() > 0 && animals.size() > 0) {
      if (rnd.nextBoolean()) {
        final Plant plant = plants.get(rnd.nextInt(plants.size()));
        eat(plant);
      } else {
        final Animal animal = animals.get(rnd.nextInt(animals.size()));
        eat(animal);
      }
    } else if (plants.size() > 0) {
      final Plant plant = plants.get(rnd.nextInt(plants.size()));
      eat(plant);
    } else if (animals.size() > 0) {
      final Animal animal = animals.get(rnd.nextInt(animals.size()));
      eat(animal);
    } else {
      die();
    }
  }

  @Override public void born(Forest homeland) {
    super.born(homeland);
    System.out.println("Bear was borned in the " + homeland);
  }

  @Override public void move(Forest destination) {
    System.out.println("Bear moves from the " + home + " to the " + destination);
    super.move(destination);
  }

  @Override public void die() {
    super.die();
    System.out.println("Bear dies in the " + home);
  }

  @Override public void eat(Plant plant) {
    System.out.println("Bear eats " + plant);
    plant.setEaten();
  }

  @Override public void eat(Animal victim) {
    System.out.println("Bear eats " + victim);
    victim.die();
  }

  public static final class BearFactory implements AnimalFactory {

    @Override public Animal createAnimal() {
      return new Bear();
    }
  }
}
