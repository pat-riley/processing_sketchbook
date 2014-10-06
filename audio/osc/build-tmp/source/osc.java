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

public class osc extends PApplet {




// create two objects, one for sending osc messages and another to store network addressse
OscP5 oscP5;
NetAddress myRemoteLocation;

public void setup() {
    size(400, 400);

	// start oscP5, telling it to listen for incoming messages at port 5001 */
 	oscP5 = new OscP5(this,5001);
 
 	// set the remote location to be the localhost on port 5001
 	myRemoteLocation = new NetAddress("127.0.0.1",5001);
}
 

public void mousePressed() { 
  // this code creates an OSC message every time we click
  // create an osc message
  OscMessage myMessage = new OscMessage("/test");
 
  myMessage.add(123); // add an int to the osc message
  myMessage.add(12.34f); // add a float to the osc message 
  myMessage.add("some text!"); // add a string to the osc message
 
  // send the message
  oscP5.send(myMessage, myRemoteLocation); 
}

public void draw() {
 println("var X: "+varX);
}


public void oscEvent(OscMessage theOscMessage) 
{  
  // get the first value as an integer
  int firstValue = theOscMessage.get(0).intValue();
 
  // get the second value as a float  
  float secondValue = theOscMessage.get(1).floatValue();
 
  // get the third value as a string
  String thirdValue = theOscMessage.get(2).stringValue();
 
  // print out the message
  print("OSC Message Recieved: ");
  print(theOscMessage.addrPattern() + " ");
  println(firstValue + " " + secondValue + " " + thirdValue);
}


// http://learning.codasign.com/index.php?title=Sending_and_Receiving_OSC_Data_Using_Processing
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "osc" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
