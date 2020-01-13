# Mystery Duplicates

`EmployeeProcessor` reads in a list of names and social security numbers. It is
supposed to count duplicates, but this code doesn't work.  It is supposed to
count duplicates and print them, like so:
```
JOHN Q PUBLIC: 2
LARS X ULRICH: 1
STEPHANIE L NICKS: 1
```

However, the code doesn't work, outputting the following instead:
```
JOHN Q PUBLIC: 1
LARS X ULRICH: 1
STEPHANIE L NICKS: 1
JOHN Q PUBLIC: 1
```

Why does John Q Public appear twice?
John Q Public appears twice because the equals/hashcode functions were not overridden in the Employee class. Thus, when the default hashcode() function is called, there will be no collision in the resulting hashmap, thus leading to the two John Q Publics being listed as separate objects. I naively used the SSN as the unique identifier for the person, but we can also extend the hashcode function to utilize the person's name as well. 

## Task 1

Fix the code so that it produces the expected output when run. You may modify
the source here in any way that you like, but please keep the `static void main()`
function in `EmployeeProcessor.java`.
