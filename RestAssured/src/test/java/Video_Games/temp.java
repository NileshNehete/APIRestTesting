package Video_Games;

import java.util.Random;

import org.testng.annotations.Test;

public class temp {
	
	@Test
	public void test(){
		
		Random dice = new Random();
		int id = dice.nextInt(100)+10;
		
		System.out.println(id);
	}
	

}
