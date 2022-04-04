const int led[6] = {3, 5, 6, 9, 10, 11};
const int analogPin = A0;


void setup() {
  for(int i = 0; i<6;i++) {
    pinMode(led[i], OUTPUT);
  }

}

void loop() {
  int analogInput = analogRead(analogPin);
  for (int i = 0; i<6; i++) {
    if (analogInput > 1024 / 7 * (1+i)) {
      digitalWrite(led[i], HIGH);
    }
    else {
      digitalWrite(led[i], LOW);
    }
  }

}
