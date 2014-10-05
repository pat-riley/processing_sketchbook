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

public class sine_cosine extends PApplet {

float x1, x2, y1, y2;
float angle1, angle2;
float scalar = 70;

public void setup() {
  size(640, 360);
  noStroke();
  rectMode(CENTER);
}

public void draw() {
  background(0);

  float ang1 = radians(angle1);
  float ang2 = radians(angle2);

  x1 = width/2 + (scalar * cos(ang1));
  x2 = width/2 + (scalar * cos(ang2));
  
  y1 = height/2 + (scalar * sin(ang1));
  y2 = height/2 + (scalar * sin(ang2));
  
  fill(255);
  rect(width*0.5f, height*0.5f, 140, 140);

  fill(0, 102, 153);
  ellipse(x1, height*0.5f - 120, scalar, scalar);
  ellipse(x2, height*0.5f + 120, scalar, scalar);
  
  fill(255, 204, 0);
  ellipse(width*0.5f - 120, y1, scalar, scalar);
  ellipse(width*0.5f + 120, y2, scalar, scalar);

  angle1 += 2;
  angle2 += 3;
  
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sine_cosine" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
