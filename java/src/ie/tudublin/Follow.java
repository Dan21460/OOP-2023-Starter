/* Make a class called Word that has fields for the word (a String) and a
n ArrayList of type Follow as fields. Make accessor methods, a constructor 
and a toString Method that will iterate through the follows ArrayList. 
(See the printout of the model above). */

// making Follow Class according to the specification
package ie.tudublin;

public class Follow 
{
    
    private String word;
    private int count;

    public Follow() 
    {

        this.word = "";
        this.count = 0;
        
    }

    public Follow(String word, int count) 
    {

        this.word = word;
        this.count = count;

    }

    public String getWord() 
    {

        return this.word;

    }

    public int getCount() 
    {

        return this.count;

    }


    public void setWord(String word) 
    {

        this.word = word;

    }

    public void setCount(int count) 
    {

        this.count = count;

    }

    // Override

    @Override
    public String toString() 
    {

        return "Follow{" + "word='" + word + '\'' + ", count=" + count + '}';

    }
}

