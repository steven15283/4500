/*
Students are told that an �art dealer� wants to �buy� paintings represented by playing cards from a traditional poker deck of 52 cards.
Student attempt to discover what kinds of cards (�paintings�) the art dealer is buying. At each turn, a student lays out 4 cards from
their deck, and observe what the art dealer buys. The turns continue until the student can do two things: put out four cards, all of which
the art dealer buys; and the student can describe what kind of cards the art dealer is buying. For K-2, the patterns will be simple: all red,
all black, all hearts, all queens, and so forth. For 3-5, the patterns will include the easy ones from K-2, but will then progress to tougher
patterns: for example, one pattern might be all single digit primes, or collections of cards that add to 9, or an ace and a black jack.
For grades 6-8, all of the previous patterns will be possible, but even more complex patterns will be introduced, including several kinds of
combinations useful in poker. Finally, students in 6-8 will be able to play the game with each other, one of the students being the art dealer,
and the other being the art seller.
*/

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class artDealer_main extends Application
{
    private GridPane gridpane = new GridPane();
    private HBox hboxBottom = new HBox();
    private VBox vboxRight = new VBox();
    public String buttonId;
    private int numCardsSelected = 0;
    private boolean gradeSelected = false;
    private Text historyText = new Text();
    private ScrollPane scrollpane = new ScrollPane();
    private final ToggleGroup rbGroup = new ToggleGroup();
    private int matchedCards = 0;
    private Button buttonK2 = null;
    private Button button35 = null;
    private Button button68 = null;
    private Button declarePattern = null;
    private Button guessPattern = null;
    private Button sellCards = null;
    
    public int[] purchasedCards = new int[51]; //array to store whether that card has been purchased based on index

    private RadioButton pattern0 = new RadioButton();
    private RadioButton pattern1 = new RadioButton();
    private RadioButton pattern2 = new RadioButton();
    private RadioButton pattern3 = new RadioButton();
    private RadioButton pattern4 = new RadioButton();
    private RadioButton pattern5 = new RadioButton();
    private RadioButton pattern6 = new RadioButton();
    private RadioButton pattern7 = new RadioButton();
    private RadioButton pattern8 = new RadioButton();
    private RadioButton pattern9 = new RadioButton();
    private RadioButton pattern10 = new RadioButton();
    private RadioButton pattern11 = new RadioButton();
    private RadioButton pattern12 = new RadioButton();
    private RadioButton pattern13 = new RadioButton();
    private RadioButton pattern14 = new RadioButton();
    private RadioButton pattern15 = new RadioButton();
    private RadioButton pattern16 = new RadioButton();
    private RadioButton pattern17 = new RadioButton();
    private RadioButton pattern18 = new RadioButton();
    private RadioButton pattern19 = new RadioButton();
    private RadioButton pattern20 = new RadioButton();
    private RadioButton pattern21 = new RadioButton();
    private RadioButton pattern22 = new RadioButton();
    private RadioButton pattern23 = new RadioButton();

    // create and design the elements of the stage
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // create a border pane
        BorderPane pane = new BorderPane();

        // create and design an hBox for the top portion of the border pane
        HBox hboxTop = new HBox();
        hboxTop.setPadding(new Insets(15, 12, 15, 12));
        hboxTop.setSpacing(10);
        hboxTop.setStyle("-fx-background-color: #336699;");

        Text startText = new Text("Start a New Game for Grade Level:");
        startText.setFill(Color.ANTIQUEWHITE);
        startText.setFont(Font.font(null, FontWeight.NORMAL, 15));

        buttonK2 = new Button("K - 2");
        buttonK2.setPrefSize(75, 20);

        button35 = new Button("3 - 5");
        button35.setPrefSize(75, 20);

        button68 = new Button("6 - 8");
        button68.setPrefSize(75, 20);

        // addAll info to hboxTop
        hboxTop.getChildren().addAll(startText, buttonK2, button35, button68);

        // create and design an hBox for the bottom portion of the border pane
        hboxBottom.getChildren().addAll(scrollpane);
        hboxBottom.setPadding(new Insets(15, 12, 15, 12));
        hboxBottom.setStyle("-fx-background-color: #336699;");
        hboxBottom.setAlignment(Pos.CENTER);

        // create a scrollpane to hold the history text output
        scrollpane.setContent(historyText);
        scrollpane.setPrefWidth(1245);
        scrollpane.setPrefHeight(180);
        scrollpane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);

        historyText.setFill(Color.BLUE);
        historyText.setText("Welcome to Art Dealer! To start a new game, please select your "
        		+ "grade level at the stop of the screen! \n");

        // create button for guessing the solution pattern
        guessPattern = new Button("GUESS PATTERN");
        guessPattern.setPrefSize(100, 100);
        guessPattern.setWrapText(true);
        guessPattern.setTextAlignment(TextAlignment.CENTER);
        guessPattern.setDisable(true);

        guessHandler guessThePattern = new guessHandler();

        guessPattern.setOnAction(guessThePattern);
        
        // create radio buttons for guessing the pattern
        pattern0.setText("Red Cards");
        pattern0.setToggleGroup(rbGroup);
        pattern0.setTextFill(Color.WHITE);
        pattern0.setId("0");

        pattern1.setText("Black Cards");
        pattern1.setToggleGroup(rbGroup);
        pattern1.setTextFill(Color.WHITE);
        pattern1.setId("1");

        pattern2.setText("Hearts");
        pattern2.setToggleGroup(rbGroup);
        pattern2.setTextFill(Color.WHITE);
        pattern2.setId("2");

        pattern3.setText("Diamonds");
        pattern3.setToggleGroup(rbGroup);
        pattern3.setTextFill(Color.WHITE);
        pattern3.setId("3");

        pattern4.setText("Clubs");
        pattern4.setToggleGroup(rbGroup);
        pattern4.setTextFill(Color.WHITE);
        pattern4.setId("4");

        pattern5.setText("Spades");
        pattern5.setToggleGroup(rbGroup);
        pattern5.setTextFill(Color.WHITE);
        pattern5.setId("5");

        pattern6.setText("Twos");
        pattern6.setToggleGroup(rbGroup);
        pattern6.setTextFill(Color.WHITE);
        pattern6.setId("6");

        pattern7.setText("Threes");
        pattern7.setToggleGroup(rbGroup);
        pattern7.setTextFill(Color.WHITE);
        pattern7.setId("7");

        pattern8.setText("Fours");
        pattern8.setToggleGroup(rbGroup);
        pattern8.setTextFill(Color.WHITE);
        pattern8.setId("8");

        pattern9.setText("Fives");
        pattern9.setToggleGroup(rbGroup);
        pattern9.setTextFill(Color.WHITE);
        pattern9.setId("9");

        pattern10.setText("Sixes");
        pattern10.setToggleGroup(rbGroup);
        pattern10.setTextFill(Color.WHITE);
        pattern10.setId("10");

        pattern11.setText("Sevens");
        pattern11.setToggleGroup(rbGroup);
        pattern11.setTextFill(Color.WHITE);
        pattern11.setId("11");

        pattern12.setText("Eights");
        pattern12.setToggleGroup(rbGroup);
        pattern12.setTextFill(Color.WHITE);
        pattern12.setId("12");

        pattern13.setText("Nines");
        pattern13.setToggleGroup(rbGroup);
        pattern13.setTextFill(Color.WHITE);
        pattern13.setId("13");

        pattern14.setText("Tens");
        pattern14.setToggleGroup(rbGroup);
        pattern14.setTextFill(Color.WHITE);
        pattern14.setId("14");

        pattern15.setText("Jacks");
        pattern15.setToggleGroup(rbGroup);
        pattern15.setTextFill(Color.WHITE);
        pattern15.setId("15");

        pattern16.setText("Queens");
        pattern16.setToggleGroup(rbGroup);
        pattern16.setTextFill(Color.WHITE);
        pattern16.setId("16");

        pattern17.setText("Kings");
        pattern17.setToggleGroup(rbGroup);
        pattern17.setTextFill(Color.WHITE);
        pattern17.setId("17");

        pattern18.setText("Aces");
        pattern18.setToggleGroup(rbGroup);
        pattern18.setTextFill(Color.WHITE);
        pattern18.setId("18");

        pattern19.setText("Single Digit Primes");
        pattern19.setToggleGroup(rbGroup);
        pattern19.setTextFill(Color.WHITE);
        pattern19.setId("19");

        pattern20.setText("Pairs");
        pattern20.setToggleGroup(rbGroup);
        pattern20.setTextFill(Color.WHITE);
        pattern20.setId("20");

        pattern21.setText("Sum of Pairs");
        pattern21.setToggleGroup(rbGroup);
        pattern21.setTextFill(Color.WHITE);
        pattern21.setId("21");

        pattern22.setText("Incrementing Cards");
        pattern22.setToggleGroup(rbGroup);
        pattern22.setTextFill(Color.WHITE);
        pattern22.setId("22");

        pattern23.setText("Decrementing Cards");
        pattern23.setToggleGroup(rbGroup);
        pattern23.setTextFill(Color.WHITE);
        pattern23.setId("23");

        //disable all radio buttons
        pattern0.setDisable(true);
        pattern1.setDisable(true);
        pattern2.setDisable(true);
        pattern3.setDisable(true);
        pattern4.setDisable(true);
        pattern5.setDisable(true);
        pattern6.setDisable(true);
        pattern7.setDisable(true);
        pattern8.setDisable(true);
        pattern9.setDisable(true);
        pattern10.setDisable(true);
        pattern11.setDisable(true);
        pattern12.setDisable(true);
        pattern13.setDisable(true);
        pattern14.setDisable(true);
        pattern15.setDisable(true);
        pattern16.setDisable(true);
        pattern17.setDisable(true);
        pattern18.setDisable(true);
        pattern19.setDisable(true);
        pattern20.setDisable(true);
        pattern21.setDisable(true);
        pattern22.setDisable(true);
        pattern23.setDisable(true);
        
        // create sell button in right vbox
        sellCards = new Button("SELL CARDS");
        sellCards.setPrefSize(100, 100);
        sellCards.setWrapText(true);
        sellCards.setTextAlignment(TextAlignment.CENTER);
        sellCards.setDisable(true);

        // create a vbox for the right panel
        //VBox vboxRight = new VBox();
        
        // create event handler for declaring a pattern
        declarePatternHandler patternSelection = new declarePatternHandler();
        
        // create button for declaring a pattern (specific to grade 6-8)
        declarePattern = new Button("Declare Pattern");
        declarePattern.setPrefSize(100, 50);
        declarePattern.setWrapText(true);
        declarePattern.setTextAlignment(TextAlignment.CENTER);
        declarePattern.setVisible(false);

        declarePattern.setOnAction(patternSelection);
        
        // add sellCards button and guessPattern button to vbox right
        vboxRight.getChildren().addAll(sellCards, pattern0, pattern1, pattern2, pattern3, 
        		pattern4, pattern5, pattern6, pattern7, pattern8, pattern9, pattern10,
                pattern11, pattern12, pattern13, pattern14, pattern15, pattern16,
                pattern17, pattern18, pattern19, pattern20, pattern21, pattern22,
                pattern23, declarePattern, guessPattern);
        vboxRight.setStyle("-fx-background-color: #336699;");
        vboxRight.setAlignment(Pos.TOP_LEFT);

        // create a grid pane for the center portion of the border pane
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(0, 10, 0, 10));

        // create event handler for selection
        cardSelectionHandler cardSelection = new cardSelectionHandler();

        // create event handler for selecting a grade level
        // this will restart the game using the new grade level settings
        newGameHandler resetHandler = new newGameHandler();
        buttonK2.setOnAction(resetHandler);
        button35.setOnAction(resetHandler);
        button68.setOnAction(resetHandler);

        // create event handler for selling cards
        sellHandler cardsSold = new sellHandler();
        // associate the sellCards button with its event handler
        sellCards.setOnAction(cardsSold);

        Image c2 = new Image(getClass().getResourceAsStream("2C.jpg"));
        Image d2 = new Image(getClass().getResourceAsStream("2D.jpg"));
        Image h2 = new Image(getClass().getResourceAsStream("2H.jpg"));
        Image s2 = new Image(getClass().getResourceAsStream("2S.jpg"));
        Image c3 = new Image(getClass().getResourceAsStream("3C.jpg"));
        Image d3 = new Image(getClass().getResourceAsStream("3D.jpg"));
        Image h3 = new Image(getClass().getResourceAsStream("3H.jpg"));
        Image s3 = new Image(getClass().getResourceAsStream("3S.jpg"));
        Image c4 = new Image(getClass().getResourceAsStream("4C.jpg"));
        Image d4 = new Image(getClass().getResourceAsStream("4D.jpg"));
        Image h4 = new Image(getClass().getResourceAsStream("4H.jpg"));
        Image s4 = new Image(getClass().getResourceAsStream("4S.jpg"));
        Image c5 = new Image(getClass().getResourceAsStream("5C.jpg"));
        Image d5 = new Image(getClass().getResourceAsStream("5D.jpg"));
        Image h5 = new Image(getClass().getResourceAsStream("5H.jpg"));
        Image s5 = new Image(getClass().getResourceAsStream("5S.jpg"));
        Image c6 = new Image(getClass().getResourceAsStream("6C.jpg"));
        Image d6 = new Image(getClass().getResourceAsStream("6D.jpg"));
        Image h6 = new Image(getClass().getResourceAsStream("6H.jpg"));
        Image s6 = new Image(getClass().getResourceAsStream("6S.jpg"));
        Image c7 = new Image(getClass().getResourceAsStream("7C.jpg"));
        Image d7 = new Image(getClass().getResourceAsStream("7D.jpg"));
        Image h7 = new Image(getClass().getResourceAsStream("7H.jpg"));
        Image s7 = new Image(getClass().getResourceAsStream("7S.jpg"));
        Image c8 = new Image(getClass().getResourceAsStream("8C.jpg"));
        Image d8 = new Image(getClass().getResourceAsStream("8D.jpg"));
        Image h8 = new Image(getClass().getResourceAsStream("8H.jpg"));
        Image s8 = new Image(getClass().getResourceAsStream("8S.jpg"));
        Image c9 = new Image(getClass().getResourceAsStream("9C.jpg"));
        Image d9 = new Image(getClass().getResourceAsStream("9D.jpg"));
        Image h9 = new Image(getClass().getResourceAsStream("9H.jpg"));
        Image s9 = new Image(getClass().getResourceAsStream("9S.jpg"));
        Image c10 = new Image(getClass().getResourceAsStream("10C.jpg"));
        Image d10 = new Image(getClass().getResourceAsStream("10D.jpg"));
        Image h10 = new Image(getClass().getResourceAsStream("10H.jpg"));
        Image s10 = new Image(getClass().getResourceAsStream("10S.jpg"));
        Image AC = new Image(getClass().getResourceAsStream("AC.jpg"));
        Image AD = new Image(getClass().getResourceAsStream("AD.jpg"));
        Image AH = new Image(getClass().getResourceAsStream("AH.jpg"));
        Image AS = new Image(getClass().getResourceAsStream("AS.jpg"));
        Image JC = new Image(getClass().getResourceAsStream("JC.jpg"));
        Image JD = new Image(getClass().getResourceAsStream("JD.jpg"));
        Image JH = new Image(getClass().getResourceAsStream("JH.jpg"));
        Image JS = new Image(getClass().getResourceAsStream("JS.jpg"));
        Image QC = new Image(getClass().getResourceAsStream("QC.jpg"));
        Image QD = new Image(getClass().getResourceAsStream("QD.jpg"));
        Image QH = new Image(getClass().getResourceAsStream("QH.jpg"));
        Image QS = new Image(getClass().getResourceAsStream("QS.jpg"));
        Image KC = new Image(getClass().getResourceAsStream("KC.jpg"));
        Image KD = new Image(getClass().getResourceAsStream("KD.jpg"));
        Image KH = new Image(getClass().getResourceAsStream("KH.jpg"));
        Image KS = new Image(getClass().getResourceAsStream("KS.jpg"));

        // place nodes in the grid pane, creating a 4x13 grid of buttons (2 - Ace, by suit)
        for (int r = 0; r < 4; r++)
        {
            for (int c = 0; c < 13; c++)
            {
                Button button = new Button("");
                ImageView cardImage = new ImageView();

                // fill first row with spades from 2-A
                // set button id to match the index of the corresponding cards
                if (r == 0)
                {
                    switch(c)
                    {
                        case 0:
                            cardImage.setImage(s2);
                            button.setGraphic(cardImage);
                            buttonId = "39";
                            button.setId(buttonId);
                            break;
                        case 1:
                            cardImage.setImage(s3);
                            button.setGraphic(cardImage);
                            buttonId = "40";
                            button.setId(buttonId);
                            break;
                        case 2:
                            cardImage.setImage(s4);
                            button.setGraphic(cardImage);
                            buttonId = "41";
                            button.setId(buttonId);
                            break;
                        case 3:
                            cardImage.setImage(s5);
                            button.setGraphic(cardImage);
                            buttonId = "42";
                            button.setId(buttonId);
                            break;
                        case 4:
                            cardImage.setImage(s6);
                            button.setGraphic(cardImage);
                            buttonId = "43";
                            button.setId(buttonId);
                            break;
                        case 5:
                            cardImage.setImage(s7);
                            button.setGraphic(cardImage);
                            buttonId = "44";
                            button.setId(buttonId);
                            break;
                        case 6:
                            cardImage.setImage(s8);
                            button.setGraphic(cardImage);
                            buttonId = "45";
                            button.setId(buttonId);
                            break;
                        case 7:
                            cardImage.setImage(s9);
                            button.setGraphic(cardImage);
                            buttonId = "46";
                            button.setId(buttonId);
                            break;
                        case 8:
                            cardImage.setImage(s10);
                            button.setGraphic(cardImage);
                            buttonId = "47";
                            button.setId(buttonId);
                            break;
                        case 9:
                            cardImage.setImage(JS);
                            button.setGraphic(cardImage);
                            buttonId = "48";
                            button.setId(buttonId);
                            break;
                        case 10:
                            cardImage.setImage(QS);
                            button.setGraphic(cardImage);
                            buttonId = "49";
                            button.setId(buttonId);
                            break;
                        case 11:
                            cardImage.setImage(KS);
                            button.setGraphic(cardImage);
                            buttonId = "50";
                            button.setId(buttonId);
                            break;
                        case 12:
                            cardImage.setImage(AS);
                            button.setGraphic(cardImage);
                            buttonId = "51";
                            button.setId(buttonId);
                            break;
                        default:
                            // do nothing; should never reach this
                            break;
                    }
                }
                // fill second row with hearts, from 2 - A
                else if (r == 1)
                {
                    switch(c)
                    {
                        case 0:
                            cardImage.setImage(h2);
                            button.setGraphic(cardImage);
                            buttonId = "0";
                            button.setId(buttonId);
                            break;
                        case 1:
                            cardImage.setImage(h3);
                            button.setGraphic(cardImage);
                            buttonId = "1";
                            button.setId(buttonId);
                            break;
                        case 2:
                            cardImage.setImage(h4);
                            button.setGraphic(cardImage);
                            buttonId = "2";
                            button.setId(buttonId);
                            break;
                        case 3:
                            cardImage.setImage(h5);
                            button.setGraphic(cardImage);
                            buttonId = "3";
                            button.setId(buttonId);
                            break;
                        case 4:
                            cardImage.setImage(h6);
                            button.setGraphic(cardImage);
                            buttonId = "4";
                            button.setId(buttonId);
                            break;
                        case 5:
                            cardImage.setImage(h7);
                            button.setGraphic(cardImage);
                            buttonId = "5";
                            button.setId(buttonId);
                            break;
                        case 6:
                            cardImage.setImage(h8);
                            button.setGraphic(cardImage);
                            buttonId = "6";
                            button.setId(buttonId);
                            break;
                        case 7:
                            cardImage.setImage(h9);
                            button.setGraphic(cardImage);
                            buttonId = "7";
                            button.setId(buttonId);
                            break;
                        case 8:
                            cardImage.setImage(h10);
                            button.setGraphic(cardImage);
                            buttonId = "8";
                            button.setId(buttonId);
                            break;
                        case 9:
                            cardImage.setImage(JH);
                            button.setGraphic(cardImage);
                            buttonId = "9";
                            button.setId(buttonId);
                            break;
                        case 10:
                            cardImage.setImage(QH);
                            button.setGraphic(cardImage);
                            buttonId = "10";
                            button.setId(buttonId);
                            break;
                        case 11:
                            cardImage.setImage(KH);
                            button.setGraphic(cardImage);
                            buttonId = "11";
                            button.setId(buttonId);
                            break;
                        case 12:
                            cardImage.setImage(AH);
                            button.setGraphic(cardImage);
                            buttonId = "12";
                            button.setId(buttonId);
                            break;
                        default:
                            // do nothing; should never reach this
                            break;
                    }
                }
                // fill third row with clubs, from 2 - A
                else if (r == 2)
                {
                    switch(c)
                    {
                        case 0:
                            cardImage.setImage(c2);
                            button.setGraphic(cardImage);
                            buttonId = "26";
                            button.setId(buttonId);
                            break;
                        case 1:
                            cardImage.setImage(c3);
                            button.setGraphic(cardImage);
                            buttonId = "27";
                            button.setId(buttonId);
                            break;
                        case 2:
                            cardImage.setImage(c4);
                            button.setGraphic(cardImage);
                            buttonId = "28";
                            button.setId(buttonId);
                            break;
                        case 3:
                            cardImage.setImage(c5);
                            button.setGraphic(cardImage);
                            buttonId = "29";
                            button.setId(buttonId);
                            break;
                        case 4:
                            cardImage.setImage(c6);
                            button.setGraphic(cardImage);
                            buttonId = "30";
                            button.setId(buttonId);
                            break;
                        case 5:
                            cardImage.setImage(c7);
                            button.setGraphic(cardImage);
                            buttonId = "31";
                            button.setId(buttonId);
                            break;
                        case 6:
                            cardImage.setImage(c8);
                            button.setGraphic(cardImage);
                            buttonId = "32";
                            button.setId(buttonId);
                            break;
                        case 7:
                            cardImage.setImage(c9);
                            button.setGraphic(cardImage);
                            buttonId = "33";
                            button.setId(buttonId);
                            break;
                        case 8:
                            cardImage.setImage(c10);
                            button.setGraphic(cardImage);
                            buttonId = "34";
                            button.setId(buttonId);
                            break;
                        case 9:
                            cardImage.setImage(JC);
                            button.setGraphic(cardImage);
                            buttonId = "35";
                            button.setId(buttonId);
                            break;
                        case 10:
                            cardImage.setImage(QC);
                            button.setGraphic(cardImage);
                            buttonId = "36";
                            button.setId(buttonId);
                            break;
                        case 11:
                            cardImage.setImage(KC);
                            button.setGraphic(cardImage);
                            buttonId = "37";
                            button.setId(buttonId);
                            break;
                        case 12:
                            cardImage.setImage(AC);
                            button.setGraphic(cardImage);
                            buttonId = "38";
                            button.setId(buttonId);
                            break;
                        default:
                            //do nothing; should never reach this
                            break;
                    }
                }
                // fill last row with diamonds, from 2 - A
                else if (r == 3)
                {
                    switch(c)
                    {
                        case 0:
                            cardImage.setImage(d2);
                            button.setGraphic(cardImage);
                            buttonId = "13";
                            button.setId(buttonId);
                            break;
                        case 1:
                            cardImage.setImage(d3);
                            button.setGraphic(cardImage);
                            buttonId = "14";
                            button.setId(buttonId);
                            break;
                        case 2:
                            cardImage.setImage(d4);
                            button.setGraphic(cardImage);
                            buttonId = "15";
                            button.setId(buttonId);
                            break;
                        case 3:
                            cardImage.setImage(d5);
                            button.setGraphic(cardImage);
                            buttonId = "16";
                            button.setId(buttonId);
                            break;
                        case 4:
                            cardImage.setImage(d6);
                            button.setGraphic(cardImage);
                            buttonId = "17";
                            button.setId(buttonId);
                            break;
                        case 5:
                            cardImage.setImage(d7);
                            button.setGraphic(cardImage);
                            buttonId = "18";
                            button.setId(buttonId);
                            break;
                        case 6:
                            cardImage.setImage(d8);
                            button.setGraphic(cardImage);
                            buttonId = "19";
                            button.setId(buttonId);
                            break;
                        case 7:
                            cardImage.setImage(d9);
                            button.setGraphic(cardImage);
                            buttonId = "20";
                            button.setId(buttonId);
                            break;
                        case 8:
                            cardImage.setImage(d10);
                            button.setGraphic(cardImage);
                            buttonId = "21";
                            button.setId(buttonId);
                            break;
                        case 9:
                            cardImage.setImage(JD);
                            button.setGraphic(cardImage);
                            buttonId = "22";
                            button.setId(buttonId);
                            break;
                        case 10:
                            cardImage.setImage(QD);
                            button.setGraphic(cardImage);
                            buttonId = "23";
                            button.setId(buttonId);
                            break;
                        case 11:
                            cardImage.setImage(KD);
                            button.setGraphic(cardImage);
                            buttonId = "24";
                            button.setId(buttonId);
                            break;
                        case 12:
                            cardImage.setImage(AD);
                            button.setGraphic(cardImage);
                            buttonId = "25";
                            button.setId(buttonId);
                            break;
                        default:
                            //do nothing; should never reach this
                            break;
                    }
                }

                button.setOnAction(cardSelection);
                gridpane.add(button, c, r);
            }
        }

        //disable all cards
        for(Node child: gridpane.getChildren())
        {
        	child.setDisable(true);
        }
        
        // place hboxtop, hboxbottom, and gridpane nodes in the border pane
        pane.setTop(hboxTop);
        pane.setCenter(gridpane);
        pane.setBottom(hboxBottom);
        pane.setRight(vboxRight);



        // create a scene and place the border pane in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Art Dealer"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    private static int turnCount = 0;                   //Counts the turns per game
    private static int solutionChoice;
    private static int grade = -1;                      //Value for storing grade
    private static int sumValue = -1;                   //Value for storing the sum value for SUMOFPAIRS pattern
    private static List<Card> gameDeck = new ArrayList<>();
    private static List<Card> playerDeck = new ArrayList<>();
    private static List<Card> matchedDeck = new ArrayList<>();
    private static Random rand = new Random();

    enum Pattern //This is the name of each of the patterns within the game
    {      
        RED, BLACK, HEART, DIAMOND, CLUB, SPADE, TWO, THREE, FOUR, FIVE,
        SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, SINGLEDIGITPRIMES,
        PAIRS, SUMOFPAIRS, INCREMENTING, DECREMENTING;
    }
    private static Pattern[] patterns = Pattern.values();   //An array to hold each pattern type in the enum
    private static Pattern pattern;                         //Holds the pattern used for an individual game

    private static int getRandomNumber(int min, int max) 
    {  //generates a random number within a range
        return (min + rand.nextInt((max - min) + 1));
    }

    private static void choosePattern() {       //Function to choose the pattern, if grade is 6-8 another player can choose the pattern
        if(grade < 3) {
            pattern = patterns[getRandomNumber(0,18)];
            ////system.out.println("Pattern:" + pattern);
        } else if(grade < 6) {
            pattern = patterns[getRandomNumber(0,20)];
            ////system.out.println("Pattern:" + pattern);
            if(pattern.equals(patterns[21])) {
                //system.out.println("Sum To Value Chosen");
                sumValue = getRandomNumber(4,28);
                //system.out.println("Sum Value:" + sumValue);
            }
        }
//        else {
//
//            //***Temporary --should get pattern from user
//            pattern = patterns[getRandomNumber(0,23)];
//            //system.out.println("Pattern:" + pattern);
//            if(pattern.equals(patterns[23])) {
//                //system.out.println("Sum To Value Chosen");
//                sumValue = getRandomNumber(4,28);
//                //system.out.println("Sum Value:" + sumValue);
//            }
//            //***
//
////            getUserPattern();
//        }
    }

    private static void clearPlayerDeck() {
        playerDeck.clear();
    }

    private static void clearMatchedDeck() {
        matchedDeck.clear();
    }

//    private static void getUserPattern() {  //Function to let a player acting as the "Art Dealer" to choose a pattern
//        int patternChoice = -1;
//        String choice;
//        while(patternChoice < 0 || patternChoice > patterns.length-1) {
//            System.out.print("Choose a pattern(0-23):");
//            choice = userInput.next();
//            patternChoice = Integer.parseInt(choice);   //***Pattern choice buttons will map here to patternChoice*** (0-23) See chart
//        }
//        pattern = patterns[patternChoice];
//
//        if(patternChoice == 20) {
//            while((sumValue < 4) || (sumValue > 28)) {
//                System.out.print("Choose a value to sum to(4-28):");
//                choice = userInput.next();              //***Integer value for SUMOFPAIRS pattern will map here to choice*** (4-28) If player acting as Art Dealer chose this pattern
//                sumValue = Integer.parseInt(choice);
//            }
//        }
//    }
    private static void setUserPattern(int patternChoice) {  //Function to let a player acting as the "Art Dealer" to choose a pattern

        pattern = patterns[patternChoice];

        if(patternChoice == 21) {
            sumValue = getRandomNumber(4,28);
        }
    }

    private static void guessPattern() {     //Function to give the player a chance to solve after all 4 cards they pick are a match
//        //system.out.println("\nAll of your cards were a match!");

//        String choice;
//        int solutionChoice;

        //***Pattern choice buttons for solving game will map here to solutionChoice*** (0-18 for K-2//0-20 for 3-5//0-23 for 6-8) See chart
//        if(grade < 3) {
//            do {
//                //system.out.println("Choose a pattern to solve game(0-18)");
//                choice = userInput.next();
//                solutionChoice = Integer.parseInt(choice);
//            } while(solutionChoice < 0 || solutionChoice > 18);
//        } else if(grade < 6) {
//            do {
//                //system.out.println("Choose a pattern to solve game(0-20)");
//                choice = userInput.next();
//                solutionChoice = Integer.parseInt(choice);
//            } while(solutionChoice < 0 || solutionChoice > 20);
//        } else {
//            do {
//                //system.out.println("Choose a pattern to solve game(0-23)");
//                choice = userInput.next();
//                solutionChoice = Integer.parseInt(choice);
//            } while(solutionChoice < 0 || solutionChoice > 23);
//        }
//        solutionChoice = 1;

        if(pattern == patterns[solutionChoice])
        {
            //system.out.println("\nYou are correct!!");
            //system.out.println("It took you " + turnCount + " turns to solve\n");
//            continueCurrentGame = 0;
        } else {
            //System.out.print("\nSorry, that is incorrect\n");
        }
    }

    private static void checkForMatches() {     //This function checks for matches depending on the current pattern
        int matchesThisTurn = 0;
        switch (pattern) {
            case RED:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardColor(playerDeck.get(i)).equals("Red")) {
                        //system.out.println("Matched Card Color:" + GameDeck.getCardColor(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case BLACK:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardColor(playerDeck.get(i)).equals("Black")) {
                        //system.out.println("Matched Card Color:" + GameDeck.getCardColor(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        matchesThisTurn++;
                        playerDeck.get(i).setCardPurchased(true);
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case HEART:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardSuit(playerDeck.get(i)).equals("Heart")) {
                        //system.out.println("Matched Card Suit:" + GameDeck.getCardSuit(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case DIAMOND:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardSuit(playerDeck.get(i)).equals("Diamond")) {
                        //system.out.println("Matched Card Suit:" + GameDeck.getCardSuit(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case CLUB:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardSuit(playerDeck.get(i)).equals("Club")) {
                        //system.out.println("Matched Card Suit:" + GameDeck.getCardSuit(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case SPADE:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardSuit(playerDeck.get(i)).equals("Spade")) {
                        //system.out.println("Matched Card Suit:" + GameDeck.getCardSuit(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case TWO:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("2")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case THREE:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("3")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case FOUR:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("4")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case FIVE:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("5")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case SIX:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("6")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case SEVEN:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("7")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case EIGHT:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("8")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case NINE:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("9")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case TEN:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("10")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case JACK:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("J")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case QUEEN:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("Q")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case KING:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("K")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case ACE:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("A")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case SINGLEDIGITPRIMES:
                for(int i = 0; i< playerDeck.size(); i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("2") ||
                            GameDeck.getCardName(playerDeck.get(i)).equals("3") ||
                            GameDeck.getCardName(playerDeck.get(i)).equals("5") ||
                            GameDeck.getCardName(playerDeck.get(i)).equals("7")) {
                        //system.out.println("Matched Card Name:" + GameDeck.getCardName(playerDeck.get(i)));
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
//                    guessPattern();
                }
                break;
            case PAIRS:
                int[] isAPair = new int[]{0,0,0,0};
                if(GameDeck.getCardName(playerDeck.get(0)).equals(GameDeck.getCardName(playerDeck.get(1)))) {
                    //system.out.println("Matched Pair Name:" + GameDeck.getCardName(playerDeck.get(0)));
                    matchedDeck.add(playerDeck.get(0));
                    playerDeck.get(0).setCardPurchased(true);
                    matchedDeck.add(playerDeck.get(1));
                    playerDeck.get(1).setCardPurchased(true);
                    isAPair[1] = 1;
                    matchesThisTurn += 2;
                } else if(GameDeck.getCardName(playerDeck.get(0)).equals(GameDeck.getCardName(playerDeck.get(2)))) {
                    //system.out.println("Matched Pair Name:" + GameDeck.getCardName(playerDeck.get(0)));
                    matchedDeck.add(playerDeck.get(0));
                    playerDeck.get(0).setCardPurchased(true);
                    matchedDeck.add(playerDeck.get(2));
                    playerDeck.get(2).setCardPurchased(true);
                    isAPair[2] = 1;
                    matchesThisTurn += 2;
                } else if(GameDeck.getCardName(playerDeck.get(0)).equals(GameDeck.getCardName(playerDeck.get(3)))) {
                    //system.out.println("Matched Pair Name:" + GameDeck.getCardName(playerDeck.get(0)));
                    matchedDeck.add(playerDeck.get(0));
                    playerDeck.get(0).setCardPurchased(true);
                    matchedDeck.add(playerDeck.get(3));
                    playerDeck.get(3).setCardPurchased(true);
                    isAPair[3] = 1;
                    matchesThisTurn += 2;
                }
                else
                {
                	playerDeck.get(0).setCardPurchased(false);
                	playerDeck.get(1).setCardPurchased(false);
                	playerDeck.get(2).setCardPurchased(false);
                	playerDeck.get(3).setCardPurchased(false);
                }
                
                if(isAPair[1] != 1) {
                    if(isAPair[2] != 1 && GameDeck.getCardName(playerDeck.get(1)).equals(GameDeck.getCardName(playerDeck.get(2)))) {
                        //system.out.println("Matched Pair Name:" + GameDeck.getCardName(playerDeck.get(1)));
                        matchedDeck.add(playerDeck.get(1));
                        playerDeck.get(1).setCardPurchased(true);
                        matchedDeck.add(playerDeck.get(2));
                        playerDeck.get(2).setCardPurchased(true);
                        isAPair[2] = 1;
                        matchesThisTurn += 2;
                    } else if(isAPair[3] != 1 && GameDeck.getCardName(playerDeck.get(1)).equals(GameDeck.getCardName(playerDeck.get(3)))) {
                        //system.out.println("Matched Pair Name:" + GameDeck.getCardName(playerDeck.get(1)));
                        matchedDeck.add(playerDeck.get(1));
                        playerDeck.get(1).setCardPurchased(true);
                        matchedDeck.add(playerDeck.get(3));
                        playerDeck.get(3).setCardPurchased(true);
                        isAPair[3] = 1;
                        matchesThisTurn += 2;
                    }
                    else
                    {
                    	playerDeck.get(1).setCardPurchased(false);
                    	playerDeck.get(2).setCardPurchased(false);
                    	playerDeck.get(3).setCardPurchased(false);
                    }
                  
                }
                
                if(isAPair[2] != 1) {
                    if(isAPair[3] != 1 && GameDeck.getCardName(playerDeck.get(2)).equals(GameDeck.getCardName(playerDeck.get(3)))) {
                        //system.out.println("Matched Pair Name:" + GameDeck.getCardName(playerDeck.get(2)));
                        matchedDeck.add(playerDeck.get(2));
                        playerDeck.get(2).setCardPurchased(true);
                        matchedDeck.add(playerDeck.get(3));
                        playerDeck.get(3).setCardPurchased(true);
                        matchesThisTurn += 2;
                    }
                    else
                    {
                    	playerDeck.get(2).setCardPurchased(false);
                    	playerDeck.get(3).setCardPurchased(false);
                    }
                }
                if(matchesThisTurn == 4)
                {
                    guessPattern();
                }
                break;
            case SUMOFPAIRS:        //Ace is high for this sum calculation(Ace=14)
                int tempSum;
                int sumPairCount = 0;
                for(int i=0;i<playerDeck.size();i+=2) {
                    tempSum = 0;
                    tempSum += GameDeck.getCardValue(playerDeck.get(i));
                    tempSum += GameDeck.getCardValue(playerDeck.get(i+1));
                    if(tempSum == sumValue) {
                        //system.out.println("Sum Value:" + tempSum);
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchedDeck.add(playerDeck.get(i+1));
                        playerDeck.get(i+1).setCardPurchased(true);
                        sumPairCount++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    	playerDeck.get(i+1).setCardPurchased(false);
                    }
                }
                if(sumPairCount == 2)
                {
//                    guessPattern();
                }
                break;
            case INCREMENTING:
                int[] isIncrementing = new int[]{0,0,0,0};
                int[] isConsecutive = new int[]{0,0,0};
                int consecutiveCount = 0;
                for(int i = 0; i< playerDeck.size()-1; i++) {
                    if(GameDeck.getCardName(playerDeck.get(i)).equals("A")) {
                        if(1 == GameDeck.getCardValue(playerDeck.get(i+1))-1) {
                            //system.out.println("Matched incrementing:" + GameDeck.getCardName(playerDeck.get(i)) +
                            //        " & " + GameDeck.getCardName(playerDeck.get(i+1)));
                            isIncrementing[i] = 1;
                            isIncrementing[i+1] = 1;
                            isConsecutive[i] = 1;
                        }
                    } else {
                        if(GameDeck.getCardValue(playerDeck.get(i)) == GameDeck.getCardValue(playerDeck.get(i+1))-1) {
                            //system.out.println("Matched incrementing:" + GameDeck.getCardName(playerDeck.get(i)) +
                            //        " & " + GameDeck.getCardName(playerDeck.get(i+1)));
                            isIncrementing[i] = 1;
                            isIncrementing[i+1] = 1;
                            isConsecutive[i] = 1;
                        }
                    }
                }
                for(int i=0;i<playerDeck.size();i++) {
                    if(isIncrementing[i] == 1) {
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn ++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                for(int i=0;i<3;i++) {
                    if(isConsecutive[i] == 1) {
                        consecutiveCount++;
                    }
                }
                if(consecutiveCount == 3)
                {
//                    guessPattern();
                }
                break;
            case DECREMENTING:
                int[] isDecrementing = new int[]{0,0,0,0};
                int[] isConsecutive2 = new int[]{0,0,0};
                int consecutiveCount2 = 0;
                for(int i = 0; i< playerDeck.size()-1; i++) {
                    if(GameDeck.getCardValue(playerDeck.get(i)) == 2) {
                        if(GameDeck.getCardName(playerDeck.get(i+1)).equals("A")) {
                            //system.out.println("Matched decrementing:" + GameDeck.getCardName(playerDeck.get(i)) +
                            //        " & " + GameDeck.getCardName(playerDeck.get(i+1)));
                            isDecrementing[i] = 1;
                            isDecrementing[i+1] = 1;
                            isConsecutive2[i] = 1;
                        }
                    } else {
                        if(GameDeck.getCardValue(playerDeck.get(i)) == GameDeck.getCardValue(playerDeck.get(i+1))+1) {
                            //system.out.println("Matched decrementing:" + GameDeck.getCardName(playerDeck.get(i)) +
                            //        " & " + GameDeck.getCardName(playerDeck.get(i+1)));
                            isDecrementing[i] = 1;
                            isDecrementing[i+1] = 1;
                            isConsecutive2[i] = 1;
                        }
                    }
                }
                for(int i=0;i<playerDeck.size();i++) {
                    if(isDecrementing[i] == 1) {
                        matchedDeck.add(playerDeck.get(i));
                        playerDeck.get(i).setCardPurchased(true);
                        matchesThisTurn ++;
                    }
                    else
                    {
                    	playerDeck.get(i).setCardPurchased(false);
                    }
                }
                for(int i=0;i<3;i++) {
                    if(isConsecutive2[i] == 1) {
                        consecutiveCount2++;
                    }
                }
                if(consecutiveCount2 == 3)
                {
//                    guessPattern();
                }
                break;
            default:
                //system.out.println("");
                break;
        }
    }

    private static void showDeckInfo() {
        //system.out.println("Game Deck:" + gameDeck.size() + gameDeck);
    }

    private static void showPlayerDeckInfo() {
        //system.out.println("Player Deck:" + playerDeck.size() + playerDeck);
    }

    private static void showMatchedDeckInfo() {
        //system.out.println("Matched Deck:" + matchedDeck.size() + matchedDeck);
    }

    private static void displayDebugInfo() {
//        system.out.println("Grade:" + grade);
//        system.out.println("Pattern:" + pattern);
//        system.out.println("SumValue:" + sumValue);
        showDeckInfo();
        showPlayerDeckInfo();
        showMatchedDeckInfo();

//        for(int i = 0; i< playerDeck.size(); i++) {
//            //system.out.println("Card Value:" + GameDeck.getCardValue(playerDeck.get(i)));
//            //system.out.println("Card Id:" + GameDeck.getCardId(playerDeck.get(i)));           //syntax for accessing the card id
//            //system.out.println("Card Suit:" + GameDeck.getCardSuit(playerDeck.get(i)));       //syntax for accessing the card suit
//            //system.out.println("Card Name:" + GameDeck.getCardName(playerDeck.get(i)));       //syntax for accessing the card name
//            //system.out.println("Card Color:" + GameDeck.getCardColor(playerDeck.get(i)));
//        }
//        //system.out.println("Pattern Length:" + patterns.length);
    }

    // reset all card selections as if no card has yet been selected
    public void resetSelections()
    {
        for(Node child: gridpane.getChildren())
        {
            Button randButton = (Button) child;

            // set all buttons to have default background
            randButton.setStyle(null);
        }
    }

    // event handler for clicking a grade level
    // this event resets the game
    class newGameHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
        	clearPlayerDeck();
            clearMatchedDeck();
            matchedCards = 0;
            
            buttonK2.setStyle(null);
            button35.setStyle(null);
            button68.setStyle(null);
            
            // store the button that was clicked as variable "clickedButton"
            Button clickedButton = (Button) e.getSource();
            clickedButton.setStyle("-fx-background-color: MediumSeaGreen");       
         
            //enable all radio buttons
            pattern0.setDisable(false);
            pattern1.setDisable(false);
            pattern2.setDisable(false);
            pattern3.setDisable(false);
            pattern4.setDisable(false);
            pattern5.setDisable(false);
            pattern6.setDisable(false);
            pattern7.setDisable(false);
            pattern8.setDisable(false);
            pattern9.setDisable(false);
            pattern10.setDisable(false);
            pattern11.setDisable(false);
            pattern12.setDisable(false);
            pattern13.setDisable(false);
            pattern14.setDisable(false);
            pattern15.setDisable(false);
            pattern16.setDisable(false);
            pattern17.setDisable(false);
            pattern18.setDisable(false);
            pattern19.setDisable(false);
            pattern20.setDisable(false);
            pattern21.setDisable(false);
            pattern22.setDisable(false);
            pattern23.setDisable(false);


            if(rbGroup.getSelectedToggle() != null)
            {
                RadioButton selectedButton = (RadioButton) rbGroup.getSelectedToggle();
                selectedButton.setSelected(false);
            }

            if(clickedButton.getText() == "6 - 8")
            {
            	declarePattern.setVisible(true);
            	pattern19.setVisible(true);
            	pattern20.setVisible(true);
            	pattern21.setVisible(true);
            	pattern22.setVisible(true);
            	pattern23.setVisible(true);
            	
            	// enable declarePattern button
            	declarePattern.setDisable(false);
            	
            	//disable all cards
                for(Node child: gridpane.getChildren())
                {
                	child.setDisable(true);
                }
                
                //disable sellCards button and guessPattern button
                sellCards.setDisable(true);
                guessPattern.setDisable(true);
            }
            else 
            {
            	if(clickedButton.getText() == "3 - 5")
            	{
            		declarePattern.setVisible(false);
            		pattern19.setVisible(true);
                	pattern20.setVisible(true);
                	pattern21.setVisible(false);
                	pattern22.setVisible(false);
                	pattern23.setVisible(false);
            	}
            	else
            	{
            		declarePattern.setVisible(false);
                	pattern19.setVisible(false);
                	pattern20.setVisible(false);
                	pattern21.setVisible(false);
                	pattern22.setVisible(false);
                	pattern23.setVisible(false);
            	}
            	
            	//enable all cards
                for(Node child: gridpane.getChildren())
                {
                	child.setDisable(false);
                }
                
                //enable sellCards button and guessPattern button
                sellCards.setDisable(false);
                guessPattern.setDisable(false);
            }
            
            turnCount = 0;
            grade = -1;
            sumValue = -1;

            gradeSelected = true;

            resetSelections();
            numCardsSelected = 0;

            if(clickedButton.getText() == "6 - 8")
            {
            	historyText.setText("With a partner, determine which of you will be the 'buyer' and which of you will be the 'seller' \n");
//            	historyText.setText(historyText.getText() + "With a partner, determine which of you will be the 'buyer' and which of you will be the 'seller' \n");
            	historyText.setText(historyText.getText() + "The seller should look away from the screen while the buyer selects a pattern "
            			+ "from the choices provided. \n");
            	historyText.setText(historyText.getText() + "Click 'Declare Pattern' when you are ready to begin! \n");
            }
            else
            {
	            historyText.setText("Great! Select 4 cards you want to sell and then click 'SELL CARDS'. If the buyer make a purchase, "
	                    + "that card will be highlighted blue. (Note: you can only sell in packs of 4!) \n");
	            historyText.setText(historyText.getText() + "The cards you put up for purchase and the cards the buyer chooses will be recorded in this box "
	                    + "for your convenience. It may help you identify the buyer's pattern! \n");
	            historyText.setText(historyText.getText() + "The buyer will always purchase your cards based on one of the patterns listed on the right. "
	                    + "When you think you've figured out the pattern, select 4 cards you think the buyer will buy "
	                    + "and then select the pattern you want to guess. \n");
	            historyText.setText(historyText.getText() + "When you're sure about your 4 cards and your pattern selection, click 'GUESS PATTERN'.\n");
	            historyText.setText(historyText.getText() + "Good luck!\n\n");
	            historyText.setText(historyText.getText() + "RESULTS OF SELL ATTEMPTS: \n");
            }

            turnCount = 0;
            sumValue = -1;

            //if k-2
            if(clickedButton.getText() == "K - 2")
            {
                grade = 2;
            }
            //if 3-5
            else if(clickedButton.getText() == "3 - 5")
            {
                grade = 5;
            }
            //if 6-8
            else if(clickedButton.getText() == "6 - 8")
            {
                grade = 8;
            }

            choosePattern();
        }
    }

    // event handler for clicking "SELL CARDS"
    class sellHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
        	// store the button that was clicked as variable "button"
            Button button = (Button) e.getSource();
            
            if(numCardsSelected == 4)
            {
                checkForMatches();
                turnCount++;
                numCardsSelected = 0;
                button.setStyle(null);

            	for(Node child: gridpane.getChildren())
                {
            		if(child.getStyle() == "-fx-background-color: MediumSeaGreen")
                    {
            			if(matchedDeck.size() != 0)
            			{
	            			for(int i = 0; i < matchedDeck.size(); i++)
	            			{
	            				if(matchedDeck.get(i).getCardId() == Integer.parseInt(child.getId()))
	            				{
	            					child.setStyle("-fx-background-color:#38ade3");
		                            break;
	            				}
	            				else
	            				{
	            					child.setStyle(null);
	            				}
	            			}
            			}
            			else
            			{
            				child.setStyle(null);
            			}
                    }	
                }
            	
            	historyText.setText(historyText.getText() + "Selection Order: ");
            	
            	for(int i = 0; i < 4; i++)
                {
            		historyText.setText(historyText.getText() + getCard(playerDeck.get(i).getCardId()) + " ");

                }
                
            	historyText.setText(historyText.getText() + "\tPURCHASED: ");

                for(int i = 0; i < 4; i++)
                {
                    if(playerDeck.get(i).getCardPurchased() == true)
                    {
                        historyText.setText(historyText.getText() + getCard(playerDeck.get(i).getCardId()) + " ");
                    }
                }

                historyText.setText(historyText.getText() + "  REJECTED: ");
                for(int i = 0; i < 4; i++)
                {
                    if(playerDeck.get(i).getCardPurchased() == false)
                    {
                        historyText.setText(historyText.getText() + getCard(playerDeck.get(i).getCardId()) + " ");
                    }
                }
                historyText.setText(historyText.getText() + "\n");
                scrollpane.setVvalue(1.0);
                
                clearPlayerDeck();
            }
            else
            {
            	
            	// set sell button red
            	button.setStyle("-fx-background-color:#f54040");
            	historyText.setText(historyText.getText() + "You must select 4 cards to attempt to sell! \n");
            }
        }
    }

    // event handler for clicking a card up for "sale"
    class cardSelectionHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            // store the button that was clicked as variable "button"
            Button button = (Button) e.getSource();
            //system.out.println("Button ID:" + button.getId());

            boolean cardInMatchedDeck = false;
            
            if (gradeSelected == true)
            {
                // if the card selected by the player was already green, return it to null
                if(button.getStyle() == "-fx-background-color: MediumSeaGreen")
                {
                	// determine if the clicked card exists in the matched deck so we can turn it back to blue if being de-selected
                	for(int i = 0; i < matchedDeck.size(); i++)
                	{
                		//tempCard = (Card) matchedDeck.get(i);
                		if(Integer.parseInt(button.getId()) == matchedDeck.get(i).getCardId())
                		{
                			cardInMatchedDeck = true;
                			break;
                		}
                	}
                	
                	// turn card back to blue as it has been previously purchased
                	if(cardInMatchedDeck)
                	{
                		button.setStyle("-fx-background-color:#38ade3");
                	}
                	else
                	{
                		button.setStyle(null);
                	}
                	
                    playerDeck.remove(gameDeck.get(Integer.parseInt(button.getId())));
                    showPlayerDeckInfo();
                    numCardsSelected--;
                }
                else if (numCardsSelected < 4)
                {
                    button.setStyle("-fx-background-color: MediumSeaGreen");
                    playerDeck.add(gameDeck.get(Integer.parseInt(button.getId())));
                    showPlayerDeckInfo();
                    numCardsSelected++;
                }
            }
        }
    }

    class guessHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
        	// store the button that was clicked as variable "button"
            Button button = (Button) e.getSource();
            
        	RadioButton selectedButton = (RadioButton) rbGroup.getSelectedToggle();
            int matchedCards = 0;
            
            // only allow guessHandler to activate when player has selected 4 final cards
            if(numCardsSelected == 4 && selectedButton != null)
            {
            	// reset highlighting on grade selection buttons
                buttonK2.setStyle(null);
                button35.setStyle(null);
                button68.setStyle(null);
                
            	//disable all radio buttons
                pattern0.setDisable(true);
                pattern1.setDisable(true);
                pattern2.setDisable(true);
                pattern3.setDisable(true);
                pattern4.setDisable(true);
                pattern5.setDisable(true);
                pattern6.setDisable(true);
                pattern7.setDisable(true);
                pattern8.setDisable(true);
                pattern9.setDisable(true);
                pattern10.setDisable(true);
                pattern11.setDisable(true);
                pattern12.setDisable(true);
                pattern13.setDisable(true);
                pattern14.setDisable(true);
                pattern15.setDisable(true);
                pattern16.setDisable(true);
                pattern17.setDisable(true);
                pattern18.setDisable(true);
                pattern19.setDisable(true);
                pattern20.setDisable(true);
                pattern21.setDisable(true);
                pattern22.setDisable(true);
                pattern23.setDisable(true);
                 
                // disable all cards
                for(Node child: gridpane.getChildren())
                {
                	child.setDisable(true);
                }
                
                // disable sell cards button
                sellCards.setDisable(true);
                
                // disable declare pattern button
                declarePattern.setDisable(true);
                
                // disable guess pattern button
                guessPattern.setDisable(true);
                
            	button.setStyle(null);
            	
            	checkForMatches();
            	
            	// system.out.println("Pattern Selected:" + Integer.parseInt(selectedButton.getId()));
                solutionChoice = Integer.parseInt(selectedButton.getId());
                guessPattern();

                // determine if the four selected cards are in the matched deck
                for(int i = 0; i < playerDeck.size(); i++)
                {
                	for(int j = 0; j < matchedDeck.size(); j++)
                	{
                		if(playerDeck.get(i).getCardId() == matchedDeck.get(j).getCardId())
                		{
                			matchedCards++;
                			break;
                		}
                	}
                }
                
                if(Integer.parseInt(selectedButton.getId()) == pattern.ordinal() && matchedCards == 4)
                {
                    // display winning message to player
                    historyText.setText(historyText.getText() + "\n***** YOU FIGURED OUT THE PATTERN *****\n");
                    historyText.setText(historyText.getText() + "It took you " + turnCount + " turns to solve.\n");
                    historyText.setText(historyText.getText() + "Congrats on the win! To start a new game, select your grade level. \n");

                    // play winning audio
                    playAudio(1);
                }
                else if(Integer.parseInt(selectedButton.getId()) == pattern.ordinal())
                {
                	// display losing message to player
                    historyText.setText(historyText.getText() + "\n --- Sorry, you picked the correct pattern, "
                    		+ "but not all of the selected cards were purchased. --- \n");
                    historyText.setText(historyText.getText() + "You used " + turnCount + " turns.\n");
                    historyText.setText(historyText.getText() + "To start a new game, select your grade level. \n");

                    // play losing audio
                    playAudio(0);
                }
                else
                {
                    // display losing message to player
                    historyText.setText(historyText.getText() + "\n --- Sorry, the correct pattern was " + convertEnum() + ". --- \n");
                    historyText.setText(historyText.getText() + "You used " + turnCount + " turns.\n");
                    historyText.setText(historyText.getText() + "To start a new game, select your grade level. \n");

                    // play losing audio
                    playAudio(0);
                }
                scrollpane.setVvalue(1.0);
                // de-select radio button
                selectedButton.setSelected(false);
            }
            else
            {
            	// set sell button red
            	button.setStyle("-fx-background-color:#f54040");
            	historyText.setText(historyText.getText() + "You must select 4 cards and have a pattern selected to guess the pattern! \n");
            }            
        }
    }

    class declarePatternHandler implements EventHandler<ActionEvent>
    {

		@Override
		public void handle(ActionEvent arg0) 
		{
            historyText.setText("No pattern selected. Please select one of the patterns on the right side.\n");

            if(rbGroup.getSelectedToggle() != null)
            {
                historyText.setText("Not Null!! \n");

                declarePattern.setVisible(false);

                RadioButton selectedButton = (RadioButton) rbGroup.getSelectedToggle();
                int patternChoice = Integer.parseInt(selectedButton.getId());

                setUserPattern(patternChoice);

                // enable all cards
                for(Node child: gridpane.getChildren())
                {
                    child.setDisable(false);
                }

                // de-select radio button
                selectedButton.setSelected(false);

                // enable sellCards button and guessPattern button
                sellCards.setDisable(false);
                guessPattern.setDisable(false);

			    historyText.setText("Great! Select 4 cards you want to sell and then click 'SELL CARDS'. If the buyer make a purchase, "
                        + "that card will be highlighted blue. (Note: you can only sell in packs of 4!) \n");
                historyText.setText(historyText.getText() + "The cards you put up for purchase and the cards the buyer chooses will be recorded in this box "
                        + "for your convenience. It may help you identify the buyer's pattern! \n");
                historyText.setText(historyText.getText() + "The buyer will always purchase your cards based on one of the patterns listed on the right. "
                        + "When you think you've figured out the pattern, select 4 cards you think the buyer will buy "
                        + "and then select the pattern you want to guess. \n");
                historyText.setText(historyText.getText() + "When you're sure about your 4 cards and your pattern selection, click 'GUESS PATTERN'.\n");
                historyText.setText(historyText.getText() + "Good luck!\n\n");
                historyText.setText(historyText.getText() + "RESULTS OF SELL ATTEMPTS: \n");
            }
		}
    }
    
    // function to convert pattern enumeration to a string
    public String convertEnum()
    {
    	switch (pattern.ordinal())
    	{
    	case 0:
    		return "Red Cards";
    	case 1:
    		return "Black Cards";
    	case 2:
    		return "Hearts";
    	case 3:
    		return "Diamonds";
    	case 4:
    		return "Clubs";
    	case 5:
    		return "Spades";
    	case 6:
    		return "Twos";
    	case 7:
    		return "Threes";
    	case 8:
    		return "Fours";
    	case 9:
    		return "Fives";
    	case 10:
    		return "Sixes";
    	case 11:
    		return "Sevens";
    	case 12:
    		return "Eights";
    	case 13:
    		return "Nines";
    	case 14:
    		return "Tens";
    	case 15:
    		return "Jacks";
    	case 16:
    		return "Queens";
    	case 17:
    		return "Kings";
    	case 18:
    		return "Aces";
    	case 19:
    		return "Single Digit Primes";
    	case 20:
    		return "Pairs";
    	case 21:
    		return "Sum of Pairs";
    	case 22:
    		return "Incrementing Cards";
    	case 23:
    		return "Decrementing Cards";
    	default:
    		return "";
    	}
    }
    
    
    // function to return the name of the card using the buttonID (index value)
    public String getCard(int buttonID)
    {
        String cardName = "";

        switch(buttonID)
        {
            case 0: cardName = "2H"; break;
            case 1: cardName = "3H"; break;
            case 2: cardName = "4H"; break;
            case 3: cardName = "5H"; break;
            case 4: cardName = "6H"; break;
            case 5: cardName = "7H"; break;
            case 6: cardName = "8H"; break;
            case 7: cardName = "9H"; break;
            case 8: cardName = "10H"; break;
            case 9: cardName = "JH"; break;
            case 10: cardName = "QH"; break;
            case 11: cardName = "KH"; break;
            case 12: cardName = "AH"; break;
            case 13: cardName = "2D"; break;
            case 14: cardName = "3D"; break;
            case 15: cardName = "4D"; break;
            case 16: cardName = "5D"; break;
            case 17: cardName = "6D"; break;
            case 18: cardName = "7D"; break;
            case 19: cardName = "8D"; break;
            case 20: cardName = "9D"; break;
            case 21: cardName = "10D"; break;
            case 22: cardName = "JD"; break;
            case 23: cardName = "QD"; break;
            case 24: cardName = "KD"; break;
            case 25: cardName = "AD"; break;
            case 26: cardName = "2C"; break;
            case 27: cardName = "3C"; break;
            case 28: cardName = "4C"; break;
            case 29: cardName = "5C"; break;
            case 30: cardName = "6C"; break;
            case 31: cardName = "7C"; break;
            case 32: cardName = "8C"; break;
            case 33: cardName = "9C"; break;
            case 34: cardName = "10C"; break;
            case 35: cardName = "JC"; break;
            case 36: cardName = "QC"; break;
            case 37: cardName = "KC"; break;
            case 38: cardName = "AC"; break;
            case 39: cardName = "2S"; break;
            case 40: cardName = "3S"; break;
            case 41: cardName = "4S"; break;
            case 42: cardName = "5S"; break;
            case 43: cardName = "6S"; break;
            case 44: cardName = "7S"; break;
            case 45: cardName = "8S"; break;
            case 46: cardName = "9S"; break;
            case 47: cardName = "10S"; break;
            case 48: cardName = "JS"; break;
            case 49: cardName = "QS"; break;
            case 50: cardName = "KS"; break;
            case 51: cardName = "AS"; break;

        }

        return cardName;
    }

    MediaPlayer mediaPlayer = null;
    // function to play a winning sound when player guesses correct pattern and all cards match pattern
    
    private void playAudio(int winLose)							
    {
        // win
        if(winLose == 1)
        {
            String path = "src/winningSound.wav";
            Media media = new Media(new File(path).toURI().toString());

            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(1);
            mediaPlayer.setAutoPlay(true);
        }
        // lose
        else
        {
            String path = "src/loserSound.wav";
            Media media = new Media(new File(path).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(1);
            mediaPlayer.setAutoPlay(true);
        }
    }

    // launch the program
    public static void main(String[] args)
    {
    	// creates the deck of 52 cards
    	gameDeck = GameDeck.CreateGameDeck();

        launch(args);
    }
}
