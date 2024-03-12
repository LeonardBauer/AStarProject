# A* Algorithmus

#### Leonard Bauer

#### März 2024


## Inhaltsverzeichnis


- 1 Die Idee des A*-Algorithmus
	- 1.1 Ursprung
	- 1.2 Grundprinzip
	- 1.3 Vorteile
	- 1.4 Anwendungsgebiete
	- 1.5 Zusammenfassung
- 2 Funktionsweise des A*-Algorithmus
	- 2.1 Suchalgorithmen
		- 2.1.1 Informierte Suche
		- 2.1.2 Best-First-Search
	- 2.2 Schrittabfolge
- 3 Anwendungszwecke f ̈ur den A*-Algorithmus
	- 3.1 Routenplanung
	- 3.2 Spielentwicklung
	- 3.3 Optimierungsprobleme
	- 3.4 Weitere Anwendungsgebiete
- 4 Eigenschaften des A*-Algorithmus
	- 4.1 Vollst ̈andigkeit
	- 4.2 Optimalit ̈at
	- 4.3 Effizienz
	- 4.4 Zul ̈assigkeit
	- 4.5 Speicher Benutzung
- 5 Nachteile A*-Algorithmus
	- 5.1 Komplexit ̈at
	- 5.2 Speicherbedarf
	- 5.3 Heuristikabh ̈angigkeit
	- 5.4 Verzerrung (Bias)
	- 5.5 Nicht f ̈ur dynamische Umgebungen geeignet
- 6 Angewandtes Beispiel
	- 6.1 Ablauf


Kapitel 1

Die Idee des

A*-Algorithmus

### 1.1 Ursprung

Die Idee hinter dem A*-Algorithmus entstand aus dem Bestreben, eine Steue-
rung f ̈ur mobile Roboter zu entwickeln, die ihre eigenen Aktionen planen k ̈onnen.

### 1.2 Grundprinzip

Der A*-Algorithmus basiert auf zwei Hauptprinzipien:

- Informierte Suche: Der Algorithmus nutzt eine Heuristik, um den Abstand
  zwischen dem aktuellen Knoten und dem Zielknoten abzusch ̈atzen. Diese
  Heuristik lenkt die Suche in Richtung des Ziels und erm ̈oglicht es dem
  Algorithmus, effizienter zu sein als uninformierte Suchalgorithmen.
- Best-First-Search: Der Algorithmus w ̈ahlt immer den Knoten mit der nied-
  rigsten Gesamtbewertung als n ̈achsten zu bearbeitenden Knoten. Die Ge-
  samtbewertung setzt sich aus den tats ̈achlichen Kosten, um zum aktuellen
  Knoten zu gelangen, und der gesch ̈atzten Kosten, um vom aktuellen Kno-
  ten zum Ziel zu gelangen, zusammen.

### 1.3 Vorteile

Der A*-Algorithmus hat mehrere Vorteile:

- Optimalit ̈at: Der Algorithmus findet garantiert den kurzesten Pfad zwi- ̈
  schen zwei Knoten, sofern eine solche L ̈osung existiert.


- Effizienz: Die Verwendung einer Heuristik erm ̈oglicht es dem Algorithmus,
  den Suchraum schnell zu durchsuchen und den Pfad in kurzer Zeit zu
  finden.
- Flexibilit ̈at: Der Algorithmus kann mit unterschiedlichen Umgebungen
  und Hindernissen umgehen.
- Robustheit: Der Algorithmus ist auch bei ungenauen Sensorinformationen
  und unvorhergesehenen Ereignissen funktionsf ̈ahig.

### 1.4 Anwendungsgebiete

Der A*-Algorithmus findet in einer Vielzahl von Anwendungsgebieten Anwen-
dung, z. B.:

- Robotik: Der Algorithmus wird zur Pfadplanung f ̈ur mobile Roboter ein-
  gesetzt.
- Navigationssysteme: Der Algorithmus wird zur Berechnung von Routen
  in Navigationssystemen verwendet.
- Spieleentwicklung: Der Algorithmus wird in der Spieleentwicklung verwen-
  det, um die Bewegung von Spielfiguren zu steuern.
- Kunstliche Intelligenz: Der Algorithmus wird in der KI-Forschung einge- ̈
  setzt, um Probleme wie Pfadplanung und Suchprobleme zu l ̈osen.

### 1.5 Zusammenfassung

Zusammenfassend l ̈asst sich sagen, dass der A*-Algorithmus ein effizienter, fle-
xibler und robuster Algorithmus zur Suche nach dem k ̈urzesten Pfad zwischen
zwei Knoten in einem Graphen ist.


Kapitel 2

Funktionsweise des

A*-Algorithmus

Der A*-Algorithmus durchsucht einen Graphen, um den k ̈urzesten Pfad zwi-
schen einem Startknotensund einem Zielknotentzu finden. Dabei verwendet
er zwei Hauptprinzipien:

### 2.1 Suchalgorithmen

#### 2.1.1 Informierte Suche

Der Algorithmus nutzt eine Heuristikh(n) um den Abstand zwischen dem ak-
tuellen Knotennund dem Zielknotentabzusch ̈atzen. Diese Heuristik lenkt die
Suche in Richtung des Ziels und erm ̈oglicht es dem Algorithmus, effizienter zu
sein als uninformierte Suchalgorithmen. Der A*-Algorithmus basiert auf einem
Gewichteten Graphen.

#### 2.1.2 Best-First-Search

Der Algorithmus w ̈ahlt immer den Knotennmit der niedrigsten Gesamtbewer-
tungf(n) als n ̈achsten zu bearbeitenden Knoten. Die Gesamtbewertung setzt
sich aus zwei Teilen zusammen:

- g(n): Die tats ̈achlichen Kosten, um vom Startknotenszum aktuellen Kno-
  tennzu gelangen.
- h(n): Die gesch ̈atzten Kosten, um vom aktuellen Knotennzum Zielknoten
  tzu gelangen.


### 2.2 Schrittabfolge

1. Der Algorithmus initialisiert den Startknotensmit einer Gesamtbewer-
   tung vonf(s) =g(s) +h(s).
2. Der Algorithmus f ̈ugt den Startknotensin eine Open-Set-Liste ein.
3. Solange die Open-Set-Liste nicht leer ist:
	- Der Algorithmus entfernt den Knotennmit der niedrigsten Gesamt-
	  bewertungf(n) aus der Open-Set-Liste und f ̈ugt ihn in eine Closed-
	  Set-Liste ein.
	- F ̈ur alle Nachbarknotenmdes aktuellen Knotenn:
		- Berechne die tats ̈achlichen Kosteng(m) um vom Startknotens
		  zum Nachbarknotenmzu gelangen.
		- Berechne die gesch ̈atzten Kostenh(m) um vom Nachbarknoten
		  mzum Zielknotentzu gelangen.
		- Berechne die Gesamtbewertungf(m) =g(m) +h(m) des Nach-
		  barknotensm.
		- Wenn der Nachbarknotenmnicht in der Open-Set-ListeOP EN
		  ist, f ̈uge ihn mit seiner Gesamtbewertungf(m) in die Open-Set-
		  ListeOP ENein.


Kapitel 3

Anwendungszwecke fur den ̈

A*-Algorithmus

### 3.1 Routenplanung

Navigationssysteme: A* ist die Grundlage f ̈ur viele Navigationssysteme in
Autos und auf Smartphones. Es berechnet die schnellste Route zwischen einem
Start- und Zielpunkt unter Ber ̈ucksichtigung von Straßenverkehr, Verkehrsregeln
und anderen Faktoren.
Flugplanung: Fluggesellschaften nutzen A*, um optimale Flugrouten zu
finden, die Treibstoffverbrauch und Flugzeit minimieren.
Roboternavigation: A* erm ̈oglicht Robotern, sich in ihrer Umgebung zu
bewegen und Hindernissen auszuweichen, um ihre Ziele zu erreichen.

### 3.2 Spielentwicklung

Wegfindung in Spielen: In Computerspielen wird A* verwendet, um die
Wegfindung von Spielfiguren und NPCs zu steuern. So k ̈onnen sie sich in der
Spielwelt effizient bewegen und auf ihre Ziele zugehen.
KI-Gegner: A* kann verwendet werden, um KI-Gegner in Spielen zu ent-
wickeln, die intelligent navigieren und optimale Entscheidungen treffen k ̈onnen.
Levelgenerierung: A* kann in der Levelgenerierung eingesetzt werden,
um automatisch Level zu erstellen, die bestimmte Anforderungen erfullen, z.B. ̈
eine bestimmte L ̈ange oder Schwierigkeit.

### 3.3 Optimierungsprobleme

Aufgabenplanung: A* kann verwendet werden, um die optimale Reihenfolge
von Aufgaben in einem Projekt zu finden.


Ressourcenzuweisung: A* kann helfen, Ressourcen effizient zuzuordnen,
um ein bestimmtes Ziel zu erreichen.
Netzwerkoptimierung: A* kann in der Netzwerkoptimierung eingesetzt
werden, um den optimalen Weg fur Daten oder G ̈ ̈uter durch ein Netzwerk zu
finden.

### 3.4 Weitere Anwendungsgebiete

Suchmaschinen: A* kann verwendet werden, um die optimale Reihenfolge
von Suchanfragen zu finden, um die relevantesten Ergebnisse zu finden.
Bioinformatik: A* kann in der Bioinformatik eingesetzt werden, um z.B.
die optimale Route fur DNA-Sequenzierung zu finden. ̈


Kapitel 4

Eigenschaften des

A*-Algorithmus

A* hat viele eigenschaften, wegen denen er weit verbreitet ist.

### 4.1 Vollst ̈andigkeit

A* wird immer eine L ̈osung finden falls eine existiert, und ween der Graph
endlich ist und es keine unendlichen kosten gibt.

### 4.2 Optimalit ̈at

A* garentiert den kurzesten Weg zu dem Ziel zu finden, wenn bestimmte Kondi- ̈
tion erf ̈ullt sind, zum beispiel ein zuverl ̈assiges Heuristisches verfahren zu haben,
das niemals die Kostenuberscha ̈ ̈atzt.

### 4.3 Effizienz

Auch wenn A* keine Garantie fur die Zeitkomplexit ̈ ̈at im schlimmsten Fall bie-
tet, schneidet es in der Praxis aufgrund seiner heuristischen Fuhrung und der ̈
Auslese weniger vielversprechender Pfade oft gut ab.

### 4.4 Zul ̈assigkeit

A* requires an admissible heuristic to ensure optimality. An admissible heuristic
never overestimates the cost to reach the goal, meaning the actual cost to reach
the goal will never be greater than the estimated cost provided by the heuristic.


### 4.5 Speicher Benutzung

A* erfordert in der Regel die Speicherung aller besuchten Knoten, was in Um-
gebungen mit begrenztem Speicherplatz oder bei großen Graphen ein Problem
darstellen kann. Verschiedene Optimierungen, wie die Verwendung einer Prio-
rit ̈atswarteschlange, k ̈onnen dieses Problem jedoch entsch ̈arfen.


Kapitel 5

Nachteile A*-Algorithmus

### 5.1 Komplexit ̈at

Die Laufzeit des A*-Algorithmus kann exponentiell mit der Gr ̈oße des Such-
raums wachsen, insbesondere wenn der Suchraum sehr groß oder un ̈ubersichtlich
ist. Dies kann zu l ̈angeren Berechnungszeiten fuhren, insbesondere wenn der ̈
Graph stark verzweigt ist.

### 5.2 Speicherbedarf

A* ben ̈otigt Speicherplatz, um die bereits besuchten Knoten und diejenigen, die
noch besucht werden m ̈ussen, zu verfolgen. Dies kann bei großen Suchr ̈aumen zu
einem erheblichen Speicherbedarf f ̈uhren, insbesondere wenn der Algorithmus
viele Knoten im Speicher behalten muss.

### 5.3 Heuristikabh ̈angigkeit

Die Effizienz des A*-Algorithmus h ̈angt stark von der Qualit ̈at der Heuristik
ab. Eine schlechte Heuristik kann dazu f ̈uhren, dass der Algorithmus unn ̈otig
viele Knoten erkundet oder sogar zu einer suboptimalen L ̈osung f ̈uhrt.

### 5.4 Verzerrung (Bias)

Wenn die Heuristik nicht konsistent ist, kann der A*-Algorithmus zu einer
Verzerrung f ̈uhren, was bedeutet, dass er die kurzeste oder optimale L ̈ ̈osung
m ̈oglicherweise nicht findet. Dies kann insbesondere bei ungleichm ̈aßig verteil-
ten Kosten im Graphen auftreten.


### 5.5 Nicht f ̈ur dynamische Umgebungen geeignet

A* ist nicht gut geeignet f ̈ur dynamische Umgebungen, in denen sich die Kosten
oder Hindernisse w ̈ahrend der Suche ̈andern k ̈onnen. Da A* nur einmal eine
Sch ̈atzung der Gesamtkosten berechnet, kann sich dies als ineffizient erweisen,
wenn sich die Umgebung w ̈ahrend der Suche ̈andert.


Kapitel 6

Angewandtes Beispiel

Die Kosten Berechnung setzt sich ausF=G+H
G ist dabei Kosten vom Start und H sind die Kosten zum Ziel.
Hier ist ein Beispiel das das Pathfinding von einem Auto zum Ziel Behandelt.

- Gesperrte Zelle (Closed List)
- Hinderniss
- Offene Zelle (Open List)

### 6.1 Ablauf

```
Die Karte wird mit einem Start, einem Ziel und
Hindernissen initialisiert
```
```
Bei jedem Durchlauf wird das aktuelle Feld zur
gesperrten Liste hinzugef ̈ugt.
Dann wird die ausgew ̈ahlte Heuristik aus-
gew ̈ahlt und damit der Weg von Start bis Ziel
gesch ̈atzt gr ̈une Linien. Dann werden die Feld
Kosten berechnet mit der FormelF =G+H.
Das Diagonal unten ist das Gunstigste deswegen ̈
ist dies der n ̈achste Schritt.
```

Das aktuelle Feld wird wieder Gesperrt da die
anderen beiden Felder schon zur Open List hin-
zugef ̈ugt wurden m ̈ussen nicht nochmal die Ko-
sten berechnet werden.

Wenn eine Deadlock Sitatuation entsteht wird
zu der n ̈achsten Top Priority in der Open List
gegangen und von dort aus weiter gesucht.

Das Feld wird wieder zur Closed List hinzu-
gef ̈ugt. Das Einzige M ̈ogliche Feld wird zur
Open List hinzugefugt. Bei de Manhattan Heu- ̈
ristik h ̈atte das Feld den WertH = 40 und
G= 20. Also insgesamt Kosten von 60.

Es kann nur diagonal gegangen werden wenn die
xund dieyRichtung frei sind.
Diagonal gehen kostet 14 da die Quadratwurzel
aus

##### √ 2 = 1. 41 ...

Wenn das Ziel in der Open List steht ist es er-
reicht.

Vom Ziel wird nun r ̈uckw ̈arts der K ̈urzeste Pfad
ausgewertet indem man den Parent der Felder
nimmt die vom Start zum Ziel f ̈uhren. Also man
f ̈angt man mit dem letzten Feld an und schaut
wer dieses untersucht hat usw. Bis man am Start
angekommen ist.


