package com.alestrio.isotope.materials;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface Material {
    //Screws
    String getHead ();

    StringProperty getHeadProperty();

    //Tubes or cylinders / screws
    double getDiameter ();

    DoubleProperty getDiameterProperty ();

    double getLength ();

    DoubleProperty getLengthProperty ();

    double getRemainingLength ();

    DoubleProperty getRemainingLengthProperty ();

    //Rectangular pieces
    double getWidth ();

    DoubleProperty getWidthProperty ();

    double getRemainingWidth ();

    DoubleProperty getRemainingWidthProperty ();

    double getThickness ();

    DoubleProperty getThicknessProperty ();

    double getRemainingThickness ();

    DoubleProperty getRemainingThicknessProperty ();

    //3D printers spools
    String getType ();

    StringProperty getTypeProperty();

    double getRemainingWeight ();

    DoubleProperty getRemainingWeightProperty ();

    double getInitialWeight ();

    DoubleProperty getInitialWeightProperty ();

    String getColor ();

    StringProperty getColorProperty();

    int getQty ();

    IntegerProperty getQtyProperty ();


}
