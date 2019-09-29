# wwfbot
A Words With Friends bot

wwfbot is a tool that tracks a Words With Friends board and, given a player's rack, computes the highest scoring possible move. The bot started life as a Python Jypter notebook and a more powerful Java command line application has now been developed. 

This Java app is not yet complete, but all core functionality is implemented. The main improvement since moving to Java is speed, allowing the bot the capability of supporting blanks in the player's rack. Most of the time, moves can be computed in around 1 second, but with 2 blank tiles in the rack, finding the best move can take roughly 75 seconds. This is a major improvement on the notebook version, which would have taken approximately 24 hours if this functionality was included. I hope to optimise this further in the future.

Additionally, a react-redux frontend is currently under development for a future webapp deployment.

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
- Refine and optimise the Java command line app.
- Scrape complete word list from Internet.
- Build and deploy a webapp.
