<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
<ul>
    <li>The task assigned is to create a terminal based game in Java</li>
    <li>The rules of the game must be implemented in Java</li>
    <li>I currently do not know how to use GenMyModel</li>
    <li>Must be able to create an intuitive and user-friendly interface</li>
    <li>Must make the output enjoyable without over-complication</li>
</ul>
<h2>
    2. Planning the Solution
</h2>
<ul>
    <li>Choose a game to create</li>
    <li>Identify game structure and components</li>
    <li>Identify game rules</li>
    <li>Learn how to use GenMyModel</li>
    <li>Create game model in GenMyModel based on structure and components identified</li>
    <li>Write each game component based on identified structure/GenMyModel</li>
    <li>Test each component of game composition</li>
    <li>Present game to class</li>
</ul>
<h2>
    3. Executing the Plan
</h2>
<ul>
    <li>Completed parts 1 and 2 of UPER</li>
    <li>Wrote 4 Pillars of OOP essay</li>
    <li>Decided on Blackjack for the game to create</li>
    <li>Looked up Blackjack game rules</li>
    <li>Did walkthrough on GenMyModel</li>
    <li>Brainstormed project layout and used GenMyModel to create corresponding diagrams</li>
    <li>Created necessary classes inside capstone project</li>
    <li>Wrote functionality for Card class</li>
    <li>Added Dealable interface</li>
    <li>Wrote functionality for Deck class, which implements the Dealable interface</li>
    <li>Added Player abstract class</li>
    <li>Wrote functionality for Spread class, adding additional members and attributes from the original wireframe</li>
    <li>Updated Spread class in wireframe</li>
    <li>Updated Player abstract class</li>
    <li>Wrote functionality for User class</li>
    <li>Updated wireframe for Player and User classes, removed Hand class from wireframe</li>
    <li>Refactored Deck class to create a Singleton instance</li>
    <li>Implemented functionality for Dealer class</li>
    <li>Changed Deck class so that filling and refilling the deck occur automatically</li>
    <li>Added newRound method to User class</li>
    <li>Implemented functionality for Menu class</li>
    <li>Added method to User and Dealer that checks for BlackJack status</li>
    <li>Began testing and bug fixing</li>
    <li>Fixed getting integer input from user to stop program crashes</li>
    <li>Fixed toLowerCase on name entry</li>
    <li>Changed for in loop to for loop in actionMenu method to loop through all user spreads including those added while iterating</li>
    <li>Fixed calculation error for doubling bet (*= operator causing unexpected results)</li>
    <li>Prepared for class presentation</li>
    <li>Presented project to class</li>
</ul>
<h2>
    4. Reflection / Refactor
</h2>
<ul>
    <li>Possibility of moving card values out of Cards and implementing more robust logic in Spread to calculate value</li>
    <li>Would have liked to have included more graphically intense ascii art for cards</li>
    <li>Determined that Hand class was not needed</li>
    <li>Decided to make Deck a Singleton instance for use in the User and Dealer classes to ensure a common pool of cards</li>
    <li>Fixed getting integer input from user to stop program crashes</li>
    <li>Changed for in loop to for loop in actionMenu method to loop through all user spreads including those added while iterating</li>
</ul>