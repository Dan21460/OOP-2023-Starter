package ie.tudublin;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class DANI extends PApplet {

	ArrayList<Word> words = new ArrayList<>();
	Random random = new Random();

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet() 
	{

        String[] sonnet = new String[14];

        for (int line = 0; line < 14; line++) 
		{

            StringBuilder sb = new StringBuilder();
            int wordCount = 0;
            int maxWordsInLine = random.nextInt(5) + 4; // Random number between 4 and 8
            Word currentWord = words.get(random.nextInt(words.size()));

            while (wordCount < maxWordsInLine) 
			{

                sb.append(currentWord.getWord()).append(' ');

                ArrayList<Follow> follows = currentWord.getFollows();
                if (follows.isEmpty()) 
				{

                    break;

                }

                currentWord = findWord(follows.get(random.nextInt(follows.size())).getWord());
                if (currentWord == null) 
				{

                    currentWord = words.get(random.nextInt(words.size()));

                }

                wordCount++;

            }

            sonnet[line] = sb.toString().trim();

        }

        return sonnet;

    }

	public void setup() {
		colorMode(HSB);

        loadFile("small.txt");

		printModel();

	}

	public void loadFile(String filename) 
	{

        String[] lines = loadStrings(filename);
        
        for (String line : lines) 
		{

            String[] tokens = split(line, ' ');

            for (int i = 0; i < tokens.length - 1; i++) 
			{

                String currentWord = tokens[i].replaceAll("[^\\w\\s]", "").toLowerCase();
                String nextWord = tokens[i + 1].replaceAll("[^\\w\\s]", "").toLowerCase();
                
                Word word = findWord(currentWord);
                if (word == null) 
				{

                    word = new Word(currentWord);
                    words.add(word);

                }
                
                Follow follow = word.findFollow(nextWord);
                if (follow == null) 
				{

                    follow = new Follow(nextWord, 1);
                    word.getFollows().add(follow);

                } 
				
				else 
				{

                    follow.setCount(follow.getCount() + 1);

                }
            }
        }
    }

	public void printModel() 
	{

        for (Word word : words) 
		{

            System.out.println("Word: " + word.getWord());
            ArrayList<Follow> follows = word.getFollows();

            for (Follow follow : follows) 
			{

                System.out.println("  Follow: " + follow.getWord() + ", Count: " + follow.getCount());

            }

            System.out.println();

        }
    }
    

    public Word findWord(String str) 
	{
        for (Word word : words)
		{

            if (word.getWord().equals(str)) 
			{

                return word;

            }

        }

        return null;

    }


	public void keyPressed() {

	}

	float off = 0;


	public void draw() 
    {

		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);

		if (frameCount == 1) 
		{

            sonnet = writeSonnet();

        }

        for (int i = 0; i < sonnet.length; i++) 
		{

            text(sonnet[i], width / 2, height / 14 * (i + 1));
			
        }
        
	}
}
