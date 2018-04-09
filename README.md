# StudentChallenger

<b>Zámer projektu:</b>

Zámer projektu je vytvoriť e-learning software, ktorý by umožnil študentom jednoduché a efektívne vzdelávanie sa, zároveň podnietil a motivoval študentov k opätovnému používaniu za pomoci jednoduchých princípov hry a súťaživosti.
Študent si po vytvorení profilu zvolí predmet kde môže plniť úlohy a testy, tzv. výzvy. Úlohy a testy sú rôzne náročné a špecifikované (čas, nápovedy, multiple-choice...). Podľa obtiažnosti a úspešnosti riešenia sa študentovi pripisujú body, ktoré ho umiestňujú do celkového rebríčka všetkých študentov. Za plnenie špeciálnych či mimoriadne náročných úloh (napr. tri testy nad 95% po sebe) študent získava trofeje, ktoré sa mu taktiež pripisujú do profilu a ovplyvňujú poradie v rebríčku. V profile študenta sú zobrazené údaje ako skill-level študenta (začiatočník, pokročilý...), celkové body, odznaky, počet splnených úloh a testov, percentuálna úspešnosť v jednotlivých predmetoch, a mnohé iné. Získané trofeje či iné významné udalosti všetkých užívateľov budú vypisované v hlavnom menu.
Výsledkom tohto projektu bude softvér ktorý posilní motiváciu k štúdiu za pomoci jednoduchých princípov hry a súťaživosti ako aj prehľad učiteľa o výsledkoch a výkone študentov, či jednoduchá implementácia nových testov a trofejí učiteľom.


<b>Info k programu (pracovná verzia)</b>

Registracia -> login 
Vytvorenie vlastneho uctu
( alebo ucet: admin/root )

Po vybrati prislusneho testu sa spusti test s otazkami.
- Pri spravnej odpovedi sa uzivatelovi pripocita +1b
- Pri zlej odpovedi sa zobrazi spravna odpoved +0b
- po zodpovedani vsetkych otazok sa test vyhodnoti a uzivatelovi sa pripocitaju body popripade ziskane odznaky

Odznaky sleduje observer a ziskaju sa automaticky na zaklade splnenia podmienky pre dany odznak (napr. hotstreak)

V profile je sumar vsetkych udajov prisluchajucich danemu uzivatelovi.

Ladderboard zobrazuje tabulku s udajmi vsetkych uzivatelov - sortable

Vytvorenie noveho testu, ciastnocne gui, zatial cez konzolu.

