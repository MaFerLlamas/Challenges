//Maria Fernanda Avila Llamas

import java.util.Scanner;
import java.util.Vector;

public class Loteria 
{
	//check if is numbers
	public static boolean isNumeric(String chain) 
	{
		try
		{
			Integer.parseInt(chain);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) 
	{
		// to deploy the result at the End
		Vector<String> result= new Vector();
		
		//Define Variables for the info line
		Scanner scan = new Scanner(System.in);
		String infoLine;
		String betLine;
		
		boolean isOver=false;
		boolean isInfoError=false;
		
		//the info Line contains:
		// N number of cases 
		// C quantity of numbers in every case
		// K Range of the numbers
		int iNumCases=0;   //N
		int iCantNumbers=0;//C
		int iRange=0;      //K
		
		//the program finish when 0 0 0 
		while(!isOver) 
		{
			//ENTRY PART////////////////////////////////////
			//check out how many numbers we have to initialize
			do
			{
				System.out.println("Entry:");
				isInfoError=false;
				// Ask for the structure information N C K
				infoLine = scan.nextLine();
				String[] infoArray = infoLine.split(" ", 3);
				
				//Anlyze Description line N C K
				if (infoArray.length!=3)
				{
					System.out.println("wrong info line has to be 3 elements");
					isInfoError=true;
				}
				else
				{
					//verify that the entry is a number
					if (isNumeric(infoArray[0]) && 
						isNumeric(infoArray[1]) && 
						isNumeric(infoArray[2])  )
					{
						iNumCases=Integer.parseInt(infoArray[0]);   //N
						iCantNumbers=Integer.parseInt(infoArray[1]);//C
						iRange=Integer.parseInt(infoArray[2]);      //K						
					}
					else
					{
						System.out.println("only numbers please");
						isInfoError=true;
						break;
					}
					//line info with 0 0 0 finish the program
					if (iNumCases==0 && iCantNumbers==0 && iRange==0)
					{
						isOver=true;
						break;
					}
					//the N bets has to be (1 <= N <= 10000)
					if (iNumCases< 1 || iNumCases>10000) 
					{
						System.out.println("first parameter out of the range");
						isInfoError=true;
					}
					//the C numbers has to be (1 <= C <= 10)
					if (iCantNumbers<1 || iCantNumbers>10) 
					{
						System.out.println(" second parameter out of the range");
						isInfoError=true;
					}
					//the K range has to be (C < K <= 100)
					if (iRange<=iCantNumbers || iRange>100) 
					{
						System.out.println("third parameter out of the range");
						isInfoError=true;
					}
					// all the parameters are right
					if (!isInfoError)
					{
						System.out.print("okay : "+iNumCases+" ");
						System.out.print(iCantNumbers+" ");
						System.out.println(iRange);
					}
				}
			//it repeat until there is not error
			}while(isInfoError);
			
			//Declare variables for check the bets
			//allArray save all the numbers for every bets
			int[][] allArray = new int[iNumCases][iCantNumbers];
			int n=0;//number of bets
			int auxNumber=0;//scroll in to every number in the bet.
			boolean isNumError=false;
			
			//Ask for all the bet cases (N)
			for(n=0;n<iNumCases;n++)
			{
				//scroll every number c in the bet
				do
				{ 
					int[] auxBets = new int[iCantNumbers];
					isNumError=false;
					auxNumber=0;
					
					System.out.print((n+1)+" :");
					betLine = scan.nextLine();
					String[] betsArray = betLine.split(" ");
					
					//if every entry is wrong 
					if (betsArray.length!=iCantNumbers)
					{
						System.out.println("wrong quantity of numbers");
						isNumError = true;
					}
					else
					{
						// scroll in to the array / past to int
						for (int c=0;c<betsArray.length;c++) 
						{
							//check that the entry is a number
							if (isNumeric(betsArray[c]))
							{
								auxNumber=Integer.parseInt(betsArray[c]);
								//check that they are in the range
								if (auxNumber>0 && auxNumber<=iRange)
								{
									//check that they are differents
									for (int i=0;i<c;i++)
									{
										// actual vs. afters
										if (auxNumber == auxBets[i])
										{
											isNumError = true;
											System.out.println("wrong a number is repeat");
											//to finish the while how scroll in to the  betsArray
											c=betsArray.length;
											break;
										}
									}
								}
								else
								{
									isNumError = true;
									System.out.println("wrong out of the Range");
									break;
								}
							}
							else
							{
								System.out.println("only numbers please");
								isNumError=true;
							}
							
							//if there is an error we don't save it
							if (!isNumError) {
								auxBets[c] = auxNumber;
							}
						}
					}//end condition quantity num
					//only f we not get an error
					if (!isNumError) {
						allArray[n]=auxBets;
					}
				}
				while(isNumError);//end while isNumError
				System.out.println(" okay");
				
			}//end of analyzing the bets numbers
			
			//PROCESSING PART////////////////////////////////////
			//declaring variables for counting the numbers
			//a counter for every number 
			int[] counterArray = new int[iRange];
			int iMin=iRange;
			
			//count the repeat numbers in all the bets
			for (int n1=0;n1<iNumCases;n1++)
			{
				for (int c=0;c<iCantNumbers;c++)
				{
					//every index represent a number and contains it quantity
					//0->1
					//99->100
					counterArray[(allArray[n1][c])-1]++;
				}
			}
			
			
			//get the minimum number
			for (int i=0;i<counterArray.length;i++)
			{
				if (counterArray[i]<iMin) {
					iMin=counterArray[i];
				}
			}
			
			//RESULT PART////////////////////////////////////
			String auxResult="";
			for (int i=0;i<counterArray.length;i++)
			{
				//if there s more then one we concatenate
				if (counterArray[i]==iMin) 
				{
					//plus 1 because 0 represents number 1
					//and so on
					auxResult+=(i+1);
					auxResult+=" ";
				}
			}
			//one String element per case
			result.add(auxResult);

		}
		
		System.out.println("the results: ");
		//we show the result at the end of the program
		for (int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}
		System.out.println("bye");
		//close scanner
		scan.close();
	}

}
