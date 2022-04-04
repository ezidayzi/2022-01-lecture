const int analogPin = A0;
const int ledPin = 10;

void setup() {


}

void loop() {
  int analogInput = analogRead(analogPin);
  analogWrite(ledPin, analogInput/4);
}
