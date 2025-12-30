# Day 02 A
Given a **list of ID ranges** find **all numbers** inside those ranges that are a made by a sequence of digits repeated **exactly twice**.<br>
Get all those numbers and add them together.<br>
<br>
The software.aoc.day05.IdRange class, as the name implies, represents the ranges themselves.<br>
The main functionality of this class is to get **all invalid IDs in the range** that **do not satisfy a certain condition**.<br>
he Runner02 class, again, acts as the controller for the program, being this class the one that receives, stores and passes the condition to the ID ranges.<br>
<br>
The main thing to note here is the code injection for the condition (long live Regex101) which will make things easier later.