# Java Calculator

### What it does:

This is a Java command line program. It is a calculator that computes operations like:
- number sign number
- number sign number sign number sign number etc
- (number sign number) sign (number sign number).

The user is asked to enter an expression, the program displays the answer, then asks to enter an option. The options are:
- 'm', to record the last result in the memory
- 'mr', to display the result recorded in the memory
- 'c', to clear the memory
- 'h', to display all the previous results since compiling the program.

The user can also type 'sign number', that will use the memory stored number, and the program will display the result. The program will run until the user will enter 'EXIT'.

### How I built it:

- evaluate method does the biggest part of the work.
- It takes the string input and verifies if the expression is valid, collecting the numbers and the sign.
- This method is divided into many parts by if and else, in order to be able to take every imput case.
- The final lines of each part compute the results, depending on the sign entered by the user.
- I have also created getters and setters for the options, that will make the user able to record a value, to see it, clear it, and see the history. These methods are used in main.
- I have added useful messages in main, that will make the calculator much easier to be used.

### Challenges I ran into:

It was pretty hard to deal will al the invalid inputs. Also, I had to take care of the 0 division, which is impossible, and the negative numbers, because they involve one more '-'.
