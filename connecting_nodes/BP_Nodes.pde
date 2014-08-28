import processing.pdf.*;
import controlP5.*;
ControlP5 cp5;



PVector[] dots;
int numDots = 1000;
float maxRange = 50.0f;
float minRange = 20.0f;
 
void setup() {
  size(1200, 800);
  colorMode(RGB, 255);
  background(22, 42, 83);
  stroke(85,120,180);
  smooth();
  
  cp5 = new ControlP5(this);
  dots = new PVector[numDots];
 
  this.setDots();
  

  cp5.addSlider("numDots")
     .setPosition(5,5)
     .setRange(0,1000)
     ;
     
  cp5.addSlider("maxRange")
     .setPosition(5,25)
     .setRange(0,100)
     ;
     
  cp5.addSlider("minRange")
     .setPosition(5,50)
     .setRange(0,100)
     ;
}
 
void draw() {
  background(22, 42, 83);
  for (int i=0; i<numDots; i++) {
    this.renderLines(dots[i].x, dots[i].y);
  }
}
 
void keyReleased() {
  this.setDots();
}
 
void setDots() {
  for (int i=0; i<numDots; i++) {
    dots[i] = new PVector(random(width), random(height));
  }
}
 
void renderLines(float x_, float y_) {
  for (int i=0; i<numDots; i++) {
    float d = dist(x_, y_, dots[i].x, dots[i].y);
    if (d<maxRange && d>minRange) {
      strokeWeight(25/d);
      line(x_, y_, dots[i].x, dots[i].y);
    }
  }
}


