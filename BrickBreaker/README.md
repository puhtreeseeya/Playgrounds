# BrickBreaker
A small game. 

This game was a small introduction to a series of project based tutorials that I plan to follow in order to learn how to 
better structure my code as well as to become more comfortable using libraries. In this particular project I used the 
keyListener and actionEvent interface to detect when the user presses the left or right arrow keys which in turn causes 
the paddle to move (the action) in those directions. I used the Graphics abstract class to draw all the shapes on the JPanel
component such as the paddle, ball, and bricks. 

My GameController class inherits all the properties of the JPanel component while providing the logic to make the game function as 
expected. The logic includes determing the area of interesection between the ball and the paddle and reversing the direction
of the ball whenever they intersect. It also determines the area of intersection between the ball and the bricks and deletes the 
brick from the screen whenever the ball intersects or 'touches' the brick and then reverses the direction of the ball. Although the logic in this game is fairly trivial, programming it helped solidify certain object oriented concepts such as Inheritance, Interfaces, and Abstract classes. All in all, it was a fun project to code and I liked having something visual to look at and play with. 
