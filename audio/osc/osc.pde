import oscP5.*;
import netP5.*;

// create two objects, one for sending osc messages and another to store network addressse
OscP5 oscP5;
NetAddress myRemoteLocation;

void setup() {
    size(400, 400);

	// start oscP5, telling it to listen for incoming messages at port 5001 */
 	oscP5 = new OscP5(this,5001);
 
 	// set the remote location to be the localhost on port 5001
 	myRemoteLocation = new NetAddress("127.0.0.1",8080);
}
 

void mousePressed() { 
  // this code creates an OSC message every time we click
  // create an osc message
  OscMessage myMessage = new OscMessage("/test");
 
  myMessage.add(123); // add an int to the osc message
  myMessage.add(12.34); // add a float to the osc message 
  myMessage.add("some text!"); // add a string to the osc message
 
  // send the message
  oscP5.send(myMessage, myRemoteLocation); 
}

void draw() {
 
}


void oscEvent(OscMessage theOscMessage) 
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