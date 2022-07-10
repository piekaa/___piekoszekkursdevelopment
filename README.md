### Zadanie

Pierwsza Springowa aplikacja. 
Możesz ją uruchomić tak jak inne, zieloną strzałką w klasie Main.

Potem w przeglądarce wejdź na http://localhost:8080

Zadanie polega na zaimplementowaniu `toBlackAndWhite`
w klasie `pl.piekoszek.image.ImageService` tak, aby
zamieniała obrazek na czarno-biały.

Metodą zamiany ma być obliczenie dla każdego pixela średniej z 
kolorów składowych (R, G, B).

Np. dla pixela kolorowego

````
R = 50
G = 100
B = 150
````
Ma wyjść pixel czarno-biały

````
R = 100
G = 100
B = 100
````