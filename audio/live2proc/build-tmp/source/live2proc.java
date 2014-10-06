import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import oscP5.*; 
import netP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class live2proc extends PApplet {






OscP5 oscP5;
NetAddress myRemoteLocation;


public void setup() {
	size(180, 150);
	
	oscP5 = new OscP5(this,8080);
	myRemoteLocation = new NetAddress("127.0.0.1",8080);
}



public void draw() {

}


public void oscEvent(OscMessage theOscMessage) {
	float myVariable = theOscMessage.get(0).floatValue();
    println(theOscMessage);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "live2proc" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
