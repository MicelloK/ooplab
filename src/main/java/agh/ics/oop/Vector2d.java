package agh.ics.oop;

public record Vector2d(int x, int y) {
    public String toString() {
        String str = "";
        str += "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
        return str;
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vector2d)) return false;
        return this.x == ((Vector2d) other).x && this.y == ((Vector2d) other).y;
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

}
