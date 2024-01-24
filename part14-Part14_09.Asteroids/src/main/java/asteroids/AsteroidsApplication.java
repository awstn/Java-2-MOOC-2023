package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application{
    
    public static int WIDTH = 600;
    public static int HEIGHT = 400;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        //adding points text
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);
        
        AtomicInteger points = new AtomicInteger();
        
        //Creates the ship and adds to the middle of the window
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        
        //Creates asteroids and adds them to a list
        List<Asteroid> asteroids = new ArrayList<>();        
        for (int i = 0; i < 5; i++){
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH), rnd.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }
        
        //create list for projectiles
        List<Projectile> projectiles = new ArrayList<>();
          
        pane.getChildren().add(ship.getCharacter());           
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
        
        Scene scene = new Scene(pane);
        
        //Create a HashMap to store the pressed keys. Used so the program can handle the keypresses as multiple events
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        //Key press events
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        
        //abstract class is ran continously to process the key presses
        new AnimationTimer() {
            
            @Override
            public void handle(long now){            
                //movement logic
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)){
                    ship.turnLeft();
                }
                
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)){
                    ship.turnRight();
                }
                
                if (pressedKeys.getOrDefault(KeyCode.UP, false)){
                    ship.accelerate();
                }
                
                //projectile logic for projectile speed and keypress and how many projectiles allowed on screen
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    // we shoot
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                }
                
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
                
                //if ship hits asteroid. stop program.
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
                
                //remove projectile and asteroid if they collide               
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if(projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });
                    //set points for when player destroys asteroid
                    if (!projectile.isAlive()){
                        text.setText("Points: " + points.addAndGet(10));
                    }
                });
                
                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                                            .filter(projectile -> !projectile.isAlive())
                                            .collect(Collectors.toList()));

                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                                            .filter(asteroid -> !asteroid.isAlive())
                                            .collect(Collectors.toList()));
                
                if (Math.random()< 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if (!asteroid.collide(ship)){
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
                

            }
            
        }.start();
        
        
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

}
