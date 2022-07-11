### Zadanie

Zaimplementuj `GuesserGame` tak, aby przy tworzeniu obiektu
została wylosowana tajna liczba, a metoda `guess` zwracała odpowiednie
`GuessResponse` w zależności od tego czy trafiono w tajną liczbę, 
czy podano za małą, a może za dużą wartość.

Tajna liczba ma być ograniczona parametrem `maxPlusOne`. 
Czyli jeżeli `maxPlusOne=100`, maksymalna dopuszczalna tajna liczba to `99`.
Minimalna dopuszczalna tajna liczba to zawsze `0`.

Do ograniczenia zakresu należy użyć operatora modulo `%`.