package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KaraBang_Project4 extends Application {
	
	/*
	Implement a JavaFX class which accesses a dice random value generator
	Implement a Button to roll the dice
	Print the returned die value on a Label or Text on the screen
	*/

	String dieAll;
	int sum1;
	String sumStr;
	int pairBonus;
	int tripBonus;
	int strBonus;
	int points1;
	
	String rerollAll;
	int rerollSum;
	String sumStr2;
	int pairBonus2;
	int tripBonus2;
	int strBonus2;
	int points2;
	int [] firstRoll = new int [3];
	
	@Override
	public void start(Stage primaryStage) {
		
		System.out.println();
	
		
		Label title = new Label("Let's Lock N' Roll!");
		Font fontTitle = Font.font("Times New Roman", FontWeight.BOLD, 30);
		title.setTextFill(Color.BLUE);
		title.setFont(fontTitle);
		
		Label Name = new Label("Name:");
		Font fontName = Font.font("Times New Roman", FontWeight.BOLD, 20);
		Name.setFont(fontName);
		
		TextField textField = new TextField ();
		
		Button roll = new Button("Click for Roll 1");
		Font labelText = Font.font("Times New Roman", FontWeight.BOLD, 15);
		roll.setFont(labelText);
		roll.setTextFill(Color.BLUE);
		
		Button rerollButton = new Button("Click for Roll 2");
		rerollButton.setFont(labelText);
		rerollButton.setTextFill(Color.BLUE);
		
		Button playAgain = new Button("Click to Play Again");
		playAgain.setFont(labelText);
		playAgain.setTextFill(Color.LIGHTBLUE);
		playAgain.setStyle("-fx-background-color: blue");
		
		Label Roll1 = new Label("Roll 1:");
		Font fontRoll1 = Font.font("Times New Roman", FontWeight.BOLD, 20);
		Roll1.setFont(fontRoll1);
		
		Text die = new Text();
		Text reroll = new Text();
		
		Label dieText = new Label("Die 1" + "    " + "Die 2" + "    " + "Die 3");
		dieText.setFont(labelText);
		
		Label rerollText = new Label("Die 1" + "    " + "Die 2" + "    " + "Die 3");
		rerollText.setFont(labelText);
		
		Label label = new Label("Sum" + "   " + "Pair" + "   " + "Triple" 
				+ "   " + "Straight" + "   " + "Total");
				label.setFont(labelText);
		
		Text rollInfo1 = new Text();
		Text rollInfo2 = new Text();
		
		Label label2 = new Label("Sum" + "   " + "Pair" + "   " + "Triple" 
				+ "   " + "Straight" + "   " + "Total");
				label2.setFont(labelText);
		
		Label Lock = new Label("Lock:");
		Font fontLock = Font.font("Times New Roman", FontWeight.BOLD, 20);
		Lock.setFont(fontLock);
		Lock.setTextFill(Color.RED);
		
		ToggleGroup lockRoll1 = new ToggleGroup();
		RadioButton lock1 = new RadioButton();
		lock1.setStyle("-fx-base: red");
		RadioButton roll1 = new RadioButton();
		roll1.setStyle("-fx-base: green");
		lock1.setToggleGroup(lockRoll1);
		roll1.setToggleGroup(lockRoll1);
		
		ToggleGroup lockRoll2 = new ToggleGroup();
		RadioButton lock2 = new RadioButton();
		lock2.setStyle("-fx-base: red");
		RadioButton roll2 = new RadioButton();
		roll2.setStyle("-fx-base: green");
		lock2.setToggleGroup(lockRoll2);
		roll2.setToggleGroup(lockRoll2);
		
		ToggleGroup lockRoll3 = new ToggleGroup();
		RadioButton lock3 = new RadioButton();
		lock3.setStyle("-fx-base: red");
		RadioButton roll3 = new RadioButton();
		roll3.setStyle("-fx-base: green");
		lock3.setToggleGroup(lockRoll3);
		roll3.setToggleGroup(lockRoll3);
		
		HBox hboxLock = new HBox(30, lock1, lock2, lock3);
		HBox hboxRoll = new HBox(30, roll1, roll2, roll3);
		
		Label Roll = new Label("Roll:");
		Font fontRoll = Font.font("Times New Roman", FontWeight.BOLD, 20);
		Roll.setFont(fontRoll);
		Roll.setTextFill(Color.GREEN);
		
		Label Roll2 = new Label("Roll 2:");
		Roll2.setFont(fontRoll);
		
		Label improvement = new Label("Improvement");
		improvement.setFont(labelText);
		Text impvNum = new Text();

		GridPane grid = new GridPane();
		grid.getChildren().addAll(title, Name, textField, Roll1, roll, dieText, label, die, rollInfo1, Lock, hboxLock,
				Roll, hboxRoll, Roll2, rerollButton, rerollText, label2, reroll, rollInfo2, improvement, impvNum, playAgain);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(50, 50, 50, 50));
		
		BackgroundFill background_fill = new BackgroundFill(Color.LIGHTBLUE, 
                CornerRadii.EMPTY, Insets.EMPTY);
		 Background background = new Background(background_fill);
		  

         grid.setBackground(background);
         
		grid.setConstraints(title, 0, 0, 5, 1);
		
		grid.setConstraints(Name, 0, 1);
		grid.setConstraints(textField, 1, 1, 3, 1);
		
		grid.setConstraints(Roll1, 0, 2);
		grid.setConstraints(roll, 1, 2, 3, 1);
		grid.setConstraints(dieText, 1, 3, 3, 1);
		grid.setConstraints(label, 5, 3, 5, 1);
		grid.setConstraints(die, 1, 4, 3, 1);
		grid.setConstraints(rollInfo1, 5, 4, 3, 1);
		
		grid.setConstraints(Lock, 0, 6);
		grid.setConstraints(hboxLock, 1,6);
		grid.setConstraints(Roll, 0, 7);
		grid.setConstraints(hboxRoll, 1, 7);
	
		grid.setConstraints(Roll2, 0, 10);
		grid.setConstraints(rerollButton, 1, 10, 3, 1);
		grid.setConstraints(rerollText, 1, 11, 3, 1);
		grid.setConstraints(label2, 5, 11, 5 ,1);
		grid.setConstraints(reroll, 1, 12, 3, 1);
		grid.setConstraints(rollInfo2, 5, 12, 3, 1);
		
		grid.setConstraints(improvement, 5, 14, 3,1);
		grid.setConstraints(impvNum, 5, 15, 3,1);
		
		grid.setConstraints(playAgain, 1, 17, 3,1);
		
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();

		roll.setOnAction(f -> {
			
			DiceGame dice = new DiceGame();
			
			firstRoll[0] = ((dice.getDieValue()));
			firstRoll[1] = ((dice.getDieValue()));
			firstRoll[2] = ((dice.getDieValue()));
			
			Arrays.sort(firstRoll);
			
			dieAll = (firstRoll[0] + "                " + firstRoll[1] + "                " + firstRoll[2]);
			die.setText(dieAll);
			
			sum1 = ((firstRoll[0] + firstRoll[1] + firstRoll[2]));
			sumStr = (Integer.toString(sum1));
			
			
			bonusPoints pairPoint = new bonusPoints();
			bonusPoints tripPoint = new bonusPoints();
			bonusPoints strPoint = new bonusPoints();
			 
			pairBonus = pairPoint.getPairBonus(firstRoll);
			tripBonus = tripPoint.getTripBonus(firstRoll);
				if (tripBonus > 0) pairBonus = 0;
			strBonus = strPoint.getStrBonus(firstRoll);
			
			String pairPoints = (Integer.toString(pairBonus)); 
			String tripPoints = (Integer.toString(tripBonus));
			String strPoints = (Integer.toString(strBonus));
			
			points1 = sum1 + pairBonus + tripBonus + strBonus;
			String totalStr1 = (Integer.toString(points1));
			
			String pointsInfo1 = (sumStr + "            " + pairPoints + "            " + tripPoints +
					"                 " + strPoints + "                   " + totalStr1);
				rollInfo1.setText(pointsInfo1);
			
		});
			int[] secondRoll = new int[3];
			Arrays.sort(secondRoll);
			DiceGame dice2 = new DiceGame();
			
			lock1.setOnAction(f -> {
				secondRoll[0] = firstRoll[0];
			});
			lock2.setOnAction(f -> {
				secondRoll[1] = firstRoll[1];
			});
			lock3.setOnAction(f -> {
				secondRoll[2] = firstRoll[2];
			});
			roll1.setOnAction(f -> {
				secondRoll[0] = ((dice2.getDieValue()));
			});
			roll2.setOnAction(f -> {
				secondRoll[1] = ((dice2.getDieValue()));
			});
			roll3.setOnAction(f -> {
				secondRoll[2] = ((dice2.getDieValue()));
			});
			
			
			rerollButton.setOnAction(g -> {
				
				Arrays.sort(secondRoll);
				rerollAll = (secondRoll[0] + "                " + secondRoll[1] + "                " + secondRoll[2]);
				reroll.setText(rerollAll);
	
				rerollSum = ((secondRoll[0] + secondRoll[1] + secondRoll[2]));
				sumStr2 = (Integer.toString(rerollSum));
				
				bonusPoints pairPoint2 = new bonusPoints();
				bonusPoints tripPoint2 = new bonusPoints();
				bonusPoints strPoint2 = new bonusPoints();
				
				pairBonus2 = pairPoint2.getPairBonus(secondRoll);
				tripBonus2 = tripPoint2.getTripBonus(secondRoll);
					if (tripBonus2 > 0) pairBonus2 = 0;
				strBonus2 = strPoint2.getStrBonus(secondRoll);
				
				points2 = rerollSum + pairBonus2 + tripBonus2 + strBonus2;
				String totalStr2 = (Integer.toString(points2));
				
				String pairPoints2 = (Integer.toString(pairBonus2)); 
				String tripPoints2 = (Integer.toString(tripBonus2));
				String strPoints2 = (Integer.toString(strBonus2));
				
				String pointsInfo2 = (sumStr2 + "            " + pairPoints2 + "            " + tripPoints2 +
						"                 " + strPoints2 + "                   " + totalStr2);                    
				rollInfo2.setText(pointsInfo2);
				
				int impv = (points2 - points1);
				String imprvStr = (Integer.toString(impv));
				impvNum.setText(imprvStr);
					
				});
			
	

	 textField.setOnKeyPressed( evt ->{
         System.out.println(KeyCode.ENTER + ", " + evt.getCode());
         if(evt.getCode().equals(KeyCode.ENTER)){
             System.out.println("entered");
             roll.requestFocus();
         }
	 });

	 roll.setOnKeyPressed( evt ->{
         System.out.println(KeyCode.ENTER + ", " + evt.getCode());
         if(evt.getCode().equals(KeyCode.ENTER)){
             System.out.println("entered");
             lock1.requestFocus();
             
         
         }
	 });
	 
	 lock1.setOnKeyPressed( evt ->{
         System.out.println(KeyCode.ENTER + ", " + evt.getCode());
         if(evt.getCode().equals(KeyCode.ENTER)){
             System.out.println("entered");
             lock2.requestFocus();
        
         }
	 });
	 
	 lock2.setOnKeyPressed( evt ->{
         System.out.println(KeyCode.ENTER + ", " + evt.getCode());
         if(evt.getCode().equals(KeyCode.ENTER)){
             System.out.println("entered");
             lock3.requestFocus();
         }
	 });
	 
	 lock3.setOnKeyPressed( evt ->{
         System.out.println(KeyCode.ENTER + ", " + evt.getCode());
         if(evt.getCode().equals(KeyCode.ENTER)){
             System.out.println("entered");
             rerollButton.requestFocus();
         }
	 });
	 roll3.setOnKeyPressed( evt ->{
         System.out.println(KeyCode.ENTER + ", " + evt.getCode());
         if(evt.getCode().equals(KeyCode.ENTER)){
             System.out.println("entered");
             rerollButton.requestFocus();
         }
	 });
	 
	 rerollButton.setOnKeyPressed( evt ->{
         System.out.println(KeyCode.ENTER + ", " + evt.getCode());
         if(evt.getCode().equals(KeyCode.ENTER)){
             System.out.println("entered");
             playAgain.requestFocus();
         }
	 });
	 
	 playAgain.setOnKeyPressed( evt ->{
         System.out.println(KeyCode.ENTER + ", " + evt.getCode());
         if(evt.getCode().equals(KeyCode.ENTER)){
             System.out.println("entered");
             roll.requestFocus();
		 }
		 });
	 
	 playAgain.setOnAction(e -> {
		 
		 die.setText("");
		 rollInfo1.setText("");
		 reroll.setText("");
		 rollInfo2.setText("");
		 impvNum.setText("");
		 
		 lock1.setSelected(false);
		 lock2.setSelected(false);
		 lock3.setSelected(false);
		 roll1.setSelected(false);
		 roll2.setSelected(false);
		 roll3.setSelected(false);
		 
	 	});
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

class DiceGame {
	
	public int getDieValue() {
		Random random = new Random();
		int dieValue = random.nextInt(6) + 1;
		return dieValue;
		}	
	}
class bonusPoints{
	
	int pair = 2;
	int otherPair = 0;
	
	
	public int getPairBonus(int[] sDice) {
		if (sDice[0] == sDice[1] || sDice[0] == sDice[2] || sDice[1] == sDice[2]) {
			return pair;
		}
		else return otherPair;
	}
	
	private int triple = 30;
	private int otherTriple = 0;
	
	public int getTripBonus(int[] sDice) {
		if (sDice[0] == sDice[1] && sDice[0] == sDice[2]) {
			return triple;
		}
		else return otherTriple;
	}
	
	private int str = 10;
	private int otherStr = 0;
	
	public int getStrBonus(int[] sDice) {
		if (sDice[1] == sDice[0] + 1 && sDice[2] == sDice[0] + 2) {
			return str;
		}
		else return otherStr;
	}
	
}


