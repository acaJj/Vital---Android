package com.wew.health.deltahacks2019;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

class ActivityHelper {

    /**
     * Toggles a recommendation option by switching the image to whatever it currently isn't when clicked on
     *
     * @param ctx activity context for getting the drawable resources
     * @param option represents the option thats been clicked
     * @param selectedImage represents the option image where its selected by the user
     * @param unselectedImage represents the option image where its not selected by the user
     * @return 1 if image is set to unselectedImage, 0 if set to selectedImage, -1 if no context or imageview is passed
     */
    public static int toggleOptionSelected(Context ctx, ImageView option, int selectedImage, int unselectedImage){
        if (ctx == null || option == null) return -1;

        Drawable.ConstantState optionSelected = ContextCompat.getDrawable(ctx,selectedImage).getConstantState();
        if (optionSelected == null) return -1;

        //if current image is the 'selected' version, then switch to unselected and vice versa
        if (option.getDrawable().getConstantState() == optionSelected){
            option.setImageResource(unselectedImage);
            return 0;
        }else{
            option.setImageResource(selectedImage);
            return 1;
        }
    }
}
