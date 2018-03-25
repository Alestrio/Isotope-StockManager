package com.alestrio.isotope.materials;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

public interface Material {
    //Screws
    String getHead ();

    StringProperty getHeadProperty();

    //Tubes or cylinders / screws
    float getDiameter ();

    FloatProperty getDiameterProperty();

    float getLength();

    FloatProperty getLengthProperty();

    float getRemainingLength();

    FloatProperty getRemainingLengthProperty();

    //Rectangular pieces
    float getWidth();

    FloatProperty getWidthProperty();

    float getRemainingWidth();

    FloatProperty getRemainingWidthProperty();

    float getThickness();

    FloatProperty getThicknessProperty();

    float getRemainingThickness();

    FloatProperty getRemainingThicknessProperty();

    //3D printers spools
    String getType ();

    StringProperty getTypeProperty();

    float getRemainingWeight ();

    FloatProperty getRemainingWeightProperty();

    float getInitialWeight ();

    FloatProperty getInitialWeightProperty();

    String getColor ();

    StringProperty getColorProperty();
}
