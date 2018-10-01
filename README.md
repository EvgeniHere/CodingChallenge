# CodingChallenge
Bots playing Cards

Coding challenge by Kauan Schuani and Evgeni Uschakov: Tournament of bots playing cards. Upload your selfwritten bot to get involved and let him play against other bots. Hope to see you in the ring!

Also join our Discord server for further information and discussions with other competitors! --> https://discord.gg/EQKtmvj

Conditions for writing: 

- Use our generated basic structure of the game
            
- Upload your single Botclass only (Write your code into FirstBot.java)
            
- Your Bot has the ability to see the opponent Cards (opponents cards will be transported to your code as a parameter of the data type List<Karte>)

- You are only allowed to use the methods of your class and the method "this.placeCard(index);" to place cards

- every card your bot places will be checked by a cheatdetector. Don't get the wrong idea...

- you are able to change some variables while developing. for example: "waitingTime" in Game.java (it does speed up everything)

- after finishing your bot, upload it to the brach: "Botuploads". To let me know who won, write your username into Firstbot.java. exactly said into the constructor where it says "-FirstBot-"

- also: stay tuned for future updates! The program has to be polished some times, so it does continue being able to handle all the new bots.

- PS: you are allowed to have fun while programming :)
            
General gamerules: 

- you can only place one card. it has to be either the same color or the same number as the card placed before you.

- every turn youll get a card. at the beginning every bot gets 5 by default. 

- if you are not able to place a card because you dont have a card that fits, you have to take a new card. if there is no card left to take, you lost.

- this game is going to run through a 100 times to identify the better bot, so simple luck cant choose the winner
