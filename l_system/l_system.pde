


String current ="A";      //start with axiom
int count = 0;            //keep track of how many generations

void setup() {
  // 
  println("Generation" + count + "; " + current); 
}

void draw() {
}


void mousePressed() {
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
