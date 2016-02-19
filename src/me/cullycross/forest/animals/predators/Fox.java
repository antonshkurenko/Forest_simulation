package me.cullycross.forest.animals.predators;

import java.util.List;
import me.cullycross.forest.Forest;
import me.cullycross.forest.animals.Animal;
import me.cullycross.forest.animals.AnimalFactory;
import me.cullycross.forest.animals.Predator;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Fox extends Animal implements Predator {

  @Override public void simulate() {
    super.simulate();

    final List<Animal> animals = home.getAnimals();

    if(animals.size() > 0) {
      final Animal animal = animals.get(rnd.nextInt(animals.size()));
      eat(animal);
    } else {
      die();
    }
  }

  @Override public void born(Forest homeland) {
    super.born(homeland);
    System.out.println("Fox was borned in the " + homeland);
  }

  @Override public void move(Forest destination) {
    System.out.println("Fox moves from the " + home + " to the " + destination);
    super.move(destination);
  }

  @Override public void die() {
    super.die();
    System.out.println("Fox dies in the " + home);
  }

  @Override public void eat(Animal victim) {
    System.out.println("Fox eats " + victim);
    victim.die();
  }

  public static final class FoxFactory implements AnimalFactory {

    @Override public Animal createAnimal() {
      return new Fox();
    }
  }
}
