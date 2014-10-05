import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 
import java.util.Calendar; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class P_2_1_3_03 extends PApplet {

// P_2_1_3_03.pde
// 
// Generative Gestaltung, ISBN: 978-3-87439-759-9
// First Edition, Hermann Schmidt, Mainz, 2009
// Hartmut Bohnacker, Benedikt Gross, Julia Laub, Claudius Lazzeroni
// Copyright 2009 Hartmut Bohnacker, Benedikt Gross, Julia Laub, Claudius Lazzeroni
//
// http://www.generative-gestaltung.de
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * changing positions of stapled circles in a grid
 * 	 
 * MOUSE
 * position x          : module detail
 * position y          : module parameter
 * 
 * KEYS
 * 1-3                 : draw mode
 * arrow left/right    : number of tiles horizontally
 * arrow up/down       : number of tiles vertically
 * s                   : save png
 * p                   : save pdf
 */





boolean savePDF = false;

float tileCountX = 6;
float tileCountY = 6;
int count = 0;

int drawMode = 1;


public void setup() { 
  size(600, 600);
} 


public void draw() { 
  if (savePDF) beginRecord(PDF, timestamp()+".pdf");

  colorMode(HSB, 360, 100, 100); 
  rectMode(CENTER);
  smooth();
  //noStroke();
  stroke(0);
  noFill();
  background(360); 

  count = mouseX/20 + 5;
  float para = (float)mouseY/height - 0.5f;

  for (int gridY=0; gridY<= tileCountY; gridY++) {
    for (int gridX=0; gridX<= tileCountX; gridX++) {  

      float tileWidth = width / tileCountX;
      float tileHeight = height / tileCountY;
      float posX = tileWidth*gridX + tileWidth/2;
      float posY = tileHeight*gridY + tileHeight/2;

      pushMatrix();
      translate(posX, posY);

      // switch between modules
      switch (drawMode) {
      case 1:
        translate(-tileWidth/2, -tileHeight/2);
        for(int i=0; i< count; i++) {
          line(0, (para+0.5f)*tileHeight, tileWidth, i*tileHeight/count);
          line(0, i*tileHeight/count, tileWidth, tileHeight-(para+0.5f)*tileHeight);
        }
        break;
      case 2:
        for(float i=0; i<=count; i++) {
          line(para*tileWidth, para*tileHeight, tileWidth/2, (i/count-0.5f)*tileHeight);
          line(para*tileWidth, para*tileHeight, -tileWidth/2, (i/count-0.5f)*tileHeight);
          line(para*tileWidth, para*tileHeight, (i/count-0.5f)*tileWidth, tileHeight/2);
          line(para*tileWidth, para*tileHeight, (i/count-0.5f)*tileWidth, -tileHeight/2);
        }
        break;
      case 3:
        for(float i=0; i<=count; i++) {
          line(0, para*tileHeight, tileWidth/2, (i/count-0.5f)*tileHeight);
          line(0, para*tileHeight, -tileWidth/2, (i/count-0.5f)*tileHeight);
          line(0, para*tileHeight, (i/count-0.5f)*tileWidth, tileHeight/2);
          line(0, para*tileHeight, (i/count-0.5f)*tileWidth, -tileHeight/2);
        }
        break;
      }

      popMatrix();

    }
  }
  if (savePDF) {
    savePDF = false;
    endRecord();
  }
} 


public void keyReleased(){
  if (key == 's' || key == 'S') saveFrame(timestamp()+"_##.png");
  if (key == 'p' || key == 'P') savePDF = true;
  
  if (key == '1') drawMode = 1;
  if (key == '2') drawMode = 2;
  if (key == '3') drawMode = 3;

  if (keyCode == DOWN) tileCountY = max(tileCountY-1, 1);
  if (keyCode == UP) tileCountY += 1;
  if (keyCode == LEFT) tileCountX = max(tileCountX-1, 1);
  if (keyCode == RIGHT) tileCountX += 1;

}

// timestamp
public String timestamp() {
  Calendar now = Calendar.getInstance();
  return String.format("%1$ty%1$tm%1$td_%1$tH%1$tM%1$tS", now);
}








  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "P_2_1_3_03" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
