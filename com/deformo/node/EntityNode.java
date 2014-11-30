/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deformo.node;

import com.deformo.framework.Graph;
import com.deformo.framework.Grid;
import com.deformo.framework.MultiLineString;
import com.deformo.framework.Node;
import com.deformo.framework.RectangularNode;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author radityopw
 */
public class EntityNode extends RectangularNode {

    public EntityNode() {
        name = new MultiLineString();
        name.setSize(MultiLineString.LARGE);
        setBounds(new Rectangle2D.Double(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);
        Rectangle2D top = new Rectangle2D.Double(getBounds().getX(),
                getBounds().getY(), getBounds().getWidth(),
                getBounds().getHeight());
        g2.draw(top);
        name.draw(g2, top);
        
    }

    public void layout(Graph g, Graphics2D g2, Grid grid) {
        Rectangle2D min = new Rectangle2D.Double(0, 0,
                DEFAULT_WIDTH, DEFAULT_COMPARTMENT_HEIGHT);
        Rectangle2D top = name.getBounds(g2);
        top.add(min);
                

        Rectangle2D b = new Rectangle2D.Double(
                getBounds().getX(), getBounds().getY(),
                top.getWidth(),
                top.getHeight());
        grid.snap(b);
        setBounds(b);
    }

    public boolean addNode(Node n, Point2D p) {
        return n instanceof PointNode;
    }

    /**
     * Sets the name property value.
     *
     * @param newValue the class name
     */
    public void setName(MultiLineString newValue) {
        name = newValue;
    }

    /**
     * Gets the name property value.
     *
     * @return the class name
     */
    public MultiLineString getName() {
        return name;
    }

    public Object clone() {
        EntityNode cloned = (EntityNode) super.clone();
        cloned.name = (MultiLineString) name.clone();
        
        return cloned;
    }

    
    private MultiLineString name;
    

    private static int DEFAULT_COMPARTMENT_HEIGHT = 20;
    private static int DEFAULT_WIDTH = 100;
    private static int DEFAULT_HEIGHT = 60;
}