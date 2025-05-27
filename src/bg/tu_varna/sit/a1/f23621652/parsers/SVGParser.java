package bg.tu_varna.sit.a1.f23621652.parsers;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.a1.f23621652.files.ShapesFile;
import bg.tu_varna.sit.a1.f23621652.models.*;

import java.io.*;
import java.util.*;

/**
 * Utility class for parsing SVG shape definitions from a file and converting them
 * into corresponding Java objects. Supports rectangles, circles, lines, and polygons.
 */
public class SVGParser {

    /**
     * Parses shapes from the shapes file and adds them to the SVGCanvas.
     * Reads the file line by line and assigns parsing to specific shape parsers.
     * Prints all parsed shapes to the console.
     */
    public static void parseShapes() {
        try (BufferedReader br = new BufferedReader(new FileReader(ShapesFile.getFile()))) {
            List<SVGShape> shapes = SVGCanvas.getInstance().getShapes();
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("<rect")) {
                    shapes.add(parseRect(line));
                }
                else if (line.startsWith("<circle")) {
                    shapes.add(parseCircle(line));
                }
                else if (line.startsWith("<line")) {
                    shapes.add(parseLine(line));
                }
                else if (line.startsWith("<polygon")) {
                    shapes.add(parsePolygon(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Parses a rectangle definition from SVG format.
     *
     * @param line The SVG string containing rectangle attributes
     * @return Rectangle object parsed from the string, or null if parsing fails
     */
    private static Rectangle parseRect(String line) {
        int width = getIntAttr(line, "width");
        int height = getIntAttr(line, "height");
        int x = getIntAttr(line, "x");
        int y = getIntAttr(line, "y");
        int rx = getIntAttr(line, "rx");
        int ry = getIntAttr(line, "ry");
        String fill = getAttr(line, "fill");
        try {
            Rectangle rect = new Rectangle(width, height, new Point(x, y));
            rect.setCornerRadius(new Point(rx, ry));
            if(!fill.isEmpty()) {
                rect.setFill(fill);
            }
            return rect;

        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Parses a circle definition from SVG format.
     *
     * @param line The SVG string containing circle attributes
     * @return Circle object parsed from the string, or null if parsing fails
     */
    private static Circle parseCircle(String line) {
        int r = getIntAttr(line, "r");
        int cx = getIntAttr(line, "cx");
        int cy = getIntAttr(line, "cy");
        String fill = getAttr(line, "fill");
        try {
            Circle circle = new Circle(r);
            circle.setCenterPoint(new Point(cx, cy));
            if(!fill.isEmpty()) {
                circle.setFill(fill);
            }
            return circle;
        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Parses a line definition from SVG format.
     *
     * @param line The SVG string containing line attributes
     * @return Line object parsed from the string
     */
    private static Line parseLine(String line) {
        int x1 = getIntAttr(line, "x1");
        int y1 = getIntAttr(line, "y1");
        int x2 = getIntAttr(line, "x2");
        int y2 = getIntAttr(line, "y2");
        String stroke = getAttr(line, "stroke");
        Line l = null;
        try {
            l = new Line(new Point(x1, y1), new Point(x2, y2));
        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
        if(!stroke.isEmpty()) {
            l.setStroke(stroke);
        }
        return l;
    }

    /**
     * Parses a polygon definition from SVG format.
     *
     * @param line The SVG string containing polygon attributes
     * @return Polygon object parsed from the string
     */
    private static Polygon parsePolygon(String line) {
        Polygon polygon = new Polygon();

        String pointsAttr = getAttr(line, "points");  // "50,150 50,200 200,200"
        if (!pointsAttr.isEmpty()) {
            String[] pointPairs = pointsAttr.trim().split("\\s+"); // Split by space
            int x, y;
            for (String pair : pointPairs) {
                String[] coordinates = pair.split(",");
                if (coordinates.length == 2) {
                    x = InputParser.parseIntegerSafely(coordinates[0]);
                    y = InputParser.parseIntegerSafely(coordinates[1]);
                    try {
                        polygon.addPoint(new Point(x, y));
                    } catch (NegativeValueException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        String fill = getAttr(line, "fill");
        if(!fill.isEmpty()) {
            polygon.setFill(fill);
        }
        return polygon;
    }

    /**
     * Extracts an integer attribute value from an SVG element string.
     *
     * @param line The SVG element string
     * @param attr The attribute name to extract
     * @return The integer value of the attribute, or 0 if not found
     */
    private static int getIntAttr(String line, String attr) {
        String intValue = getAttr(line, attr);
        return intValue.isEmpty() ? 0 : InputParser.parseIntegerSafely(intValue);
    }

    /**
     * Extracts an attribute value from an SVG element string.
     *
     * @param line The SVG element string
     * @param attr The attribute name to extract
     * @return The string value of the attribute, or empty string if not found
     */
    private static String getAttr(String line, String attr) {
        int start = line.indexOf(attr + "=\"");
        if (start == -1)
            return "";

        start += attr.length() + 2; // to go after ="
        int end = line.indexOf("\"", start);
        return line.substring(start, end);
    }
}
