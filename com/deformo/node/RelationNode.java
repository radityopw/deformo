/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deformo.node;

import com.deformo.framework.MultiLineString;
import com.deformo.framework.RectangularNode;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author radity
 */
public class RelationNode extends RectangularNode {
    /**
     * Construct a use case node with a default size
     */
    public RelationNode() {
        name = new MultiLineString();
        setBounds(new Rectangle2D.Double(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);
        int x1 = 0;
        int y1 = 0;
        
        int x2 = 0;
        int y2 = 0;
        
        x1 = (int) getBounds().getX();
        y1 = (int) (getBounds().getY() + getBounds().getHeight() / 2);
        
        y2 = (int) getBounds().getY();
        x2 = (int) (getBounds().getX() + getBounds().getWidth() / 2);
        
        g2.drawLine(x1, y1, x2, y2);
        
        x1 = (int) getBounds().getX();
        y1 = (int) (getBounds().getY() + getBounds().getHeight() / 2);
        
        y2 = (int) getBounds().getMaxY();
        x2 = (int) (getBounds().getX() + getBounds().getWidth() / 2);
        
        g2.drawLine(x1, y1, x2, y2);
        
        
        x1 = (int) (getBounds().getX() + getBounds().getWidth() / 2);
        y1 = (int) getBounds().getY();
        
        y2 = (int) (getBounds().getY() + getBounds().getHeight() / 2);
        x2 = (int) (getBounds().getMaxX());
        
        g2.drawLine(x1, y1, x2, y2);
        
        
        x1 = (int) (getBounds().getMaxX());
        y1 = (int) (getBounds().getY() + getBounds().getHeight() / 2);
        
        y2 = (int) (getBounds().getMaxY());
        x2 = (int) (getBounds().getX() + getBounds().getWidth() / 2);
        
        g2.drawLine(x1, y1, x2, y2);
        
        name.draw(g2, getBounds());
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
        RelationNode cloned = (RelationNode) super.clone();
        cloned.name = (MultiLineString) name.clone();
        return cloned;
    }

    private MultiLineString name;

    private static int DEFAULT_WIDTH = 110;
    private static int DEFAULT_HEIGHT = 110;
}
