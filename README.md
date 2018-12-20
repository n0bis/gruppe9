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
Start en cmd og naviger frem til folderen hvor “SDUMaze.jar” filen er placeret, derefter køres der kommandoen: <br/>
```java .jar SDUMaze.jar```
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
For at skabe et hurtigt overblik over gruppens spil, er der blevet lavet en oversigt over spillets klassediagram. Dog har gruppen måtte erkende at dette klassediagram har meget coupling, som gør oversigten over spillet meget obskurt. Vi må derfor erkende at klassediagrammer ikke altid giver mening at have med i et dokument, da de kan være svære at få ind, men derimod giver et bedre overblik i et UML-program, der kan give et bedre overblik.
<img src="https://github.com/n0bis/gruppe9/blob/master/wiki-img/arkitektur-design.png" height="500" alt="Arkitektur design">
<br/>
**Figur 1: Dette er SDU Maze’s forsimplede klassediagram.**
<br/>
<img src="https://github.com/n0bis/gruppe9/blob/master/wiki-img/arkitektur-design.png" height="500" alt="Arkitektur design">
<br/>
**Figur 2: Arkitektur oversigt for SDU Maze.**

Der blev valgt at implementere View-Controller arkitektur og ikke en MVC arkitektur, da spillet ikke behøvede at sende en model til viewet, da vores controller ikke havde behov for at skulle opdatere en database med hvad spilleren har ændret/fortaget sig. Dvs. at man kun har en controller som sørger for at sende et view ud til spilleren, og på viewet er der implementeret ting som brugeren kan integrere med, ved at klikke på det. Derudover kan vi konkludere de samme benefits fra 1. iteration.

