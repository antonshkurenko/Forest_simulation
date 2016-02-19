package me.cullycross.forest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import me.cullycross.forest.animals.Animal;
import me.cullycross.forest.animals.AnimalCreator;
import me.cullycross.forest.plants.Plant;
import me.cullycross.forest.plants.PlantCreator;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public class Forest implements Simulatable {
  private static final long DELAY = 250;

  private final String name;

  private final List<Forest> neighbours = new ArrayList<Forest>();

  private final List<Animal> animals = new ArrayList<Animal>();
  private final List<Plant> plants = new ArrayList<Plant>();

  private Random rnd = new Random();

  public Forest(String name) {
    this.name = name;
  }

  public void generate(Random rnd) {

    this.rnd = rnd;

    try {
      generateAnimals(rnd, 5);
      generatePlants(rnd, 5);
    } catch (InterruptedException ignored) {

    }
  }

  @Override public void simulate() {
    try {

      System.out.println("*******************************************");
      System.out.println("Start of the step: ");
      System.out.println("Animals: " + animals.size());
      System.out.println("Plants: " + plants.size());
      System.out.println("*******************************************");

      Thread.sleep(DELAY * 4);

      final Iterator<Animal> iterAnimals = animals.iterator();
      while (iterAnimals.hasNext()) {
        final Animal a = iterAnimals.next();
        if (a.isDead()) {
          iterAnimals.remove();
          continue;
        }
        a.simulate();

        if (rnd.nextBoolean()) {
          a.move(getNeighbours().get(rnd.nextInt(getNeighbours().size())));
          iterAnimals.remove();
        }

        Thread.sleep(DELAY);
      }

      final Iterator<Plant> iterPlants = plants.iterator();

      while (iterPlants.hasNext()) {
        final Plant p = iterPlants.next();
        if (p.isEaten()) {
          iterPlants.remove();
          continue;
        }

        p.simulate();

        Thread.sleep(DELAY);
      }

      generateAnimals(rnd, 3);
      generatePlants(rnd, 3);

      Thread.sleep(DELAY * 4);

    } catch (InterruptedException ignored) {

    }
  }

  public Forest addNeighbour(Forest neighbour) {
    neighbours.add(neighbour);
    return this;
  }

  public List<Forest> getNeighbours() {
    return neighbours;
  }

  public Forest addAnimal(Animal animal) {
    animals.add(animal);
    return this;
  }

  public Forest addPlant(Plant plant) {
    plants.add(plant);
    return this;
  }

  public List<Animal> getAnimals() {
    return animals;
  }

  public List<Plant> getPlants() {
    return plants;
  }

  @Override public String toString() {
    return name;
  }

  private void generateAnimals(Random rnd, int randomMin) throws InterruptedException {
    final int totalAnimals = rnd.nextInt(randomMin * 2) + randomMin;

    for (int i = 0; i < totalAnimals; i++) {
      AnimalCreator.getInstance().createRandomAnimal().born(this);
      Thread.sleep(DELAY);
    }
  }

  private void generatePlants(Random rnd, int randomMin) throws InterruptedException {
    final int totalPlants = rnd.nextInt(randomMin * 2) + randomMin;

    for (int i = 0; i < totalPlants; i++) {
      PlantCreator.getInstance().createRandomPlant().seed(this);
      Thread.sleep(DELAY);
    }
  }
}
