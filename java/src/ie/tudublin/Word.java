/*
 Make a class called Word that has fields for the word (a String) an
 d an ArrayList of type Follow as fields. Make accessor methods, a constructor and 
 a toString Method that will iterate through the follows ArrayList. 
 (See the printout of the model above).
 */


package ie.tudublin;

import java.util.ArrayList;

public class Word 
{

    private String word;
    private ArrayList<Follow> follow;

    public Word() 
    {

        this.word = "";
        this.follow = new ArrayList<>();

    }

    public Word(String word)
    {

        this.word = word;
        this.follow = new ArrayList<>();

    }
    

    public ArrayList<Follow> getFollows()
    {

        return this.follow;

    }

    public String getWord()
    {

        return this.word;

    }

    public void setFollows(ArrayList<Follow> follow)
    {

        this.follow = follow;

    }

    public void setWord(String word)
    {

        this.word = word;
        
    }
    
    // Had to make find follow because realised i needed it
    public Follow findFollow(String str) 
    {

        for (Follow follow : follow) 
        {

            if (follow.getWord().equals(str)) 
            {

                return follow;

            }
        }

        return null;

    }


    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("Word{");
        sb.append("word ='").append(word).append('\'');
        sb.append(", follow=[");

        for(int i = 0; i < follow.size(); i++)
        {

            sb.append(follow.get(i).toString());

            if(i < follow.size() - 1)
            {

                sb.append(",  ");

            }

        }

        sb.append("]}");

        return sb.toString();

    }

}
