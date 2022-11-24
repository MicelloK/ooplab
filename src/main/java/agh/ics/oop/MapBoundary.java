package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

class CmpX implements Comparator<Vector2d> {
    public int compare(Vector2d pos1, Vector2d pos2) {
        if (pos1.equals(pos2)) return 0;
        if (pos1.x() > pos2.x()) return 1;
        else return -1;
    }
}

class CmpY implements Comparator<Vector2d> {
    public int compare(Vector2d pos1, Vector2d pos2) {
        if (pos1.equals(pos2)) return 0;
        if (pos1.y() > pos2.y()) return 1;
        else return -1;
    }
}

public class MapBoundary {
    private final SortedSet<Vector2d> elementsX = new TreeSet<>(new CmpX());
    private final SortedSet<Vector2d> elementsY = new TreeSet<>(new CmpY());
    private final Vector2d[] ends = new Vector2d[2];
    private boolean dynamicMap;

    public MapBoundary() {
        ends[0] = new Vector2d(0, 0);
        ends[1] = new Vector2d(0, 0);
        dynamicMap = true;
    }

    protected void updatePosition() {
        if (!elementsX.isEmpty()) {
            ends[0] = elementsX.first().lowerLeft(elementsY.first());
            ends[1] = elementsX.last().upperRight(elementsY.last());
        }
    }

    public void addElement(Vector2d position) {
        elementsX.add(position);
        elementsY.add(position);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        elementsX.remove(oldPosition);
        elementsY.remove(oldPosition);

        elementsX.add(newPosition);
        elementsY.add(newPosition);
    }

    public Vector2d[] getEnds() {
        if (dynamicMap) updatePosition();
        return ends;
    }

    public void setEnds(Vector2d lowerLeft, Vector2d upperRight) {
        ends[0] = lowerLeft;
        ends[1] = upperRight;
        dynamicMap = false;
    }
}
