/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.deformo.graph;

import com.deformo.edge.ClassRelationshipEdge;
import com.deformo.edge.NoteEdge;
import com.deformo.framework.Edge;
import com.deformo.framework.Graph;
import com.deformo.framework.Node;
import com.deformo.node.AttributeNode;
import com.deformo.node.DerivedAttributeNode;
import com.deformo.node.EntityNode;
import com.deformo.node.KeyAttributeNode;
import com.deformo.node.MultivaluedAttributeNode;
import com.deformo.node.NoteNode;
import com.deformo.node.RelationNode;
import com.deformo.node.WeakEntityNode;
import java.awt.geom.Point2D;

/**
 *
 * @author radityopw
 */
public class ERDGraph extends Graph {
    
    public boolean connect(Edge e, Point2D p1, Point2D p2)
   {
      Node n1 = findNode(p1);
      Node n2 = findNode(p2);
      // if (n1 == n2) return false;
      return super.connect(e, p1, p2);
   }

   public Node[] getNodePrototypes()
   {
      return NODE_PROTOTYPES;
   }

   public Edge[] getEdgePrototypes()
   {
      return EDGE_PROTOTYPES;
   }

   private static final Node[] NODE_PROTOTYPES = new Node[8];

   private static final Edge[] EDGE_PROTOTYPES = new Edge[2];

   static
   {
      NODE_PROTOTYPES[0] = new EntityNode();
      NODE_PROTOTYPES[1] = new WeakEntityNode();
      NODE_PROTOTYPES[2] = new AttributeNode();
      NODE_PROTOTYPES[3] = new KeyAttributeNode();
      NODE_PROTOTYPES[4] = new MultivaluedAttributeNode();
      NODE_PROTOTYPES[5] = new DerivedAttributeNode();
      NODE_PROTOTYPES[6] = new RelationNode();
      NODE_PROTOTYPES[7] = new NoteNode();

      ClassRelationshipEdge edge = new ClassRelationshipEdge();
      EDGE_PROTOTYPES[0] = edge;
      EDGE_PROTOTYPES[1] = new NoteEdge();
   }
    
}
