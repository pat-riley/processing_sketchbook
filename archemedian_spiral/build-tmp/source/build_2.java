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

public class build_2 extends PApplet {

/*
Animated archimedean spiral
Translated from Pascal into processing by Silvia Rothen, Switzerland
Special Thanks to Max Kleiner and his maXbox
*/
int myHeight = 1000;
int myWidth = 1000;
int cx = 0;
int cy = 0;
float FValueA = 3.0f;
float FValueB = 1.4f;
float angle = 0.0f;
float x1 = 0.0f;
float x2 = 0.0f;
float y1 = 0.0f;
float y2 = 0.0f;
int myDelay = 25;
int lastTime = 0;
boolean odd = false;
int refresh = 0;
boolean continued = true;


 
 
public void setup() {
  size(myWidth, myHeight);
  strokeWeight(1);
  fill(255, 255, 255);
  stroke(255, 255, 255, 5);
  background(0, 0, 0);
  cx = myWidth / 2;
  cy = myHeight / 2;
  frameRate(1000/myDelay);
}
 
/* toggle drawing with left mouse buttona
   restart drawing with right mouse button
*/
public void mousePressed() {
  if ( mouseButton == LEFT) {
    continued = !continued;
  }
  if ( mouseButton == RIGHT) {
    FValueB = 1.4f;
    background(0, 0, 255);
    stroke(255);
    x1 = 0.0f;
    x2 = 0.0f;
    y1 = 0.0f;
    y2 = 0.0f;
    continued = true;
  }
}
 
 
public void draw() {
      //bool = T
  if (continued) {
  //1.4       3         // This number affects speed
    FValueB = FValueB + 0.0001f;
    //0        0  + 1
    refresh = refresh + 1;
    //draw a background square
    background(mouseX/2, 150, mouseX/2 );
   
    stroke(mouseY/2, 150, mouseY/2);
    //i times  subtract 1 from i
                 //this is number of lines
    for (int i = 1000; i >= 0; i = i-1) {
      //0     1.4 * i
      angle = FValueB * i;
      //angle becomes 1400
      //
      x2 = cx + (FValueA + FValueB * angle) * cos(angle);
      y2 = cy + (FValueA + FValueB * angle) * sin(angle);
      if (i == 1000) {
        x1 = x2;
        y1 = y2;
      } else { 
        line(x1,y1,x2,y2);
        x1 = x2;
        y1 = y2;
      }
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
