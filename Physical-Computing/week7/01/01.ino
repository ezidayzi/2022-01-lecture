#include <TimerOne.h>

const int BUZZER = 10;

const int trigPin = 11;
const int echoPin = 12;

void setup() {
  Timer1.initialize();
  Timer1.pwm(BUZZER, 0);
  
  Timer1.setPwmDuty(BUZZER, 512);

  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  
  Serial.begin(115200);

}
int note_freq[] = { 262, 294, 330, 349, 393, 440, 494, 523};

void loop() {
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  unsigned long duration = pulseIn(echoPin, HIGH);
  float distance = duration/59.f;

  if (distance < 15.00 && distance> 0.0 ) {
    Timer1.setPeriod(1000000/note_freq[(int)distance%7]);
    delay(300);
  } else {
    Timer1.setPeriod(0);
  }

  Serial.print(distance, 2);
  Serial.println("cm");

  delay(10);
}
