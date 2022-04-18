const int Xin = A0;
const int Yin = A1;
const int UP = 5;
const int DOWN = 6;
const int LEFT = 9;
const int RIGHT = 11;

void setup() {
  pinMode(UP, OUTPUT);
  pinMode(DOWN, OUTPUT);
  pinMode(LEFT, OUTPUT);
  pinMode(RIGHT, OUTPUT);
  
  Serial.begin(115200);
}

void loop() {
  int xVal = analogRead(Xin);
  int yVal = analogRead(Yin);

  if(xVal > 1000)
    digitalWrite(UP, HIGH);
  else
    digitalWrite(UP, LOW);

  if(xVal < 50)
    digitalWrite(DOWN, HIGH);
  else
    digitalWrite(DOWN, LOW);

  if(yVal > 1000)
    digitalWrite(LEFT, HIGH);
  else
    digitalWrite(LEFT, LOW);

   
  if(yVal < 50)
    digitalWrite(RIGHT, HIGH);
  else
    digitalWrite(RIGHT, LOW);

}
