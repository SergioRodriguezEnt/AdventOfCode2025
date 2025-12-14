# Day 03 A
We are given banks of batteries composed of **sequences of digits** that go from **1 to 9**.<br>
The task is to create the **biggest number** with **two digits** while maintaining the **order of appearance**<br>
<br>
The Bank class is purely representational, describing the battery bank.<br>
The DigitSequenceSelector class acts as the solver for the problem, with a digit list and a stack to rebuild the final number at the end.<br>
The Lock class is there to keep count of the number of zeros that have appeared.<br>
Finally, the Runner03 class acts as the controller for the program, parsing the inputs and obtaining the results, with the Runner03Builder acting as the Builder class with a fluent API.<br>