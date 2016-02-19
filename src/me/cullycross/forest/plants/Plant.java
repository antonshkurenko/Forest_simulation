package me.cullycross.forest.plants;

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
public abstract class Plant implements Simulatable {

  protected final Random rnd = new Random();

  protected Forest home;

  protected boolean isEaten = false;

  protected abstract void grow();

  @Override public void simulate() {
    grow();
  }

  public void seed(Forest homeland) {
    home = homeland;
    home.addPlant(this);
  }

  public boolean isEaten() {
    return isEaten;
  }

  public void setEaten() {
    this.isEaten = true;
  }
}
