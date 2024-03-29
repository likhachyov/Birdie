package fyodor.likhachev.birdie.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Bush extends Plant {

    public static final int WIDTH = 250, HEIGHT = 252;
    private static final int ALLOWED_INDENT = 35;
    private static final int DOWN_STEP = 25;

    public Bush(int x, int y) {
        texture = new Texture("bush.png");
        bounds = new Rectangle(x, y - DOWN_STEP, WIDTH, HEIGHT);
    }

    // FIXME: 23.06.2019 оптимизировать как в классе Hawk
    public boolean isIntersection(Rectangle rect) {
        // Если касание передним нижним углом
        if (rect.x + rect.width > bounds.x + ALLOWED_INDENT && rect.x + rect.width < bounds.x + bounds.width && rect.y < bounds.y + bounds.height - ALLOWED_INDENT)
            return true;
            // Касание левым нижним углом
        else if (rect.x > bounds.x && rect.x + ALLOWED_INDENT < bounds.x + bounds.width && rect.y < bounds.y + bounds.height - ALLOWED_INDENT)
            return true;
            // Касание нижней гранью
        else if (rect.x < bounds.x && rect.x + rect.width > bounds.x + bounds.width && rect.y < bounds.y + bounds.height - ALLOWED_INDENT)
            return true;
        return false;
    }
}
