```
                                            o
                                           /|\
                                           / \
```

# Buildman

Buildman is a word-guessing game (Hangman-style). You try to discover an unknown word before the character is fully built. You can guess individual letters first, then attempt to guess the full word.

## Tools & languages

- **Language:** Java (core game logic + GUI)  
- **GUI:** Java Swing (JFrame, JPanel, JButton, JLabel, JTextField)  
- **File I/O:** Java `java.io` + `java.nio.file` for loading/saving word lists  
- **Build / dev environment:** Nix (`replit.nix`) with GraalVM 17 Community Edition, Maven, and Replit Java tooling (JDT language server + Java debugger)

## Features

### Difficulty modes
Pick a difficulty to control how forgiving the game is.

- **Easy / Normal / Hard** difficulty selection
- Difficulty also controls the **word-length range** chosen for the round:
  - Easy: short words
  - Normal: medium-length words
  - Hard: longer words

### Themes (word packs + visuals)
After choosing difficulty, you choose a theme.

- **Winter theme**
  - Loads words from `christmasWords.txt`
  - Uses winter/Christmas background and **Snowman** build images
- **Bunny theme**
  - Loads words from `jungleWords.txt`
  - Uses bunny background and **Bunny** build images
- **Custom theme**
  - Lets you play from your own word list file
  - Uses chalkboard background and **Stickman** build images

### Add your own words (Custom Words mode)
You can create your own word list file from inside the app.

1. Choose **Custom** on the theme screen.
2. Enter a **Filename** (this becomes `<filename>.txt`).
3. Type a word and press **Enter** to add it to the file.
4. On the right side, type the name of a file to **Play**, then press **Play**.

Notes:
- Custom words are validated against `words.txt` (dictionary check) before being saved.
- Built-in word files (like `words.txt`, `christmasWords.txt`, `jungleWords.txt`) are set to read-only so you don’t accidentally overwrite them.

### Guessing system (letters or full word)
- Enter **one letter** to guess a letter.
- Enter **multiple characters** to guess the full word.
- Tracks and displays:
  - **Letters guessed**
  - **Words guessed**
  - **Guesses remaining**

### Win / Loss conditions
- If you guess the word correctly → **Win screen**
- If your guesses reach 0 → **Loss screen**

## How to play

1. **Start the game**.
2. **Choose a difficulty** when prompted.
   - Higher difficulty generally means **fewer guesses** and **harder words**.
3. **Choose a theme** (Winter, Bunny, or Custom).
4. **Guess letters** to reveal parts of the word.
5. When you're confident, **guess the entire word** to win.

## Notes

- The goal is to solve the word **before** you run out of allowed guesses.
- If you want, you can add screenshots / a demo GIF here to show gameplay.
