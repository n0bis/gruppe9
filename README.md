# gruppe9

Our version of World of Zuul

## Introduktion
Du er blevet inviteret til den store Halloween fest på dit universitet SDU. Du skal mødes med den frække sygeplejeske, du mødte til intro fest ugen, som du har haft noget kørende med siden. Du vil blive udfordret i hvordan du skal sno dig igennem gangene, find alternative ruter, hjælpe ting du møder på din vej, inden din frække date bliver sur over at i ikke når at deltage i årets par kostumer. Kan du klare mosten og nå ned i nendenunder hvor festen bliver holdt.

## How to play
Spilleren skal nå igennem gangene på SDU på 20 minutter, ellers vil man gå glip af sin date, som man skal mødes med nedenunder i fredagsbaren. man navigerer sig rundt ved at klikke på pilene, som kan ses på de forskellige scener i spillet. Man skal huske at samle ting man ser op undervejs, men man skal også sørge for at have tid til at snakke med de forskellige NPC’er man møder på sin vej og de forskellige udfordringer man møder på sin vej til Nedenunder.

## Start the game
Du kan downloade spillet [her](https://github.com/n0bis/gruppe9/releases/tag/2.0)
<br/>
## Windows bruger
Start en cmd og naviger frem til folderen hvor “SDUMaze.jar” filen er placeret, derefter køres der kommandoen: ```java .jar SDUMaze.jar```
## Mac bruger
kan nøjes med at navigere hen til folderen og så dobbeltklik på .jar 
## OBS
Det kan være at Spillet ikke kan komme videre fra intro videoen, i dette tilfælde bør ```SDUMazeNoIntro.jar``` benyttes.

## Directory structure
I root folderen ligger filer som ```.gitignore```, ```README.md```, ```LICENSE```, etc.
- ```src```: indeholder source koden
    - ```characters```: klasser der relateres til personer, dvs. Boss, NPC, etc.
    - ```command```: opsætning og afvikling af command-pattern
    - ```controllers```: sørger for at give et view til brugeren og tage imod en action fra brugeren
        - ```subfolder```: opdelt i gang navne eller bygning fx. “controllers/Krogene”
    - ```items```: klasser der relateres til ting, dvs. item, spell, etc.
    - ```missions```: klasser der har med missioner at gøre, dvs. quest
    - ```utils```: hjælpe funktioner som oftes laves som static metoder
    - ```world```: indkapsler vores verden, står for opsætning og afvikling af verdenen
    - ```worldofzuul```: sørger for at eksekvere spillet
- ```resources```: indeholder ikke kode filer
    - ```images```: indeholder billeder af skolen
    - ```NPC```: forskellige billeder af non-playing-characters
    - ```gameofthrones```: billeder relateret til Game of Thrones tema
    - ```harrypotter```: billeder relateret til Harry Potter tema
    - ```lordoftherings```: billeder relateret til Lord of the Rings tema
    - ```items```: billeder af ting som kan samles op, eller fås af en mission
    - ```menu```: billeder relateret til menu’en
    - ```rooms```: billeder af nogle af rummene 
    - ```startscreen```: billeder til tema vælger
    - ```sounds```: alle lydfiler
    - ```styles```: alle css filer
    - ```videos```: alle video filer
    - ```views```: alle vores views til brugeren

## Overview
<img src="https://github.com/n0bis/gruppe9/blob/master/wiki-img/arkitektur-design.png" height="500" alt="Arkitektur design"><br />
**Figur 1: Et diagram over arkitekturdesignet for World-of-Zuul.**
<br />
Ud fra figur 1 kan man se at diagrammet over arkitekturdesignet for World-of-Zuul er et pakkediagram, som består af en tolags lagdeling. Det første lag i diagrammet, som er navngivet ”textUI” er det man kalder GUI, hvilket er en forkortelse for ”Graphical User Interface”. GUI er alt det man kan se i et program. Forestil dig at du er inde på din Facebook forside, alt det du ser på forsiden, er GUI, mens alle de aktiviteter du kan udføre på Facebook, går ind under business/domain logikken. Business/domain logikken er i figur 1’s tilfælde lag to i diagrammet, som er navngivet ”domain”, hvor man ligesom kan se klasserne i World-of-Zuul og de forskellige commands i spillet.
<br />
![Detaljeret design](https://github.com/n0bis/gruppe9/blob/master/wiki-img/detaljeret-design.png)
**Figur 2: Et diagram over et detaljeret design for World-of-Zuul.**
<br />
Ud fra figur 2 kan man derimod se, at det detaljerede design for World-of-Zuul er et klassediagram, som går under kategorien logical view. Et logical view er en objektorienteret nedbrydning af et system, hvilket vil sige, at et system bliver nedbrudt til mindre dele, hvilket eksempelvis kunne være i klasser og forholdene mellem disse klasser bliver beskrevet. I figur 2 kan man se, hvad sammenhængen mellem de forskellige klasser er, hvilket gør, at man kan få en overordnet idé om hvorfor klasserne er forbundet til hinanden. Dette fører os tilbage til ”logical view”, som ligesom viste forholdet bag de forskellige klasser.

Ud fra figur 2, kan man vurdere, at der er cohesion og coupling. Grunden til, at der er cohesion skyldes sammenhæng mellem klassen ”Game” og ”Room”. Disse to klassers sammenhæng er af typen high/høj-cohesion, hvilket skyldes at begge klasser udfører opgaver, som er relaterede til hinanden. Grunden til, at der er coupling i det detaljerede design er, at klassen ”Game” og ”Room” er afhængige af hinanden. Klasserne er så afhængige af hinanden, at man kan beskrive deres forhold som et child-parent forhold, hvilket også gør at det detaljerede design har en tæt coupling, hvilket ikke er godt, da de afhænger for meget af hinanden. 

![Udvidet uml design](https://github.com/n0bis/gruppe9/blob/master/wiki-img/zuul-diagram.png)
**Figur 3: Udvidet uml design med udbygget funktioner**
