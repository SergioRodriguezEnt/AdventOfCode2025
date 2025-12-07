# Day 01 B
The main change from day01-a is that we now count **every** time the dial passes through zero.<br>
This means the code stays the same except for DialRecord, where we now check full rotations and rotations that pass through 0 while not being full rotations.