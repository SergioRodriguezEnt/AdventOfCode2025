# Day 04 A
We are given a Wall composed of **spaces with paper or empty**.<br>
The task is to **count how many paper rolls we can remove**.<br>
We can only remove paper rolls that are **surrounded by less than 4** paper rolls in the **8 adjacent positions**.<br>
<br>
The Position class acts as an int tuple.<br>
The Space enum simplifies code and conditions. <br>
The Wall class stores the state of the wall with every space accounted for.<br>
The WallAnalyzer class is the problem solver for this phase, filtering which spaces have paper rolls to be removed.<br>
Finally, the Runner04A class acts as the controller for the program, parsing the inputs and obtaining the results, with the Runner04Factory acting as the Simple-Factory class with a fluent API.<br>