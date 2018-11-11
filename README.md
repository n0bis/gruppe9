# gruppe9

Our version of World of Zuul

## Introduktion
Du er blevet inviteret til den store Halloween fest på dit universitet SDU. Du skal mødes med den frække sygeplejeske, du mødte til intro fest ugen, som du har haft noget kørende med siden. Du vil blive udfordret i hvordan du skal sno dig igennem gangene, find alternative ruter, hjælpe ting du møder på din vej, inden din frække date bliver sur over at i ikke når at deltage i årets par kostumer. Kan du klare mosten og nå ned i nendenunder hvor festen bliver holdt.

## How to play
Du skal nå igennem gangene på SDU på bare 20 minutter, ellers vil du gå glip af din date. Du navigere rundt på universitet med følgene kommandoer:
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
Fyr op i din cmd og navigere frem til folderen hvor WorldOfZuul.jar filen er placeret, så fyres denne kommando af:
```
java -jar WorldOfZuul.jar
```

## Directory structure
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

## Overview
<img src="https://github.com/n0bis/gruppe9/blob/master/wiki-img/arkitektur-design.png" height="500" alt="Arkitektur design"><br />
**Figur 1: Et diagram over arkitekturdesignet for World-of-Zuul.**
<br />
Ud fra figur 1 kan man se at diagrammet over arkitekturdesignet for World-of-Zuul er et pakkediagram, som består af en tolags lagdeling. Det første lag i diagrammet, som er navngivet ”textUI” er det man kalder GUI, hvilket er en forkortelse for ”Graphical User Interface”. GUI er alt det man kan se i et program. Forestil dig at du er inde på din Facebook forside, alt det du ser på forsiden, er GUI, mens alle de aktiviteter du kan udføre på Facebook, går ind under business/domain logikken. Business/domain logikken er i figur 1’s tilfælde lag to i diagrammet, som er navngivet ”domain”, hvor man ligesom kan se klasserne i World-of-Zuul og de forskellige commands i spillet.
<br />
![Detaljeret design](https://github.com/n0bis/gruppe9/blob/master/wiki-img/detaljeret-design.png)
**Figur 2: Et diagram over et detaljeret design for World-ofZuul.**
<br />
Ud fra figur 2 kan man derimod se, at det detaljerede design for World-of-Zuul er et klassediagram, som går under kategorien logical view. Et logical view er en objektorienteret nedbrydning af et system, hvilket vil sige, at et system bliver nedbrudt til mindre dele, hvilket eksempelvis kunne være i klasser og forholdene mellem disse klasser bliver beskrevet. I figur 2 kan man se, hvad sammenhængen mellem de forskellige klasser er, hvilket gør, at man kan få en overordnet idé om hvorfor klasserne er forbundet til hinanden. Dette fører os tilbage til ”logical view”, som ligesom viste forholdet bag de forskellige klasser.

Ud fra figur 2, kan man vurdere, at der er cohesion og coupling. Grunden til, at der er cohesion skyldes sammenhæng mellem klassen ”Game” og ”Room”. Disse to klassers sammenhæng er af typen high/høj-cohesion, hvilket skyldes at begge klasser udfører opgaver, som er relaterede til hinanden. Grunden til, at der er coupling i det detaljerede design er, at klassen ”Game” og ”Room” er afhængige af hinanden. Klasserne er så afhængige af hinanden, at man kan beskrive deres forhold som et child-parent forhold, hvilket også gør at det detaljerede design har en tæt coupling, hvilket ikke er godt, da de afhænger for meget af hinanden. 
