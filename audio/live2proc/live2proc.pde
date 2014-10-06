
import oscP5.*;
import netP5.*;


OscP5 oscP5;
NetAddress myRemoteLocation;


void setup() {
	size(180, 150);
	
	oscP5 = new OscP5(this,8080);
	myRemoteLocation = new NetAddress("127.0.0.1",8080);
}



void draw() {

}


void oscEvent(OscMessage theOscMessage) {
	float myVariable = theOscMessage.get(0).floatValue();
    println(theOscMessage);
}