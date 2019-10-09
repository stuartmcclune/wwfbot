# wwfbot
A Words With Friends bot

wwfbot is a tool that tracks a Words With Friends board and, given a player's rack, computes the highest scoring possible move. The bot started life as a Python Jypter notebook and a more powerful Java command line application has now been developed. Furthermore, a web application is under development.

This Java app is not yet complete, but all core functionality is implemented. The main improvement since moving to Java is speed, allowing the bot the capability of supporting blanks in the player's rack. Most of the time, moves can be computed in around 1 second, but with 2 blank tiles in the rack, finding the best move can take up to roughly 70 seconds. This is a major improvement on the notebook version, which would have taken approximately 24 hours if this functionality was included. I hope to optimise this further in the future.

Additionally, a webapp is being built with a React-Redux front end and a Java Spring back end. A work in progress version of this is deployed on Heroku at https://wwfbot.herokuapp.com. Currently, it can handle up to 1 blank in the rack, but will crash in the case of 2 due to running out of memory. I am looking into ways of improving both the time and memory complexity of the move calculating algorithm in order to better the user experience. I will also work on the frontend UI since it is currently not mobile friendly and generally looks pretty ugly.

# Using the webapp
1. Visit https://wwfbot.herokuapp.com on a **computer**.
2. Click on tiles in the pool to select them, then click where to place them on the board.
3. Similarly, move tiles into your rack.
4. Click the Cheat button and wait whilst the highest scoring move is calculated.
5. The best move will be shown in green on the board.

NOTE: Due to infrequent traffic, Heroku unloads both the front end and back end dynos. Therefore, loading the website may take some time, and calculating the first move may also take longer than expected.

# Running the Java app
Clone the repository and execute the following:
```
cd wwfbotJava
gradlew run --console=plain
```

# Running the Jupyter notebook
1. Make sure you have Jupyter installed on your system. 
2. Clone the repository. 
3. Run Jupyter. 
4. Navigate to `wwfbot.ipynb` and open it.

# Future plans
- Refine and optimise the Java command line app / webapp back end.
- Scrape complete word list from Internet.
- Webapp front end UI/UX improvements.
