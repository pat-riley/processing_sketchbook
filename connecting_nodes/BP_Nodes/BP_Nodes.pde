import processing.pdf.*;
import controlP5.*;
ControlP5 cp5;



PVector[] dots;
int numDots = 1000;
float maxRange = 50.0f;
float minRange = 20.0f;
 
boolean savePDF = false;
void setup() {
  size(1200, 800);
  colorMode(RGB, 255);
  background(0, 40, 85);
  stroke(0,0,0);
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
  if ( savePDF ) {
    beginRecord( PDF, "pdf/myartwork-####.pdf" );
  }
 
  
  background(300, 300, 300);
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


