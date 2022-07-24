### Zadanie

Dostępny jest endpoint pod adresem `http://localhost:8080/api/temperature/cities` i metodą `GET`.
Zwraca tablicę obiektów z polami `city` i `temp` w formacie `JSON`

#### Przykładowa odpowiedź

````

[
  {
    "city": "Kraków",
    "temp": 10
  },
  {
    "city": "Białystok",
    "temp": 20.5
  },
  {
    "city": "Supraśl",
    "temp": 31
  }
]

````

Twoim zdaniem jest stworzenie endpointu `GET /api/hottest-city`, który
korzystając z endpointu `GET http://localhost:8080/api/temperature/cities`
Wybierze miasto z największą `temp` i zwróci nazwę miasta.

#### Przykładowa odpowiedź twojego endpointu

````
{
  "city": "Supraśl"
}
````