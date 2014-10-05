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

public class l_system extends PApplet {


String current ="A";      //start with axiom
int count = 0;            //keep track of how many generations

public void setup() {
  // 
  println("Generation" + count + "; " + current); 
}

public void draw() {
}


public void mousePressed() {
  String next = "";
  for (int i = 0; i < current.length(); i++) {
    char c = current.charAt(i);
    if (c == 'A') {
      next += "AB";
    }  else if (c == 'B') {
      next += "A";
    }
  }
  current = next;
  count++;
  println("Generation " + count + ": " + current);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "l_system" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
