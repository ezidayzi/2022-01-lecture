int trig = 12 ;

int echo = 11 ;

float duration;

float distance;

void setup() 

{

  Serial.begin(9600);

  pinMode(trig,OUTPUT);

  pinMode(echo,INPUT);

}

 

void loop() 

{

  digitalWrite(trig,HIGH);

  delay(10);

  digitalWrite(trig,LOW);

  duration = pulseIn(echo,HIGH);     //pulseIn함수의 단위는 ms(마이크로 세컨드)

  distance = ((34000*duration)/1000000)/2;

  Serial.println(distance);


}
