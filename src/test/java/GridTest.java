import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    @Test
    void check_grid_is_created() {
        Grid grid = new Grid();
        int[][] actualGrid = grid.create(10, 10);
        int[][] expectedGrid = new int[10][10];
        assertThat(actualGrid).isEqualTo(expectedGrid);
    }
}
