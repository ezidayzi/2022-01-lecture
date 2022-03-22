const unsigned int led[6] = {3,5,6,9,10,11};

void setup() {
  for ( int x = 0; x<6;x++) {
    pinMode(led[x], OUTPUT);
  }
}

void loop() {
  for(int x = 0; x < 6; x ++) {
    for(int y = 0; y<255; y++) {
      analogWrite(led[x],y);
      delay(2); 
    }

    for ( int i=255; i>=0; i-- ){  
      analogWrite(led[x], i );  
      delay(2);  
    }  
  }

}
