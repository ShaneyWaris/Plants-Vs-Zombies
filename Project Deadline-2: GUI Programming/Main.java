package Plant_vs_Zombies;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.io.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

//NOTES
//1. setLayout x or y cannot be used with stackpane
public class Main extends Application {

    Media sound = new Media(new File("C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\bg_sound.mp3").toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    String B1 = "file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawn1.jpg";
    String B2 = "file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawn1.jpg";
    String B3 = "file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawn1.jpg";
    String B4 = "file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawn2.jpg";
    String B5 = "file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawn2.jpg";
    String B6 = "file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawn2.jpg";
    String B7 = "file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawn2.jpg";
    String B8 = "file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawn2.jpg";
    String img_path = "";

    class buy_plants implements EventHandler<ActionEvent> {

        String s;

        public buy_plants(String s) {
            this.s = s;
        }

        @Override
        public void handle(ActionEvent event) {
            img_path = s;
        }
    }
    
    class buy_sun implements EventHandler<ActionEvent> {

        String s;

        public buy_sun(String s) {
            this.s = s;
        }

        @Override
        public void handle(ActionEvent event) {
            img_path = s;
        }
    }

    class game implements EventHandler<ActionEvent> {

        Stage stage;
        String tile = "";
        //String img_path="";

        public game(Stage stage, String s, String tile) {
            this.stage = stage;
            //img_path=s;
            this.tile = tile;
        }

        @Override
        public void handle(ActionEvent event) {
            ImageView Pea = new ImageView();
            if (tile.equals("b3")) {
                Line pea = new Line(380, 280, 1000, 280);
                Image img_p = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\pea.png");
                Pea.setImage(img_p);
                Pea.setFitHeight(20);//set height of image
                Pea.setFitWidth(20);

                PathTransition animp = new PathTransition();
                animp.setNode(Pea);
                animp.setPath(pea);
                animp.setDuration(new Duration(6000));
                animp.setCycleCount(1000);
                animp.setRate(1.5);//set speed
                animp.play();
            }
            if (tile.equals("b1")) {
                B1 = img_path;
            } else if (tile.equals("b2")) {
                B2 = img_path;
            } else if (tile.equals("b3")) {
                B3 = img_path;
            } else if (tile.equals("b4")) {
                B4 = img_path;
            } else if (tile.equals("b5")) {
                B5 = img_path;
            } else if (tile.equals("b6")) {
                B6 = img_path;
            }

            //fixed
            Image back = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\background.jpg");
            ImageView backg = new ImageView();
            backg.setImage(back);
            backg.setFitHeight(800);
            backg.setFitWidth(1500);

            //fixed
            Image Plant = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\peashooter.png");
            ImageView plant = new ImageView();
            plant.setImage(Plant);
            plant.setFitHeight(80);
            plant.setFitWidth(100);
            
            Image sun_image = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\sun.png");
            ImageView sun_ = new ImageView(sun_image);
            //sun_.setImage(Plant);
            sun_.setFitHeight(80);
            sun_.setFitWidth(100);
            Button sun_button = new Button("", sun_);
            sun_button.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            sun_button.setTranslateX(0);
            sun_button.setTranslateY(100);
            sun_button.setOnAction(new buy_sun("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\sun.gif"));
            
            

            System.out.println("b1");
            ImageView iv1 = new ImageView(new Image(B1));
            System.out.println("b2");
            ImageView iv2 = new ImageView(new Image(B2));
            System.out.println("b3");
            ImageView iv3 = new ImageView(new Image(B3));
            System.out.println("b4");
            ImageView iv4 = new ImageView(new Image(B4));
            System.out.println("b5");
            ImageView iv5 = new ImageView(new Image(B5));
            System.out.println("b6");
            ImageView iv6 = new ImageView(new Image(B6));
            System.out.println("b7");
            ImageView iv7 = new ImageView(new Image(B7));
            System.out.println("b8");
            ImageView iv8 = new ImageView(new Image(B8));
            
            
            

            Button b1 = new Button("", plant);//to set graphics in button
            b1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            //b1.setOnAction(new game(stage,"file:C:\\Users\\anand\\Desktop\\plants vs zombies\\plants animation\\abcdef.gif",""));
            b1.setOnAction(new buy_plants("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\abcdef.gif"));
            
            //b1.setTranslateY(80);
            //Button b2=new Button("",iv2);
            //b2.setTranslateX(85);
            //b2.setTranslateY(80);
            iv3.setFitHeight(110);
            iv3.setFitWidth(90);
            Button b3 = new Button("", iv3);
            b3.setTranslateX(330);
            b3.setTranslateY(230);
            b3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            System.out.println("img_path = " + img_path);
            b3.setOnAction(new game(stage, img_path, "b3"));
            
            
            iv2.setFitHeight(110);
            iv2.setFitWidth(85);
            Button b2 = new Button("", iv2);
            b2.setTranslateX(330);
            b2.setTranslateY(380);
            b2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b2.setOnAction(new game(stage, img_path, "b2"));
            
            
            //Button b4=new Button("",iv6);
            //b4.setTranslateY(185);
            //Button b5=new Button("",iv6);
            //b5.setTranslateX(150);
            //b5.setTranslateY(185);
            //Button b6=new Button("",iv6);
            //b6.setTranslateX(300);
            //b6.setTranslateY(185);
            //Button b7=new Button("",iv6);
            //Button b8=new Button("",iv6);
            //Button b9=new Button("",iv6);
            //Button b10=new Button("",iv6);
            //Button b11=new Button("",iv6);
            //Button b12=new Button("",iv6);

            Image sun = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\sun_token.png");
            ImageView sun1 = new ImageView(sun);
            sun1.setFitHeight(70);
            sun1.setFitWidth(180);
            sun1.setTranslateX(150);
            sun1.setTranslateY(10);

//            Button sun2 = new Button();
//            sun2.setMinSize(120, 55);
//            sun2.setTranslateX(210);
//            sun2.setTranslateY(16);    
            Image lm = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
            ImageView lawnmover = new ImageView(lm);
            lawnmover.setFitHeight(50);
            lawnmover.setFitWidth(100);
            lawnmover.setTranslateX(230);
            lawnmover.setTranslateY(150);

            Image lm1 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
            ImageView lawnmover1 = new ImageView(lm1);
            lawnmover1.setFitHeight(50);
            lawnmover1.setFitWidth(100);
            lawnmover1.setTranslateX(230);
            lawnmover1.setTranslateY(270);

            Image lm2 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
            ImageView lawnmover2 = new ImageView(lm2);
            lawnmover2.setFitHeight(50);
            lawnmover2.setFitWidth(100);
            lawnmover2.setTranslateX(230);
            lawnmover2.setTranslateY(410);

            Image lm3 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
            ImageView lawnmover3 = new ImageView(lm3);
            lawnmover3.setFitHeight(50);
            lawnmover3.setFitWidth(100);
            lawnmover3.setTranslateX(230);
            lawnmover3.setTranslateY(530);

            Image lm4 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
            ImageView lawnmover4 = new ImageView(lm4);
            lawnmover4.setFitHeight(50);
            lawnmover4.setFitWidth(100);
            lawnmover4.setTranslateX(230);
            lawnmover4.setTranslateY(670);

            Line l1 = new Line(1500, 290, 200, 290);
            Line l2 = new Line(2200, 440, 200, 440);

            Image img1 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\tenor2.gif");
            ImageView zombie1 = new ImageView();
            zombie1.setImage(img1);
            zombie1.setFitHeight(190);//set height of image
            zombie1.setFitWidth(190);

            Image img2 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie3.gif");
            ImageView zombie2 = new ImageView();
            zombie2.setImage(img2);
            zombie2.setFitHeight(140);//set height of image
            zombie2.setFitWidth(140);
            

            PathTransition anim1 = new PathTransition();
            anim1.setNode(zombie1);
            anim1.setPath(l1);
            anim1.setDuration(new Duration(6000));
            anim1.setCycleCount(1000);
            anim1.setRate(0.2);//set speed
            anim1.play();

            PathTransition anim2 = new PathTransition();
            anim2.setNode(zombie2);
            anim2.setPath(l2);
            anim2.setDuration(new Duration(6000));
            anim2.setCycleCount(1000);
            anim2.setRate(0.1);//set speed
            anim2.play();
            
            

            Image m = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\menu.png");
            ImageView menu1 = new ImageView(m);
            menu1.setFitHeight(60);
            menu1.setFitWidth(120);

            Button menu = new Button("", menu1);
            menu.setTranslateX(1340);
            menu.setTranslateY(10);
            menu.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            menu.setOnAction(e -> {
                menu();
            });
            
            Image t = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\timer.png");
            ImageView timer = new ImageView(t);
            timer.setFitHeight(50);
            timer.setFitWidth(180);
            timer.setTranslateX(700);
            timer.setTranslateY(0);

            Group root = new Group();
            root.getChildren().addAll(backg, b1, b2, b3, zombie1, zombie2, Pea, menu1, menu, sun1, lawnmover, lawnmover1, lawnmover2, lawnmover3, lawnmover4, sun_button, timer);

            Scene scene = new Scene(root, 1500, 800);
            stage.setScene(scene);
            stage.show();
        }

        public void menu() {
            Image bg_ = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\menu_bar2.jpg");
            ImageView bg1 = new ImageView(bg_);
            //bg1.setImage(bg_);
            bg1.setFitHeight(800);
            bg1.setFitWidth(1000);

            Image rs = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\resume_game.png");
            ImageView resume = new ImageView(rs);
            resume.setFitHeight(50);
            resume.setFitWidth(200);

            Button resume_game = new Button("", resume);//to set graphics in button
            resume_game.setTranslateX(0);//to set x and y coordinates of button
            resume_game.setTranslateY(-100);
            resume_game.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            resume_game.setOnAction(e -> {
                this.handle(e);
            });

            Image sg = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\save_game.png");
            ImageView save = new ImageView(sg);
            save.setFitHeight(50);
            save.setFitWidth(200);

            Button save_game = new Button("", save);//to set graphics in button
            save_game.setTranslateX(0);//to set x and y coordinates of button
            save_game.setTranslateY(0);
            save_game.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            save_game.setOnAction(e -> {
                start(stage);
            });

            Image eg = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\exit_game.png");
            ImageView exit = new ImageView(eg);
            exit.setFitHeight(50);
            exit.setFitWidth(200);

            Button exit_game = new Button("", exit);//to set graphics in button
            exit_game.setTranslateX(0);//to set x and y coordinates of button
            exit_game.setTranslateY(100);
            exit_game.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            exit_game.setOnAction(e -> {
                System.exit(0);
            });

            StackPane pane = new StackPane();
            pane.getChildren().addAll(bg1, save, save_game, resume, resume_game, exit, exit_game);
            Scene scene = new Scene(pane, 1000, 800);
            stage.setScene(scene);
            stage.show();
        }
    }

    class load implements EventHandler<ActionEvent> {

        int x = -390;
        int y = -175;
        Stage stage;

        public load(Stage stage) {
            this.stage = stage;
        }

        public void change_level(int x, int y) {
            Image image = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\w1.jpg");//image location
            ImageView iv = new ImageView();//object to use image
            iv.setImage(image);
            iv.setFitHeight(600);//set height of image
            iv.setFitWidth(1000);//set width of image

            Image playI = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\L-1.png");
            ImageView iv1 = new ImageView(playI);
            iv1.setFitHeight(240);
            iv1.setFitWidth(190);
            Button b1 = new Button("", iv1);//to set graphics in button
            b1.setTranslateX(x);//to set x and y coordinates of button
            b1.setTranslateY(y);
            b1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b1.setOnAction(new game(stage, "", ""));

            Image play4 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\L-2.png");
            ImageView iv4 = new ImageView(play4);
            iv4.setFitHeight(200);
            iv4.setFitWidth(150);
            Button b4 = new Button("", iv4);//to set graphics in button
            b4.setTranslateX(x + 200);//to set x and y coordinates of button
            b4.setTranslateY(y);
            b4.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b4.setOnAction(new game(stage, "", ""));

            Image play5 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\L-3.png");
            ImageView iv5 = new ImageView(play5);
            iv5.setFitHeight(200);
            iv5.setFitWidth(150);
            Button b5 = new Button("", iv5);//to set graphics in button
            b5.setTranslateX(x + 400);//to set x and y coordinates of button
            b5.setTranslateY(y);
            b5.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b5.setOnAction(new game(stage, "", ""));

            Image play6 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\L-4.png");
            ImageView iv6 = new ImageView(play6);
            iv6.setFitHeight(200);
            iv6.setFitWidth(150);
            Button b6 = new Button("", iv6);//to set graphics in button
            b6.setTranslateX(x + 600);//to set x and y coordinates of button
            b6.setTranslateY(y);
            b6.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b6.setOnAction(new game(stage, "", ""));

            Image play7 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\L-5.png");
            ImageView iv7 = new ImageView(play7);
            iv7.setFitHeight(200);
            iv7.setFitWidth(150);
            Button b7 = new Button("", iv7);//to set graphics in button
            b7.setTranslateX(x + 800);//to set x and y coordinates of button
            b7.setTranslateY(y);
            b7.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b7.setOnAction(new game(stage, "", ""));

            Image play2 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\left.png");
            ImageView iv2 = new ImageView(play2);
            iv2.setFitHeight(50);
            iv2.setFitWidth(50);
            Button b2 = new Button("", iv2);//to set graphics in button
            b2.setTranslateX(350);//to set x and y coordinates of button
            b2.setTranslateY(30);
            b2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b2.setOnAction(e -> {
                this.x += 20;
                change_level(this.x, this.y);
            });

            Image play3 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\right.png");
            ImageView iv3 = new ImageView(play3);
            iv3.setFitHeight(50);
            iv3.setFitWidth(50);
            Button b3 = new Button("", iv3);//to set graphics in button
            b3.setTranslateX(430);//to set x and y coordinates of button
            b3.setTranslateY(30);
            b3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b3.setOnAction(e -> {
                this.x -= 20;
                change_level(this.x, this.y);
            });

            Image b = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\back.png");
            ImageView back_ = new ImageView(b);
            back_.setFitHeight(50);
            back_.setFitWidth(50);
            Button back = new Button("", back_);
            back.setTranslateX(-400);
            back.setTranslateY(30);
            back.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            back.setOnAction(e -> {
                start(stage);
            });

            StackPane pane = new StackPane();
            pane.getChildren().addAll(iv, b1, b2, b3, b4, b5, b6, b7, back);
            Scene scene = new Scene(pane, 1000, 800);
            stage.setScene(scene);
            stage.show();
        }

        @Override
        public void handle(ActionEvent event) {
            change_level(x, y);
            //x = x + 20;
        }
    }

    class start implements EventHandler<ActionEvent> {

        Stage stage;

        public start(Stage stage) {
            this.stage = stage;
        }

        @Override
        public void handle(ActionEvent event) {
            Image image = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\player_name.png");//image location
            ImageView iv = new ImageView();//object to use image
            iv.setImage(image);
            iv.setFitHeight(600);//set height of image
            iv.setFitWidth(1000);//set width of image

            Image sub = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\submit.png");
            ImageView iv_submit = new ImageView();
            iv_submit.setImage(sub);
            iv_submit.setFitHeight(40);
            iv_submit.setFitWidth(40);
            Button submit = new Button("", iv_submit);
            submit.setTranslateX(440);
            submit.setTranslateY(100);
            submit.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            submit.setOnAction(e -> {
                load l = new load(stage);
                l.change_level(-390, -175);
                new game(stage, "", "");

            });

            TextField player1 = new TextField("textfield");//textfield
            player1.setTranslateX(150);//textfield coordinates on screen
            player1.setTranslateY(100);
            player1.setMaxSize(500, 20);//set length of textfield
            Label b = new Label("Enter player name");
            b.setLabelFor(player1);
            b.setTranslateX(150);//label coordinates on screen
            b.setTranslateY(140);
            b.setScaleX(2);//set label size
            b.setScaleY(2);
            b.setTextFill(Color.web("#FFFFFF"));//set label color

            Image bb = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\back.png");
            ImageView back__ = new ImageView(bb);
            back__.setFitHeight(50);
            back__.setFitWidth(50);
            Button back1 = new Button("", back__);
            back1.setTranslateX(150);
            back1.setTranslateY(220);
            back1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            back1.setOnAction(e -> {
                start(stage);
            });

            StackPane pane = new StackPane();
            pane.getChildren().addAll(iv, player1, b, submit, back1);
            Scene scene = new Scene(pane, 1000, 800);
            stage.setScene(scene);
            stage.show();
        }
    }

    class options implements EventHandler<ActionEvent> {

        Stage stage;
        int state = 0;

        public options(Stage stage) {
            this.stage = stage;
        }

        @Override
        public void handle(ActionEvent event) {
            //stage.setFullScreen(true);
            if (state == 1) {
                state = 0;
            } else if (state == 0) {
                state = 1;
            }

            Image img = new Image("file:C:\\Users\\SHANEY WARIS\\Desktop\\option_2.png");
            ImageView iv = new ImageView();
            iv.setImage(img);
            iv.setFitHeight(600);
            iv.setFitWidth(1000);

            Image playI4 = null;
            if (state == 1) {
                playI4 = new Image("file:C:\\Users\\SHANEY WARIS\\Desktop\\1111.png");
                mediaPlayer.play();
            } else {
                playI4 = new Image("file:C:\\Users\\SHANEY WARIS\\Desktop\\2222.png");
                mediaPlayer.pause();
            }
            ImageView iv4 = new ImageView();
            iv4.setImage(playI4);
            iv4.setFitHeight(50);
            iv4.setFitWidth(100);

            Button b1 = new Button("", iv4);
            b1.setTranslateX(70);
            b1.setTranslateY(-110);
            b1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b1.setOnAction(this);

            Image back_ = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\back.png");
            ImageView back = new ImageView(back_);
            back.setFitHeight(50);
            back.setFitWidth(50);

            Button back_b = new Button("", back);
            back_b.setTranslateX(0);
            back_b.setTranslateY(110);
            back_b.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            back_b.setOnAction(e -> {
                start(stage);
            });

            if (state == 1) {
                Button b3 = new Button("English");
                b3.setTranslateX(40);
                b3.setTranslateY(10);
                //b3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
                //b3.setOnAction(this);

                Button b2 = new Button("Hindi");
                b2.setTranslateX(110);
                b2.setTranslateY(10);
                //b2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
                //b2.setOnAction(this);

                StackPane pane = new StackPane();
                pane.getChildren().addAll(iv4, iv, b1, b2, b3, back_b);
                Scene scene = new Scene(pane, 1000, 800);
                stage.setScene(scene);
                stage.show();
            } else {
                StackPane pane = new StackPane();
                pane.getChildren().addAll(iv, b1, back_b);
                Scene scene = new Scene(pane, 1000, 800);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    class exit implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }

    class menu implements EventHandler<ActionEvent> {

        Stage stage;

        public menu(Stage stage) {
            this.stage = stage;
        }

        @Override
        public void handle(ActionEvent event) {
            stage.setTitle("Plants v/s zombies");
            Image image = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\w.gif");//image location
            ImageView iv = new ImageView();//object to use image
            iv.setImage(image);
            iv.setFitHeight(600);//set height of image
            iv.setFitWidth(1000);//set width of image

            Image playI1 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\start.jpg");
            ImageView iv1 = new ImageView(playI1);
            iv1.setFitHeight(50);
            iv1.setFitWidth(100);
            //iv1.setFitHeight(67);
            //iv1.setFitWidth(69);//buttons can be customized from here

            Image playI2 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\load.jpg");
            ImageView iv2 = new ImageView(playI2);
            iv2.setFitHeight(50);
            iv2.setFitWidth(100);

            Image playI3 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\options.jpg");
            ImageView iv3 = new ImageView(playI3);
            iv3.setFitHeight(50);
            iv3.setFitWidth(100);

            Image playI4 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\exit.jpg");
            ImageView iv4 = new ImageView(playI4);
            iv4.setFitHeight(50);
            iv4.setFitWidth(100);

            Button b1 = new Button("", iv1);//to set graphics in button
            b1.setTranslateX(-300);//to set x and y coordinates of button
            b1.setTranslateY(10);
            b1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b1.setOnAction(new start(stage));

            Button b2 = new Button("", iv2);//to set graphics in button
            b2.setTranslateX(-300);//to set x and y coordinates of button
            b2.setTranslateY(100);
            b2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b2.setOnAction(new load(stage));

            Button b3 = new Button("", iv3);//to set graphics in button
            b3.setTranslateX(-300);//to set x and y coordinates of button
            b3.setTranslateY(180);
            b3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b3.setOnAction(new options(stage));

            Button b4 = new Button("", iv4);//to set graphics in button
            b4.setTranslateX(-300);//to set x and y coordinates of button
            b4.setTranslateY(270);
            b4.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b4.setOnAction(new exit());

            StackPane pane = new StackPane();
            pane.getChildren().addAll(iv, b1, b2, b3, b4);
            Scene scene = new Scene(pane, 1000, 800);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void start(Stage stage) {
        //stage.setFullScreen(true);
        mediaPlayer.play();

        stage.setTitle("Plants v/s zombies");
        Image image = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\screen2.png");//image location
        ImageView iv = new ImageView();//object to use image
        iv.setImage(image);
        iv.setFitHeight(600);//set height of image
        iv.setFitWidth(1000);//set width of image

        Image playI1 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\new_game.png");
        ImageView iv1 = new ImageView(playI1);
        iv1.setFitHeight(50);
        iv1.setFitWidth(150);
        //iv1.setFitHeight(67);
        //iv1.setFitWidth(69);//buttons can be customized from here

        Image playI2 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\load_game.png");
        ImageView iv2 = new ImageView(playI2);
        iv2.setFitHeight(50);
        iv2.setFitWidth(150);
        
        //Image choose = new Image();
        

        Image playI3 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\options.png");
        ImageView iv3 = new ImageView(playI3);
        iv3.setFitHeight(50);
        iv3.setFitWidth(140);

        Image playI4 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\exit.png");
        ImageView iv4 = new ImageView(playI4);
        iv4.setFitHeight(50);
        iv4.setFitWidth(130);
        
        Image choose = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\choose_level.png");
        ImageView iv5 = new ImageView(choose);
        iv5.setFitHeight(50);
        iv5.setFitWidth(150);
        
        

        Button b1 = new Button("", iv1);//to set graphics in button
        b1.setTranslateX(0);//to set x and y coordinates of button
        b1.setTranslateY(-70);
        b1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        b1.setOnAction(new start(stage));

        Button b2 = new Button("", iv2);//to set graphics in button
        b2.setTranslateX(0);//to set x and y coordinates of button
        b2.setTranslateY(10);
        b2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        b2.setOnAction(new load(stage));
        
        Button b5 = new Button("", iv5);//to set graphics in button
        b5.setTranslateX(0);//to set x and y coordinates of button
        b5.setTranslateY(90);
        b5.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        b5.setOnAction(e -> {
                load l = new load(stage);
                l.change_level(-390, -175);
            });

        Button b3 = new Button("", iv3);//to set graphics in button
        b3.setTranslateX(0);//to set x and y coordinates of button
        b3.setTranslateY(170);
        b3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        b3.setOnAction(new options(stage));

        Button b4 = new Button("", iv4);//to set graphics in button
        b4.setTranslateX(0);//to set x and y coordinates of button
        b4.setTranslateY(250);
        b4.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        b4.setOnAction(new exit());
        
        

        StackPane pane = new StackPane();
        pane.getChildren().addAll(iv, b1, b2, b3, b4, b5);
        Scene scene = new Scene(pane, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
