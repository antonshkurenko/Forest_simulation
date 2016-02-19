package me.cullycross;

import java.util.Random;
import me.cullycross.forest.Forest;

public class Main {

  public static void main(String[] args) {
    simulate();
  }

  public static void simulate() {
    final Forest greenForest = new Forest("Green forest");
    final Forest blueForest = new Forest("Blue forest");
    final Forest redForest = new Forest("Red forest");

    final Random rnd = new Random();
    greenForest.generate(rnd);
    blueForest.generate(rnd);
    redForest.generate(rnd);

    greenForest.addNeighbour(blueForest).addNeighbour(redForest);
    blueForest.addNeighbour(greenForest).addNeighbour(redForest);
    redForest.addNeighbour(greenForest).addNeighbour(blueForest);

    while (true) {
      greenForest.simulate();
      blueForest.simulate();
      redForest.simulate();
    }
  }
}
