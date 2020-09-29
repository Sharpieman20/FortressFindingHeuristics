This repository tests out various Nether Fortress Search Algorithms

Speedrunners familiar with Pre 1.16 running are familiar with the "East/West" rule. It posits that because fortresses spawn in strips that are oriented from North to South, one should travel east or west from their spawn location in order to find a fortress as quickly as possible.

This repository contains code to test this "rule" against other potential rules, such as a "North/South rule", as well as an "Optimal rule". It does this by randomly selecting a portal location in the (-1, -1), (-1, 0), (0, -1), and (0,0) regions and applying the rule from there, checking if there is a fortress in the region or not. Then it calculates the number of regions "walked" from the portal and back (assuming you take the same exact path back and don't shortcut). This is the "cost" associated with traveling for a given seed.

The average distances per algorithm are as follows:

North/South rule: 1.818738\
East/West rule: 0.961536\
Switch Z, then East/West rule: 0.814782\
Optimal rule: (WIP, Finishing up Optimal algorithm)

From time to time I might attempt to make various improvements to this repository, if anyone is interested in helping out just let me know.
These include attempting to account for terrain navigation cost tradeoffs, visibility of fortresses, and writing an in-game bot to test the algorithms in practical circumstances.