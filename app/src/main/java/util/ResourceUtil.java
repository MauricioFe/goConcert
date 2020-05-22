package util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {
    public static final String DRAWABLE = "drawable";
    public static Drawable getDrawable(String drawbleTexto, Context context) {
        Resources resources = context.getResources();
        int idDodrawable = resources.getIdentifier(drawbleTexto, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDodrawable);

    }
}
