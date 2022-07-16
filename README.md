### Zadanie

Zadanie polega na zaimplementowaniu `reverseColors`
w klasie `pl.piekoszek.image.ImageService` tak, zwaracała nowy obrazek z odwróconymi kolorami.

Musisz także dorobić endpoint `POST /api/reverse-colors` przyjmujący dane binarne obrazu PNG
i zwracający dane binarne nowego obrazu PNG z odwróconami kolorami.

#### Obrazek Musi być w formacie PNG!

Np. dla pixela

````
R = 50
G = 100
B = 150
````
Ma wyjść pixel z odwróconymi kolorami

(maksymalna wartość każdej składowej koloru minus obecna wartość każdej składowej koloru)

````
R = 205
G = 155
B = 105
````