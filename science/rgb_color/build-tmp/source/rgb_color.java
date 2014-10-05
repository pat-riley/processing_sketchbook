import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class rgb_color extends PApplet {


ControlP5 cp5;


int red;
int green;
int blue;

public void setup() {
  size(500,500);
  background(0xffFFFFFF);
  cp5 = new ControlP5(this);
  
    cp5.addSlider("red")
     .setPosition(25,25)
     .setRange(0,250)
     ;
     
    cp5.addSlider("green")
     .setPosition(25,50)
     .setRange(0,250)
     ;
     
    cp5.addSlider("blue")
     .setPosition(25,75)
     .setRange(0,250)
     ;
  
}



public void draw() {
  background(red, green, blue);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "rgb_color" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
