package me.cullycross.forest.animals;

import java.util.Random;
import me.cullycross.forest.Forest;
import me.cullycross.forest.Simulatable;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Forest
 * Date: 2/19/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
public abstract class Animal implements Simulatable {

  protected final Random rnd = new Random();

  protected boolean isDead = false;
  protected Forest home;

  public boolean isDead() {
    return isDead;
  }

  @Override public void simulate() {

  }

  public void born(Forest homeland) {
    home = homeland;
    home.addAnimal(this);
  }

  public void move(Forest destination) {
    destination.addAnimal(this);
  }

  public void die() {
    isDead = true;
  }
}
