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

public class Gaussian2 extends PApplet {

// Daniel Shiffman
// The Nature of Code
// http://www.shiffman.net/

Random generator;

public void setup() {
  size(200,200);
  background(0);
  smooth();
  generator = new Random();
}

public void draw() {
  //create an alpha blended background
  fill(0,1);
  rect(0,0,width,height);

  //get 3 gaussian random numbers w/ mean of 0 and standard deviation of 1.0
  float r = (float) generator.nextGaussian();
  float g = (float) generator.nextGaussian();
  float b = (float) generator.nextGaussian();

  //define standard deviation and mean
  float sd = 100; float mean = 100;
  //scale by standard deviation and mean
  //also constrain to between (0,255) since we are dealing with color
  r = constrain((r * sd) + mean,0,255);

  //repeat for g & b
  sd = 20; mean = 200;
  g = constrain((g * sd) + mean,0,255);
  sd = 50; mean = 0;
  b = constrain((b * sd) + mean,0,255);

  //get more gaussian numbers, this time for location
  float xloc = (float) generator.nextGaussian();
  float yloc = (float) generator.nextGaussian();
  sd = width/10;
  mean = width/2;
  xloc = ( xloc * sd ) + mean;
  yloc = ( yloc * sd ) + mean;

  //draw an ellipse with gaussian generated color and location
  noStroke();
  fill(r,g,b);
  ellipse(xloc,yloc,8,8);
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Gaussian2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
