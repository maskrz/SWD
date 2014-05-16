SWD
===
Format for input file:

criteriaAmpunt - Integer<br>
criteria1 - String (suggested Capital - to discuss)<br>
...<br>
criteriaN<br>
nodesAmount - Integer<br>
node1Name x y - String Double Double<br>
...<br>
nodeNName<br>
linksAmount - Integer<br>
node11 node12 criteria11value ... criteria1Nvalue - Integer Integer Double ... Double<br>
...<br>
nodeN1 nodeN2 criteria11value ... criteriaNNvalue<br>
<br>
example:<br>
2<br>
DISTANCE<br>
TIME<br>
4<br>
one 1 1<br>
two 2 2<br>
three 3 3<br>
four 4 4<br>
4<br>
1 2 3 1<br>
1 3 1 2<br>
2 3 4 1<br>
3 4 1 5
