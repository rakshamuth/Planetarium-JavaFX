import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

/**
* This class represents a Planetarium creation
* @author Raksha Muthukumar
* @version 1.0
*/

public class Planetarium extends Application {

    private Planet earth;
    private Planet mercury;
    private Planet venus;
    private Planet mars;

    /**
    *  starts the animation
    **/
    @Override
    public void start(Stage stage) {
        Pane backdrop = new Pane();
        earth = Planet.EARTH;
        mars = Planet.MARS;
        mercury = Planet.MERCURY;
        venus = Planet.VENUS;
        Circle sun = new Circle(350, 350, 65, Color.YELLOW);
        backdrop.getChildren().add(sun);
        backdrop.getChildren().addAll(earth.getCircle(), earth.getPath());
        backdrop.getChildren().addAll(mars.getCircle(), mars.getPath());
        backdrop.getChildren().addAll(mercury.getCircle(), mercury.getPath());
        backdrop.getChildren().addAll(venus.getCircle(), venus.getPath());
        Scene scene = new Scene(backdrop, 700, 700, Color.BLACK);

        stage.setScene(scene);
        stage.show();
    }
}
