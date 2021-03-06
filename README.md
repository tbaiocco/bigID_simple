# Big ID - Challenge Simple

## Run instructions
This project was built and compiled under AdoptOpenJDK JAVA 11, release jdk-11.0.10.9-hotspot, you can get it here (according to your OS): https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/tag/jdk-11.0.10%2B9
### Command line run
First get the jar file at: https://github.com/tbaiocco/bigID_simple/blob/master/build/libs/bigID_simple-1.0-SNAPSHOT.jar
Execute it locally:
`%YOUR_JAVA11_BIN_FOLDER%/java -jar %DOWNLOADED_FILEPATH%/bigID_simple-1.0-SNAPSHOT.jar`
### Gradle run
First download the project, or clone on github: https://github.com/tbaiocco/bigID_simple
Use the embedded gradle wrapper:
`windows: gradlew.bat run`
`linux: ./gradlew run`

## Challenge Description
BigID - Backend Dev Task  ~v1.5~

Design and implement a simple Java program to find specific strings in a large text. The
program should be composed of the following modules:
1. The main module - reads a large text file in parts (e.g. 1000 lines in each part) and
   sends each part (as string) to a matcher. After all matchers completed, it calls the
   aggregator to combine and print the results
2. The matcher - gets a text string as input and searches for matches of a given set of
   strings. The result is a map from a word to its location(s) in the text
3. The aggregator - aggregates the results from all the matchers and prints the results.

For this task, please use the text at http://norvig.com/big.txt, and the strings to find should be
the 50 most common English first names:
```
James,John,Robert,Michael,William,David,Richard,Charles,Joseph,Thomas,Christopher,Daniel,Paul,Mark,Donal
d,George,Kenneth,Steven,Edward,Brian,Ronald,Anthony,Kevin,Jason,Matthew,Gary,Timothy,Jose,Larry,Jeffrey,
Frank,Scott,Eric,Stephen,Andrew,Raymond,Gregory,Joshua,Jerry,Dennis,Walter,Patrick,Peter,Harold,Douglas,H
enry,Carl,Arthur,Ryan,Roger
```

Example of one line from the program output based on the input above:
Timothy --> [[lineOffset=13000, charOffset=19775], [lineOffset=13000, charOffset=42023]]

There should be several concurrent matchers (i.e each matcher should run in a separate
thread).

The results should be printed (in no particular order) after all text pieces have been
processed.

Please provide a main method that executes a sample run.

This task should be done alone. You can make use of any written or web resource you find,
incl. 3rd party libraries).

The code should work, and be as clean and efficient as you think necessary.

### Expected example result log:
```
10:40:10.511 [main] INFO     c.b.c.ReadMatchAggregateApp - *** Starting processing file: http://norvig.com/big.txt
10:40:10.513 [main] INFO   c.b.challenge.utils.InfoUtils - Max Memory: 8146 Mb
10:40:10.513 [main] INFO   c.b.challenge.utils.InfoUtils - Total Memory: 510 Mb
10:40:10.513 [main] INFO   c.b.challenge.utils.InfoUtils - Free Memory: 502 Mb
10:40:12.973 [main] INFO        c.b.c.service.FileReader - File size: 6488666 bytes
10:40:14.723 [main] INFO  c.b.c.service.ResultAggregator - *** Alphabetical Ordered Results ***************************************************************
10:40:14.727 [main] INFO  c.b.c.service.ResultAggregator - Andrew --> [[lineOffset=13779, charOffset=62], [lineOffset=14124, charOffset=15], [lineOffset=14190, charOffset=32], [lineOffset=14234, charOffset=56], [lineOffset=14420, ch
arOffset=6], [lineOffset=14785, charOffset=6], [lineOffset=14882, charOffset=24], [lineOffset=14913, charOffset=32], [lineOffset=14963, charOffset=26], [lineOffset=15617, charOffset=56], [lineOffset=15801, charOffset=36], [lineOffse
t=17202, charOffset=9], [lineOffset=17956, charOffset=41], [lineOffset=18065, charOffset=25], [lineOffset=18181, charOffset=2], [lineOffset=18181, charOffset=65], [lineOffset=22281, charOffset=33], [lineOffset=22287, charOffset=25],
 [lineOffset=22756, charOffset=15], [lineOffset=23827, charOffset=32], [lineOffset=28694, charOffset=10], [lineOffset=28716, charOffset=10], [lineOffset=54901, charOffset=60], [lineOffset=54930, charOffset=8], [lineOffset=54931, cha
rOffset=24], [lineOffset=54933, charOffset=21], [lineOffset=54944, charOffset=31], [lineOffset=54960, charOffset=28], [lineOffset=55090, charOffset=8], [lineOffset=55146, charOffset=33], [lineOffset=55158, charOffset=42], [lineOffse
t=55165, charOffset=8], [lineOffset=55246, charOffset=8], [lineOffset=55278, charOffset=1], [lineOffset=55285, charOffset=36], [lineOffset=55290, charOffset=8], [lineOffset=55363, charOffset=8], [lineOffset=55406, charOffset=21], [l
ineOffset=55423, charOffset=30], [lineOffset=55447, charOffset=50], [lineOffset=55454, charOffset=13], [lineOffset=55458, charOffset=22], [lineOffset=55465, charOffset=28], [lineOffset=55470, charOffset=28], [lineOffset=55486, charO
ffset=59], [lineOffset=55492, charOffset=32], [lineOffset=55501, charOffset=8], [lineOffset=55504, charOffset=34], [lineOffset=55511, charOffset=8], [lineOffset=55529, charOffset=1], [lineOffset=55532, charOffset=55], [lineOffset=55
556, charOffset=1], [lineOffset=55585, charOffset=52], [lineOffset=55596, charOffset=1], [lineOffset=55600, charOffset=6], [lineOffset=55602, charOffset=59], [lineOffset=55606, charOffset=18], [lineOffset=55614, charOffset=50], [lin
eOffset=55618, charOffset=24], [lineOffset=55625, charOffset=42], [lineOffset=55637, charOffset=8], [lineOffset=55645, charOffset=21], [lineOffset=55668, charOffset=31], [lineOffset=55668, charOffset=46], [lineOffset=55676, charOffs
et=46], [lineOffset=55699, charOffset=29], [lineOffset=55704, charOffset=24], [lineOffset=55724, charOffset=24], [lineOffset=55731, charOffset=55], [lineOffset=55741, charOffset=45], [lineOffset=55744, charOffset=22], [lineOffset=55
748, charOffset=4], [lineOffset=55756, charOffset=38], [lineOffset=55770, charOffset=8], [lineOffset=55782, charOffset=41], [lineOffset=55788, charOffset=34], [lineOffset=55819, charOffset=51], [lineOffset=55823, charOffset=44], [li
neOffset=59026, charOffset=25], [lineOffset=59406, charOffset=19], [lineOffset=59412, charOffset=26], [lineOffset=59432, charOffset=8], [lineOffset=59449, charOffset=57], [lineOffset=59454, charOffset=31], [lineOffset=59459, charOff
set=28], [lineOffset=59464, charOffset=1], [lineOffset=59465, charOffset=37], [lineOffset=59476, charOffset=55], [lineOffset=59479, charOffset=8], [lineOffset=59483, charOffset=34], [lineOffset=59492, charOffset=33], [lineOffset=595
01, charOffset=38], [lineOffset=59522, charOffset=31], [lineOffset=59530, charOffset=22], [lineOffset=59544, charOffset=13], [lineOffset=59561, charOffset=31], [lineOffset=59567, charOffset=24], [lineOffset=59579, charOffset=8], [li
neOffset=59598, charOffset=8], [lineOffset=59621, charOffset=41], [lineOffset=59667, charOffset=47], [lineOffset=59672, charOffset=60], [lineOffset=59684, charOffset=53], [lineOffset=59732, charOffset=12], [lineOffset=59752, charOff
set=55], [lineOffset=59762, charOffset=8], [lineOffset=59779, charOffset=1], [lineOffset=59839, charOffset=8], [lineOffset=59841, charOffset=50], [lineOffset=59848, charOffset=51], [lineOffset=59855, charOffset=1], [lineOffset=59880
, charOffset=5], [lineOffset=59884, charOffset=8], [lineOffset=59888, charOffset=7], [lineOffset=59899, charOffset=8], [lineOffset=59906, charOffset=50], [lineOffset=59913, charOffset=1], [lineOffset=59928, charOffset=50], [lineOffs
et=59936, charOffset=27], [lineOffset=59939, charOffset=29], [lineOffset=59950, charOffset=1], [lineOffset=59958, charOffset=22], [lineOffset=59961, charOffset=1], [lineOffset=59975, charOffset=62], [lineOffset=59985, charOffset=2],
 [lineOffset=59989, charOffset=31], [lineOffset=59999, charOffset=56], [lineOffset=60001, charOffset=10], [lineOffset=60005, charOffset=57], [lineOffset=60012, charOffset=26], [lineOffset=60030, charOffset=38], [lineOffset=60049, ch
arOffset=2], [lineOffset=60053, charOffset=29], [lineOffset=60057, charOffset=33], [lineOffset=60064, charOffset=8], [lineOffset=60078, charOffset=8], [lineOffset=60082, charOffset=40], [lineOffset=60093, charOffset=48], [lineOffset
=60097, charOffset=13], [lineOffset=60127, charOffset=8], [lineOffset=60143, charOffset=35], [lineOffset=60161, charOffset=1], [lineOffset=60188, charOffset=1], [lineOffset=60194, charOffset=29], [lineOffset=60204, charOffset=46], [
lineOffset=60218, charOffset=20], [lineOffset=60221, charOffset=8], [lineOffset=60228, charOffset=2], [lineOffset=60242, charOffset=14], [lineOffset=60245, charOffset=1], [lineOffset=60578, charOffset=39], [lineOffset=60593, charOff
set=33], [lineOffset=60846, charOffset=38], [lineOffset=60901, charOffset=55], [lineOffset=60929, charOffset=1], [lineOffset=60936, charOffset=8], [lineOffset=60941, charOffset=46], [lineOffset=60954, charOffset=8], [lineOffset=6096
3, charOffset=19], [lineOffset=60967, charOffset=13], [lineOffset=60969, charOffset=27], [lineOffset=60973, charOffset=20], [lineOffset=60983, charOffset=8], [lineOffset=60991, charOffset=25], [lineOffset=60996, charOffset=8], [line
Offset=61037, charOffset=8], [lineOffset=61050, charOffset=48], [lineOffset=61055, charOffset=56], [lineOffset=61060, charOffset=16], [lineOffset=61097, charOffset=52], [lineOffset=61120, charOffset=39], [lineOffset=62565, charOffse
t=8], [lineOffset=62571, charOffset=46], [lineOffset=62583, charOffset=18], [lineOffset=62606, charOffset=8], [lineOffset=62608, charOffset=30], [lineOffset=62622, charOffset=39], [lineOffset=62627, charOffset=25], [lineOffset=62643
, charOffset=38], [lineOffset=62645, charOffset=48], [lineOffset=62650, charOffset=8], [lineOffset=62669, charOffset=8], [lineOffset=62675, charOffset=59], [lineOffset=62692, charOffset=18], [lineOffset=62707, charOffset=13], [lineO
ffset=62720, charOffset=8], [lineOffset=62724, charOffset=44], [lineOffset=62729, charOffset=36], [lineOffset=62735, charOffset=8], [lineOffset=62743, charOffset=11], [lineOffset=62744, charOffset=54], [lineOffset=62745, charOffset=
37], [lineOffset=62810, charOffset=30], [lineOffset=62826, charOffset=1], [lineOffset=62837, charOffset=30], [lineOffset=62883, charOffset=1], [lineOffset=62898, charOffset=8], [lineOffset=62911, charOffset=40], [lineOffset=62925, c
harOffset=33], [lineOffset=62941, charOffset=28], [lineOffset=62946, charOffset=13], [lineOffset=62991, charOffset=27], [lineOffset=63016, charOffset=62], [lineOffset=63029, charOffset=18], [lineOffset=63038, charOffset=39], [lineOf
fset=63047, charOffset=50], [lineOffset=63077, charOffset=61], [lineOffset=63105, charOffset=21], [lineOffset=63111, charOffset=58], [lineOffset=63117, charOffset=8], [lineOffset=63157, charOffset=28], [lineOffset=63157, charOffset=
53], [lineOffset=63180, charOffset=38], [lineOffset=63190, charOffset=26], [lineOffset=63199, charOffset=8], [lineOffset=63208, charOffset=54], [lineOffset=63243, charOffset=29], [lineOffset=63304, charOffset=36], [lineOffset=63317,
 charOffset=52], [lineOffset=63330, charOffset=12], [lineOffset=63339, charOffset=8], [lineOffset=63345, charOffset=27], [lineOffset=63367, charOffset=43], [lineOffset=63385, charOffset=8], [lineOffset=63388, charOffset=18], [lineOf
fset=63441, charOffset=8], [lineOffset=63446, charOffset=60], [lineOffset=63462, charOffset=1], [lineOffset=63467, charOffset=46], [lineOffset=63478, charOffset=8], [lineOffset=63483, charOffset=8], [lineOffset=63493, charOffset=8],
 [lineOffset=63513, charOffset=28], [lineOffset=63545, charOffset=22], [lineOffset=63547, charOffset=32], [lineOffset=63557, charOffset=44], [lineOffset=63562, charOffset=1], [lineOffset=63568, charOffset=39], [lineOffset=63583, cha
rOffset=44], [lineOffset=63594, charOffset=8], [lineOffset=63597, charOffset=17], [lineOffset=63611, charOffset=55], [lineOffset=63643, charOffset=8], [lineOffset=63654, charOffset=1], [lineOffset=63655, charOffset=37], [lineOffset=
63799, charOffset=56], [lineOffset=63814, charOffset=36], [lineOffset=63819, charOffset=43], [lineOffset=63825, charOffset=1], [lineOffset=63839, charOffset=13], [lineOffset=63863, charOffset=8], [lineOffset=63866, charOffset=25], [
lineOffset=63876, charOffset=8], [lineOffset=63880, charOffset=30], [lineOffset=63889, charOffset=49], [lineOffset=63904, charOffset=25], [lineOffset=63911, charOffset=56], [lineOffset=63915, charOffset=46], [lineOffset=63921, charO
ffset=44], [lineOffset=63948, charOffset=25], [lineOffset=63968, charOffset=8], [lineOffset=63981, charOffset=59], [lineOffset=63994, charOffset=1], [lineOffset=64069, charOffset=8], [lineOffset=64091, charOffset=29], [lineOffset=64
098, charOffset=16], [lineOffset=64102, charOffset=59], [lineOffset=64119, charOffset=59], [lineOffset=64143, charOffset=23], [lineOffset=64168, charOffset=33], [lineOffset=64177, charOffset=38], [lineOffset=64189, charOffset=44], [
lineOffset=64203, charOffset=52], [lineOffset=64205, charOffset=20], [lineOffset=64206, charOffset=8], [lineOffset=64210, charOffset=8], [lineOffset=64213, charOffset=25], [lineOffset=64214, charOffset=63], [lineOffset=64217, charOf
fset=22], [lineOffset=64221, charOffset=39], [lineOffset=64268, charOffset=44], [lineOffset=64271, charOffset=37], [lineOffset=64323, charOffset=40], [lineOffset=64347, charOffset=1], [lineOffset=64353, charOffset=8], [lineOffset=64
395, charOffset=8], [lineOffset=64418, charOffset=21], [lineOffset=64511, charOffset=38], [lineOffset=64514, charOffset=38], [lineOffset=64831, charOffset=58], [lineOffset=64972, charOffset=15], [lineOffset=64986, charOffset=24], [l
ineOffset=64988, charOffset=8], [lineOffset=64992, charOffset=8], [lineOffset=65181, charOffset=8], [lineOffset=65243, charOffset=1], [lineOffset=65248, charOffset=53], [lineOffset=65279, charOffset=22], [lineOffset=65282, charOffse
t=27], [lineOffset=65293, charOffset=38], [lineOffset=65298, charOffset=1], [lineOffset=65302, charOffset=8], [lineOffset=65513, charOffset=19], [lineOffset=66556, charOffset=18], [lineOffset=67027, charOffset=12], [lineOffset=67367
, charOffset=24], [lineOffset=67609, charOffset=8], [lineOffset=67610, charOffset=1], [lineOffset=67616, charOffset=9], [lineOffset=67624, charOffset=20], [lineOffset=67636, charOffset=34], [lineOffset=67640, charOffset=31], [lineOf
fset=67644, charOffset=44], [lineOffset=67662, charOffset=49], [lineOffset=67671, charOffset=36], [lineOffset=67683, charOffset=8], [lineOffset=67685, charOffset=18], [lineOffset=67922, charOffset=24], [lineOffset=67940, charOffset=
19], [lineOffset=67955, charOffset=25], [lineOffset=67962, charOffset=55], [lineOffset=67965, charOffset=8], [lineOffset=67974, charOffset=8], [lineOffset=67977, charOffset=54], [lineOffset=67979, charOffset=52], [lineOffset=67988,
charOffset=47], [lineOffset=68000, charOffset=60], [lineOffset=68004, charOffset=14], [lineOffset=68009, charOffset=40], [lineOffset=68013, charOffset=8], [lineOffset=68027, charOffset=8], [lineOffset=68042, charOffset=8], [lineOffs
et=68063, charOffset=45], [lineOffset=68067, charOffset=1], [lineOffset=68125, charOffset=1], [lineOffset=68133, charOffset=8], [lineOffset=68137, charOffset=30], [lineOffset=68153, charOffset=38], [lineOffset=68155, charOffset=29],
 [lineOffset=68167, charOffset=54], [lineOffset=68464, charOffset=8], [lineOffset=68489, charOffset=39], [lineOffset=68500, charOffset=49], [lineOffset=68517, charOffset=28], [lineOffset=68529, charOffset=8], [lineOffset=68531, char
Offset=63], [lineOffset=68534, charOffset=47], [lineOffset=68539, charOffset=29], [lineOffset=68554, charOffset=62], [lineOffset=68558, charOffset=25], [lineOffset=68608, charOffset=16], [lineOffset=68750, charOffset=32], [lineOffse
t=68762, charOffset=23], [lineOffset=68765, charOffset=37], [lineOffset=68797, charOffset=60], [lineOffset=68804, charOffset=44], [lineOffset=68818, charOffset=13], [lineOffset=69312, charOffset=19], [lineOffset=69321, charOffset=56
], [lineOffset=69326, charOffset=44], [lineOffset=69375, charOffset=49], [lineOffset=69383, charOffset=18], [lineOffset=69391, charOffset=19], [lineOffset=69397, charOffset=8], [lineOffset=69407, charOffset=60], [lineOffset=69413, c
harOffset=43], [lineOffset=69458, charOffset=47], [lineOffset=69480, charOffset=52], [lineOffset=69579, charOffset=57], [lineOffset=69595, charOffset=27], [lineOffset=69600, charOffset=16], [lineOffset=69605, charOffset=19], [lineOf
fset=69617, charOffset=56], [lineOffset=69638, charOffset=28], [lineOffset=69663, charOffset=45], [lineOffset=69673, charOffset=26], [lineOffset=69680, charOffset=44], [lineOffset=69681, charOffset=32], [lineOffset=69686, charOffset
=24], [lineOffset=69697, charOffset=39], [lineOffset=69705, charOffset=42], [lineOffset=69718, charOffset=46], [lineOffset=70259, charOffset=22], [lineOffset=70293, charOffset=41], [lineOffset=70299, charOffset=8], [lineOffset=70324
, charOffset=8], [lineOffset=70378, charOffset=8], [lineOffset=70382, charOffset=51], [lineOffset=70386, charOffset=36], [lineOffset=70397, charOffset=24], [lineOffset=70410, charOffset=37], [lineOffset=70415, charOffset=8], [lineOf
fset=70419, charOffset=36], [lineOffset=70453, charOffset=12], [lineOffset=71852, charOffset=24], [lineOffset=71895, charOffset=10], [lineOffset=71954, charOffset=42], [lineOffset=71968, charOffset=25], [lineOffset=71982, charOffset
=55], [lineOffset=72048, charOffset=49], [lineOffset=72057, charOffset=32], [lineOffset=72173, charOffset=7], [lineOffset=72175, charOffset=27], [lineOffset=72201, charOffset=1], [lineOffset=72207, charOffset=1], [lineOffset=72218,
charOffset=27], [lineOffset=72220, charOffset=28], [lineOffset=72226, charOffset=8], [lineOffset=72228, charOffset=37], [lineOffset=72230, charOffset=44], [lineOffset=72238, charOffset=1], [lineOffset=72241, charOffset=60], [lineOff
set=72249, charOffset=35], [lineOffset=72251, charOffset=30], [lineOffset=72265, charOffset=24], [lineOffset=72272, charOffset=61], [lineOffset=72276, charOffset=17], [lineOffset=72291, charOffset=57], [lineOffset=74582, charOffset=
8], [lineOffset=74610, charOffset=15], [lineOffset=74612, charOffset=48], [lineOffset=74614, charOffset=31], [lineOffset=74618, charOffset=19], [lineOffset=74621, charOffset=35], [lineOffset=74623, charOffset=25], [lineOffset=74626,
 charOffset=38], [lineOffset=74632, charOffset=24], [lineOffset=74636, charOffset=8], [lineOffset=74639, charOffset=20], [lineOffset=74646, charOffset=47], [lineOffset=74657, charOffset=62], [lineOffset=74666, charOffset=49], [lineO
ffset=74672, charOffset=8], [lineOffset=74692, charOffset=8], [lineOffset=74704, charOffset=8], [lineOffset=74709, charOffset=2], [lineOffset=74718, charOffset=18], [lineOffset=74742, charOffset=8], [lineOffset=74754, charOffset=1],
 [lineOffset=74774, charOffset=8], [lineOffset=74908, charOffset=17], [lineOffset=74940, charOffset=8], [lineOffset=74943, charOffset=33], [lineOffset=74946, charOffset=8], [lineOffset=74954, charOffset=13], [lineOffset=74957, charO
ffset=33], [lineOffset=74964, charOffset=8], [lineOffset=74970, charOffset=32], [lineOffset=75186, charOffset=14], [lineOffset=75206, charOffset=18], [lineOffset=75210, charOffset=59], [lineOffset=75216, charOffset=40], [lineOffset=
75231, charOffset=36], [lineOffset=75234, charOffset=55], [lineOffset=75245, charOffset=1], [lineOffset=75249, charOffset=26], [lineOffset=75253, charOffset=52], [lineOffset=75256, charOffset=50], [lineOffset=75264, charOffset=19],
[lineOffset=75272, charOffset=51], [lineOffset=75282, charOffset=31], [lineOffset=75293, charOffset=61], [lineOffset=75299, charOffset=24], [lineOffset=75308, charOffset=24], [lineOffset=75313, charOffset=33], [lineOffset=75318, cha
rOffset=59], [lineOffset=75328, charOffset=52], [lineOffset=75342, charOffset=17], [lineOffset=75359, charOffset=8], [lineOffset=75387, charOffset=8], [lineOffset=75395, charOffset=39], [lineOffset=75411, charOffset=65], [lineOffset
=75422, charOffset=8], [lineOffset=75435, charOffset=50], [lineOffset=75454, charOffset=33], [lineOffset=75477, charOffset=41], [lineOffset=75484, charOffset=45], [lineOffset=75490, charOffset=8], [lineOffset=75509, charOffset=8], [
lineOffset=75510, charOffset=50], [lineOffset=75529, charOffset=16], [lineOffset=75530, charOffset=29], [lineOffset=75540, charOffset=29], [lineOffset=75543, charOffset=33], [lineOffset=75551, charOffset=35], [lineOffset=75560, char
Offset=1], [lineOffset=75574, charOffset=8], [lineOffset=75577, charOffset=48], [lineOffset=75579, charOffset=8], [lineOffset=75585, charOffset=8], [lineOffset=75602, charOffset=25], [lineOffset=75604, charOffset=16], [lineOffset=75
623, charOffset=45], [lineOffset=75627, charOffset=27], [lineOffset=75631, charOffset=13], [lineOffset=75644, charOffset=8], [lineOffset=75647, charOffset=53], [lineOffset=75657, charOffset=8], [lineOffset=75661, charOffset=59], [li
neOffset=75671, charOffset=40], [lineOffset=75680, charOffset=39], [lineOffset=75691, charOffset=33], [lineOffset=75693, charOffset=15], [lineOffset=75700, charOffset=46], [lineOffset=75707, charOffset=8], [lineOffset=75714, charOff
set=8], [lineOffset=75734, charOffset=2], [lineOffset=75740, charOffset=29], [lineOffset=75750, charOffset=46], [lineOffset=75753, charOffset=2], [lineOffset=75754, charOffset=36], [lineOffset=75756, charOffset=2], [lineOffset=75764
, charOffset=28], [lineOffset=75768, charOffset=36], [lineOffset=75790, charOffset=40], [lineOffset=75807, charOffset=45], [lineOffset=75809, charOffset=2], [lineOffset=75862, charOffset=8], [lineOffset=75881, charOffset=36], [lineO
ffset=75888, charOffset=39], [lineOffset=75908, charOffset=58], [lineOffset=75920, charOffset=43], [lineOffset=75934, charOffset=1], [lineOffset=75944, charOffset=23], [lineOffset=75952, charOffset=58], [lineOffset=75969, charOffset
=50], [lineOffset=76891, charOffset=60], [lineOffset=77071, charOffset=45], [lineOffset=77316, charOffset=8], [lineOffset=77320, charOffset=23], [lineOffset=77333, charOffset=8], [lineOffset=77336, charOffset=1], [lineOffset=77344,
charOffset=26], [lineOffset=77382, charOffset=44], [lineOffset=77407, charOffset=40], [lineOffset=77413, charOffset=1], [lineOffset=77431, charOffset=8], [lineOffset=77434, charOffset=22], [lineOffset=77440, charOffset=8], [lineOffs
et=77457, charOffset=16], [lineOffset=77462, charOffset=1], [lineOffset=77468, charOffset=8], [lineOffset=77490, charOffset=13], [lineOffset=77496, charOffset=63], [lineOffset=77512, charOffset=17], [lineOffset=77534, charOffset=34]
, [lineOffset=77540, charOffset=53], [lineOffset=77558, charOffset=42], [lineOffset=77578, charOffset=8], [lineOffset=77588, charOffset=43], [lineOffset=77596, charOffset=46], [lineOffset=77605, charOffset=25], [lineOffset=77627, ch
arOffset=55], [lineOffset=77638, charOffset=26], [lineOffset=77656, charOffset=8], [lineOffset=77675, charOffset=62], [lineOffset=77678, charOffset=47], [lineOffset=77686, charOffset=30], [lineOffset=77693, charOffset=19], [lineOffs
et=77697, charOffset=29], [lineOffset=77706, charOffset=26], [lineOffset=77709, charOffset=52], [lineOffset=77718, charOffset=17], [lineOffset=77725, charOffset=29], [lineOffset=77729, charOffset=36], [lineOffset=77736, charOffset=1
9], [lineOffset=77739, charOffset=8], [lineOffset=77747, charOffset=58], [lineOffset=77759, charOffset=27], [lineOffset=77766, charOffset=25], [lineOffset=77771, charOffset=8], [lineOffset=77779, charOffset=8], [lineOffset=77784, ch
arOffset=8], [lineOffset=77790, charOffset=11], [lineOffset=77800, charOffset=18], [lineOffset=77813, charOffset=8], [lineOffset=77817, charOffset=8], [lineOffset=77835, charOffset=58], [lineOffset=77838, charOffset=43], [lineOffset
=77846, charOffset=1], [lineOffset=77858, charOffset=1], [lineOffset=77877, charOffset=53], [lineOffset=77882, charOffset=23], [lineOffset=77886, charOffset=46], [lineOffset=77893, charOffset=65], [lineOffset=77905, charOffset=8], [
lineOffset=77913, charOffset=38], [lineOffset=77914, charOffset=45], [lineOffset=77933, charOffset=8], [lineOffset=77936, charOffset=47], [lineOffset=77944, charOffset=30], [lineOffset=77951, charOffset=20], [lineOffset=77953, charO
ffset=1], [lineOffset=77961, charOffset=19], [lineOffset=77969, charOffset=17], [lineOffset=77978, charOffset=53], [lineOffset=77982, charOffset=50], [lineOffset=77994, charOffset=41], [lineOffset=78017, charOffset=57], [lineOffset=
78037, charOffset=57], [lineOffset=78055, charOffset=40], [lineOffset=78071, charOffset=8], [lineOffset=78085, charOffset=8], [lineOffset=78089, charOffset=1], [lineOffset=78093, charOffset=45], [lineOffset=78098, charOffset=1], [li
neOffset=78100, charOffset=14], [lineOffset=78102, charOffset=33], [lineOffset=78107, charOffset=1], [lineOffset=78117, charOffset=1], [lineOffset=78119, charOffset=24], [lineOffset=78123, charOffset=18], [lineOffset=78129, charOffs
et=59], [lineOffset=78145, charOffset=8], [lineOffset=78151, charOffset=21], [lineOffset=79519, charOffset=30], [lineOffset=79585, charOffset=8], [lineOffset=79615, charOffset=8], [lineOffset=79619, charOffset=29], [lineOffset=79627
, charOffset=8], [lineOffset=79648, charOffset=28], [lineOffset=79657, charOffset=31], [lineOffset=79658, charOffset=43], [lineOffset=79669, charOffset=8], [lineOffset=79687, charOffset=14], [lineOffset=79698, charOffset=65], [lineO
ffset=79703, charOffset=58], [lineOffset=79706, charOffset=51], [lineOffset=79716, charOffset=19], [lineOffset=79725, charOffset=31], [lineOffset=79728, charOffset=60], [lineOffset=79736, charOffset=35], [lineOffset=79742, charOffse
t=1], [lineOffset=79778, charOffset=17], [lineOffset=79795, charOffset=8], [lineOffset=79809, charOffset=8], [lineOffset=79819, charOffset=8], [lineOffset=79823, charOffset=8], [lineOffset=79829, charOffset=30], [lineOffset=79834, c
harOffset=36], [lineOffset=79837, charOffset=18], [lineOffset=79849, charOffset=18], [lineOffset=79855, charOffset=1], [lineOffset=79862, charOffset=8], [lineOffset=79888, charOffset=18], [lineOffset=79890, charOffset=41], [lineOffs
et=79906, charOffset=42], [lineOffset=79910, charOffset=53], [lineOffset=79925, charOffset=48], [lineOffset=79929, charOffset=29], [lineOffset=79936, charOffset=27], [lineOffset=79941, charOffset=11], [lineOffset=79943, charOffset=2
9], [lineOffset=79969, charOffset=17], [lineOffset=79976, charOffset=39], [lineOffset=79982, charOffset=42], [lineOffset=79988, charOffset=19], [lineOffset=79995, charOffset=33], [lineOffset=79996, charOffset=38], [lineOffset=80014,
 charOffset=8], [lineOffset=80205, charOffset=8], [lineOffset=80212, charOffset=8], [lineOffset=80226, charOffset=28], [lineOffset=80228, charOffset=29], [lineOffset=80231, charOffset=8], [lineOffset=80233, charOffset=26], [lineOffs
et=80237, charOffset=50], [lineOffset=80247, charOffset=49], [lineOffset=80260, charOffset=15], [lineOffset=80269, charOffset=8], [lineOffset=80277, charOffset=54], [lineOffset=80287, charOffset=32], [lineOffset=80296, charOffset=54
], [lineOffset=80300, charOffset=61], [lineOffset=80302, charOffset=1], [lineOffset=80325, charOffset=52], [lineOffset=80328, charOffset=54], [lineOffset=80333, charOffset=32], [lineOffset=80338, charOffset=8], [lineOffset=80341, ch
arOffset=29], [lineOffset=80367, charOffset=1], [lineOffset=80379, charOffset=1], [lineOffset=80389, charOffset=26], [lineOffset=80407, charOffset=29], [lineOffset=80409, charOffset=64], [lineOffset=80417, charOffset=52], [lineOffse
t=80424, charOffset=8], [lineOffset=80433, charOffset=32], [lineOffset=80454, charOffset=37], [lineOffset=80459, charOffset=34], [lineOffset=80464, charOffset=8], [lineOffset=80464, charOffset=23], [lineOffset=80476, charOffset=25],
 [lineOffset=80489, charOffset=53], [lineOffset=80499, charOffset=8], [lineOffset=80512, charOffset=42], [lineOffset=80524, charOffset=8], [lineOffset=80531, charOffset=8], [lineOffset=80537, charOffset=8], [lineOffset=80604, charOf
fset=42], [lineOffset=80610, charOffset=8], [lineOffset=80624, charOffset=20], [lineOffset=80634, charOffset=58], [lineOffset=80638, charOffset=8], [lineOffset=80648, charOffset=21], [lineOffset=80659, charOffset=54], [lineOffset=80
663, charOffset=34], [lineOffset=80684, charOffset=34], [lineOffset=80706, charOffset=8], [lineOffset=80716, charOffset=8], [lineOffset=80736, charOffset=8], [lineOffset=80739, charOffset=41], [lineOffset=80752, charOffset=8], [line
Offset=80755, charOffset=45], [lineOffset=80769, charOffset=22], [lineOffset=80779, charOffset=37], [lineOffset=80785, charOffset=44], [lineOffset=80794, charOffset=60], [lineOffset=80805, charOffset=44], [lineOffset=80807, charOffs
et=8], [lineOffset=80808, charOffset=1], [lineOffset=80815, charOffset=36], [lineOffset=80818, charOffset=13], [lineOffset=80830, charOffset=52], [lineOffset=80834, charOffset=65], [lineOffset=80842, charOffset=1], [lineOffset=80849
, charOffset=52], [lineOffset=80853, charOffset=25], [lineOffset=80864, charOffset=8], [lineOffset=80871, charOffset=37], [lineOffset=80876, charOffset=59], [lineOffset=80911, charOffset=59], [lineOffset=80926, charOffset=26], [line
Offset=80933, charOffset=19], [lineOffset=80964, charOffset=8], [lineOffset=80999, charOffset=1], [lineOffset=81020, charOffset=38], [lineOffset=81036, charOffset=20], [lineOffset=81092, charOffset=38], [lineOffset=81096, charOffset
=48], [lineOffset=81107, charOffset=26], [lineOffset=81110, charOffset=21], [lineOffset=81304, charOffset=44], [lineOffset=81333, charOffset=36], [lineOffset=81342, charOffset=1], [lineOffset=82685, charOffset=8], [lineOffset=82818,
 charOffset=22], [lineOffset=82951, charOffset=64], [lineOffset=83003, charOffset=8], [lineOffset=83192, charOffset=63], [lineOffset=83709, charOffset=60], [lineOffset=83749, charOffset=63], [lineOffset=83761, charOffset=2], [lineOf
fset=83829, charOffset=49], [lineOffset=83901, charOffset=1], [lineOffset=83924, charOffset=49], [lineOffset=84172, charOffset=27], [lineOffset=84203, charOffset=34], [lineOffset=84427, charOffset=38], [lineOffset=84605, charOffset=
48], [lineOffset=84610, charOffset=1], [lineOffset=84622, charOffset=49], [lineOffset=84629, charOffset=25], [lineOffset=84872, charOffset=49], [lineOffset=84969, charOffset=56], [lineOffset=84977, charOffset=16], [lineOffset=84979,
 charOffset=1], [lineOffset=85107, charOffset=46], [lineOffset=85223, charOffset=22], [lineOffset=85496, charOffset=8], [lineOffset=85641, charOffset=1], [lineOffset=85664, charOffset=19], [lineOffset=85669, charOffset=16], [lineOff
set=85672, charOffset=60], [lineOffset=85794, charOffset=40], [lineOffset=85807, charOffset=26], [lineOffset=86053, charOffset=8], [lineOffset=86053, charOffset=33], [lineOffset=86158, charOffset=48], [lineOffset=86160, charOffset=3
6], [lineOffset=86168, charOffset=30], [lineOffset=86170, charOffset=63], [lineOffset=86223, charOffset=29], [lineOffset=86267, charOffset=38], [lineOffset=86318, charOffset=1], [lineOffset=86367, charOffset=23], [lineOffset=86472,
charOffset=1], [lineOffset=87035, charOffset=24], [lineOffset=87041, charOffset=60], [lineOffset=87074, charOffset=63], [lineOffset=87082, charOffset=1], [lineOffset=87093, charOffset=8], [lineOffset=87117, charOffset=29], [lineOffs
et=87379, charOffset=24], [lineOffset=87388, charOffset=8], [lineOffset=87391, charOffset=38], [lineOffset=87397, charOffset=8], [lineOffset=87398, charOffset=50], [lineOffset=87404, charOffset=14], [lineOffset=87417, charOffset=15]
, [lineOffset=87425, charOffset=26], [lineOffset=87447, charOffset=21], [lineOffset=87457, charOffset=52], [lineOffset=87460, charOffset=21], [lineOffset=87467, charOffset=24], [lineOffset=87469, charOffset=8], [lineOffset=87476, ch
arOffset=50], [lineOffset=87487, charOffset=39], [lineOffset=87492, charOffset=42], [lineOffset=87496, charOffset=20], [lineOffset=87500, charOffset=8], [lineOffset=87507, charOffset=40], [lineOffset=87511, charOffset=32], [lineOffs
et=87518, charOffset=24], [lineOffset=87523, charOffset=8], [lineOffset=87536, charOffset=50], [lineOffset=87540, charOffset=26], [lineOffset=87554, charOffset=50], [lineOffset=88975, charOffset=51], [lineOffset=88979, charOffset=56
], [lineOffset=88982, charOffset=19], [lineOffset=88985, charOffset=50], [lineOffset=88988, charOffset=8], [lineOffset=88993, charOffset=1], [lineOffset=88994, charOffset=29], [lineOffset=89015, charOffset=40], [lineOffset=89029, ch
arOffset=49], [lineOffset=89035, charOffset=19], [lineOffset=89052, charOffset=24], [lineOffset=89065, charOffset=62], [lineOffset=89073, charOffset=34], [lineOffset=89078, charOffset=29], [lineOffset=89089, charOffset=64], [lineOff
set=89097, charOffset=30], [lineOffset=89102, charOffset=51], [lineOffset=89108, charOffset=65], [lineOffset=89114, charOffset=48], [lineOffset=89120, charOffset=44], [lineOffset=89125, charOffset=8], [lineOffset=89129, charOffset=2
9], [lineOffset=89131, charOffset=12], [lineOffset=89143, charOffset=8], [lineOffset=89146, charOffset=19], [lineOffset=89152, charOffset=27], [lineOffset=89154, charOffset=40], [lineOffset=89162, charOffset=29], [lineOffset=89173,
charOffset=2], [lineOffset=89177, charOffset=8], [lineOffset=89195, charOffset=41], [lineOffset=89196, charOffset=31], [lineOffset=89201, charOffset=11], [lineOffset=89205, charOffset=38], [lineOffset=89217, charOffset=19], [lineOff
set=89226, charOffset=8], [lineOffset=89236, charOffset=8], [lineOffset=89245, charOffset=41], [lineOffset=89247, charOffset=1], [lineOffset=89251, charOffset=16], [lineOffset=89260, charOffset=46], [lineOffset=89321, charOffset=37]
, [lineOffset=89462, charOffset=55], [lineOffset=89482, charOffset=25], [lineOffset=89507, charOffset=8], [lineOffset=89519, charOffset=8], [lineOffset=89545, charOffset=62], [lineOffset=89546, charOffset=59], [lineOffset=89553, cha
rOffset=1], [lineOffset=89555, charOffset=31], [lineOffset=89556, charOffset=34], [lineOffset=89576, charOffset=16], [lineOffset=89578, charOffset=1], [lineOffset=89579, charOffset=58], [lineOffset=89587, charOffset=30], [lineOffset
=89629, charOffset=31], [lineOffset=89645, charOffset=8], [lineOffset=89650, charOffset=23], [lineOffset=89660, charOffset=1], [lineOffset=89674, charOffset=14], [lineOffset=89755, charOffset=30], [lineOffset=89757, charOffset=25],
[lineOffset=89772, charOffset=8], [lineOffset=89787, charOffset=48], [lineOffset=89835, charOffset=19], [lineOffset=89838, charOffset=49], [lineOffset=89839, charOffset=33], [lineOffset=89852, charOffset=50], [lineOffset=90318, char
Offset=2], [lineOffset=90781, charOffset=19], [lineOffset=90793, charOffset=18], [lineOffset=91028, charOffset=35], [lineOffset=92194, charOffset=40], [lineOffset=92251, charOffset=55], [lineOffset=92252, charOffset=61], [lineOffset
=92256, charOffset=48], [lineOffset=92260, charOffset=15], [lineOffset=92268, charOffset=33], [lineOffset=92279, charOffset=58], [lineOffset=92363, charOffset=26], [lineOffset=92471, charOffset=14], [lineOffset=92513, charOffset=32]
, [lineOffset=92927, charOffset=8], [lineOffset=92935, charOffset=28], [lineOffset=92943, charOffset=8], [lineOffset=92960, charOffset=39], [lineOffset=92967, charOffset=8], [lineOffset=92974, charOffset=41], [lineOffset=92993, char
Offset=31], [lineOffset=93005, charOffset=51], [lineOffset=93033, charOffset=8], [lineOffset=93051, charOffset=8], [lineOffset=93055, charOffset=63], [lineOffset=93059, charOffset=23], [lineOffset=93066, charOffset=29], [lineOffset=
93072, charOffset=22], [lineOffset=93078, charOffset=8], [lineOffset=93081, charOffset=37], [lineOffset=93086, charOffset=8], [lineOffset=93090, charOffset=20], [lineOffset=93092, charOffset=57], [lineOffset=93095, charOffset=8], [l
ineOffset=93105, charOffset=41], [lineOffset=93118, charOffset=43], [lineOffset=93123, charOffset=41], [lineOffset=93131, charOffset=35], [lineOffset=93133, charOffset=36], [lineOffset=93141, charOffset=30], [lineOffset=93145, charO
ffset=26], [lineOffset=93153, charOffset=40], [lineOffset=93158, charOffset=8], [lineOffset=93166, charOffset=40], [lineOffset=93173, charOffset=8], [lineOffset=93180, charOffset=49], [lineOffset=93193, charOffset=1], [lineOffset=93
209, charOffset=30], [lineOffset=93628, charOffset=61], [lineOffset=93692, charOffset=18], [lineOffset=93876, charOffset=22], [lineOffset=93908, charOffset=31], [lineOffset=93925, charOffset=19], [lineOffset=94010, charOffset=14], [
lineOffset=94018, charOffset=8], [lineOffset=94144, charOffset=23], [lineOffset=94326, charOffset=8], [lineOffset=94334, charOffset=12], [lineOffset=94341, charOffset=39], [lineOffset=94351, charOffset=22], [lineOffset=94354, charOf
fset=8], [lineOffset=94500, charOffset=41], [lineOffset=95031, charOffset=1], [lineOffset=95119, charOffset=1], [lineOffset=95121, charOffset=8], [lineOffset=95129, charOffset=43], [lineOffset=95132, charOffset=54], [lineOffset=9513
6, charOffset=8], [lineOffset=95156, charOffset=38], [lineOffset=95163, charOffset=26], [lineOffset=95169, charOffset=44], [lineOffset=95171, charOffset=8], [lineOffset=95192, charOffset=31], [lineOffset=95224, charOffset=56], [line
Offset=95229, charOffset=14], [lineOffset=95245, charOffset=19], [lineOffset=95247, charOffset=39], [lineOffset=95249, charOffset=8], [lineOffset=95260, charOffset=59], [lineOffset=95271, charOffset=20], [lineOffset=95272, charOffse
t=59], [lineOffset=95331, charOffset=8], [lineOffset=95334, charOffset=36], [lineOffset=95339, charOffset=60], [lineOffset=95358, charOffset=37], [lineOffset=95409, charOffset=59], [lineOffset=95410, charOffset=43], [lineOffset=9541
3, charOffset=18], [lineOffset=95414, charOffset=8], [lineOffset=95421, charOffset=8], [lineOffset=95426, charOffset=1], [lineOffset=95432, charOffset=24], [lineOffset=95436, charOffset=31], [lineOffset=95449, charOffset=37], [lineO
ffset=95453, charOffset=32], [lineOffset=95454, charOffset=21], [lineOffset=95484, charOffset=56], [lineOffset=95493, charOffset=8], [lineOffset=95508, charOffset=37], [lineOffset=95512, charOffset=8], [lineOffset=95521, charOffset=
47], [lineOffset=95528, charOffset=38], [lineOffset=96631, charOffset=9], [lineOffset=96741, charOffset=60], [lineOffset=96866, charOffset=45], [lineOffset=96875, charOffset=16], [lineOffset=96947, charOffset=8], [lineOffset=96953,
charOffset=8], [lineOffset=96955, charOffset=26], [lineOffset=96964, charOffset=50], [lineOffset=96972, charOffset=28], [lineOffset=96986, charOffset=51], [lineOffset=96991, charOffset=8], [lineOffset=96996, charOffset=1], [lineOffs
et=97003, charOffset=8], [lineOffset=97006, charOffset=8], [lineOffset=97010, charOffset=8], [lineOffset=97015, charOffset=28], [lineOffset=97037, charOffset=64], [lineOffset=97040, charOffset=21], [lineOffset=97044, charOffset=21],
 [lineOffset=97072, charOffset=16], [lineOffset=97077, charOffset=38], [lineOffset=97084, charOffset=23], [lineOffset=97103, charOffset=8], [lineOffset=97105, charOffset=8], [lineOffset=97127, charOffset=28], [lineOffset=97142, char
Offset=44], [lineOffset=97144, charOffset=31], [lineOffset=97147, charOffset=1], [lineOffset=97148, charOffset=55], [lineOffset=97170, charOffset=30], [lineOffset=97182, charOffset=29], [lineOffset=97193, charOffset=1], [lineOffset=
97205, charOffset=30], [lineOffset=97220, charOffset=8], [lineOffset=97256, charOffset=42], [lineOffset=97263, charOffset=21], [lineOffset=97265, charOffset=44], [lineOffset=97269, charOffset=8], [lineOffset=97276, charOffset=22], [
lineOffset=97283, charOffset=32], [lineOffset=97300, charOffset=57], [lineOffset=97312, charOffset=8], [lineOffset=97940, charOffset=48], [lineOffset=98048, charOffset=53], [lineOffset=98970, charOffset=1], [lineOffset=99091, charOf
fset=8], [lineOffset=99147, charOffset=8], [lineOffset=99154, charOffset=14], [lineOffset=99183, charOffset=1], [lineOffset=99187, charOffset=54], [lineOffset=99195, charOffset=8], [lineOffset=99199, charOffset=37], [lineOffset=9921
0, charOffset=57], [lineOffset=99216, charOffset=18], [lineOffset=99249, charOffset=8], [lineOffset=99254, charOffset=31], [lineOffset=99271, charOffset=56], [lineOffset=99274, charOffset=40], [lineOffset=99289, charOffset=46], [lin
eOffset=99310, charOffset=1], [lineOffset=99317, charOffset=8], [lineOffset=99319, charOffset=1], [lineOffset=99330, charOffset=37], [lineOffset=99343, charOffset=37], [lineOffset=99349, charOffset=51], [lineOffset=99352, charOffset
=22], [lineOffset=99358, charOffset=8], [lineOffset=99362, charOffset=8], [lineOffset=99365, charOffset=29], [lineOffset=99368, charOffset=51], [lineOffset=99378, charOffset=38], [lineOffset=99384, charOffset=28], [lineOffset=99397,
 charOffset=1], [lineOffset=99399, charOffset=53], [lineOffset=99407, charOffset=36], [lineOffset=99420, charOffset=8], [lineOffset=100087, charOffset=32], [lineOffset=100089, charOffset=45], [lineOffset=100939, charOffset=46], [lin
eOffset=101190, charOffset=44], [lineOffset=101673, charOffset=29], [lineOffset=102083, charOffset=29], [lineOffset=102105, charOffset=30], [lineOffset=102214, charOffset=41], [lineOffset=104903, charOffset=53], [lineOffset=104938,
charOffset=53], [lineOffset=104963, charOffset=32], [lineOffset=104964, charOffset=1], [lineOffset=105033, charOffset=1], [lineOffset=105037, charOffset=50], [lineOffset=105062, charOffset=26], [lineOffset=105081, charOffset=36], [l
ineOffset=105095, charOffset=56], [lineOffset=105099, charOffset=41], [lineOffset=105102, charOffset=18], [lineOffset=105104, charOffset=18], [lineOffset=105118, charOffset=8], [lineOffset=105127, charOffset=21], [lineOffset=105151,
 charOffset=23], [lineOffset=105177, charOffset=59], [lineOffset=105196, charOffset=1], [lineOffset=105206, charOffset=30], [lineOffset=105222, charOffset=1], [lineOffset=105263, charOffset=1], [lineOffset=105265, charOffset=8], [li
neOffset=105269, charOffset=1], [lineOffset=105281, charOffset=8], [lineOffset=105292, charOffset=27], [lineOffset=105302, charOffset=52], [lineOffset=105308, charOffset=8], [lineOffset=105332, charOffset=61], [lineOffset=105338, ch
arOffset=12], [lineOffset=106539, charOffset=16], [lineOffset=106652, charOffset=1], [lineOffset=106748, charOffset=28], [lineOffset=106761, charOffset=49], [lineOffset=106822, charOffset=47], [lineOffset=106864, charOffset=37], [li
neOffset=106904, charOffset=8], [lineOffset=106993, charOffset=37], [lineOffset=107059, charOffset=1], [lineOffset=107062, charOffset=33], [lineOffset=107075, charOffset=37], [lineOffset=107079, charOffset=63], [lineOffset=107105, c
harOffset=33], [lineOffset=107109, charOffset=8], [lineOffset=107129, charOffset=58], [lineOffset=107157, charOffset=28], [lineOffset=107180, charOffset=23], [lineOffset=108016, charOffset=61], [lineOffset=108049, charOffset=18], [l
ineOffset=108078, charOffset=65], [lineOffset=108185, charOffset=51], [lineOffset=108195, charOffset=56], [lineOffset=108259, charOffset=28], [lineOffset=108269, charOffset=28], [lineOffset=108339, charOffset=43], [lineOffset=108352
, charOffset=8], [lineOffset=108367, charOffset=52], [lineOffset=108383, charOffset=2], [lineOffset=108387, charOffset=8], [lineOffset=108395, charOffset=46], [lineOffset=108397, charOffset=25], [lineOffset=108434, charOffset=8], [l
ineOffset=108450, charOffset=36], [lineOffset=108464, charOffset=21], [lineOffset=108530, charOffset=14], [lineOffset=108616, charOffset=8], [lineOffset=108636, charOffset=39], [lineOffset=108638, charOffset=36], [lineOffset=108658,
 charOffset=53], [lineOffset=110108, charOffset=54], [lineOffset=110109, charOffset=52], [lineOffset=110110, charOffset=30], [lineOffset=113611, charOffset=14], [lineOffset=113911, charOffset=8], [lineOffset=115205, charOffset=13],
[lineOffset=115228, charOffset=8], [lineOffset=115644, charOffset=11], [lineOffset=115649, charOffset=56], [lineOffset=115808, charOffset=56], [lineOffset=115845, charOffset=53], [lineOffset=116095, charOffset=55], [lineOffset=11612
2, charOffset=31], [lineOffset=116147, charOffset=27], [lineOffset=116267, charOffset=1], [lineOffset=117086, charOffset=37], [lineOffset=117819, charOffset=25], [lineOffset=117824, charOffset=36], [lineOffset=117826, charOffset=40]
, [lineOffset=117829, charOffset=50], [lineOffset=117836, charOffset=57], [lineOffset=117992, charOffset=44], [lineOffset=117993, charOffset=60], [lineOffset=119367, charOffset=8], [lineOffset=119374, charOffset=8]]
10:40:14.730 [main] INFO  c.b.c.service.ResultAggregator - Anthony --> [[lineOffset=9919, charOffset=44], [lineOffset=13391, charOffset=37], [lineOffset=24618, charOffset=37], [lineOffset=24739, charOffset=6], [lineOffset=28082, cha
rOffset=1]]
10:40:14.730 [main] INFO  c.b.c.service.ResultAggregator - Arthur --> [[lineOffset=2, charOffset=8], [lineOffset=3, charOffset=27], [lineOffset=29, charOffset=13], [lineOffset=4382, charOffset=140], [lineOffset=4386, charOffset=254]
, [lineOffset=4392, charOffset=81], [lineOffset=4392, charOffset=337], [lineOffset=4394, charOffset=34], [lineOffset=4438, charOffset=4], [lineOffset=4458, charOffset=162], [lineOffset=4458, charOffset=400], [lineOffset=4474, charOf
fset=67], [lineOffset=4478, charOffset=2], [lineOffset=4502, charOffset=45], [lineOffset=4522, charOffset=29], [lineOffset=4534, charOffset=178], [lineOffset=4536, charOffset=86], [lineOffset=4542, charOffset=205], [lineOffset=4566,
 charOffset=116], [lineOffset=4703, charOffset=18], [lineOffset=4723, charOffset=12], [lineOffset=4725, charOffset=472], [lineOffset=4741, charOffset=445], [lineOffset=10164, charOffset=57], [lineOffset=19697, charOffset=29], [lineO
ffset=19985, charOffset=16], [lineOffset=23711, charOffset=14], [lineOffset=23726, charOffset=1], [lineOffset=27592, charOffset=64], [lineOffset=27593, charOffset=15], [lineOffset=48914, charOffset=38], [lineOffset=48918, charOffset
=43]]
10:40:14.730 [main] INFO  c.b.c.service.ResultAggregator - Carl --> [[lineOffset=18672, charOffset=19], [lineOffset=19840, charOffset=20]]
10:40:14.730 [main] INFO  c.b.c.service.ResultAggregator - Charles --> [[lineOffset=1356, charOffset=293], [lineOffset=5504, charOffset=4], [lineOffset=5514, charOffset=9], [lineOffset=6072, charOffset=51], [lineOffset=6579, charOff
set=12], [lineOffset=7281, charOffset=33], [lineOffset=7493, charOffset=19], [lineOffset=8045, charOffset=51], [lineOffset=8051, charOffset=53], [lineOffset=8059, charOffset=1], [lineOffset=8189, charOffset=1], [lineOffset=8204, cha
rOffset=55], [lineOffset=8579, charOffset=20], [lineOffset=8750, charOffset=17], [lineOffset=10273, charOffset=20], [lineOffset=10311, charOffset=20], [lineOffset=10789, charOffset=1], [lineOffset=10885, charOffset=20], [lineOffset=
14773, charOffset=32], [lineOffset=14855, charOffset=17], [lineOffset=16551, charOffset=1], [lineOffset=17947, charOffset=8], [lineOffset=18281, charOffset=27], [lineOffset=24700, charOffset=29], [lineOffset=25917, charOffset=28], [
lineOffset=28202, charOffset=1], [lineOffset=28204, charOffset=1], [lineOffset=28629, charOffset=9], [lineOffset=28778, charOffset=14], [lineOffset=29064, charOffset=11], [lineOffset=29290, charOffset=9], [lineOffset=29558, charOffs
et=4], [lineOffset=45104, charOffset=35], [lineOffset=88895, charOffset=45], [lineOffset=97696, charOffset=53], [lineOffset=97709, charOffset=44], [lineOffset=120013, charOffset=33], [lineOffset=120023, charOffset=1]]
10:40:14.730 [main] INFO  c.b.c.service.ResultAggregator - Christopher --> [[lineOffset=8774, charOffset=60], [lineOffset=42725, charOffset=8]]
10:40:14.732 [main] INFO  c.b.c.service.ResultAggregator - Daniel --> [[lineOffset=6826, charOffset=35], [lineOffset=7994, charOffset=39], [lineOffset=9913, charOffset=47], [lineOffset=10663, charOffset=15], [lineOffset=13240, charO
ffset=67], [lineOffset=14475, charOffset=1], [lineOffset=14619, charOffset=66], [lineOffset=14729, charOffset=67], [lineOffset=14963, charOffset=66], [lineOffset=14991, charOffset=30], [lineOffset=15166, charOffset=1], [lineOffset=2
7574, charOffset=53], [lineOffset=28139, charOffset=8], [lineOffset=58017, charOffset=25], [lineOffset=58020, charOffset=28], [lineOffset=58034, charOffset=30], [lineOffset=58073, charOffset=13], [lineOffset=81487, charOffset=17], [
lineOffset=81492, charOffset=64], [lineOffset=81496, charOffset=2], [lineOffset=81510, charOffset=1], [lineOffset=81527, charOffset=20], [lineOffset=81528, charOffset=19], [lineOffset=81530, charOffset=29], [lineOffset=81536, charOf
fset=49], [lineOffset=81537, charOffset=27], [lineOffset=81538, charOffset=56], [lineOffset=81561, charOffset=2], [lineOffset=81564, charOffset=14], [lineOffset=81713, charOffset=31], [lineOffset=81731, charOffset=11], [lineOffset=8
1756, charOffset=57], [lineOffset=81761, charOffset=6], [lineOffset=81769, charOffset=43], [lineOffset=81781, charOffset=46], [lineOffset=81806, charOffset=1], [lineOffset=81807, charOffset=5], [lineOffset=81969, charOffset=42], [li
neOffset=81973, charOffset=21], [lineOffset=81978, charOffset=1], [lineOffset=81982, charOffset=32], [lineOffset=81984, charOffset=9], [lineOffset=81988, charOffset=1], [lineOffset=81990, charOffset=37], [lineOffset=81993, charOffse
t=50], [lineOffset=82008, charOffset=7], [lineOffset=82010, charOffset=34], [lineOffset=82013, charOffset=1], [lineOffset=82017, charOffset=16], [lineOffset=104843, charOffset=5], [lineOffset=104851, charOffset=25], [lineOffset=1048
54, charOffset=1], [lineOffset=104865, charOffset=24], [lineOffset=117953, charOffset=30]]
10:40:14.732 [main] INFO  c.b.c.service.ResultAggregator - David --> [[lineOffset=10313, charOffset=63], [lineOffset=15720, charOffset=14], [lineOffset=16743, charOffset=11], [lineOffset=23711, charOffset=61], [lineOffset=26233, cha
rOffset=11], [lineOffset=28633, charOffset=7], [lineOffset=90845, charOffset=1], [lineOffset=90882, charOffset=39], [lineOffset=105991, charOffset=33]]
10:40:14.734 [main] INFO  c.b.c.service.ResultAggregator - Douglas --> [[lineOffset=15880, charOffset=39], [lineOffset=16912, charOffset=43], [lineOffset=16917, charOffset=1], [lineOffset=16926, charOffset=1], [lineOffset=16938, cha
rOffset=4], [lineOffset=16942, charOffset=41], [lineOffset=17042, charOffset=14], [lineOffset=17044, charOffset=13], [lineOffset=17048, charOffset=13], [lineOffset=17050, charOffset=14], [lineOffset=17068, charOffset=20], [lineOffse
t=17072, charOffset=45], [lineOffset=17077, charOffset=27], [lineOffset=17120, charOffset=52], [lineOffset=17131, charOffset=18], [lineOffset=17132, charOffset=59], [lineOffset=17151, charOffset=45], [lineOffset=17161, charOffset=33
], [lineOffset=17271, charOffset=61], [lineOffset=17302, charOffset=14], [lineOffset=17305, charOffset=65], [lineOffset=17507, charOffset=32], [lineOffset=18065, charOffset=1], [lineOffset=18356, charOffset=59], [lineOffset=18807, c
harOffset=15], [lineOffset=19221, charOffset=37], [lineOffset=28382, charOffset=1], [lineOffset=28791, charOffset=3]]
10:40:14.735 [main] INFO  c.b.c.service.ResultAggregator - Edward --> [[lineOffset=816, charOffset=69], [lineOffset=4996, charOffset=1197], [lineOffset=10322, charOffset=44], [lineOffset=17167, charOffset=51], [lineOffset=19912, cha
rOffset=1], [lineOffset=28551, charOffset=9]]
10:40:14.735 [main] INFO  c.b.c.service.ResultAggregator - Frank --> [[lineOffset=4255, charOffset=159], [lineOffset=4261, charOffset=56], [lineOffset=4261, charOffset=183], [lineOffset=4261, charOffset=269], [lineOffset=4261, charO
ffset=364], [lineOffset=4261, charOffset=469], [lineOffset=4261, charOffset=671], [lineOffset=4261, charOffset=1190], [lineOffset=4263, charOffset=22], [lineOffset=4263, charOffset=256], [lineOffset=4263, charOffset=491], [lineOffse
t=4263, charOffset=747], [lineOffset=4265, charOffset=332], [lineOffset=4267, charOffset=412], [lineOffset=4267, charOffset=797], [lineOffset=4267, charOffset=961], [lineOffset=4271, charOffset=50], [lineOffset=4271, charOffset=384]
, [lineOffset=4271, charOffset=797]]
10:40:14.735 [main] INFO  c.b.c.service.ResultAggregator - George --> [[lineOffset=1040, charOffset=169], [lineOffset=1554, charOffset=448], [lineOffset=2118, charOffset=99], [lineOffset=3907, charOffset=149], [lineOffset=3931, char
Offset=45], [lineOffset=4384, charOffset=747], [lineOffset=4386, charOffset=57], [lineOffset=4474, charOffset=81], [lineOffset=4713, charOffset=203], [lineOffset=4725, charOffset=433], [lineOffset=4725, charOffset=642], [lineOffset=
4741, charOffset=257], [lineOffset=4743, charOffset=107], [lineOffset=4751, charOffset=78], [lineOffset=5747, charOffset=11], [lineOffset=5748, charOffset=11], [lineOffset=6085, charOffset=64], [lineOffset=6488, charOffset=34], [lin
eOffset=7403, charOffset=31], [lineOffset=7512, charOffset=28], [lineOffset=7558, charOffset=9], [lineOffset=7676, charOffset=47], [lineOffset=7874, charOffset=27], [lineOffset=7892, charOffset=54], [lineOffset=7924, charOffset=15],
 [lineOffset=7994, charOffset=17], [lineOffset=8096, charOffset=49], [lineOffset=8096, charOffset=62], [lineOffset=8112, charOffset=13], [lineOffset=8189, charOffset=32], [lineOffset=8398, charOffset=62], [lineOffset=8489, charOffse
t=27], [lineOffset=8490, charOffset=31], [lineOffset=8493, charOffset=12], [lineOffset=8502, charOffset=45], [lineOffset=8508, charOffset=33], [lineOffset=8516, charOffset=14], [lineOffset=8520, charOffset=46], [lineOffset=8531, cha
rOffset=24], [lineOffset=8540, charOffset=14], [lineOffset=8541, charOffset=26], [lineOffset=8560, charOffset=14], [lineOffset=8567, charOffset=1], [lineOffset=8570, charOffset=56], [lineOffset=8602, charOffset=1], [lineOffset=8619,
 charOffset=32], [lineOffset=8660, charOffset=16], [lineOffset=8750, charOffset=45], [lineOffset=8751, charOffset=56], [lineOffset=8772, charOffset=15], [lineOffset=8826, charOffset=18], [lineOffset=9029, charOffset=23], [lineOffset
=9033, charOffset=13], [lineOffset=9090, charOffset=1], [lineOffset=9153, charOffset=27], [lineOffset=9190, charOffset=30], [lineOffset=9194, charOffset=14], [lineOffset=9264, charOffset=13], [lineOffset=9273, charOffset=6], [lineOf
fset=9327, charOffset=18], [lineOffset=9397, charOffset=11], [lineOffset=9502, charOffset=1], [lineOffset=9663, charOffset=50], [lineOffset=9672, charOffset=34], [lineOffset=9789, charOffset=7], [lineOffset=9886, charOffset=30], [li
neOffset=9953, charOffset=18], [lineOffset=9956, charOffset=61], [lineOffset=10028, charOffset=43], [lineOffset=10242, charOffset=22], [lineOffset=10298, charOffset=32], [lineOffset=10328, charOffset=11], [lineOffset=10408, charOffs
et=50], [lineOffset=10411, charOffset=41], [lineOffset=10447, charOffset=8], [lineOffset=10786, charOffset=1], [lineOffset=11267, charOffset=30], [lineOffset=11644, charOffset=27], [lineOffset=12458, charOffset=1], [lineOffset=12593
, charOffset=60], [lineOffset=12980, charOffset=23], [lineOffset=13063, charOffset=65], [lineOffset=13241, charOffset=25], [lineOffset=13246, charOffset=53], [lineOffset=13979, charOffset=6], [lineOffset=14001, charOffset=42], [line
Offset=14756, charOffset=36], [lineOffset=15165, charOffset=49], [lineOffset=16980, charOffset=57], [lineOffset=19554, charOffset=5], [lineOffset=19840, charOffset=33], [lineOffset=22734, charOffset=11], [lineOffset=23669, charOffse
t=10], [lineOffset=24494, charOffset=23], [lineOffset=24599, charOffset=56], [lineOffset=26233, charOffset=23], [lineOffset=26242, charOffset=42], [lineOffset=27568, charOffset=3], [lineOffset=27571, charOffset=53], [lineOffset=2757
2, charOffset=53], [lineOffset=27581, charOffset=53], [lineOffset=27739, charOffset=10], [lineOffset=28528, charOffset=1], [lineOffset=28530, charOffset=1], [lineOffset=28532, charOffset=1], [lineOffset=28735, charOffset=6], [lineOf
fset=34563, charOffset=32], [lineOffset=42477, charOffset=53], [lineOffset=46895, charOffset=32], [lineOffset=48335, charOffset=32], [lineOffset=48908, charOffset=25], [lineOffset=54842, charOffset=29], [lineOffset=54928, charOffset
=48], [lineOffset=67422, charOffset=60], [lineOffset=67828, charOffset=26], [lineOffset=70874, charOffset=26], [lineOffset=71177, charOffset=41], [lineOffset=74373, charOffset=8], [lineOffset=77196, charOffset=61], [lineOffset=85702
, charOffset=49], [lineOffset=85855, charOffset=62], [lineOffset=85858, charOffset=14], [lineOffset=85930, charOffset=14], [lineOffset=85935, charOffset=1], [lineOffset=85944, charOffset=65], [lineOffset=85951, charOffset=14], [line
Offset=85956, charOffset=14], [lineOffset=85973, charOffset=14], [lineOffset=85988, charOffset=48], [lineOffset=90385, charOffset=47], [lineOffset=90412, charOffset=47], [lineOffset=90419, charOffset=40], [lineOffset=91026, charOffs
et=54], [lineOffset=91099, charOffset=29], [lineOffset=91211, charOffset=18], [lineOffset=96532, charOffset=20], [lineOffset=98505, charOffset=17], [lineOffset=100111, charOffset=52], [lineOffset=106423, charOffset=17], [lineOffset=
112087, charOffset=46], [lineOffset=115100, charOffset=56], [lineOffset=115112, charOffset=1], [lineOffset=118379, charOffset=45]]
10:40:14.735 [main] INFO  c.b.c.service.ResultAggregator - Gregory --> [[lineOffset=29858, charOffset=10], [lineOffset=54202, charOffset=10]]
10:40:14.736 [main] INFO  c.b.c.service.ResultAggregator - Henry --> [[lineOffset=2585, charOffset=68], [lineOffset=2585, charOffset=301], [lineOffset=2683, charOffset=441], [lineOffset=2687, charOffset=127], [lineOffset=2707, charO
ffset=50], [lineOffset=2709, charOffset=40], [lineOffset=2721, charOffset=6], [lineOffset=2749, charOffset=18], [lineOffset=2763, charOffset=51], [lineOffset=2887, charOffset=248], [lineOffset=6350, charOffset=41], [lineOffset=7175,
 charOffset=52], [lineOffset=7524, charOffset=37], [lineOffset=8398, charOffset=19], [lineOffset=8749, charOffset=26], [lineOffset=9264, charOffset=43], [lineOffset=9579, charOffset=33], [lineOffset=9866, charOffset=53], [lineOffset
=10540, charOffset=1], [lineOffset=12568, charOffset=59], [lineOffset=12577, charOffset=43], [lineOffset=13172, charOffset=60], [lineOffset=14178, charOffset=67], [lineOffset=14190, charOffset=48], [lineOffset=14447, charOffset=1],
[lineOffset=14619, charOffset=20], [lineOffset=14689, charOffset=52], [lineOffset=14963, charOffset=54], [lineOffset=15295, charOffset=14], [lineOffset=15326, charOffset=29], [lineOffset=15523, charOffset=12], [lineOffset=16474, cha
rOffset=27], [lineOffset=19303, charOffset=55], [lineOffset=19813, charOffset=31], [lineOffset=19840, charOffset=56], [lineOffset=20750, charOffset=1], [lineOffset=22369, charOffset=26], [lineOffset=23674, charOffset=67], [lineOffse
t=23929, charOffset=12], [lineOffset=27590, charOffset=53], [lineOffset=28240, charOffset=7], [lineOffset=28248, charOffset=14], [lineOffset=28611, charOffset=1], [lineOffset=37399, charOffset=26], [lineOffset=114816, charOffset=13]
]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - James --> [[lineOffset=880, charOffset=28], [lineOffset=914, charOffset=1305], [lineOffset=1263, charOffset=37], [lineOffset=1267, charOffset=20], [lineOffset=1299, charOffs
et=1112], [lineOffset=1305, charOffset=633], [lineOffset=1315, charOffset=800], [lineOffset=1360, charOffset=424], [lineOffset=1398, charOffset=6], [lineOffset=1476, charOffset=232], [lineOffset=1488, charOffset=48], [lineOffset=149
2, charOffset=41], [lineOffset=1492, charOffset=169], [lineOffset=1516, charOffset=93], [lineOffset=1524, charOffset=40], [lineOffset=1752, charOffset=1], [lineOffset=2083, charOffset=260], [lineOffset=2134, charOffset=160], [lineOf
fset=2681, charOffset=227], [lineOffset=2695, charOffset=41], [lineOffset=2897, charOffset=92], [lineOffset=6067, charOffset=65], [lineOffset=6084, charOffset=1], [lineOffset=7182, charOffset=15], [lineOffset=7344, charOffset=26], [
lineOffset=7461, charOffset=21], [lineOffset=7552, charOffset=45], [lineOffset=8059, charOffset=21], [lineOffset=8079, charOffset=11], [lineOffset=8085, charOffset=18], [lineOffset=8112, charOffset=1], [lineOffset=8491, charOffset=3
3], [lineOffset=8882, charOffset=23], [lineOffset=8897, charOffset=38], [lineOffset=10035, charOffset=67], [lineOffset=10311, charOffset=28], [lineOffset=10777, charOffset=57], [lineOffset=10778, charOffset=47], [lineOffset=10786, c
harOffset=20], [lineOffset=11281, charOffset=19], [lineOffset=11363, charOffset=28], [lineOffset=12316, charOffset=66], [lineOffset=12541, charOffset=22], [lineOffset=12741, charOffset=10], [lineOffset=13031, charOffset=20], [lineOf
fset=14302, charOffset=1], [lineOffset=14485, charOffset=41], [lineOffset=14744, charOffset=51], [lineOffset=15167, charOffset=60], [lineOffset=15241, charOffset=1], [lineOffset=15346, charOffset=21], [lineOffset=15365, charOffset=2
9], [lineOffset=16422, charOffset=1], [lineOffset=16473, charOffset=66], [lineOffset=16984, charOffset=1], [lineOffset=18069, charOffset=56], [lineOffset=19553, charOffset=52], [lineOffset=19767, charOffset=25], [lineOffset=19833, c
harOffset=56], [lineOffset=20104, charOffset=55], [lineOffset=20981, charOffset=16], [lineOffset=21034, charOffset=45], [lineOffset=23671, charOffset=9], [lineOffset=24425, charOffset=43], [lineOffset=26388, charOffset=21], [lineOff
set=27572, charOffset=3], [lineOffset=27574, charOffset=3], [lineOffset=27581, charOffset=4], [lineOffset=27585, charOffset=4], [lineOffset=27592, charOffset=4], [lineOffset=27600, charOffset=53], [lineOffset=28161, charOffset=11],
[lineOffset=28615, charOffset=7], [lineOffset=28698, charOffset=1], [lineOffset=28700, charOffset=1], [lineOffset=28827, charOffset=10], [lineOffset=28896, charOffset=9], [lineOffset=28993, charOffset=13], [lineOffset=29005, charOff
set=7], [lineOffset=29452, charOffset=9], [lineOffset=44507, charOffset=59], [lineOffset=48626, charOffset=24]]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - Jason --> [[lineOffset=15405, charOffset=51]]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - John --> [[lineOffset=309, charOffset=42], [lineOffset=350, charOffset=30], [lineOffset=420, charOffset=286], [lineOffset=567, charOffset=683], [lineOffset=950, charOffset=2
], [lineOffset=950, charOffset=240], [lineOffset=952, charOffset=114], [lineOffset=1000, charOffset=15], [lineOffset=1016, charOffset=24], [lineOffset=1020, charOffset=67], [lineOffset=1356, charOffset=134], [lineOffset=1398, charOf
fset=347], [lineOffset=1694, charOffset=6], [lineOffset=1823, charOffset=25], [lineOffset=1841, charOffset=16], [lineOffset=1857, charOffset=39], [lineOffset=1927, charOffset=28], [lineOffset=1935, charOffset=9], [lineOffset=1939, c
harOffset=8], [lineOffset=1977, charOffset=47], [lineOffset=2051, charOffset=527], [lineOffset=2113, charOffset=86], [lineOffset=2218, charOffset=82], [lineOffset=2679, charOffset=54], [lineOffset=2681, charOffset=36], [lineOffset=2
893, charOffset=47], [lineOffset=5615, charOffset=64], [lineOffset=6076, charOffset=7], [lineOffset=6104, charOffset=52], [lineOffset=6517, charOffset=1], [lineOffset=6590, charOffset=26], [lineOffset=6590, charOffset=38], [lineOffs
et=6652, charOffset=16], [lineOffset=7180, charOffset=53], [lineOffset=7337, charOffset=64], [lineOffset=7757, charOffset=30], [lineOffset=8899, charOffset=25], [lineOffset=8969, charOffset=1], [lineOffset=9105, charOffset=26], [lin
eOffset=9157, charOffset=52], [lineOffset=9264, charOffset=67], [lineOffset=9578, charOffset=66], [lineOffset=9677, charOffset=32], [lineOffset=9731, charOffset=14], [lineOffset=9738, charOffset=65], [lineOffset=9842, charOffset=35]
, [lineOffset=9842, charOffset=63], [lineOffset=9861, charOffset=69], [lineOffset=9885, charOffset=62], [lineOffset=9917, charOffset=13], [lineOffset=10038, charOffset=50], [lineOffset=10166, charOffset=45], [lineOffset=10167, charO
ffset=35], [lineOffset=10783, charOffset=5], [lineOffset=11370, charOffset=62], [lineOffset=11383, charOffset=44], [lineOffset=11713, charOffset=7], [lineOffset=11844, charOffset=28], [lineOffset=11904, charOffset=52], [lineOffset=1
1913, charOffset=22], [lineOffset=11971, charOffset=23], [lineOffset=12111, charOffset=46], [lineOffset=12223, charOffset=37], [lineOffset=12578, charOffset=1], [lineOffset=12831, charOffset=21], [lineOffset=12885, charOffset=2], [l
ineOffset=12888, charOffset=68], [lineOffset=13030, charOffset=39], [lineOffset=13160, charOffset=26], [lineOffset=13241, charOffset=8], [lineOffset=13498, charOffset=32], [lineOffset=13506, charOffset=4], [lineOffset=13778, charOff
set=50], [lineOffset=14027, charOffset=43], [lineOffset=14153, charOffset=57], [lineOffset=14176, charOffset=1], [lineOffset=14180, charOffset=48], [lineOffset=14187, charOffset=18], [lineOffset=14190, charOffset=13], [lineOffset=14
206, charOffset=56], [lineOffset=14718, charOffset=23], [lineOffset=14911, charOffset=36], [lineOffset=15168, charOffset=33], [lineOffset=15292, charOffset=51], [lineOffset=15356, charOffset=27], [lineOffset=15402, charOffset=32], [
lineOffset=16534, charOffset=37], [lineOffset=16976, charOffset=55], [lineOffset=17081, charOffset=2], [lineOffset=17086, charOffset=27], [lineOffset=17158, charOffset=11], [lineOffset=17167, charOffset=22], [lineOffset=17673, charO
ffset=1], [lineOffset=18099, charOffset=51], [lineOffset=18357, charOffset=10], [lineOffset=19304, charOffset=13], [lineOffset=19367, charOffset=10], [lineOffset=19610, charOffset=38], [lineOffset=20960, charOffset=32], [lineOffset=
21342, charOffset=62], [lineOffset=21749, charOffset=6], [lineOffset=21832, charOffset=32], [lineOffset=22280, charOffset=16], [lineOffset=22587, charOffset=38], [lineOffset=22733, charOffset=56], [lineOffset=22758, charOffset=46],
[lineOffset=23300, charOffset=22], [lineOffset=24342, charOffset=68], [lineOffset=24552, charOffset=26], [lineOffset=24841, charOffset=1], [lineOffset=25617, charOffset=63], [lineOffset=26161, charOffset=63], [lineOffset=27568, char
Offset=53], [lineOffset=27569, charOffset=3], [lineOffset=27575, charOffset=3], [lineOffset=27575, charOffset=53], [lineOffset=27576, charOffset=53], [lineOffset=27579, charOffset=53], [lineOffset=27580, charOffset=4], [lineOffset=2
7866, charOffset=41], [lineOffset=27866, charOffset=53], [lineOffset=28026, charOffset=8], [lineOffset=28123, charOffset=8], [lineOffset=28127, charOffset=7], [lineOffset=28153, charOffset=9], [lineOffset=28155, charOffset=8], [line
Offset=28605, charOffset=6], [lineOffset=28706, charOffset=6], [lineOffset=28722, charOffset=8], [lineOffset=28800, charOffset=8], [lineOffset=28847, charOffset=11], [lineOffset=29205, charOffset=9], [lineOffset=29457, charOffset=11
], [lineOffset=31213, charOffset=24], [lineOffset=31214, charOffset=66], [lineOffset=32498, charOffset=48], [lineOffset=42024, charOffset=6], [lineOffset=42511, charOffset=42], [lineOffset=47932, charOffset=65], [lineOffset=48501, c
harOffset=2], [lineOffset=49905, charOffset=27], [lineOffset=50045, charOffset=39], [lineOffset=90943, charOffset=34]]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - Jose --> [[lineOffset=45, charOffset=24]]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - Joseph --> [[lineOffset=1825, charOffset=79], [lineOffset=9682, charOffset=31], [lineOffset=15529, charOffset=1], [lineOffset=20016, charOffset=34], [lineOffset=20763, charO
ffset=1], [lineOffset=21362, charOffset=34], [lineOffset=22356, charOffset=1], [lineOffset=22735, charOffset=15], [lineOffset=23445, charOffset=1], [lineOffset=29236, charOffset=8], [lineOffset=39805, charOffset=61], [lineOffset=484
60, charOffset=8], [lineOffset=49505, charOffset=53], [lineOffset=73749, charOffset=18], [lineOffset=73776, charOffset=7], [lineOffset=73853, charOffset=5], [lineOffset=78192, charOffset=1], [lineOffset=78214, charOffset=1], [lineOf
fset=78384, charOffset=1], [lineOffset=78390, charOffset=26], [lineOffset=78401, charOffset=11], [lineOffset=78417, charOffset=1], [lineOffset=78429, charOffset=32], [lineOffset=78452, charOffset=55], [lineOffset=78458, charOffset=6
0], [lineOffset=78583, charOffset=1], [lineOffset=78705, charOffset=16], [lineOffset=78733, charOffset=23], [lineOffset=78742, charOffset=1], [lineOffset=83925, charOffset=14], [lineOffset=86784, charOffset=1], [lineOffset=87029, ch
arOffset=49], [lineOffset=102356, charOffset=60], [lineOffset=102376, charOffset=32], [lineOffset=102391, charOffset=39], [lineOffset=102409, charOffset=30], [lineOffset=104030, charOffset=35], [lineOffset=104032, charOffset=57], [l
ineOffset=104035, charOffset=60], [lineOffset=104046, charOffset=28], [lineOffset=113483, charOffset=27]]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - Joshua --> [[lineOffset=121345, charOffset=12]]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - Kenneth --> [[lineOffset=45623, charOffset=6]]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - Mark --> [[lineOffset=1550, charOffset=1003], [lineOffset=68498, charOffset=56]]
10:40:14.737 [main] INFO  c.b.c.service.ResultAggregator - Matthew --> [[lineOffset=64938, charOffset=14], [lineOffset=92766, charOffset=37], [lineOffset=117509, charOffset=47]]
10:40:14.738 [main] INFO  c.b.c.service.ResultAggregator - Michael --> [[lineOffset=5335, charOffset=1], [lineOffset=5367, charOffset=52], [lineOffset=5391, charOffset=5], [lineOffset=5422, charOffset=29], [lineOffset=5489, charOffs
et=41], [lineOffset=5494, charOffset=1], [lineOffset=29749, charOffset=60], [lineOffset=29901, charOffset=11], [lineOffset=54093, charOffset=60], [lineOffset=54244, charOffset=11], [lineOffset=55043, charOffset=43], [lineOffset=5938
0, charOffset=57], [lineOffset=59655, charOffset=23], [lineOffset=59658, charOffset=15], [lineOffset=59659, charOffset=56], [lineOffset=59702, charOffset=27], [lineOffset=59728, charOffset=61], [lineOffset=59731, charOffset=8], [lin
eOffset=59736, charOffset=1], [lineOffset=59767, charOffset=12], [lineOffset=59783, charOffset=2], [lineOffset=59919, charOffset=5], [lineOffset=60092, charOffset=21], [lineOffset=60166, charOffset=43], [lineOffset=60318, charOffset
=8], [lineOffset=60355, charOffset=32], [lineOffset=69470, charOffset=28], [lineOffset=69488, charOffset=12], [lineOffset=70524, charOffset=5], [lineOffset=75977, charOffset=39], [lineOffset=77841, charOffset=51], [lineOffset=80986,
 charOffset=6], [lineOffset=81561, charOffset=42], [lineOffset=81633, charOffset=43], [lineOffset=81746, charOffset=60], [lineOffset=82195, charOffset=11], [lineOffset=85237, charOffset=11], [lineOffset=87210, charOffset=29], [lineO
ffset=92289, charOffset=50], [lineOffset=92291, charOffset=1], [lineOffset=92299, charOffset=54], [lineOffset=92347, charOffset=22], [lineOffset=92351, charOffset=1], [lineOffset=92362, charOffset=16], [lineOffset=92367, charOffset=
24], [lineOffset=92370, charOffset=7], [lineOffset=92386, charOffset=6], [lineOffset=92393, charOffset=6], [lineOffset=92395, charOffset=39], [lineOffset=92405, charOffset=12], [lineOffset=92468, charOffset=15], [lineOffset=94361, c
harOffset=58], [lineOffset=94365, charOffset=37], [lineOffset=94495, charOffset=26], [lineOffset=97228, charOffset=60], [lineOffset=106115, charOffset=8], [lineOffset=107835, charOffset=1], [lineOffset=107837, charOffset=42], [lineO
ffset=107839, charOffset=16], [lineOffset=108980, charOffset=8], [lineOffset=111547, charOffset=2], [lineOffset=117744, charOffset=55], [lineOffset=121542, charOffset=1], [lineOffset=121574, charOffset=52], [lineOffset=121598, charO
ffset=5], [lineOffset=121629, charOffset=29], [lineOffset=121696, charOffset=41], [lineOffset=121701, charOffset=1]]
10:40:14.738 [main] INFO  c.b.c.service.ResultAggregator - Patrick --> [[lineOffset=7524, charOffset=29], [lineOffset=8398, charOffset=11], [lineOffset=8749, charOffset=18], [lineOffset=9264, charOffset=35], [lineOffset=10539, charO
ffset=62], [lineOffset=14178, charOffset=59], [lineOffset=28611, charOffset=8]]
10:40:14.738 [main] INFO  c.b.c.service.ResultAggregator - Paul --> [[lineOffset=816, charOffset=93], [lineOffset=2196, charOffset=517], [lineOffset=9842, charOffset=40], [lineOffset=28722, charOffset=13], [lineOffset=59030, charOff
set=1], [lineOffset=66093, charOffset=61], [lineOffset=71285, charOffset=21], [lineOffset=75097, charOffset=1], [lineOffset=75099, charOffset=41], [lineOffset=75113, charOffset=5], [lineOffset=87211, charOffset=5], [lineOffset=91624
, charOffset=27], [lineOffset=94025, charOffset=63], [lineOffset=97228, charOffset=32], [lineOffset=116878, charOffset=18]]
10:40:14.738 [main] INFO  c.b.c.service.ResultAggregator - Peter --> [[lineOffset=936, charOffset=344], [lineOffset=6246, charOffset=42], [lineOffset=6592, charOffset=13], [lineOffset=7503, charOffset=38], [lineOffset=13645, charOff
set=56], [lineOffset=15785, charOffset=54], [lineOffset=19305, charOffset=16], [lineOffset=19309, charOffset=67], [lineOffset=29486, charOffset=9], [lineOffset=57437, charOffset=6], [lineOffset=57439, charOffset=15], [lineOffset=574
49, charOffset=24], [lineOffset=57456, charOffset=16], [lineOffset=63534, charOffset=43], [lineOffset=71282, charOffset=35], [lineOffset=75096, charOffset=56], [lineOffset=75099, charOffset=31], [lineOffset=75112, charOffset=63], [l
ineOffset=75113, charOffset=60], [lineOffset=77371, charOffset=1], [lineOffset=77373, charOffset=1], [lineOffset=81720, charOffset=19], [lineOffset=84496, charOffset=63], [lineOffset=87557, charOffset=34], [lineOffset=87582, charOff
set=2], [lineOffset=89672, charOffset=60], [lineOffset=89678, charOffset=8], [lineOffset=90610, charOffset=35], [lineOffset=91157, charOffset=28], [lineOffset=91226, charOffset=27], [lineOffset=91334, charOffset=18], [lineOffset=913
41, charOffset=8], [lineOffset=91635, charOffset=35], [lineOffset=94027, charOffset=58], [lineOffset=96593, charOffset=8], [lineOffset=97682, charOffset=43], [lineOffset=97698, charOffset=32], [lineOffset=98924, charOffset=22], [lin
eOffset=100777, charOffset=2], [lineOffset=100779, charOffset=13], [lineOffset=100800, charOffset=64], [lineOffset=100803, charOffset=11], [lineOffset=102062, charOffset=7], [lineOffset=102266, charOffset=2], [lineOffset=104708, cha
rOffset=2], [lineOffset=105311, charOffset=1], [lineOffset=110688, charOffset=26], [lineOffset=110719, charOffset=1], [lineOffset=113762, charOffset=38], [lineOffset=113778, charOffset=24], [lineOffset=120105, charOffset=45]]
10:40:14.738 [main] INFO  c.b.c.service.ResultAggregator - Richard --> [[lineOffset=7338, charOffset=1], [lineOffset=7526, charOffset=62], [lineOffset=10201, charOffset=34], [lineOffset=21923, charOffset=49], [lineOffset=27578, char
Offset=53]]
10:40:14.740 [main] INFO  c.b.c.service.ResultAggregator - Robert --> [[lineOffset=3893, charOffset=368], [lineOffset=3899, charOffset=247], [lineOffset=3929, charOffset=23], [lineOffset=3943, charOffset=7], [lineOffset=4251, charOf
fset=16], [lineOffset=4271, charOffset=1020], [lineOffset=7270, charOffset=48], [lineOffset=8103, charOffset=43], [lineOffset=8473, charOffset=47], [lineOffset=10123, charOffset=11], [lineOffset=10777, charOffset=35], [lineOffset=10
785, charOffset=54], [lineOffset=11361, charOffset=18], [lineOffset=13687, charOffset=48], [lineOffset=15522, charOffset=12], [lineOffset=16751, charOffset=18], [lineOffset=17891, charOffset=67], [lineOffset=27867, charOffset=11], [
lineOffset=28509, charOffset=9], [lineOffset=28607, charOffset=8], [lineOffset=28904, charOffset=9], [lineOffset=29409, charOffset=14], [lineOffset=39669, charOffset=27]]
10:40:14.740 [main] INFO  c.b.c.service.ResultAggregator - Roger --> [[lineOffset=6119, charOffset=12], [lineOffset=6591, charOffset=30], [lineOffset=7299, charOffset=40], [lineOffset=7818, charOffset=1], [lineOffset=29448, charOffs
et=11]]
10:40:14.740 [main] INFO  c.b.c.service.ResultAggregator - Scott --> [[lineOffset=996, charOffset=74], [lineOffset=12880, charOffset=10], [lineOffset=15353, charOffset=41], [lineOffset=15719, charOffset=44], [lineOffset=15755, charO
ffset=9], [lineOffset=16833, charOffset=52], [lineOffset=16989, charOffset=11], [lineOffset=16992, charOffset=1], [lineOffset=16992, charOffset=26], [lineOffset=16999, charOffset=54], [lineOffset=17002, charOffset=6], [lineOffset=17
022, charOffset=6], [lineOffset=17069, charOffset=38], [lineOffset=17076, charOffset=15], [lineOffset=17269, charOffset=22], [lineOffset=17298, charOffset=11], [lineOffset=17744, charOffset=23], [lineOffset=17779, charOffset=27], [l
ineOffset=18356, charOffset=23], [lineOffset=23574, charOffset=6], [lineOffset=28389, charOffset=6], [lineOffset=29183, charOffset=1], [lineOffset=50222, charOffset=12]]
10:40:14.740 [main] INFO  c.b.c.service.ResultAggregator - Stephen --> [[lineOffset=15880, charOffset=28], [lineOffset=16912, charOffset=32], [lineOffset=16942, charOffset=30], [lineOffset=18064, charOffset=58], [lineOffset=28382, c
harOffset=10]]
10:40:14.740 [main] INFO  c.b.c.service.ResultAggregator - Thomas --> [[lineOffset=6122, charOffset=4], [lineOffset=6591, charOffset=63], [lineOffset=7527, charOffset=24], [lineOffset=9393, charOffset=47], [lineOffset=9745, charOffs
et=1], [lineOffset=10540, charOffset=8], [lineOffset=11375, charOffset=13], [lineOffset=11716, charOffset=29], [lineOffset=11763, charOffset=29], [lineOffset=12111, charOffset=58], [lineOffset=12914, charOffset=66], [lineOffset=1397
0, charOffset=40], [lineOffset=14180, charOffset=27], [lineOffset=17883, charOffset=26], [lineOffset=21832, charOffset=45], [lineOffset=25617, charOffset=51], [lineOffset=27569, charOffset=53], [lineOffset=27570, charOffset=3], [lin
eOffset=27594, charOffset=53], [lineOffset=27601, charOffset=53], [lineOffset=28623, charOffset=9], [lineOffset=28708, charOffset=12], [lineOffset=29010, charOffset=8], [lineOffset=41048, charOffset=41], [lineOffset=48557, charOffse
t=34], [lineOffset=73771, charOffset=58], [lineOffset=109968, charOffset=16]]
10:40:14.740 [main] INFO  c.b.c.service.ResultAggregator - Timothy --> [[lineOffset=13388, charOffset=1], [lineOffset=13752, charOffset=30]]
10:40:14.741 [main] INFO  c.b.c.service.ResultAggregator - Walter --> [[lineOffset=23568, charOffset=1]]
10:40:14.741 [main] INFO  c.b.c.service.ResultAggregator - William --> [[lineOffset=812, charOffset=32], [lineOffset=818, charOffset=152], [lineOffset=1360, charOffset=195], [lineOffset=1362, charOffset=50], [lineOffset=1398, charOf
fset=746], [lineOffset=6080, charOffset=9], [lineOffset=6160, charOffset=17], [lineOffset=6590, charOffset=53], [lineOffset=6591, charOffset=12], [lineOffset=7401, charOffset=64], [lineOffset=7420, charOffset=53], [lineOffset=7601,
charOffset=64], [lineOffset=7818, charOffset=66], [lineOffset=7873, charOffset=31], [lineOffset=7914, charOffset=34], [lineOffset=8085, charOffset=54], [lineOffset=8094, charOffset=35], [lineOffset=8338, charOffset=52], [lineOffset=
8473, charOffset=26], [lineOffset=8567, charOffset=13], [lineOffset=9856, charOffset=28], [lineOffset=10306, charOffset=1], [lineOffset=10782, charOffset=34], [lineOffset=10814, charOffset=65], [lineOffset=12568, charOffset=51], [li
neOffset=14133, charOffset=12], [lineOffset=14161, charOffset=65], [lineOffset=14689, charOffset=44], [lineOffset=15291, charOffset=1], [lineOffset=16492, charOffset=19], [lineOffset=16632, charOffset=46], [lineOffset=16980, charOff
set=9], [lineOffset=16980, charOffset=64], [lineOffset=17306, charOffset=14], [lineOffset=18050, charOffset=9], [lineOffset=19554, charOffset=12], [lineOffset=19840, charOffset=40], [lineOffset=19841, charOffset=14], [lineOffset=198
78, charOffset=54], [lineOffset=21431, charOffset=57], [lineOffset=22143, charOffset=33], [lineOffset=22733, charOffset=26], [lineOffset=23028, charOffset=58], [lineOffset=23340, charOffset=1], [lineOffset=23669, charOffset=17], [li
neOffset=25739, charOffset=20], [lineOffset=25892, charOffset=28], [lineOffset=27584, charOffset=53], [lineOffset=27597, charOffset=4], [lineOffset=27600, charOffset=4], [lineOffset=27738, charOffset=36], [lineOffset=28520, charOffs
et=11], [lineOffset=28739, charOffset=6], [lineOffset=28823, charOffset=11], [lineOffset=29033, charOffset=11], [lineOffset=29035, charOffset=7], [lineOffset=29066, charOffset=7], [lineOffset=29446, charOffset=1], [lineOffset=47095,
 charOffset=57]]
10:40:14.741 [main] INFO  c.b.c.service.ResultAggregator - *** End of Results *****************************************************************************
10:40:14.741 [main] INFO   c.b.challenge.utils.InfoUtils - Free Memory: 394 Mb
10:40:14.741 [main] INFO     c.b.c.ReadMatchAggregateApp - *** Execution Finished!

```