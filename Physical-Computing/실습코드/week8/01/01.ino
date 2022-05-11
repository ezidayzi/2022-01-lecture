#include "PinChangeInterrupt.h"

const int trig_pin = 11;
const int echo_pin = 12;
const int LED[6] = {2, 3, 4, 5, 6, 7};

volatile unsigned long echo_duration = 0;
void echoIsr(void) {
  static unsigned long echo_begin = 0;
  static unsigned long echo_end = 0;

  unsigned int echo_pin_state = digitalRead(echo_pin);
  if (echo_pin_state == HIGH) {
    echo_begin = micros();
  } 
  else {
    echo_end = micros();
    echo_duration = echo_end - echo_begin;
  }
}

void setup() {
   Serial.begin(115200);
  for (int i = 0; i < 6; i++) {
    pinMode(LED[i], OUTPUT);
  }
  pinMode(trig_pin, OUTPUT);
  pinMode(echo_pin, INPUT);

  attachPCINT(digitalPinToPCINT(echo_pin), echoIsr, CHANGE);
}

void loop() {
  if (echo_duration == 0) {
    digitalWrite(trig_pin, LOW);
    delayMicroseconds(2);
    digitalWrite(trig_pin, HIGH);
    delayMicroseconds(10);
    digitalWrite(trig_pin, LOW);
  } 
  else {
    unsigned long distance = echo_duration / 58;
    for (int i = 0; i < 6; i++) {
      if ((60.f - distance) / 10.f >= i){
        digitalWrite(LED[i], HIGH);
      }
      else
        digitalWrite(LED[i], LOW);
    }
    Serial.print(distance);
    Serial.println(" cm");
    echo_duration = 0;
  }
}
