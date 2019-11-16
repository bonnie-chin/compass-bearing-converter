import java.util.Scanner;
import java.util.InputMismatchException;
public class Compass {

	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);
	    boolean play = true;
	    while (play == true) {
	      System.out.println("\n(1)convert bearing to compass");
	      System.out.println("(2)convert compass to bearing");
	      System.out.print("Choose: ");
	      
	      try {
	        int program = user_input.nextInt();
	        if (program == 1) {
	        boolean bearingValid = false;
	        int bearing = 0;
	        String compass = "";
	        while (bearingValid == false) {
	          Scanner userInput = new Scanner(System.in);
	          System.out.print("Bearing: ");
	          
	            try {
	              bearing = userInput.nextInt();
	              if ((bearing <= 360) && (bearing >= 0)) {
	                bearingValid = true;
	                if (bearing < 90) {
	                  if (bearing < 45) {
	                    if (bearing == 0) {
	                      compass = "N"; 
	                    }
	                    else {
	                      compass = "N" + bearing + "E";
	                    }
	                  }
	                else {
	                  if (bearing == 45) {
	                    compass = "NE";
	                  }
	                  else {
	                    compass ="E" + (90-bearing) + "N";
	                  }
	                }
	              }
	                else if (bearing < 180) {
	                if (bearing < 135) {
	                  if (bearing == 90) {
	                    compass = "E";
	                  }
	                  else {
	                     compass = "E" + (bearing-90) + "S";
	                  }
	                }
	                else {
	                  if (bearing == 135) {
	                    compass = "SE";
	                  }
	                  else {
	                    compass ="E" + (180-bearing) + "N";
	                  }
	                }
	              }
	                else if (bearing < 270) {
	                if (bearing < 225) {
	                  if (bearing == 180) {
	                    compass = "S";
	                  }
	                  else {
	                     compass = "S" + (bearing-180) + "E";
	                  }
	                }
	                else {
	                  if (bearing == 225) {
	                    compass = "SW";
	                  }
	                  else {
	                    compass ="W" + (270-bearing) + "S";
	                  }
	                }
	              }
	                else {
	                if (bearing < 315) {
	                  if (bearing == 270) {
	                    compass = "W";
	                  }
	                  else {
	                     compass = "W" + (bearing-270) + "N";
	                  }
	                }
	                else {
	                  if (bearing == 315) {
	                    compass = "NW";
	                  }
	                  else if (bearing == 360) {
	                    compass = "N";
	                  }
	                  else {
	                    compass ="N" + (360-bearing) + "W";
	                  }
	                }
	              }
	              }
	              else {
	                System.out.println("Invalid input, please try again.");
	              }
	            }
	            catch (InputMismatchException exception){
	                System.out.println("Invalid input, please try again.");
	            }
	          
	            
	          
	          
	        }
	        System.out.println("Bearing " + bearing + " is a compass direction of " + compass);
	          
	        }
	        else if (program == 2) {
	          char d1 = '\0';
	          char d2 = '\0';
	          int degree = 0;
	          int bearing = 0;
	          
	          String compass = " ";
	          
	          boolean inputValid = false;
	          while (inputValid == false) {
	            boolean directionValid = true;
	            boolean degreeValid = true;
	            Scanner userInput = new Scanner(System.in);
	            System.out.print("Compass direction: ");
	            compass = userInput.nextLine();
	            d1 = compass.charAt(0);
	            d2 = compass.charAt((compass.length()-1));
	            if (compass.length() >=3) {
	              try {
	                degree = Integer.parseInt(compass.substring(1, (compass.length()-1)));
	                if ((degree >= 0)&& (degree <= 45)) {
	                  if (d1 == 'N') {
	                    if (d2 == 'E') {
	                      bearing = 0 + degree;
	                    }
	                    else if (d2 == 'W') {
	                      bearing = 360 - degree;
	                    }
	                    else {
	                      directionValid = false;
	                    }
	                  }
	                  else if (d1 == 'S') {
	                    if (d2 == 'E') {
	                      bearing = 180-degree;
	                    }
	                    else if (d2 == 'W') {
	                      bearing = 180 + degree;
	                    }
	                    else {
	                      directionValid = false;
	                    }
	                  }
	                  else if (d1 == 'E') {
	                    if (d2 == 'N') {
	                      bearing = 90 - degree;
	                    }
	                    else if (d2 == 'S') {
	                      bearing = 90 + degree;
	                    }
	                    else {
	                      directionValid = false;
	                    }
	                  }
	                  else if (d1 == 'W') {
	                    if  (d2 == 'N') {
	                      bearing = 270 - degree;
	                    }
	                    else if (d2 == 'S') {
	                      bearing = 270 + degree;
	                    }
	                    else {
	                      directionValid = false;
	                    }
	                  }
	                  else {
	                    directionValid = false;
	                  }
	                }
	                else {
	                  degreeValid = false;
	                }
	              }
	              catch (NumberFormatException exception) {
	                degreeValid = false;
	              }
	              
	            }
	            else if (compass.length() == 2) {
	              if ((d1 == 'N')&&(d2 == 'E')) {
	                  bearing = 45;
	              }
	              else if ((d1 == 'N')&&(d2 == 'W')){
	                bearing = 315;
	              }
	              else if ((d1 == 'S')&&(d2 == 'E')) {
	                bearing = 135;
	              }
	              else if ((d1 == 'S')&&(d2 == 'W')) {
	                bearing = 225;
	              }
	              else {
	                directionValid = false;
	              }
	            }
	            else if (compass.length() == 1) {
	              if (d1 == 'N') {
	                  bearing = 0;
	              }
	              else if (d1 == 'S') {
	                bearing = 180;
	              }
	              else if (d1 == 'E') {
	                bearing = 90;
	              }
	              else if (d1 == 'W'){
	                bearing = 270;
	              }
	              else {
	                directionValid = false;
	              }
	            }
	            
	            
	            
	            if ((directionValid && degreeValid) != true) {
	              System.out.println("Invalid input, please try again.");
	            }
	            else {
	              inputValid = true;
	            }
	          }
	        
	        
	          
	        
	          System.out.println("Compass " + compass + " is a bearing of " + bearing + "\n");
	      
	      }
	        else {
	        System.out.println("Invalid input, please try again.");
	      }
	        boolean replayValid = false;
	      
	        while (replayValid == false) {
	        System.out.print("Do another conversion? y/n:");
	        Scanner replay = new Scanner(System.in);
	        char rerun = replay.nextLine().charAt(0);
	        if (rerun == 'n') {
	          play = false;
	          replayValid = true;
	        }
	        else if (rerun != 'y') {
	          System.out.println("Invalid input, please try again.");
	        }
	        else {
	          replayValid = true;
	        }
	      }
	      }
	      catch (InputMismatchException exception){
	        System.out.println("Invalid input, please try again.");        
	      }
	      }
	      
	      
	      
	      System.out.print("Goodbye.");

	}

}
