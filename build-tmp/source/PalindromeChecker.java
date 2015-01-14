import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}


public boolean palindrome(String word)
{
  word=word.toLowerCase();
  String temp= new String();
  for(int i=0; i<word.length(); i++)
  {
     if(Character.isLetter(word.charAt(i))==true)
     {
        temp=temp+word.charAt(i);
     }
  }
 word=temp;

  if (word.length()%2==0) //for words with EVEN length
  {
    for(int i=0; i<=(word.length()-1)/2; i++)
    {
      if(word.charAt(i)!=word.charAt(word.length()-1-i)) //return false if chosen letters do not equal each other
      {
        return false;
      }
    }
  }
  else if (word.length()%2==1) //for words with ODD length
  {
    for(int i=0; i<=(word.length()-1)/2; i++)
    {
      if(word.charAt(i)!=word.charAt(word.length()-1-i) && word.charAt(((word.length())/2)+1)==word.charAt(((word.length())/2)+1))
      {
        return false;
      }
    }
  }


  return true;
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
