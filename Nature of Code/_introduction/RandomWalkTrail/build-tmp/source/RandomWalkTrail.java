import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class RandomWalkTrail extends PApplet {

// Random Walker (No Vectors)
// Daniel Shiffman <http://www.shiffman.net>
// The Nature of Code

Walker w;

public void setup() {
  size(400,400);
  frameRate(30);

  // Create a walker object
  w = new Walker();

}

public void draw() {
  background(255);
  // Run the walker object
  w.walk();
  w.display();
}



// Random Walker (No Vectors)
// Daniel Shiffman <http://www.shiffman.net>
// The Nature of Code

// A random walker class!

class Walker {
  PVector location;

  ArrayList<PVector> history;


  Walker() {
    location = new PVector(width/2, height/2);
    history = new ArrayList<PVector>();
  }

  public void display() {
    stroke(0);
    fill(175);
    rectMode(CENTER);
    rect(location.x, location.y, 16, 16);

    beginShape();
    stroke(0);
    noFill();
    for (PVector v: history) {
      vertex(v.x, v.y);
    }
    endShape();
  }

  // Randomly move up, down, left, right, or stay in one place
  public void walk() {
    PVector vel = new PVector(random(-2, 2), random(-2, 2));
    location.add(vel);

    // Stay on the screen
    location.x = constrain(location.x, 0, width-1);
    location.y = constrain(location.y, 0, height-1);


    history.add(location.get());
    if (history.size() > 1000) {
      history.remove(0);
    }
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "RandomWalkTrail" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
