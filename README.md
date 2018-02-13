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

To reach this goal, you must complete the 6 tasks marked "TODO: Assignment 4" throughout the code base. You should not need to modify any code outside of the specified TODO regions.

You are required to author unit tests (to be saved in the testing package) for every piece of functionality you write that is more complex than a "getter" function; this does include pre-written functions that include a TODO. Ensure that constructors set up the objects the way you expect, that setter functions set the appropriate values, that computational functions compute things in the way you expect, etc. Pay particular attention to functions with side-effects. Should your unit tests require a GameBoard object, you can look at the existing unit tests for the PathFinder class for examples of how to create a GameBoard for testing. Though the exact number of unit tests you write will depend on your implementation, if you have fewer than 20 when you think you are finished, you have probably not tested thoroughly enough.

### What You Will Hand In
You will turn in both your code and your design document on GitHub (similarly to Assignment 3). Only commits pushed to GitHub before the deadline will be considered.

### Notes and Grading
Beware of using your late pass on this assignment, as Assignment 5 will be assigned on the day Assignment 4 is due.

Grading of Assignment 4 (for those who do not use their late passes) will occur the night it is due. Grades and feedback on Assignment 4 should be returned within 24 hours.

Please note that you should not work ahead on Assignment 5 (ghost functionality) until Assignment 4 is graded. Working ahead will result in confusion while the instructor/TA team grades Assignment 4 (which does not bode well for your grade) and may also require you to redo the anticipatory work you did prior to the release of the details of Assignment 5.
