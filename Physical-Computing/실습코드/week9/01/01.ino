#include <Stepper.h>
#include <DHT.h>
#define STEPS 2048

Stepper stepper(STEPS, 8, 10, 9, 11);
DHT dht(A0, DHT11);
int buzzerPin = 3;
unsigned long curTime = millis();

void setup() {
  Serial.begin(115200);
  dht.begin();
  stepper.setSpeed(15);
  pinMode(buzzerPin, OUTPUT);
}

void loop() {
   unsigned long delayTime =  millis() - curTime;
   
   float h = dht.readHumidity();
   float t = dht.readTemperature();

   Serial.print("H: ");
   Serial.println(h);
   Serial.print("T: ");
   Serial.println(t);
   Serial.println("\n");

   if (delayTime % 1000 == 0) {
      stepper.step(STEPS/60.f);
   }

    if (delayTime/1000 > 10 && delayTime/1000 <13) {
      digitalWrite(buzzerPin, HIGH);
      
      } else {
      digitalWrite(buzzerPin, LOW);
      
    }
   
}
