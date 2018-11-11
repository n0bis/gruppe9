# gruppe9

Our version of World of Zuul

## Introduktion
***
Du er blevet inviteret til den store Halloween fest på dit universitet SDU. Du skal mødes med den frække sygeplejske, du mødte til intro fest ugen, som du har haft noget kørende med siden. Du vil blive udfordret i hvordan du skal sno dig igennem gangene, find alternative ruter, hjælpe ting du møder på din vej, inden din frække date bliver sur over at i ikke når at deltage i årets par kostumer. Kan du klare mosten og nå ned i nenderunder hvor festen bliver holdt.

## How to play
***
Du skal nå igennem gangene på SDU på bare 20 minutter, ellers vil du gå glip af din date. Du navigere rundt på universitet med fælgene kommandoer:
```java
GO - "go"
QUIT - "quit"
HELP - "help"
SEARCH - "search"
DROP - "drop"
SHOW - "show"
TALK - "talk"
```

## Start the game
***
Fyr op i din cmd og navigere frem til folderen hvor WorldOfZuul.jar filen er placeret, så fyres denne kommando af:
```
java -jar WorldOfZuul.jar
```

## Directory structure
***
I root folderen ligger filer som ```.gitignore```, ```README.md```, ```LICENSE```, etc.
- ```src```: indeholder source koden
    - ```characters```: klasser der relateres til personer, dvs. Boss, NPC, etc.
    - ```command```: opsætning og afvikling af command-pattern
    - ```items```: klasser der relateres til ting, dvs. item, spell, etc.
    - ```missions```: klasser der har med missioner at gøre, dvs. quest
    - ```utils```: hjælpe funktioner som oftes laves som static metoder
    - ```world```: indkapsler vores verden, står for opsætning og afvikling af verdenen
    - ```worldofzuul```: sørger for at eksekvere spillet
- ```test```: et par basale unit-tests

