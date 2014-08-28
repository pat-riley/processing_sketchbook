import controlP5.*;
ControlP5 cp5;


int x1 = 100;
int x2 = 150;
int x3 = 200;
int x4 = 250;
int x5 = 300;
int x6 = 350;
int x7 = 400;
int x8 = 450;
int x9 = 500;
int x10 = 550;

int y1 = 100;
int y2 = 150;
int y3 = 200;
int y4 = 250;
int y5 = 300;
int y6 = 350;
int y7 = 400;
int y8 = 450;
int y9 = 500;
int y10 = 550;

int md1 = 275; 
int md2 = 375;
int mm = 475;

void setup () {
  size(1500,1000);
  background(#FFFFFF);
    cp5 = new ControlP5(this);

  cp5.addSlider("x1")
     .setPosition(750,25)
     .setRange(0,x1)
     ;
     
    cp5.addSlider("x2")
     .setPosition(750,50)
     .setRange(x1,x2)
     ;
     
    cp5.addSlider("x3")
     .setPosition(750,75)
     .setRange(x2,x3)
     ;
     
    cp5.addSlider("x4")
     .setPosition(750,100)
     .setRange(x4,x5)
     ;
     
     cp5.addSlider("x5")
     .setPosition(750,125)
     .setRange(x5,x6)
     ;
     
    cp5.addSlider("x6")
     .setPosition(750,150)
     .setRange(x6,x7)
     ;
     
    cp5.addSlider("x7")
     .setPosition(750,175)
     .setRange(x7,x8)
     ;
     
    cp5.addSlider("x8")
     .setPosition(750,200)
     .setRange(x8,x9)
     ;
  
      cp5.addSlider("x9")
     .setPosition(750,225) 
     .setRange(x9,x10)
     ;
     
    cp5.addSlider("x10")
     .setPosition(750,250)
     .setRange(x10,500)
     ;
}

void draw() {

  background(51);
  fill(102);
  stroke(255);
  strokeWeight(2);
  beginShape();
  
    vertex(x1, y2);
    vertex(x3,y2);
    vertex(x3,y1);
    vertex(x4,y1);
    vertex(x4,y2);
    vertex(x5,y2);
    vertex(x5,y1);
    vertex(x6,y1);
    vertex(x6,y2);
    //the curve
    vertex(x6,y2);
    bezierVertex(x8+10,y2,x9,y3,x9,md1);
    bezierVertex(x9,md1,x9,y5+10,mm,(y5+20));
    bezierVertex(x9,(y6-10),x10,y6+10,x10,md2);
    bezierVertex(x10,y8,mm,y9,x7,y9);
    vertex(x6,y9);
    vertex(x6,y10);
    vertex(x5,y10);
    vertex(x5,y9);
    vertex(x4,y9);
    vertex(x4,y10);
    vertex(x3,y10);
    vertex(x3,y9);
    vertex(x1,y9);
    vertex(x1,y8);
    vertex((x1+25),y8);
    bezierVertex(x2,y8,x2,y7,x2,y6+25);
    vertex(x2,y4);
    bezierVertex(x2,y3,x2,y3,x1+10,y3);
    vertex(x1,y3);
    vertex(x1,y2);
    
  endShape(CLOSE);

  strokeWeight(.5);
  line(x1,0,x1,1000);
  line(x2,0,x2,1000);
  line(x3,0,x3,1000);
  line(x4,0,x4,1000);
  line(x5,0,x5,000);
  line(x6,0,x6,1000);
  line(x7,0,x7,1000);
  line(x8,0,x8,1000);
  line(x9,0,x9,1000);
  line(x10,0,x10,1000);
  
  
}
  
