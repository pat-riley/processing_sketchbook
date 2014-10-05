import controlP5.*;
ControlP5 cp5;


int red;
int green;
int blue;

void setup() {
  size(500,500);
  background(#FFFFFF);
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



void draw() {
  background(red, green, blue);
  
}
