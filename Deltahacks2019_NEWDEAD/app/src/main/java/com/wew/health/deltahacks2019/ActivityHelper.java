package com.wew.health.deltahacks2019;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

public class ActivityHelper {

    public ActivityHelper(){}

    /**
     * Toggles a recommendation option by switching the image to
     * whatever it currently isn't when clicked on
     * @param ctx the activity context for getting the drawable resources
     * @param option imageview representing the option thats been clicked
     * @param selectedImage the drawable representing the image of the option when its selected by the user
     * @param unselectedImage the drawable representing the image of the option when its not selected by the user
     * @return true if successful, false otherwise
     */
    public boolean toggleOptionSelected(Context ctx, ImageView option, int selectedImage, int unselectedImage){
        if (ctx == null || option == null) return false;

        Drawable.ConstantState optionSelected = ContextCompat.getDrawable(ctx,selectedImage).getConstantState();

        //if current image is the 'selected' version, then switch to unselected and vice versa
        if (option.getDrawable().getConstantState() == optionSelected){
            option.setImageResource(unselectedImage);
        }else{
            option.setImageResource(selectedImage);
        }

        return true;
    }
}
