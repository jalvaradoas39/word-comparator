# Word Comparator Program

## Description
This project was a school assignment for my Java programming course. The task was to write a Java program that evaluates the scrabble value of words from a given list and sorts them in ascending order based on their value. The program uses a custom comparator to calculate and compare the word values. Each letter is assigned a specific point value:

- **1 point**: A, E, I, O, U, L, N, S, T, R.
- **2 points**: D, G.
- **3 points**: B, C, M, P.
- **4 points**: F, H, V, W, Y.
- **5 points**: K.
- **8 points**: J, X.
- **10 points**: Q, Z.

The program reads a list of words from a file named `wordlist.txt`, calculates the scrabble value of each word, and outputs the words sorted in a comma-separated format based on their values.

## Example
Using the `wordlist.txt` file containing:
```
dog soap puzzle wolf apple zoo
```

The program will output the following:

```
dog, wolf, soap, apple, zoo, puzzle
```

## What I Learned
In this week's lesson, I deepened my understanding of runtime complexity analysis. One key takeaway was recognizing that sorting algorithms often involve nested loops, which can lead to O(N^2) complexity. Also, understanding logarithmic time complexity through concepts like binary search (O(log N)) helped me see the efficiency of certain approaches and their impact on processing larger datasets.