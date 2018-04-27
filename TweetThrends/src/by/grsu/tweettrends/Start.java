package by.grsu.tweettrends;

import by.grsu.tweettrends.bean.Coordinate;
import by.grsu.tweettrends.bean.Polygon;
import by.grsu.tweettrends.bean.State;
import by.grsu.tweettrends.manager.DictionaryManager;
import by.grsu.tweettrends.manager.StateManager;
import by.grsu.tweettrends.manager.TweetManager;
import by.grsu.tweettrends.utills.Converter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Start {

    public static void main(String[] args) throws FileNotFoundException {
        DictionaryManager dictionaryManager = new DictionaryManager();
        TweetManager tweetManager = new TweetManager();
        StateManager stateManager = new StateManager();
        JFrame frame = new JFrame("Map");

        dictionaryManager.readDictionary();
        tweetManager.readTweets();
        stateManager.readStateFromJson();
        stateManager.setStateSentiments();
        frame.setContentPane(new MapContainer(stateManager.getStateRepository().getStates()));
        frame.setSize(new Dimension(4000, 4000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static class MapContainer extends Container {

        ArrayList<State> states = new StateManager().getStateRepository().getStates();

        public MapContainer(ArrayList<State> states) {
            this.states = states;
        }

        @Override
        public void paint(final Graphics g) {

            final Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));

            states.forEach((state) -> {

                g2.setPaint(Color.BLACK);

                final ArrayList<Polygon> polygons = state.getPolygons();
                for (final Polygon polygon :
                        polygons) {
                    final ArrayList<Coordinate> points = polygon.getCoordinates();

                    final GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
                    path.moveTo(points.get(0).getLongitude() * (8) + 1600, points.get(0).getLatitude() * (-11) + 800);
                    for (int i = 0; i < points.size(); i++) {
                        final Coordinate location = points.get(i);
                        path.lineTo(location.getLongitude() * (8) + 1600, location.getLatitude() * (-11) + 800);
                    }
                    path.closePath();
                    g2.draw(path);
                    g2.setPaint(getColorBySentimentValue(state.getSentiment()));
                    g2.fill(path);
                }
            });
        }

        private Color getColorBySentimentValue(final Double value) {
            if (value == null) {
                return Color.MAGENTA;
            } else if (value < 0) {
                return Color.RED;
            } else if (value > 0) {
                return Color.GREEN;
            }

            return Color.GRAY;
        }

    }
}
