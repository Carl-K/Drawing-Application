package model.shapemanager;

import model.subscriptions.ShapeAddedSubject;
import model.subscriptions.ShapeRemovedSubject;
import model.subscriptions.ShapeUpdatedSubject;

public interface IShapeCollectionSubjects extends ShapeAddedSubject, ShapeRemovedSubject, ShapeUpdatedSubject
{

}
