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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.TimerTask;
import javafx.scene.layout.TilePane;

class game_level3 implements EventHandler<ActionEvent> {
    
        static ArrayList<String> users_names = new ArrayList<String>();
    int sun_value = 0;
    Button sun2;
    

    ImageView zombie1 = new ImageView();//zombie imageview
    ImageView zombie2 = new ImageView();//zombie imageview
    ImageView zombie3 = new ImageView();//zombie imageview
    ImageView zombie4 = new ImageView();//zombie imageview
    ImageView zombie5 = new ImageView();//zombie imageview

    ImageView lawnmover1 = new ImageView();//zombie imageview
    ImageView lawnmover2 = new ImageView();//zombie imageview
    ImageView lawnmover3 = new ImageView();//zombie imageview
    ImageView lawnmover4 = new ImageView();//zombie imageview
    ImageView lawnmover5 = new ImageView();//zombie imageview

    PathTransition zombie_t1 = new PathTransition();
    PathTransition zombie_t2 = new PathTransition();
    PathTransition zombie_t3 = new PathTransition();
    PathTransition zombie_t4 = new PathTransition();
    PathTransition zombie_t5 = new PathTransition();

    int count[] = new int[5];//lawnmover once moved or not

    ImageView pea[] = new ImageView[45];

    Line l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    Button b1, b2, b3, b4;
    TextField player1;

    int flag = 0;

    int tile[] = new int[50];// can be changed later
    int t_no = 6;//check each tile at a time

    int t_row1 = 8;//check each tile at a time
    int t_row2 = 8;//check each tile at a time
    int t_row3 = 8;//check each tile at a time
    int t_row4 = 8;//check each tile at a time
    int t_row5 = 8;//check each tile at a time

    int attacks1 = 0;
    int attacks2 = 0;
    int attacks3 = 0;
    int attacks4 = 0;
    int attacks5 = 0;

    int collision[] = new int[5];
    String path = "";
    Image PLANT = new Image("file:C:\\Users\\anand\\Desktop\\plants vs zombies\\plants animation\\abcdef.gif");
    //plant image
    ImageView plant_1 = new ImageView();
    ImageView plant_2 = new ImageView();
    ImageView plant_3 = new ImageView();
    ImageView plant_4 = new ImageView();
    ImageView plant_5 = new ImageView();
    ImageView plant_6 = new ImageView();
    ImageView plant_7 = new ImageView();
    ImageView plant_8 = new ImageView();
    ImageView plant_9 = new ImageView();
    ImageView plant_10 = new ImageView();
    ImageView plant_11 = new ImageView();
    ImageView plant_12 = new ImageView();
    ImageView plant_13 = new ImageView();
    ImageView plant_14 = new ImageView();
    ImageView plant_15 = new ImageView();
    ImageView plant_16 = new ImageView();
    ImageView plant_17 = new ImageView();
    ImageView plant_18 = new ImageView();
    ImageView plant_19 = new ImageView();
    ImageView plant_20 = new ImageView();
    ImageView plant_21 = new ImageView();
    ImageView plant_22 = new ImageView();
    ImageView plant_23 = new ImageView();
    ImageView plant_24 = new ImageView();
    ImageView plant_25 = new ImageView();
    ImageView plant_26 = new ImageView();
    ImageView plant_27 = new ImageView();
    ImageView plant_28 = new ImageView();
    ImageView plant_29 = new ImageView();
    ImageView plant_30 = new ImageView();
    ImageView plant_31 = new ImageView();
    ImageView plant_32 = new ImageView();
    ImageView plant_33 = new ImageView();
    ImageView plant_34 = new ImageView();
    ImageView plant_35 = new ImageView();
    ImageView plant_36 = new ImageView();
    ImageView plant_37 = new ImageView();
    ImageView plant_38 = new ImageView();
    ImageView plant_39 = new ImageView();
    ImageView plant_40 = new ImageView();
    ImageView plant_41 = new ImageView();
    ImageView plant_42 = new ImageView();
    ImageView plant_43 = new ImageView();
    ImageView plant_44 = new ImageView();
    ImageView plant_45 = new ImageView();

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

    class tester1 implements EventHandler<ActionEvent> {

        ImageView zombie;
        int start_x = 0;
        int end_x = 0;
        int start_y = 0;
        int end_y = 0;

        public tester1(PathTransition anim, ImageView zombie, int start_x, int start_y, int end_x, int end_y) {
            zombie_t1 = anim;
            this.zombie = zombie;
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //Line l=new Line(880,300,800,300);

            Line l = new Line(start_x, start_y, end_x, end_y);

            collision[0] = 0;

            if (t_row1 >= 0 && tile[t_row1] == 1) {
                collision[0] = 1;
                System.out.println("Collision detected");
                zombie_t1.pause();

                //fighting conditions here
            }
            if (collision[0] == 0) {
                t_row1--;
                //System.out.println("Zombie ="+zombie.translateXProperty().get());
                zombie_t1.setPath(l);
                zombie_t1.setCycleCount(1);
                zombie_t1.setRate(1.2);
                zombie_t1.play();

                if (end_x > 250) {
                    zombie_t1.setOnFinished(new tester1(zombie_t1, zombie, end_x, end_y, end_x - 90, end_y));
                } else {
                    zombie_t1.stop();
                    zombie1.setImage(null);

                    if (count[0] == 0) {
                        count[0] = 1;
                        Image i = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
                        lawnmover1.setImage(i);
                        Line l4 = new Line(250, 190, 1500, 190);
                        PathTransition lawn = new PathTransition();
                        lawn.setNode(lawnmover1);
                        lawn.setPath(l4);
                        lawn.setDuration(new Duration(6000));
                        lawn.setCycleCount(1);
                        lawn.setRate(4);//set speed
                        lawn.play();
                    }
                }
            }
        }
    }

    class tester2 implements EventHandler<ActionEvent> {

        ImageView zombie;
        int start_x = 0;
        int end_x = 0;
        int start_y = 0;
        int end_y = 0;

        public tester2(PathTransition anim, ImageView zombie, int start_x, int start_y, int end_x, int end_y) {
            zombie_t2 = anim;
            this.zombie = zombie;
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //Line l=new Line(880,300,800,300);

            System.out.println("start_x = " + start_x);
            System.out.println("start_y = " + start_y);
            Line l = new Line(start_x, start_y, end_x, end_y);

            collision[1] = 0;

            if (t_row2 >= 0 && tile[9 + t_row2] == 1) {
                collision[1] = 1;
                System.out.println("current tile =" + (9 + t_row2));
                System.out.println("current column = " + t_row2);
                System.out.println("Collision detected");
                zombie_t2.pause();
                //fighting conditions here
            }
            if (collision[1] == 0) {
                t_row2--;
                System.out.println("t_row2 -- " + t_row2);
                //System.out.println("Zombie ="+zombie.translateXProperty().get());
                zombie_t2.setPath(l);
                zombie_t2.setCycleCount(1);
                zombie_t2.setRate(1);
                zombie_t2.play();

                if (end_x > 250) {
                    zombie_t2.setOnFinished(new tester2(zombie_t2, zombie, end_x, end_y, end_x - 90, end_y));
                } else {
                    zombie_t2.stop();
                    zombie2.setImage(null);

                    if (count[1] == 0) {
                        count[1] = 1;
                        Image i = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
                        lawnmover2.setImage(i);
                        Line l4 = new Line(250, 300, 1500, 300);
                        PathTransition lawn = new PathTransition();
                        lawn.setNode(lawnmover2);
                        lawn.setPath(l4);
                        lawn.setDuration(new Duration(6000));
                        lawn.setCycleCount(1);
                        lawn.setRate(4);//set speed
                        lawn.play();
                    }
                }
            }
        }
    }

    class tester3 implements EventHandler<ActionEvent> {

        ImageView zombie;
        int start_x = 0;
        int end_x = 0;
        int start_y = 0;
        int end_y = 0;

        public tester3(PathTransition anim, ImageView zombie, int start_x, int start_y, int end_x, int end_y) {
            zombie_t3 = anim;
            this.zombie = zombie;
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //Line l=new Line(880,300,800,300);

            Line l = new Line(start_x, start_y, end_x, end_y);

            collision[2] = 0;

            if (t_row3 >= 0 && tile[18 + t_row3] == 1) {
                collision[2] = 1;
                System.out.println("Collision detected");
                zombie_t3.pause();

                //fighting conditions here
            }
            if (collision[2] == 0) {
                t_row3--;
                //System.out.println("Zombie ="+zombie.translateXProperty().get());
                zombie_t3.setPath(l);
                zombie_t3.setCycleCount(1);
                zombie_t3.setRate(0.7);
                zombie_t3.play();

                if (end_x > 250) {
                    zombie_t3.setOnFinished(new tester3(zombie_t3, zombie, end_x, end_y, end_x - 90, end_y));
                } else {
                    zombie_t3.stop();
                    zombie3.setImage(null);

                    if (count[2] == 0) {
                        count[2] = 1;
                        Image i = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
                        lawnmover3.setImage(i);
                        Line l4 = new Line(250, 420, 1500, 420);
                        PathTransition lawn = new PathTransition();
                        lawn.setNode(lawnmover3);
                        lawn.setPath(l4);
                        lawn.setDuration(new Duration(6000));
                        lawn.setCycleCount(1);
                        lawn.setRate(4);//set speed
                        lawn.play();
                    }
                }
            }
        }
    }

    class tester4 implements EventHandler<ActionEvent> {

        ImageView zombie;
        int start_x = 0;
        int end_x = 0;
        int start_y = 0;
        int end_y = 0;

        public tester4(PathTransition anim, ImageView zombie, int start_x, int start_y, int end_x, int end_y) {
            zombie_t4 = anim;
            this.zombie = zombie;
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //Line l=new Line(880,300,800,300);

            Line l = new Line(start_x, start_y, end_x, end_y);

            collision[3] = 0;

            if (t_row4 >= 0 && tile[27 + t_row4] == 1) {
                collision[3] = 1;
                System.out.println("Collision detected");
                zombie_t4.pause();

                //fighting conditions here
            }
            if (collision[3] == 0) {
                t_row4--;
                //System.out.println("Zombie ="+zombie.translateXProperty().get());
                zombie_t4.setPath(l);
                zombie_t4.setCycleCount(1);
                zombie_t4.setRate(1.2);
                zombie_t4.play();

                if (end_x > 250) {
                    zombie_t4.setOnFinished(new tester4(zombie_t4, zombie, end_x, end_y, end_x - 90, end_y));
                } else {
                    zombie_t4.stop();
                    zombie4.setImage(null);

                    if (count[3] == 0) {
                        count[3] = 1;
                        Image i = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
                        lawnmover4.setImage(i);
                        Line l4 = new Line(250, 550, 1500, 550);
                        PathTransition lawn = new PathTransition();
                        lawn.setNode(lawnmover4);
                        lawn.setPath(l4);
                        lawn.setDuration(new Duration(6000));
                        lawn.setCycleCount(1);
                        lawn.setRate(4);//set speed
                        lawn.play();
                    }
                }
            }
        }
    }

    class tester5 implements EventHandler<ActionEvent> {

        ImageView zombie;
        int start_x = 0;
        int end_x = 0;
        int start_y = 0;
        int end_y = 0;

        public tester5(PathTransition anim, ImageView zombie, int start_x, int start_y, int end_x, int end_y) {
            zombie_t5 = anim;
            this.zombie = zombie;
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //Line l=new Line(880,300,800,300);

            Line l = new Line(start_x, start_y, end_x, end_y);

            collision[4] = 0;

            if (t_row5 >= 0 && tile[36 + t_row5] == 1) {
                collision[4] = 1;
                System.out.println("Collision detected");
                zombie_t5.pause();

                //fighting conditions here
            }
            if (collision[4] == 0) {
                t_row5--;
                //System.out.println("Zombie ="+zombie.translateXProperty().get());
                zombie_t5.setPath(l);
                zombie_t5.setCycleCount(1);
                zombie_t5.setRate(1);
                zombie_t5.play();

                if (end_x > 250) {
                    zombie_t5.setOnFinished(new tester5(zombie_t5, zombie, end_x, end_y, end_x - 90, end_y));
                } else {
                    zombie_t5.stop();
                    zombie5.setImage(null);

                    if (count[4] == 0) {
                        count[4] = 1;
                        Image i = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
                        lawnmover5.setImage(i);
                        Line l4 = new Line(250, 670, 1500, 670);
                        PathTransition lawn = new PathTransition();
                        lawn.setNode(lawnmover5);
                        lawn.setPath(l4);
                        lawn.setDuration(new Duration(6000));
                        lawn.setCycleCount(1);
                        lawn.setRate(4);//set speed
                        lawn.play();
                    }
                }
            }
        }
    }

    class sun_class implements EventHandler<ActionEvent> {

        PathTransition sun;
        Button b;

        public sun_class(PathTransition sun, Button b) {
            this.sun = sun;
            this.b = b;
        }

        @Override
        public void handle(ActionEvent event) {
            Random rand = new Random();
            int x = rand.nextInt(300) + 500;
            Line l = new Line(x, -40, x, 500);
            sun = new PathTransition();
            sun.setNode(b);
            sun.setPath(l);

            sun.setDuration(new Duration(6000));
            sun.setCycleCount(1000);
            sun.setRate(0.7);//set speed
            sun.play();

            sun_value += 10;
            sun2.setText(Integer.toString(sun_value));
            sun.setDelay(new Duration(2000));
            //try{b.wait(5000);}catch(Exception e) {}
        }
    }

    class plante1 implements EventHandler<ActionEvent> {

        int x = 0;
        int y = 0;
        ImageView plant;
        int fx = 0;

        public plante1(int x, int y, ImageView plant, int fx) {
            this.x = x;
            this.y = y;
            this.plant = plant;
            this.fx = fx;
        }

        @Override
        public void handle(ActionEvent event) {
            tile[fx] = 1;//means we have applied plant on that tile
            System.out.println(fx);

            plant.setImage(PLANT);
            plant.setFitHeight(130);//set height of image
            plant.setFitWidth(100);
            plant.setTranslateX(x);
            plant.setTranslateY(y);

            PathTransition anim1 = new PathTransition();
            anim1.setNode(plant);
            anim1.setDuration(new Duration(6000));
            anim1.setCycleCount(1000);
            anim1.setRate(0.4);//set speed
            anim1.play();
            PLANT = null;
            if (path.equals("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\abcdef.gif")) {
                
                Image PEA = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\pea.png");
                pea[fx].setImage(PEA);
                pea[fx].setFitHeight(20);//set height of image
                pea[fx].setFitWidth(20);

                Line l = new Line(plant.translateXProperty().get() + 90, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea[fx]);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack1(pea[fx], plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, 0));
                path = "";
            }

        }
    }

    class pea_attack1 implements EventHandler<ActionEvent> {

        ImageView pea;
        double start_x;
        double safe_x;
        double start_y;
        double safe_y;

        public pea_attack1(ImageView pea, double x1, double y1, double safe_x, double safe_y, int at) {
            this.pea = pea;
            start_x = x1;
            this.safe_x = safe_x;
            start_y = y1;
            this.safe_y = safe_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //this.pea.setImage(null);
            Line l = new Line(start_x, start_y, start_x + 30, start_y);

            if (attacks1 == 50) {
                zombie1.setImage(null);

                //respawn zombies
                collision[0] = 0;
                attacks1 = 0;//reload
                Image ZOMBIE = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");
                zombie1.setImage(ZOMBIE);

                t_row1 = 8;
                zombie_t1.stop();
                Line l2 = new Line(1200, 150, 1120, 150);
                PathTransition zomb = new PathTransition();
                zomb.setNode(zombie1);
                zomb.setPath(l2);
                zomb.setDuration(new Duration(6000));
                zomb.setCycleCount(1);
                zomb.setRate(0.4);//set speed
                zomb.play();
                System.out.println("reached");
                zomb.setOnFinished(new tester1(zomb, zombie1, 1200, 150, 1120, 150));

                //pea restart
                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition Pea = new PathTransition();
                Pea.setNode(pea);
                Pea.setDuration(new Duration(6000));
                Pea.setCycleCount(1);
                Pea.setPath(l);
                Pea.setRate(25);//set speed
                Pea.play();
                Pea.setOnFinished(new pea_attack1(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks1));
            } else if (start_x >= zombie1.translateXProperty().get()) {
                attacks1++;
                System.out.println("attacks1 = " + attacks1);

                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack1(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks1));
            } else {
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack1(pea, start_x + 30, start_y, this.safe_x, this.safe_y, attacks1));
            }
        }
    }

    class plante2 implements EventHandler<ActionEvent> {

        int x = 0;
        int y = 0;
        ImageView plant;
        int fx = 0;

        public plante2(int x, int y, ImageView plant, int fx) {
            this.x = x;
            this.y = y;
            this.plant = plant;
            this.fx = fx;
        }

        @Override
        public void handle(ActionEvent event) {
            tile[fx] = 1;//means we have applied plant on that tile
            System.out.println(fx);

            plant.setImage(PLANT);
            plant.setFitHeight(130);//set height of image
            plant.setFitWidth(100);
            plant.setTranslateX(x);
            plant.setTranslateY(y);

            PathTransition anim1 = new PathTransition();
            anim1.setNode(plant);
            anim1.setDuration(new Duration(6000));
            anim1.setCycleCount(1000);
            anim1.setRate(0.4);//set speed
            anim1.play();
            PLANT = null;
            if (path.equals("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\abcdef.gif")) {
                Image PEA = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\pea.png");
                pea[fx].setImage(PEA);
                pea[fx].setFitHeight(20);//set height of image
                pea[fx].setFitWidth(20);

                Line l = new Line(plant.translateXProperty().get() + 90, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea[fx]);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack2(pea[fx], plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, 0));
                path = "";
            }
        }
    }

    class pea_attack2 implements EventHandler<ActionEvent> {

        ImageView pea;
        double start_x;
        double safe_x;
        double start_y;
        double safe_y;

        public pea_attack2(ImageView pea, double x1, double y1, double safe_x, double safe_y, int at) {
            this.pea = pea;
            start_x = x1;
            this.safe_x = safe_x;
            start_y = y1;
            this.safe_y = safe_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //this.pea.setImage(null);
            Line l = new Line(start_x, start_y, start_x + 30, start_y);

            if (attacks2 == 20) {
                zombie2.setImage(null);

                //respawn zombies
                collision[1] = 0;
                attacks2 = 0;//reload
                Image ZOMBIE = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");
                zombie2.setImage(ZOMBIE);

                t_row2 = 8;
                zombie_t2.stop();
                Line l2 = new Line(1400, 300, 1120, 300);
                PathTransition zomb = new PathTransition();
                zomb.setNode(zombie2);
                zomb.setPath(l2);
                zomb.setDuration(new Duration(6000));
                zomb.setCycleCount(1);
                zomb.setRate(0.4);//set speed
                zomb.play();
                System.out.println("reached");
                zomb.setOnFinished(new tester2(zomb, zombie2, 1400, 300, 1120, 300));

                //pea restart
                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition Pea = new PathTransition();
                Pea.setNode(pea);
                Pea.setDuration(new Duration(6000));
                Pea.setCycleCount(1);
                Pea.setPath(l);
                Pea.setRate(25);//set speed
                Pea.play();
                Pea.setOnFinished(new pea_attack2(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks2));

            } else if (start_x >= zombie2.translateXProperty().get()) {
                System.out.println("Properties:-");
                System.out.println(start_x);
                System.out.println(zombie2.translateXProperty().get());
                attacks2++;
                System.out.println("attacks2 = " + attacks2);

                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack2(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks2));
            } else {
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack2(pea, start_x + 30, start_y, this.safe_x, this.safe_y, attacks2));
            }
        }
    }

    class plante3 implements EventHandler<ActionEvent> {

        int x = 0;
        int y = 0;
        ImageView plant;
        int fx = 0;

        public plante3(int x, int y, ImageView plant, int fx) {
            this.x = x;
            this.y = y;
            this.plant = plant;
            this.fx = fx;
        }

        @Override
        public void handle(ActionEvent event) {
            tile[fx] = 1;//means we have applied plant on that tile
            System.out.println(fx);

            plant.setImage(PLANT);
            plant.setFitHeight(130);//set height of image
            plant.setFitWidth(100);
            plant.setTranslateX(x);
            plant.setTranslateY(y);

            PathTransition anim1 = new PathTransition();
            anim1.setNode(plant);
            anim1.setDuration(new Duration(6000));
            anim1.setCycleCount(1000);
            anim1.setRate(0.4);//set speed
            anim1.play();
            PLANT = null;
            if (path.equals("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\abcdef.gif")) {
                Image PEA = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\pea.png");
                pea[fx].setImage(PEA);
                pea[fx].setFitHeight(20);//set height of image
                pea[fx].setFitWidth(20);

                Line l = new Line(plant.translateXProperty().get() + 90, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea[fx]);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack3(pea[fx], plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, 0));
                path = "";
            }
        }
    }

    class pea_attack3 implements EventHandler<ActionEvent> {

        ImageView pea;
        double start_x;
        double safe_x;
        double start_y;
        double safe_y;

        public pea_attack3(ImageView pea, double x1, double y1, double safe_x, double safe_y, int at) {
            this.pea = pea;
            start_x = x1;
            this.safe_x = safe_x;
            start_y = y1;
            this.safe_y = safe_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //this.pea.setImage(null);
            Line l = new Line(start_x, start_y, start_x + 30, start_y);

            if (attacks3 == 10) {
                zombie3.setImage(null);

                //respawn zombies
                collision[2] = 0;
                attacks3 = 0;//reload
                Image ZOMBIE = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");
                zombie3.setImage(ZOMBIE);

                t_row3 = 8;
                zombie_t3.stop();
                Line l2 = new Line(1600, 420, 1120, 420);
                PathTransition zomb = new PathTransition();
                zomb.setNode(zombie3);
                zomb.setPath(l2);
                zomb.setDuration(new Duration(6000));
                zomb.setCycleCount(1);
                zomb.setRate(0.4);//set speed
                zomb.play();
                System.out.println("reached");
                zomb.setOnFinished(new tester3(zomb, zombie3, 1600, 420, 1120, 420));

                //pea restart
                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition Pea = new PathTransition();
                Pea.setNode(pea);
                Pea.setDuration(new Duration(6000));
                Pea.setCycleCount(1);
                Pea.setPath(l);
                Pea.setRate(25);//set speed
                Pea.play();
                Pea.setOnFinished(new pea_attack3(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks3));
            } else if (start_x >= zombie3.translateXProperty().get()) {
                attacks3++;
                System.out.println("attacks3 = " + attacks3);

                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack3(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks3));
            } else {
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack3(pea, start_x + 30, start_y, this.safe_x, this.safe_y, attacks3));
            }
        }
    }

    class plante4 implements EventHandler<ActionEvent> {

        int x = 0;
        int y = 0;
        ImageView plant;
        int fx = 0;

        public plante4(int x, int y, ImageView plant, int fx) {
            this.x = x;
            this.y = y;
            this.plant = plant;
            this.fx = fx;
        }

        @Override
        public void handle(ActionEvent event) {
            tile[fx] = 1;//means we have applied plant on that tile
            System.out.println(fx);

            plant.setImage(PLANT);
            plant.setFitHeight(130);//set height of image
            plant.setFitWidth(100);
            plant.setTranslateX(x);
            plant.setTranslateY(y);

            PathTransition anim1 = new PathTransition();
            anim1.setNode(plant);
            anim1.setDuration(new Duration(6000));
            anim1.setCycleCount(1000);
            anim1.setRate(0.4);//set speed
            anim1.play();
            PLANT = null;
            if (path.equals("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\abcdef.gif")) {
                Image PEA = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\pea.png");
                pea[fx].setImage(PEA);
                pea[fx].setFitHeight(20);//set height of image
                pea[fx].setFitWidth(20);

                Line l = new Line(plant.translateXProperty().get() + 90, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea[fx]);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack4(pea[fx], plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, 0));
                path = "";
            }
        }
    }

    class pea_attack4 implements EventHandler<ActionEvent> {

        ImageView pea;
        double start_x;
        double safe_x;
        double start_y;
        double safe_y;

        public pea_attack4(ImageView pea, double x1, double y1, double safe_x, double safe_y, int at) {
            this.pea = pea;
            start_x = x1;
            this.safe_x = safe_x;
            start_y = y1;
            this.safe_y = safe_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //this.pea.setImage(null);
            Line l = new Line(start_x, start_y, start_x + 30, start_y);

            if (attacks4 == 10) {
                zombie4.setImage(null);

                //respawn zombies
                collision[3] = 0;
                attacks4 = 0;//reload
                Image ZOMBIE = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");
                zombie4.setImage(ZOMBIE);

                t_row4 = 8;
                zombie_t4.stop();
                Line l2 = new Line(1800, 550, 1120, 550);
                PathTransition zomb = new PathTransition();
                zomb.setNode(zombie4);
                zomb.setPath(l2);
                zomb.setDuration(new Duration(6000));
                zomb.setCycleCount(1);
                zomb.setRate(0.4);//set speed
                zomb.play();
                System.out.println("reached");
                zomb.setOnFinished(new tester4(zomb, zombie4, 1800, 550, 1120, 550));

                //pea restart
                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition Pea = new PathTransition();
                Pea.setNode(pea);
                Pea.setDuration(new Duration(6000));
                Pea.setCycleCount(1);
                Pea.setPath(l);
                Pea.setRate(25);//set speed
                Pea.play();
                Pea.setOnFinished(new pea_attack4(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks4));
            } else if (start_x >= zombie4.translateXProperty().get()) {
                attacks4++;
                System.out.println("attacks4 = " + attacks4);

                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack4(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks4));
            } else {
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack4(pea, start_x + 30, start_y, this.safe_x, this.safe_y, attacks4));
            }
        }
    }

    class plante5 implements EventHandler<ActionEvent> {

        int x = 0;
        int y = 0;
        ImageView plant;
        int fx = 0;

        public plante5(int x, int y, ImageView plant, int fx) {
            this.x = x;
            this.y = y;
            this.plant = plant;
            this.fx = fx;
        }

        @Override
        public void handle(ActionEvent event) {
            tile[fx] = 1;//means we have applied plant on that tile
            System.out.println(fx);

            plant.setImage(PLANT);
            plant.setFitHeight(130);//set height of image
            plant.setFitWidth(100);
            plant.setTranslateX(x);
            plant.setTranslateY(y);

            PathTransition anim1 = new PathTransition();
            anim1.setNode(plant);
            anim1.setDuration(new Duration(6000));
            anim1.setCycleCount(1000);
            anim1.setRate(0.4);//set speed
            anim1.play();
            PLANT = null;
            
            
            if (path.equals("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\abcdef.gif")) {
                Image PEA = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\pea.png");
                pea[fx].setImage(PEA);
                pea[fx].setFitHeight(20);//set height of image
                pea[fx].setFitWidth(20);

                Line l = new Line(plant.translateXProperty().get() + 90, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea[fx]);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack5(pea[fx], plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, plant.translateXProperty().get() + 120, plant.translateYProperty().get() + 50, 0));
                path = "";
            }
        }
    }

    class pea_attack5 implements EventHandler<ActionEvent> {

        ImageView pea;
        double start_x;
        double safe_x;
        double start_y;
        double safe_y;

        public pea_attack5(ImageView pea, double x1, double y1, double safe_x, double safe_y, int at) {
            this.pea = pea;
            start_x = x1;
            this.safe_x = safe_x;
            start_y = y1;
            this.safe_y = safe_y;
        }

        @Override
        public void handle(ActionEvent event) {
            //this.pea.setImage(null);
            Line l = new Line(start_x, start_y, start_x + 30, start_y);

            if (attacks5 == 10) {
                zombie5.setImage(null);

                //respawn zombies
                collision[4] = 0;
                attacks5 = 0;//reload
                Image ZOMBIE = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");
                zombie5.setImage(ZOMBIE);

                t_row5 = 8;
                zombie_t5.stop();
                Line l2 = new Line(2000, 670, 1120, 670);
                PathTransition zomb = new PathTransition();
                zomb.setNode(zombie5);
                zomb.setPath(l2);
                zomb.setDuration(new Duration(6000));
                zomb.setCycleCount(1);
                zomb.setRate(0.4);//set speed
                zomb.play();
                System.out.println("reached");
                zomb.setOnFinished(new tester5(zomb, zombie5, 2000, 670, 1120, 670));

                //pea restart
                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition Pea = new PathTransition();
                Pea.setNode(pea);
                Pea.setDuration(new Duration(6000));
                Pea.setCycleCount(1);
                Pea.setPath(l);
                Pea.setRate(25);//set speed
                Pea.play();
                Pea.setOnFinished(new pea_attack5(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks5));
            } else if (start_x >= zombie5.translateXProperty().get()) {
                attacks5++;
                System.out.println("attacks5 = " + attacks5);

                l = new Line(safe_x, safe_y, safe_x + 30, safe_y);
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack5(pea, safe_x + 30, safe_y, this.safe_x, this.safe_y, attacks5));
            } else {
                PathTransition anim2 = new PathTransition();
                anim2.setNode(pea);
                anim2.setDuration(new Duration(6000));
                anim2.setCycleCount(1);
                anim2.setPath(l);
                anim2.setRate(25);//set speed
                anim2.play();
                anim2.setOnFinished(new pea_attack5(pea, start_x + 30, start_y, this.safe_x, this.safe_y, attacks5));
            }
        }
    }

    class buy_plants implements EventHandler<ActionEvent> {

        String s;
        int cost;

        public buy_plants(String s, int i) {
            this.s = s;
            this.cost = i;
        }

        @Override
        public void handle(ActionEvent event) {
            if (cost <= sun_value) {
                PLANT = new Image(s);
                path = s;
                sun_value = sun_value - cost;
                sun2.setText(Integer.toString(sun_value));
            }

        }
    }
    
    class won implements EventHandler<ActionEvent>{
        Stage stage;
        
        public won(Stage stage){
            this.stage = stage;
        }
        @Override
        public void handle(ActionEvent event) {
            Button b = new Button("You won the Game");
            Scene scene = new Scene(b, 1500, 800);
            stage.setScene(scene);
            stage.show();
        }
        
    }
    
        private game_level3() {
        }

        class game1 extends TimerTask {

            ImageView zombie;
            Button test;

            public game1(ImageView i, Button test) {
                this.zombie = i;
                this.test = test;
            }

            private game1() {
            }

            @Override
            public void run() {/*
                System.out.println("IN THE INNER CLASS");
                test.fire();
                test.setOnAction(e -> {
                    System.out.println(zombie.translateXProperty().get());
                });*/

            }

        }

        Stage stage;
        //String img_path="";

        public game_level3(Stage stage, String s, int flag) {
            this.stage = stage;
            this.flag = flag;
            //img_path=s;

        }

        @Override
        public void handle(ActionEvent event) {
            
            // Timer
            new Reminder(240);
            System.out.println("Task scheduled.");

            Image time = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\bar.jpeg");
            ImageView time_view = new ImageView(time);
            time_view.setFitHeight(50);
            time_view.setFitWidth(300);
            time_view.setTranslateX(700);
            time_view.setTranslateY(0);

            Image head = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\head.png");
            ImageView head_view = new ImageView(head);
            head_view.setFitHeight(50);
            head_view.setFitWidth(50);

            PathTransition head_p = new PathTransition();
            head_p.setNode(head_view);
            head_p.setPath(new Line(1000, 20, 700, 20));
            head_p.setDuration(new Duration(240000));
            head_p.setCycleCount(1);
            head_p.play();

            head_p.setOnFinished(new won(stage));

            // timer ends
            

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

            //____________________tiles button_____________________________//
            Button button1 = new Button("button");
            button1.setMinSize(90, 120);
            button1.setOnAction(new plante1(350, 130, plant_1, 0));
            //button1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button2 = new Button("button");
            button2.setMinSize(90, 120);
            button2.setOnAction(new plante1(440, 130, plant_2, 1));
            //button2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button3 = new Button("button");
            button3.setMinSize(90, 120);
            button3.setOnAction(new plante1(530, 130, plant_3, 2));
            //button3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button4 = new Button("button");
            button4.setMinSize(90, 120);
            button4.setOnAction(new plante1(620, 130, plant_4, 3));
            //button4.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button5 = new Button("button");
            button5.setMinSize(90, 120);
            button5.setOnAction(new plante1(710, 130, plant_5, 4));
            //button5.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button6 = new Button("button");
            button6.setMinSize(90, 120);
            button6.setOnAction(new plante1(800, 130, plant_6, 5));
            //button6.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button7 = new Button("button");
            button7.setMinSize(90, 120);
            button7.setOnAction(new plante1(890, 130, plant_7, 6));
            //button7.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button8 = new Button("button");
            button8.setMinSize(90, 120);
            button8.setOnAction(new plante1(980, 130, plant_8, 7));
            //button8.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button9 = new Button("button");
            button9.setMinSize(90, 120);
            button9.setOnAction(new plante1(1070, 130, plant_9, 8));
            //button9.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button10 = new Button("button");
            button10.setMinSize(90, 120);
            button10.setOnAction(new plante2(350, 250, plant_10, 9));
            //button10.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button11 = new Button("button");
            button11.setMinSize(90, 120);
            button11.setOnAction(new plante2(440, 250, plant_11, 10));
            //button11.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button12 = new Button("button");
            button12.setMinSize(90, 120);
            button12.setOnAction(new plante2(530, 250, plant_12, 11));
            //button12.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button13 = new Button("button");
            button13.setMinSize(90, 120);
            button13.setOnAction(new plante2(620, 250, plant_13, 12));
            //button13.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button14 = new Button("button");
            button14.setMinSize(90, 120);
            button14.setOnAction(new plante2(710, 250, plant_14, 13));
            //button14.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            Button button15 = new Button("button");
            button15.setMinSize(90, 120);
            button15.setOnAction(new plante2(800, 250, plant_15, 14));

            Button button16 = new Button("button");
            button16.setMinSize(90, 120);
            button16.setOnAction(new plante2(890, 250, plant_16, 15));

            Button button17 = new Button("button");
            button17.setMinSize(90, 120);
            button17.setOnAction(new plante2(980, 250, plant_17, 16));

            Button button18 = new Button("button");
            button18.setMinSize(90, 120);
            button18.setOnAction(new plante2(1070, 250, plant_18, 17));

            Button button19 = new Button("button");
            button19.setMinSize(90, 120);
            button19.setOnAction(new plante3(350, 370, plant_19, 18));

            Button button20 = new Button("button");
            button20.setMinSize(90, 120);
            button20.setOnAction(new plante3(440, 370, plant_20, 19));

            Button button21 = new Button("button");
            button21.setMinSize(90, 120);
            button21.setOnAction(new plante3(530, 370, plant_21, 20));

            Button button22 = new Button("button");
            button22.setMinSize(90, 120);
            button22.setOnAction(new plante3(620, 370, plant_22, 21));

            Button button23 = new Button("button");
            button23.setMinSize(90, 120);
            button23.setOnAction(new plante3(710, 370, plant_23, 22));

            Button button24 = new Button("button");
            button24.setMinSize(90, 120);
            button24.setOnAction(new plante3(800, 370, plant_24, 23));

            Button button25 = new Button("button");
            button25.setMinSize(90, 120);
            button25.setOnAction(new plante3(890, 370, plant_25, 24));

            Button button26 = new Button("button");
            button26.setMinSize(90, 120);
            button26.setOnAction(new plante3(980, 370, plant_26, 25));

            Button button27 = new Button("button");
            button27.setMinSize(90, 120);
            button27.setOnAction(new plante3(1070, 370, plant_27, 26));

            Button button28 = new Button("button");
            button28.setMinSize(90, 120);
            button28.setOnAction(new plante4(350, 490, plant_28, 27));

            Button button29 = new Button("button");
            button29.setMinSize(90, 120);
            button29.setOnAction(new plante4(440, 490, plant_29, 28));

            Button button30 = new Button("button");
            button30.setMinSize(90, 120);
            button30.setOnAction(new plante4(530, 490, plant_30, 29));

            Button button31 = new Button("button");
            button31.setMinSize(90, 120);
            button31.setOnAction(new plante4(620, 490, plant_31, 30));

            Button button32 = new Button("button");
            button32.setMinSize(90, 120);
            button32.setOnAction(new plante4(710, 490, plant_32, 31));

            Button button33 = new Button("button");
            button33.setMinSize(90, 120);
            button33.setOnAction(new plante4(800, 490, plant_33, 32));

            Button button34 = new Button("button");
            button34.setMinSize(90, 120);
            button34.setOnAction(new plante4(890, 490, plant_34, 33));

            Button button35 = new Button("button");
            button35.setMinSize(90, 120);
            button35.setOnAction(new plante4(980, 490, plant_35, 34));

            Button button36 = new Button("button");
            button36.setMinSize(90, 120);
            button36.setOnAction(new plante4(1070, 490, plant_36, 35));

            Button button37 = new Button("button");
            button37.setMinSize(90, 120);
            button37.setOnAction(new plante5(350, 610, plant_37, 36));

            Button button38 = new Button("button");
            button38.setMinSize(90, 120);
            button38.setOnAction(new plante5(440, 610, plant_38, 37));

            Button button39 = new Button("button");
            button39.setMinSize(90, 120);
            button39.setOnAction(new plante5(530, 610, plant_39, 38));

            Button button40 = new Button("button");
            button40.setMinSize(90, 120);
            button40.setOnAction(new plante5(620, 610, plant_40, 39));

            Button button41 = new Button("button");
            button41.setMinSize(90, 120);
            button41.setOnAction(new plante5(710, 610, plant_41, 40));

            Button button42 = new Button("button");
            button42.setMinSize(90, 120);
            button42.setOnAction(new plante5(800, 610, plant_42, 41));

            Button button43 = new Button("button");
            button43.setMinSize(90, 120);
            button43.setOnAction(new plante5(890, 610, plant_43, 42));

            Button button44 = new Button("button");
            button44.setMinSize(90, 120);
            button44.setOnAction(new plante5(980, 610, plant_44, 43));

            Button button45 = new Button("button");
            button45.setMinSize(90, 120);
            button45.setOnAction(new plante5(1070, 610, plant_45, 44));

            //____________________tiles button_____________________________//
            //Button test=new Button("play/pause");
            //test.setOnAction(new tester(anim1,zombie1,880,300,800,300));
            //test.setTranslateX(500);
            //test.setTranslateY(500);
            TilePane tilePane = new TilePane();
            tilePane.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24, button25, button26, button27, button28, button29, button30, button31, button32, button33, button34, button35, button36, button37, button38, button39, button40, button41, button42, button43, button44, button45);
            tilePane.setTranslateX(350);
            tilePane.setTranslateY(130);
            tilePane.setMinWidth(810);//90*7=630(7 buttons in a tile)

            //plant-1
            Image Plant = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\peashooter.png");
            ImageView plant = new ImageView();
            plant.setImage(Plant);
            plant.setFitHeight(80);
            plant.setFitWidth(100);

            b1 = new Button("", plant);//to set graphics in button
            b1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b1.setOnAction(new buy_plants("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\abcdef.gif", 100));

            //plant-2
            Image Plant1 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\cherrybomb.png");
            ImageView plant1 = new ImageView();
            plant1.setImage(Plant1);
            plant1.setFitHeight(80);
            plant1.setFitWidth(100);
            b2 = new Button("", plant1);//to set graphics in button
            b2.setTranslateX(0);
            b2.setTranslateY(200);
            b2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b2.setOnAction(new buy_plants("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\cheery2.gif", 150));

            // plant-3
            Image Plant2 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\garlic.png");
            ImageView plant2 = new ImageView();
            plant2.setImage(Plant2);
            plant2.setFitHeight(80);
            plant2.setFitWidth(100);
            b3 = new Button("", plant2);//to set graphics in button
            b3.setTranslateX(0);
            b3.setTranslateY(300);
            b3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            b3.setOnAction(new buy_plants("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\plants animation\\stone1.png", 50));

            // sun
            Image sun_image = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\sun.png");
            ImageView sun_ = new ImageView(sun_image);
            sun_.setFitHeight(80);
            sun_.setFitWidth(100);
            Button sun_button = new Button("", sun_);
            sun_button.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            sun_button.setTranslateX(0);
            sun_button.setTranslateY(100);
            sun_button.setOnAction(new buy_plants("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\sun.gif", 50));

            Image sun = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\sun_token.png");
            ImageView sun1 = new ImageView(sun);
            sun1.setFitHeight(70);
            sun1.setFitWidth(180);
            sun1.setTranslateX(150);
            sun1.setTranslateY(10);

            sun2 = new Button();
            sun2.setMinSize(110, 50);
            sun2.setTranslateX(210);
            sun2.setTranslateY(19);
            sun2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            sun2.setText(Integer.toString(sun_value));

            // lawnmovers
            Image lm = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\lawnmover.png");
            lawnmover1.setImage(lm);
            lawnmover1.setFitHeight(50);
            lawnmover1.setFitWidth(100);
            lawnmover1.setTranslateX(230);
            lawnmover1.setTranslateY(150);

            lawnmover2.setImage(lm);
            lawnmover2.setFitHeight(50);
            lawnmover2.setFitWidth(100);
            lawnmover2.setTranslateX(230);
            lawnmover2.setTranslateY(270);

            lawnmover3.setImage(lm);
            lawnmover3.setFitHeight(50);
            lawnmover3.setFitWidth(100);
            lawnmover3.setTranslateX(230);
            lawnmover3.setTranslateY(410);

            lawnmover4.setImage(lm);
            lawnmover4.setFitHeight(50);
            lawnmover4.setFitWidth(100);
            lawnmover4.setTranslateX(230);
            lawnmover4.setTranslateY(530);

            lawnmover5.setImage(lm);
            lawnmover5.setFitHeight(50);
            lawnmover5.setFitWidth(100);
            lawnmover5.setTranslateX(230);
            lawnmover5.setTranslateY(670);

            for (int i = 0; i < 45; i++) {
                pea[i] = new ImageView();
            }

            // falling sun
            l11 = new Line(200, 400, 200, 1500);

            Image _sun_ = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\sunfall.png");
            ImageView sunfall = new ImageView();
            sunfall.setImage(_sun_);
            sunfall.setFitHeight(50);//set height of image
            sunfall.setFitWidth(50);

            Button bsun = new Button("", sunfall);
            bsun.setTranslateX(0);
            bsun.setTranslateY(250);
            bsun.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            PathTransition sun_anim = new PathTransition();
            bsun.setOnAction(new sun_class(sun_anim, bsun));
            sun_anim.setNode(bsun);
            sun_anim.setPath(l11);
            sun_anim.setDuration(new Duration(6000));
            sun_anim.setCycleCount(1000);
            sun_anim.setRate(0.2);//set speed
            sun_anim.play();

            // zombies
            Image img1 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");

            zombie1.setImage(img1);
            zombie1.setFitHeight(190);//set height of image
            zombie1.setFitWidth(190);

            Image img2 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");

            zombie2.setImage(img2);
            zombie2.setFitHeight(190);//set height of image
            zombie2.setFitWidth(190);

            Image img3 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");

            zombie3.setImage(img3);
            zombie3.setFitHeight(190);//set height of image
            zombie3.setFitWidth(190);

            Image img4 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");

            zombie4.setImage(img4);
            zombie4.setFitHeight(190);//set height of image
            zombie4.setFitWidth(190);

            Image img5 = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\zombies animation\\zombie1.gif");

            zombie5.setImage(img5);
            zombie5.setFitHeight(190);//set height of image
            zombie5.setFitWidth(190);

            l1 = new Line(1200, 150, 1120, 150);
            l2 = new Line(1400, 300, 1150, 300);
            l3 = new Line(1600, 420, 1120, 420);
            l4 = new Line(1800, 550, 1120, 550);
            l5 = new Line(2000, 670, 1120, 670);

            // deserialize
            boolean exist = new File("C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\level3_serialize.txt").exists();
            if (flag == 1 && exist == true) {
                ObjectInputStream in = null;
                try {
                    in = new ObjectInputStream(new FileInputStream("C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\level3_serialize.txt"));
                    double arr[] = (double[]) in.readObject();

                    l1 = new Line(arr[0], 150, 200, 150);
                    zombie_t1.setNode(zombie1);
                    zombie_t1.setPath(l1);
                    zombie_t1.setDuration(new Duration(6000));
                    zombie_t1.setCycleCount(1);
                    zombie_t1.setRate(1);//set speed
                    zombie_t1.play();

                    l2 = new Line(arr[1], 300, 200, 300);
                    zombie_t2.setNode(zombie2);
                    zombie_t2.setPath(l2);
                    zombie_t2.setDuration(new Duration(6000));
                    zombie_t2.setCycleCount(1);
                    zombie_t2.setRate(0.8);//set speed
                    zombie_t2.play();

                    l3 = new Line(arr[2], 420, 200, 420);
                    zombie_t3.setNode(zombie3);
                    zombie_t3.setPath(l3);
                    zombie_t3.setDuration(new Duration(6000));
                    zombie_t3.setCycleCount(1);
                    zombie_t3.setRate(0.5);//set speed
                    zombie_t3.play();

                    l4 = new Line(arr[3], 550, 200, 550);
                    zombie_t4.setNode(zombie4);
                    zombie_t4.setPath(l4);
                    zombie_t4.setDuration(new Duration(6000));
                    zombie_t4.setCycleCount(1000);
                    zombie_t4.setRate(1);//set speed
                    zombie_t4.play();

                    l5 = new Line(arr[4], 700, 200, 700);
                    zombie_t5.setNode(zombie5);
                    zombie_t5.setPath(l5);
                    zombie_t5.setDuration(new Duration(6000));
                    zombie_t5.setCycleCount(1);
                    zombie_t5.setRate(0.8);//set speed
                    zombie_t5.play();

                    sun_value = (int) arr[5];
                    sun2.setText(Integer.toString(sun_value));

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {

                zombie_t1.setNode(zombie1);
                zombie_t1.setPath(l1);
                zombie_t1.setDuration(new Duration(6000));
                zombie_t1.setCycleCount(1);
                zombie_t1.setRate(1);//set speed
                zombie_t1.play();

                zombie_t2.setNode(zombie2);
                zombie_t2.setPath(l2);
                zombie_t2.setDuration(new Duration(6000));
                zombie_t2.setCycleCount(1);
                zombie_t2.setRate(0.8);//set speed
                zombie_t2.play();

                zombie_t3.setNode(zombie3);
                zombie_t3.setPath(l3);
                zombie_t3.setDuration(new Duration(6000));
                zombie_t3.setCycleCount(1);
                zombie_t3.setRate(0.5);//set speed
                zombie_t3.play();

                zombie_t4.setNode(zombie4);
                zombie_t4.setPath(l4);
                zombie_t4.setDuration(new Duration(6000));
                zombie_t4.setCycleCount(1);
                zombie_t4.setRate(1);//set speed
                zombie_t4.play();

                zombie_t5.setNode(zombie5);
                zombie_t5.setPath(l5);
                zombie_t5.setDuration(new Duration(6000));
                zombie_t5.setCycleCount(1);
                zombie_t5.setRate(0.8);//set speed
                zombie_t5.play();
                zombie_t1.setOnFinished(new tester1(zombie_t1, zombie1, 1120, 190, 1040, 190));
            zombie_t2.setOnFinished(new tester2(zombie_t2, zombie2, 1150, 310, 1040, 310));
            zombie_t3.setOnFinished(new tester3(zombie_t3, zombie3, 1120, 430, 1040, 430));
            zombie_t4.setOnFinished(new tester4(zombie_t4, zombie4, 1120, 550, 1040, 550));
            zombie_t5.setOnFinished(new tester5(zombie_t5, zombie5, 1120, 670, 1040, 670));
            }

            

            Image m = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\menu.png");
            ImageView menu1 = new ImageView(m);

            menu1.setFitHeight(60);
            menu1.setFitWidth(120);

            Button menu = new Button("", menu1);

            menu.setTranslateX(1340);
            menu.setTranslateY(10);
            menu.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            System.out.println("Inside code coordinates");
            System.out.println(zombie1.translateXProperty().get());

            menu.setOnAction(e
                    -> {
                double arr[] = {zombie1.translateXProperty().get(), zombie2.translateXProperty().get(), zombie3.translateXProperty().get(),
                    zombie4.translateXProperty().get(), zombie5.translateXProperty().get(), sun_value};

                //double arr[] = {zombie1.translateXProperty().get(), zombie1.translateYProperty().get(), sun_value};
                //System.out.println(arr[0]);
                //System.out.println(arr[1]);
                // serialize
                ObjectOutputStream user_out = null;

                try {
                    user_out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\level3_serialize.txt"));
                    user_out.writeObject(arr);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        user_out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                menu();
            }
            );

            Image t = new Image("file:C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\images\\timer.png");
            ImageView timer = new ImageView(t);

            timer.setFitHeight(
                    50);
            timer.setFitWidth(
                    180);
            timer.setTranslateX(
                    700);
            timer.setTranslateY(
                    0);

            Group root = new Group();

            root.getChildren()
                    .addAll(backg, tilePane, plant_1, plant_2, plant_3, plant_4, plant_5, plant_6, plant_7, plant_8, plant_9, plant_10,
                            plant_11, plant_12, plant_13, plant_14, plant_15, plant_16, plant_17, plant_18, plant_19, plant_20, plant_21, plant_22,
                            plant_23, plant_24, plant_25, plant_26, plant_27, plant_28, plant_29, plant_30, plant_31, plant_32, plant_33, plant_34, plant_35, plant_36, plant_37, plant_38, plant_39, plant_40, plant_41, plant_42, plant_43, plant_44, plant_45, plant1, plant2, b1, b2, b3, zombie1, zombie2,
                            zombie3, zombie4, zombie5, sunfall, bsun, Pea, menu1, menu, sun1, sun2, lawnmover5, lawnmover1, lawnmover2, lawnmover3,
                            lawnmover4, pea[0], pea[1], pea[2], pea[3], pea[4], pea[5], pea[6], pea[7], pea[8], pea[9], pea[10],
                            pea[11], pea[12], pea[13], pea[14], pea[15], pea[16], pea[17], pea[18], pea[19], pea[20],
                            pea[21], pea[22], pea[23], pea[24], pea[25], pea[26], pea[27], pea[28], pea[29], pea[30],
                            pea[31], pea[32], pea[33], pea[34], pea[35], pea[36], pea[37], pea[38], pea[39], pea[40],
                            pea[41], pea[42], pea[43], pea[44], sun_button, time_view, head_view);
            // add time_view and head_view too.
            Scene scene = new Scene(root, 1500, 800);

            stage.setScene(scene);

            stage.show();
        }

        public void menu() {
            flag = 1;
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
                this.handle(e);
                //start(stage);
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
                try {
                    serialize(users_names);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(users_names);
                System.exit(0);
            });

            StackPane pane = new StackPane();
            pane.getChildren().addAll(bg1, save, save_game, resume, resume_game, exit, exit_game);
            Scene scene = new Scene(pane, 1000, 800);
            stage.setScene(scene);
            stage.show();
        }
    
    public static void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\users_list.txt"));
            users_names = (ArrayList<String>) in.readObject();
        } finally {
            in.close();
        }
    }

    public static void serialize(ArrayList<String> a) throws IOException {

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\SHANEY WARIS\\OneDrive\\Documents\\NetBeansProjects\\FX_Project\\src\\Plant_vs_Zombies\\users_list.txt"));
            out.writeObject(a);
        } finally {
            out.close();
        }
    }
    
}
