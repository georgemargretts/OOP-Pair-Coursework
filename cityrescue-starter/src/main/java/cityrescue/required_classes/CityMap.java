
package cityrescue.required_classes;

/**
 * CityMap Class
 * 
 * This class ___
 */

public class CityMap{
    // Attributes
    public int city_width;
    public int city_height;
    public boolean[][] grid; // defines the grid

    // Constructor
    public CityMap(int width, int height) {
        this.city_width = width;
        this.city_height = height;
        this.grid = new boolean[width][height];
    }

    // Methods
    public int[] getGridSize() {
        int[] size = {city_width, city_height};
        return size;
    }

    public void updateObstacle(boolean new_grid_value, int new_x_coord, int new_y_coord) {
        grid[new_x_coord][new_y_coord] = new_grid_value;
    }
}