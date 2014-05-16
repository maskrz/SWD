SWD
===
Format for input file:

criteriaAmpunt - Integer
criteria1 - String (suggested Capital- to discuss)
...
criteriaN
nodesAmount - Integer
node1Name x y - String Double Double
...
nodeNName
linksAmount - Integer
node11 node12 criteria11value ... criteria1Nvalue - Integer Integer Double ... Double
...
nodeN1 nodeN2 criteria11value ... criteriaNNvalue

example:
2
DISTANCE
TIME
4
one 1 1
two 2 2
three 3 3
four 4 4
4
1 2 3 1
1 3 1 2
2 3 4 1
3 4 1 5
