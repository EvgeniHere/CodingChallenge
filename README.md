# CodingChallenge
Bots playing Cards

Coding challenge by Kauan Schuani and Evgeni Uschakov: Tournament of bots playing cards. Upload your selfwritten bot to get involved and let him play against other bots. Hope to see you in the ring!

Also join our Discord server for further information and discussions with other competitors! --> https://discord.gg/EQKtmvj

Conditions for writing: 

- Use our generated basic structure of the game
            
- Upload your single Botclass only (FirstBot.java)
            
- Your Bot has the ability to see the opponent Cards (opponents cards will be transported to your code as a parameter of the data type List<Karte>)

- You are only allowed to use the methods of your class and the method "this.placeCard(index);" to place cards

- Every card your bot places will be checked by a cheatdetector. Don't get the wrong idea...

- You are able to change some variables while developing. for example: "waitingTime" in Game.java (it does speed up everything)

- After finishing your bot, send me your email or username of github as an email to evgeni.uschakov@gmail.com. Than wait for me to allow you access and upload it to the branch: "Botuploads". To let me know whos bot won, write your username into "Firstbot.java". exactly: into the constructor where it says "-FirstBot-"

- also: Stay tuned for future updates! The program has to be polished some times, so it does continue being able to handle all the new bots.

- PS: you are allowed to have fun while programming :)
            
General gamerules: 

- You can only place one card. it has to be either the same color or the same number as the card placed before you.

- At the beginning every bot gets 15 by default. one card will be placed in the cardfield and the other one gets the beginner bot.

- If you are not able to place a card because you dont have one that fits, the other bot can play the next card.

- The winner of this game is the bot who has no cards left.

- This game is going to run through a 100 times to identify the better bot, so simple luck cant choose the winner

Tips:

- You dont have to look into the other classes. Write your bot only into "FirstBot.java", change the "waitingTime" variable to something higher in "Game.java" and you are fine.
