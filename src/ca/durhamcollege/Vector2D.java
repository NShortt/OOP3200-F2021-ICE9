package ca.durhamcollege;

public class Vector2D
{
    // PRIVATE INSTANCE VARIABLES
    private float x;
    private float y;

    // PUBLIC PROPERTIES

    /**
     * Return's point x from vector
     */
    public float getX()
    {
        return x;
    }

    /**
     * Set the x value for the vector
     * @param x the value to set the vector's x to
     */
    public void setX(final float x)
    {
        this.x = x;
    }

    /**
     * Return's point y from vector
     */
    public float getY()
    {
        return y;
    }

    /**
     * Set the y value for the vector
     * @param y the value to set the vector's y to
     */
    public void setY(final float y)
    {
        this.y = y;
    }

    /**
     * Set both x and y for the vector
     * @param x the value to set x to
     * @param y the value to set y to
     */
    public void set(final float x, final float y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Set both x and y for the vector
     * @param vector the vector used to set the x and y
     */
    public void set(final Vector2D vector)
    {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    // CONSTRUCTORS

    /**
     * Default Constructor
     */
    Vector2D()
    {
        set(Vector2D.zero());
    }

    /**
     * Overload Constructor for creating a vector object
     * @param x the x value of the vector
     * @param y the y value of the vector
     */
    Vector2D(final float x, final float y)
    {
        set(x, y);
    }

    /**
     * Copy Constructor for creating a vector object
     * @param vector the vector used to set the x and y
     */
    Vector2D(final Vector2D vector)
    {
        set(vector.getX(), vector.getY());
    }

    // PRIVATE METHODS

    // PUBLIC METHODS

    /**
     * Add a vector's point to another
     * @param rhs the vector you are adding with
     */
    public void add(final Vector2D rhs)
    {
        this.setX(this.getX() + rhs.getX());
        this.setY(this.getY() + rhs.getY());
    }

    /**
     * Subtract a vector's point to another
     * @param rhs the vector you are subtracting with
     */
    public void subtract(final Vector2D rhs)
    {
        this.setX(this.getX() - rhs.getX());
        this.setY(this.getY() - rhs.getY());
    }

    /**
     * Multiply a vector's point to another
     * @param rhs the vector you are multiplying with
     */
    public void multiply(final Vector2D rhs)
    {
        this.setX(this.getX() * rhs.getX());
        this.setY(this.getY() * rhs.getY());
    }

    /**
     * Divide a vector's point to another
     * @param rhs the vector you are dividing with
     */
    public void divide(final Vector2D rhs)
    {
        this.setX(this.getX() / rhs.getX());
        this.setY(this.getY() / rhs.getY());
    }

    /**
     * Make a vector's point equal to another
     * @param rhs the vector you are using to make equal with
     */
    public boolean equals(final Vector2D rhs)
    {
        return ((getX() == rhs.getX()) && (getY() == rhs.getY()));
    }

    /**
     * Calculate the magnitude of the vector
     * @return the magnitude of the vector
     */
    public float getMagnitude()
    {
        return (float)(Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY()));
    }

    /**
     * Calculate the magnitude before squaring it
     * @return returns magnitude before it is squared
     */
    public float getSqrtMagnitude()
    {
        return (this.getX() * this.getX() + this.getY() * this.getY());
    }

    /**
     * Scale the vector point
     * @param scale value used as the scale
     */
    public void setScale(final float scale)
    {
        this.set(getX() * scale, this.getY() * scale);
    }

    /**
     * Scale the vector point
     * @param scale value used as the scale
     */
    public void setScale(final Vector2D scale)
    {
        this.set(getX() * scale.getX(), this.getY() * scale.getY());
    }

    /**
     * Normalize the vector point's values
     */
    public void normalize()
    {
        final var magnitude = this.getMagnitude();
        if ((double)(magnitude) > 9.99999974737875E-06)
        {
            set(getX() / magnitude, getY() / magnitude);
        }
        else
        {
            set(Vector2D.zero());
        }
    }

    /**
     * Get a normalized vector
     * @return a normalized vector
     */
    public Vector2D getNormalize()
    {
        Vector2D vector = new Vector2D(getX(), getY());
        vector.normalize();
        return vector;
    }

    /**
     * A string representing the vector object
     * @return a string containing the x adn y of the vector
     */
    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    // STATIC METHODS

    /**
     * A vector at (0, 0)
     * @return A vector at (0, 0)
     */
    public static Vector2D zero()
    {
        return new Vector2D(0.0f, 0.0f);
    }

    /**
     * A vector at (1, 1)
     * @return A vector at (1, 1)
     */
    public static Vector2D one()
    {
        return new Vector2D(1.0f, 1.0f);
    }

    /**
     * A vector used to move a vector left
     * @return A vector at (-1.0f, 0.0f)
     */
    public static Vector2D left()
    {
        return new Vector2D(-1.0f, 0.0f);
    }

    /**
     * A vector used to move a vector right
     * @return A vector at (1.0f, 0.0f)
     */
    public static Vector2D right()
    {
        return new Vector2D(1.0f, 0.0f);
    }

    /**
     * A vector used to move a vector up
     * @return A vector at (0.0f, 1.0f)
     */
    public static Vector2D up()
    {
        return new Vector2D(0.0f, 1.0f);
    }

    /**
     * A vector used to move a vector down
     * @return A vector at (0.0f, -1.0f)
     */
    public static Vector2D down()
    {
        return new Vector2D(0.0f, -1.0f);
    }

    /**
     * Calculate the linear interpolation of two vectors
     * @param a first vector
     * @param b second vector
     * @param t the alpha value
     * @return the liner interpolation of the two vectors
     */
    public static Vector2D lerp(final Vector2D a, final Vector2D b, float t)
    {
        // Clamp t between 0.0 and 1.0
        if ((double)(t) < 0.0)
        {
            t = 0.0f;
        }
        if ((double)(t) > 1.0)
        {
            t = 1.0f;
        }

        return new Vector2D(a.getX() + (b.getX() - a.getX()) * t, a.getY() + (b.getY() - a.getY()) * t);
    }

    /**
     * Finds the dot product of two vecots
     * @param lhs the first vector
     * @param rhs the second vector
     * @return the dot product between the two
     */
    public static float dot(final Vector2D lhs, final Vector2D rhs)
    {
        return (float)((double)(lhs.getX()) * (double)(rhs.getX()) + (double)(lhs.getY()) * (double)(rhs.getY()));
    }

    /**
     * Calculate the distance between two vectors
     * @param a the first vector
     * @param b the second vector
     * @return the distance between the two
     */
    public static float distance(final Vector2D a, final Vector2D b)
    {
        final var delta_x = (double)(b.getX()) - (double)(a.getX());
        final var delta_y = (double)(b.getY()) - (double)(a.getY());

        return (float)(Math.sqrt(delta_x * delta_x + delta_y * delta_y));
    }
}
