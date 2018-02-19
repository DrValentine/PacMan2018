# PacMan Part 1 (Assignment 4)

From Wikipedia:
> PacMan is an arcade game developed by Namco and first released in Japan in May 1980. It was created by Japanese video game designer Toru Iwatani. It was licensed for distribution in the United States by Midway Games and released in October 1980. Immensely popular from its original release to the present day, PacMan is considered one of the classics of the medium, and an icon of 1980s popular culture. Upon its release, the game — and, subsequently, PacMan derivatives — became a social phenomenon that yielded high sales of merchandise and inspired a legacy in other media. PacMan was popular in the 1980s and 1990s and is still played in the 2010s.

Your task for Assignments 4 and 5 is to complete the game of PacMan. Much of the implementation has been provided for you, but you will be tasked with completing the moving parts (quite literally!). You need to add and configure the components that move - PacMan in Assignment 4 and the Ghosts in Assignment 5.

In Assignment 4, you will focus primarily on designing the Agent class hierarchy and the members/functions that belong to each level of the hierarchy. In Assignment 4, you will also be charged with implementing the Agent class, the PacMan class, and a few other odds and ends.

The version of PacMan to be built in these two assignments has these gameplay attributes:
  * The player navigates the PacMan character using the directional arrows (left, up, down, right).
  * The game is won when PacMan has eaten all of the available Pac-Dots (called coins hereafter for brevity).
  * The game is lost when PacMan and a ghost share a cell of the gameboard (Assignment 5 only).
  * PacMan's image changes direction based on the last direction he traveled (e.g., if PacMan last traveled down, his mouth should face the south direction).
  * There are 4 ghosts (Red, Blue, Yellow, and Pink) that move autonomously through the gameboard. Ghosts are not controlled by the player.
  * Each ghost "haunts" two different cells in the gameboard, and spends its time navigating between its two haunts.
  * The ghosts' bodies do not change direction, but their eyes do change direction based on the last direction traveled (e.g., if the ghost last traveled up, the eyes should face up).
  * PacMan and the ghosts can only travel one cell at a time, in either of the left, up, down, or right directions. They cannot travel diagonally.
  * Neither PacMan nor the ghosts can travel through walls (the gameboard should ensure this).
  * Our version of PacMan has no cherries, no blue dots, and no extra lives for PacMan.

Technical attributes regarding this game:
  * Much of the functionality for a PacMan game (representing and rendering the gameboard, a keyboard listener, an animation timer for ghosts, etc.) has been provided for you in this repository.
  * The GameRunner class contains the `main` function that starts the game and performs or coordinates most UI-related tasks.
  * The GameBoard class handles all gameplay-related functionality and does not handle *any* UI-related tasks.
  * The only class that is allowed to have a reference to the GameBoard class is the GameRunner class.
  * The Agent, PacMan, and Ghost classes are presently empty. You are tasked with writing those classes (Agent & PacMan in Assignment 4, Ghost in Assignment 5).
  * The Sprite class (a superclass for everything that can be represented by an image) and Agent class (a superclass for everything that can be represented by an image and that can move) are both abstract.
  * All of the images you will need are included in the "/images" folder in the provided repository.

### PacMan Assignment 4 (This Assignment)

The goals of this assignment are two-fold. First, you must design a class hierarchy and determine which functionality belongs to which class. Second, you must implement that hierarchy in the code and ensure your implementation meets the specifications outlined in this document.

**Phase 1: Design** As stated above, the Agent class should be an abstract superclass for everything that can be represented by an image and that can move. Remember that superclasses should hold only the functionality shared by all of its children. Also remember that abstract classes can guarantee that their children have specific functionality, without necessarily defining that functionality itself. Given the gameplay attributes listed above, determine which functionality belongs with the Agent class and which belongs with the PacMan class. Though you will not be implementing the Ghost class in this assignment, keep in mind the functionality required for Ghosts when designing your Agent class.

Keep a "Design Document" that outlines your decisions (a markdown file stored in the same directory as this README file). For each piece of functionality, you will include four pieces of information:
1. The functionality about which you made a decision (e.g., moving from one cell to another)
2. The class(es) you chose to be responsible for the functionality (plural in case of abstract functions)
3. Whether the functionality is or is not abstract
4. Why you chose to add that functionality to the chosen class

**Phase 2: Implementation** By the end of Assignment 4, a player of your game should be able to navigate PacMan through the passageways of the gameboard using the directional keys. If PacMan eats all of the coins, the game should end with a congratulatory message.

To reach this goal, you must complete the 6 tasks marked "`TODO: Assignment 4`" throughout the code base. You should not need to modify any code outside of the specified `TODO` regions.

You are required to author unit tests (to be saved in the testing package) for every piece of functionality you write that is more complex than a "getter" function; this does include pre-written functions that include a `TODO`. Ensure that constructors set up the objects the way you expect, that setter functions set the appropriate values, that computational functions compute things in the way you expect, etc. Pay particular attention to functions with side-effects. Should your unit tests require a GameBoard object, you can look at the existing unit tests for the PathFinder class for examples of how to create a GameBoard for testing. Though the exact number of unit tests you write will depend on your implementation, if you have fewer than 20 when you think you are finished, you have probably not tested thoroughly enough.

### What You Will Hand In
You will turn in both your code and your design document on GitHub (similarly to Assignment 3). Only commits pushed to GitHub before the deadline will be considered.

### Notes and Grading
Beware of using your late pass on this assignment, as Assignment 5 will be assigned on the day Assignment 4 is due.

Grading of Assignment 4 (for those who do not use their late passes) will occur the night it is due. Grades and feedback on Assignment 4 should be returned within 24 hours.

Please note that you should not work ahead on Assignment 5 (ghost functionality) until Assignment 4 is graded. Working ahead will result in confusion while the instructor/TA team grades Assignment 4 (which does not bode well for your grade) and may also require you to redo the anticipatory work you did prior to the release of the details of Assignment 5.

# PacMan Part 2 (Assignment 5)
Your task for Assignment 5 is to add ghosts and to complete the functionality of your PacMan Game. This assignment will proceed in 6 phases:

**Phase 1: Design***
Update the design document that you created for PacMan Part 1 to include the functionality required for the Ghost class. Be sure to include the following pieces of information for each piece of functionality:
1. The functionality about which you made a decision (e.g., moving from one cell to another)
2. The class(es) you chose to be responsible for the functionality (plural in case of abstract functions)
3. Whether the functionality is or is not abstract
4. Why you chose to add that functionality to the chosen class

**Phase 2: Update the Agent Class to Support Ghosts**
If necessary, update the Agent and PacMan classes to be consistent with any changes you made in your design document. This will be necessary if, perhaps, you included some functionality in the PacMan class that you think should be in the Agent class (or vice versa). Don't forget to update any unit tests that may be broken by your refactoring. If no refactoring is necessary, skip to Phase 3.

**Phase 3: Implement the Ghost Class**
Implement the functionality for the Ghost class that you defined in your design document. Write functions and unit tests in tandem so you identify any major issues in your code before it is used elsewhere in the codebase. Note that every function that is more complicated than a getter should have at least one unit test. For some functions, it will be difficult to test *all* of the features. For example, paint function(s) probably do not need to be unit tested at all (if you would like to add a unit test for these functions, you might choose to assert that they have no side-effects). Functions that retrieve images can be half-tested -- you can verify that they return *an image*, and that after changing directions they return *a different image*, but it may be unnecessarily difficult to verify that the image returned is the one you thought you should receive.

**Phase 4: Mop Up the Rest of the TODOs**
Once you have a working Ghost class, find the rest of the `TODO`s labeled with Assignment 5. Begin with instantiating and adding one Ghost in GameBoard's initialization function. Add a unit test for the initialize function that tests to verify that it creates a new ghost. When your test passes and you run GameRunner, you should see a ghost hanging out in the lair, but not moving.
Now, it's time to get your ghost to move. Begin tackling the "advanceGhosts" function. This function should loop through all ghost objects on the GameBoard. With each of the objects, it should do the following things:
* If the ghost doesn't currently have a path, or if the path has no more instructions, generate a new path to some other cell using PathFinder's static findPath() method. This method returns an ArrayList of Integers, each of which is an instruction to move in a specified direction (an integer KeyEvent direction). Store the new path inside the Ghost object.
* Regardless of whether the ghost had a path at the beginning of the function, get the next instruction from the ghost's path (an integer KeyEvent direction) and move the ghost in the direction specified. The next instruction of the path should always be the 0th element in the ArrayList of Integers that defines the path. Already-executed instructions should be removed from the list. ArrayList's `remove(int index)` function may be helpful to you.
* Attend to any other maintenance necessary, as per your implementation of Ghost.
Create unit tests that verify the features of the `advanceGhosts` function. Create a GameBoard (for examples of how to do this for testing, see the provided unit tests for the PathFinder class; the last unit test should be particularly helpful to you). On your newly created GameBoard, call the    `advanceGhosts` function (in order to test the function, you will need to change its visibility to public). Does a ghost who didn't previously have a path have a path after the function? Is a ghost in a new cell after the function? Is the ghost in the correct new cell after the function? Verify.
When you run the GameRunner, you should see your ghost navigating first from the ghost lair to one of its haunts, and then navigating between its haunts.
The final step toward a working game is to complete the last `TODO`: verifying the loss-state. Complete the function and write a few unit-tests: one to confirm that the function correctly identifies a loss-state when appropriate, and one to confirm that the function does **not** identify a loss-state when appropriate.

**Phase 5: Play PacMan!**
At this point, you should have a fully-operational game of PacMan! Play to see if you can win! Play to see if you can lose!

**Phase 6: Commit Your Code to GitHub**
You should have been doing this all along (once after each major phase), but if you haven't committed your code to GitHub yet, ensure that you do so now!

See the assignment on Canvas for the grading rubric for this assignment!
