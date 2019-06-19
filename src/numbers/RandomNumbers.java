package numbers;
import java.util.Random;

	

public class RandomNumbers {
	public RandomNumbers (){}
	 public  int randoms(  int minnumber,  int  maxnumber) { // makes a random number between two values
		Random random= new Random();
		if (maxnumber-minnumber==0)
		{
			maxnumber++;
		}
		 int randomnumber=random.nextInt(maxnumber - minnumber) + minnumber;
	    return randomnumber;
	}
		}



