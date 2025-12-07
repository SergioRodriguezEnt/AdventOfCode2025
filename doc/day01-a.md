# Day 01 A
Given a dial that **starts at 50**, the dial can go **from 0 to 99**.<br>
Follow a set of orders and **count the times the dials ends at 0 after an order**<br>
<br>
In this case, the Dial class represents the dial itself, with no functionality.<br>
The Order class contains a parsed instruction and is the one tasked with applying itself to a dial.<br>
The DialRecord class (inner class of Runner01A) is there to keep count of the number of zeros that have appeared.<br>
Finally, the Runner01A class acts as the controller for the program, parsing the inputs and obtaining the results.<br>
<br>
Important to note the use of the _Function interface_ inside the Order class so that a stream of orders can be easily reduced.