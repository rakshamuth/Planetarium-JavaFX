import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Circle;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.MoveTo;
import javafx.util.Duration;
import javafx.animation.Interpolator;
import javafx.scene.shape.ArcTo;

/**
* This class represents a enumerated class of type Planet
* @author Raksha Muthukumar
* @version 1.0
*/

public enum Planet {

    EARTH(Color.SPRINGGREEN, 1, 1, 1), MERCURY(Color.SILVER, .1915, .387, .24),
        VENUS(Color.GREEN, .4745, .723, .62), MARS(Color.RED, .266, 1.52, 1.88);

    private final Color c;
    private double rad;
    private double dist;
    private double period;

    private Path path;
    private Circle circle;
    private PathTransition pathTransition;

    /** DO NOT MODIFY IT'S FOR YOUR OWN GOOD**/
    private final int earthRadius = 35;
    private final int earthDistance = 265;
    private final int earthPeriod = 5;
    /** OK YOU'RE GOOD GO AHEAD AND DO WORK NOW **/

    /**
    *  Creates a new Planet object
    *
    *  @param the color, the difference in the values from the earth's
    **/
    Planet(Color c, double i, double j, double k) {
        this.c = c;
        rad = i * earthRadius;
        dist = j * earthDistance;
        period = k * earthPeriod;

        path = new Path();
        path.setStroke(Color.WHITE);
        path.getElements().add(new MoveTo(350, 350 + dist));
        ArcTo arcTo = new ArcTo();
        arcTo.setX(350);
        arcTo.setY(350 - dist);
        arcTo.setRadiusX(dist);
        arcTo.setRadiusY(dist);
        ArcTo arcTo2 = new ArcTo();
        arcTo2.setX(350);
        arcTo2.setY(350 + dist);
        arcTo2.setRadiusX(dist);
        arcTo2.setRadiusY(dist);
        path.getElements().addAll(arcTo, arcTo2);
        circle = new Circle(350 - dist, 350 - dist, rad, c);
        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(period));
        pathTransition.setPath(path);
        pathTransition.setNode(circle);
        pathTransition
        .setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.play();
    }

    /**
    *  Gets the path of the given planet
    *
    *  @return the path
    **/
    public Path getPath() {
        return path; //from constructor
    }

    /**
    *  Gets the circle of the given planet
    *
    *  @return the circle
    **/
    public Circle getCircle() {
        return circle; //from constructor
    }
}
