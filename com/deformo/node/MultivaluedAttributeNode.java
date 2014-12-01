/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deformo.node;

import com.deformo.framework.MultiLineString;
import com.deformo.framework.RectangularNode;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author radity
 */
public class MultivaluedAttributeNode extends RectangularNode {
    /**
     * Construct a use case node with a default size
     */
    public MultivaluedAttributeNode() {
        name = new MultiLineString();
        setBounds(new Rectangle2D.Double(0, 0,
                DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);
        g2.draw(getShape());
        g2.draw(getShape2());
        name.draw(g2, getBounds());
    }

    public Shape getShape() {
        
        Ellipse2D shape = new Ellipse2D.Double(
                getBounds().getX(), getBounds().getY(),
                getBounds().getWidth(), getBounds().getHeight());
        
        return shape;
    }
    
    public Shape getShape2(){
        Ellipse2D shape = new Ellipse2D.Double(
                getBounds().getX() + 4, getBounds().getY() + 4,
                getBounds().getWidth() - 10, getBounds().getHeight() - 6);
        
        return shape;
    }

    /**
     * Sets the name property value.
     *
     * @param newValue the new use case name
     */
    public void setName(MultiLineString newValue) {
        name = newValue;
    }

    /**
     * Gets the name property value.
     *
     * @param the use case name
     */
    public MultiLineString getName() {
        return name;
    }

    public Object clone() {
        MultivaluedAttributeNode cloned = (MultivaluedAttributeNode) super.clone();
        cloned.name = (MultiLineString) name.clone();
        return cloned;
    }

    private MultiLineString name;

    private static int DEFAULT_WIDTH = 110;
    private static int DEFAULT_HEIGHT = 40;
}