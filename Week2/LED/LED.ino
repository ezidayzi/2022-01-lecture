const int LED = 13;

void setup() {
  // put your setup code here, to run once:
  pinMode(LED, OUTPUT);
  digitalWrite(LED,1);
  
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(LED,1); // HIGH
  delay(500); // 1000ms = 1sec, 0.5sec
  digitalWrite(LED,0); // LOW
  delay(500); 
  // 주기가 1초 
}
