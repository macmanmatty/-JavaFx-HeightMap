package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;


public class NumberWindow {
Stage stage;
Button setNumbers;
RandomNumbers value= new RandomNumbers();

Button showMap;
TextField sizeX;
TextField sizeY;
TextField smooth;
TextField maxNum;
TextField minNum;
Button newLine;
ArrayList<TextField> lines = new ArrayList<TextField>();
ArrayList<TextField> lineNumbers = new ArrayList<TextField>();
ArrayList<TextField> lineWidth = new ArrayList<TextField>();


ArrayList<CheckBox> lineOrientations= new ArrayList<CheckBox>();

VBox window = new VBox();

CheckBox trimNumbers;


VBox header = new VBox();
HBox header1= new HBox();
HBox header2= new HBox();

int xSize;
int ySize;
int smoothness;
int maxNumber;
int minNumber;
int rivers;
int riverNumber;


int mountians;
int mountianNumber;
Button [][] buttons;
int [] []  bitValues= new int [3][3];
int[] eightBitMaskValues= new int [16];

int[] [] bitMap;









	
	NumberWindow(Stage stage){
		
		this.stage=stage;
		sizeY=new TextField();
		sizeX=new TextField();
		smooth=new TextField();
		maxNum=new TextField();
		minNum=new TextField();
		
sizeX.setMaxWidth(80);
smooth.setMaxWidth(80);
maxNum.setMaxWidth(80);
minNum.setMaxWidth(80);
bitValues[0][0]=1;
bitValues[1][0]=2;
bitValues[2][0]=4;
bitValues[0][1]=8;
bitValues[2][1]=16;
bitValues[0][2]=32;
bitValues[1][2]=64;
bitValues[2][2]=128;

eightBitMaskValues[0]=0;
eightBitMaskValues[1]=11;
eightBitMaskValues[2]=22;
eightBitMaskValues[3]=31;
eightBitMaskValues[4]=104;
eightBitMaskValues[5]=107;
eightBitMaskValues[6]=126;
eightBitMaskValues[7]=127;
eightBitMaskValues[8]=208;
eightBitMaskValues[9]=214;
eightBitMaskValues[10]=219;
eightBitMaskValues[11]=223;
eightBitMaskValues[12]=248;
eightBitMaskValues[13]=251;
eightBitMaskValues[14]=254;
eightBitMaskValues[15]=255;




		showMap= new Button("Show Map");
		setNumbers= new Button("set Numbers");
		trimNumbers= new CheckBox("Trim off single numbers?");
		


			
showMap.setOnAction(new EventHandler<ActionEvent >() {
	@Override
	public void handle(ActionEvent event) {
		xSize=Integer.parseInt(sizeX.getText());
		ySize=Integer.parseInt(sizeY.getText());
		smoothness=Integer.parseInt(smooth.getText());
		maxNumber=Integer.parseInt(maxNum.getText());
	
		
		
	showMap();
	
	
		
		
	}
});
			
newLine= new Button("Add Line");
		
newLine.setOnAction(new EventHandler<ActionEvent >() {
	@Override
	public void handle(ActionEvent event) {
		newLine();
		
	
		
		
	}		});

				
		
		
			
			
		
		
	}
	
	public void showWindow(){
		
		

		Label sizex= new Label("X Grid Size");
		Label sizey= new Label("Y Grid Size");
		Label smoothl= new Label("Smoothness");
		Label minNuml= new Label("Min Number");
		Label maxNuml= new Label("Max Number");
		Label numberOfMountians= new Label ("Number Of Mountians");
		Label numberOfRivers= new Label ("Number Of Rivers");
		Label mountianHeight= new Label ("Mountian Height Number");
		Label riverHeight= new Label ("River Height Number");

		header1.getChildren().add(sizex);
		header1.getChildren().add(sizeX);

		header1.getChildren().add(sizey);
		header1.getChildren().add(sizeY);
		header1.getChildren().add(smoothl);
		header1.getChildren().add(smooth);
		header1.getChildren().add(minNuml);
		header1.getChildren().add(minNum);
		header1.getChildren().add(maxNuml);
		header1.getChildren().add(maxNum);
		header1.getChildren().add(trimNumbers);
		
		
		

		header1.setSpacing(20);
		header2.setSpacing(20);
		header.setSpacing(20);

		header1.getChildren().add(showMap);
		header1.getChildren().add(newLine);
		header.getChildren().add(header1);
		header.getChildren().add(header2);

		window.getChildren().add(header);
		stage.setScene(new Scene(window));
		stage.show();
		
		
		
	}
	
	public int eightSideBitMapCalculator( int terrianNumber, int locationX, int locationY,  int [] [] map ){ // does the same as pervious function but for all eight sides and with a tile boolean flag rather than an Item


	    boolean [] [] bitMap = new boolean [3] [3];


	    for (int countx = -1; countx < 2; countx++) {
	        for (int county = -1; county < 2; county++) {


	            int x=countx+locationX;
	            int y=county+locationY;

	            if(x<0){
	                bitMap[countx+1][county+1]=true;
	                continue;


	            }
	            if (x>map.length-1){
	                bitMap[countx+1][county+1]=true;

	                continue;
	            }

	            if(y<0){
	                bitMap[countx+1][county+1]=true;
	                continue;


	            }
	            if (y>map[0].length-1){
	                bitMap[countx+1][county+1]=true;

	                continue;
	            }

	           
	            int terrianNumber2= map[x][y];
	            
	            if (terrianNumber <=terrianNumber2) {
	                bitMap[countx+1][county+1]=true;

	            }
	            
	            System.out.print(bitMap[countx+1][county+1]+" ");
	            
	        }

	        
	        System.out.println();
	        
	    }
	    
	    

	return eightBitConverter(bitMap);

	    }

	
	
	



	 private   int eightBitConverter(boolean [][]  map ){ // converts  WoodWand array of boolean s for adjecent tiles on whether or not  they match the center tile  and then  retuns the value

	        int bitMapValue = 0;                    // then returns the value




	        for (int countx = 0; countx < 3; countx++) {
	            for (int county = 0; county < 3; county++) {
	                if ( (countx==1 && county==1)) {
	                    continue;

	                }



	                if (map[countx][county]==true) {
	                    if (county==0 && countx==0 && map[0][1]==true && map[1][0]==true) {
	                        bitMapValue = bitMapValue + this.bitValues[countx][county];

	                        continue;
	                    }
	                    else if(county==0 && countx==0 ) {
	                        continue;


	                    }
	                    else if (county==0 && countx==2 && map[2][1]==true && map[1][0]==true) {
	                        bitMapValue = bitMapValue + this.bitValues[countx][county];

	                        continue;
	                    }
	                    else if(county==0 && countx==2 ) {
	                        continue;


	                    }
	                    else if (county==2 && countx==0 && map[0][1]==true && map[1][2]==true) {
	                        bitMapValue = bitMapValue + this.bitValues[countx][county];


	                        continue;
	                    }
	                    else if(county==2 && countx==0 ) {
	                        continue;


	                    }
	                    else if (county==2 && countx==2 && map[2][1]==true && map[1][2]==true) {
	                        bitMapValue = bitMapValue + this.bitValues[countx][county];

	                        continue;
	                    }
	                    else if(county==2 && countx==2 ) {
	                        continue;


	                    }
	                        bitMapValue = bitMapValue + this.bitValues[countx][county];




	                }





	            }


	        }
	        return bitMapValue;


	    }
	public void  newLine() {
		HBox lineBox= new HBox();
		int size=lines.size();
		TextField field=new TextField();
		TextField field2=new TextField();
		TextField field3= new TextField();
		

		CheckBox box= new CheckBox();
		box.setText("Horozontal Line?");
		lineOrientations.add(box);
		
		lines.add(field);
		lineNumbers.add(field2);
		lineWidth.add(field3);
		
		
		
		
		
		Label label= new Label("enter start point # for Line  #"+size);
		
		Label label2= new Label("enter line Square #"+size);

		
		Label label3=  new Label("Enter The Line Width");
		
		
		lineBox.getChildren().add(label2);
		lineBox.getChildren().add(field2);
		lineBox.getChildren().add(label);
		lineBox.getChildren().add(field);
		lineBox.getChildren().add(label3);
		lineBox.getChildren().add(field3);
		lineBox.getChildren().add(box);
		
		lineBox.setSpacing(15);
		header2.getChildren().add(lineBox);
		
	
		
		
		
		
		
		
		
		
	}
			
	

    public static String colorToHex(Color color) {
        return colorChanelToHex(color.getRed())
                + colorChanelToHex(color.getGreen())
                + colorChanelToHex(color.getBlue())
                + colorChanelToHex(color.getOpacity());
    }

    private static String colorChanelToHex(double chanelValue) {
        String rtn = Integer.toHexString((int) Math.min(Math.round(chanelValue * 255), 255));
        if (rtn.length() == 1) {
            rtn = "0" + rtn;
        }
        return rtn;
    }
	public void showMap(){
	
		
		window.getChildren().removeAll(window.getChildren());
		header.getChildren().removeAll(header.getChildren());
		


		
		


	
		header.getChildren().add(header1);
		header.getChildren().add(header2);

		window.getChildren().add(header);
		
		
		int [] [] map = makeMap(maxNumber, minNumber, smoothness, xSize, ySize);
		ArrayList<Integer> numbers=findNumbers(map);
		ArrayList<Color> colors= new ArrayList<Color>();
		
		int size=numbers.size();
		System.out.println(numbers.size());
		
		for (int count=0; count<size; count++) {
			
			colors.add(makeColor());
			
		}
		
	    

		
		
		
		GridPane pane = new GridPane();
		if(trimNumbers.isSelected()) {
		boolean trimmed=true;
		while(trimmed==true) {

			
			boolean trimmedSomthing=false;
			
			for (int countx=0; countx<xSize;  countx++){
				for (int county=0; county<ySize; county++){
					
					int size2=numbers.size();
					for(int count=0; count<size2; count++) {
						if(map[countx][county]==numbers.get(count)) {
							
							int bit =eightSideBitMapCalculator(numbers.get(count), countx, county, map);
							 boolean trimmedIt=trim(bit);
							 if(trimmedIt==true) {
								 
								 map[countx][county]--;
								 if(trimmedSomthing==false) {
									 
									 trimmedSomthing=trimmedIt;
									 
								 }
								
								 continue;
								 
								 
							 }
							 
							
							bitMap[countx][county]=bit;
							
							
							
						
					

					
					
				}
				
			
			
			}
			
		
		
		}
		
			}
			
			trimmed=trimmedSomthing;
			
		}
		
				
		}
		else {
			

			for (int countx=0; countx<xSize;  countx++){
				for (int county=0; county<ySize; county++){
					
					
					

			int bit =eightSideBitMapCalculator(map[countx][county], countx, county, map);
			
					
					
			bitMap[countx][county]=bit;
				}
			}
			
			
			
		}
				
		
		
		
		
		
		
		for (int countx=0; countx<xSize;  countx++){
					for (int county=0; county<ySize; county++){
						Button button= new Button();
						button.setMaxSize(48, 48);
						button.setPrefSize(48, 48);
						button.setMinSize(48, 48);
						int size2=numbers.size();
						for(int count=0; count<size2; count++) {
							if(map[countx][county]==numbers.get(count)) {
								
								
								
							
						

						
						
					
					

				button.setText(String.valueOf(bitMap[countx][county])+"\n"+String.valueOf(map[countx][county]));
				Color color=colors.get(count);
				String c = String.format("#%02x%02x%02x",
					    (int) (255 * color.getRed()),
					    (int) (255 * color.getGreen()),
					    (int) (255 * color.getBlue()));	
				button.wrapTextProperty().setValue(true);
				button.setStyle("-fx-background-color: "+c+";");
				
				buttons[countx][county]=button;
				pane.add(button, countx, county);
				
							}
							
				
			}
			
				}
		

		
				}
				
		
			
			window.getChildren().add(pane);
			
			
			
			
			
			
			
		
		 VBox area= new VBox();
		 area.setSpacing(20);
		 area.setPadding(new Insets(20,20,0,0));
		 	int [] [] areas=  new int [size] [2];
		 	
		 	

			for (int count=0; count<size; count++) {
				areas[count][0]=findTilesSquare(numbers.get(count), map);
				areas[count][1]=numbers.get(count);
				

				
			}
			
			for (int count=0; count<size; count++) {
				Label label= new Label("Number "+areas[count][1]+ "  Area " + areas[count][0]);
				
				area.getChildren().add(label);
				

				
			}
			
			int number2=0;

			for (int countx=0; countx<xSize;  countx++) {
				for (int county = 0; county < ySize; county++) {

					
					 number2=number2+map[countx][county];
					
					
					}
				
				
				
				
				}
			int average=number2/(xSize*ySize);
			area.getChildren().add(new Label("average number "+average));
			
		 
		window.getChildren().add(area);
		
		stage.setScene(new Scene(new ScrollPane(window)));
		stage.show();
		
		
		
		
		
		
		
		
	}
	
	public boolean trim(int number) {
		for (int count=0; count<16; count++) {
			
			if(number==eightBitMaskValues[count]) {
				
				return false;
				
			}
			
			
		}
		
		return true;
		
		
	}
	
	
	private Color makeColor() {
		
		
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();

		Color randomColor = new Color (r, g, b,1);
		return randomColor;
		
		
	}
			
			
		private ArrayList<Integer> findNumbers( int [] [] map){
			
			ArrayList<Integer> numbers= new ArrayList<Integer>();
			
		numbers.add(map[0][0]);
			for (int countx=0; countx<xSize;  countx++){
				for (int county=0; county<ySize; county++){
					int size=numbers.size();
					boolean in=false;
					
					for (int count=0; count<size; count++) {
						if (numbers.get(count).equals(map[countx][county])) {
							in=true;
							break;
							
							
						}
						
					}
				if (in==false) {
					
					numbers.add(map[countx][county]);
					
				}

		}

			}
			
			
			return numbers;
			
		}
	

	public   int [] []  makeMap( int maxNumber, int minNumber, int smoothness, int xSize, int ySize){ // makes 2d array of ints that resembles a rain map
		int [] [] map= new int [xSize][ySize];
		bitMap= new int [xSize][ySize];
		
		buttons= new Button [xSize][ySize];
		
		
		int x;
		int y;
		int a;
		int b;









		for (int countx=0; countx<xSize;  countx++){
			for (int county=0; county<ySize; county++){
				map[countx][county]=value.randoms(minNumber, maxNumber);
				
				
					
					
				
					
					
				
				}
				}
				
		int size4=lines.size();
		
		for (int count=0; count<size4; count++) {
			Integer integer=null;
			Integer integer2=null;
			
			Integer width=null;
			

			
			
			String string=lines.get(count).getText();
			String string2=lineNumbers.get(count).getText();
			String string3=lineWidth.get(count).getText();

			if(string.matches("-?\\d+(\\.\\d+)?")) {
				integer=Integer.valueOf(string);
				integer2=Integer.valueOf(string2);
				width=Integer.valueOf(string3);
				

				
			}
			else {
				continue;
				
			}
			if(integer!=null) {
				if(lineOrientations.get(count).isSelected()) {
					if(integer>ySize-1 || integer<0) {
						continue;
						
					}
					
					
					if(width+integer>ySize) {
						width=ySize-integer;
						
					}
					else {
						width=width+integer;
						
					}
					
					
				for(int countx=0; countx<xSize; countx++) {
					for(int county=integer; county<width; countx++) {
	
					map[countx][county]=integer2;
					
				}
				}
				}
				else {
					if(integer>xSize-1 || integer<0) {
						continue;
						
					}
					
				
					
					if(width+integer>xSize) {
						width=xSize-integer;
						
					}
					else {
						width=width+integer;
						
					}
					for(int countx=integer; countx<width; countx++) {

					for(int county=0; county<ySize; county++) {
						map[countx][county]=integer2;

						
					}
					}
					
				}
				
				
			}
			
			
			
			
		}
				
					
				
					

			
		

		

			
		






		for(int smooth=0; smooth<smoothness; smooth++){
			for (int countx=0; countx<xSize;  countx++){
				for (int county=0; county<ySize; county++){
					x=countx-1;
					y=county-1;
					a=countx+1;
					b=county+1;
					if (x<0){
						x=0;
					}
					if (y<0){
						y=0;
					}
					if (a>=xSize){
						a=xSize-1;
					}
					if (b>=ySize){
						b=ySize-1;
					}

					map[countx][county]=((map[a][county]+map[x][county]+map[a][b]+map[a][y]+map[countx][b]+map[countx][y]+map[x][y]+map[x][b])/8);

				}
			}
		}




		return map;

	}
     private int  findTilesSquare(int number,  int [][] map){
            int xSize=map.length;
            int ySize=map[0].length;
           int [] []  counterMap= new int [xSize+1][ySize+1];
          
            int largestNumber=0;
          
       

            for (int countx = 1; countx < xSize; countx++) {
                for (int county =1; county <ySize; county++) {
                	
                	
                	if (map[countx][county]== number) {
                		int smallest = Math.min(counterMap[countx-1][county], Math.min(counterMap[countx-1][county-1], counterMap[countx][county-1]));
                		
                		
                		counterMap[countx][county]=1+smallest;
                		if (counterMap[countx][county]>largestNumber) {
                			largestNumber=counterMap[countx][county];
                		
                			
                			
                		}




                 }
                	
                	
                }
            }
         
          
            
	           
            return largestNumber;
            
                }
   


        }






	

