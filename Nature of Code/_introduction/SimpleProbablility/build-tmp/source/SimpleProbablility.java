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

public class SimpleProbablility extends PApplet {

// Daniel Shiffman
// The Nature of Code
// http://www.shiffman.net/

int x,y;

public void setup() {
  size(200,200);
  background(0);
  smooth();
}

public void draw() {
  //create an alpha blended background
  fill(0,1);
  rect(0,0,width,height);
  
  //calculate a probability between 0 and 100% based on mouseX location
  float prob = (mouseX / (float) width);     
  
  //get a random floating point value between 0 and 1
  float r = random(1);   
  
  //test the random value against the probability and trigger an event
  if (r < prob) {
    noStroke();
    fill(255);
    ellipse(x,y,10,10);
  }
  
  // X and Y walk through a grid
  x = (x + 10) % width;
  if (x == 0) y = (y + 10) % width;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SimpleProbablility" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
