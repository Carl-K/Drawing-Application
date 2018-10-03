package controller.shapegraphicmanager;

import view.subscriptions.ShapeGraphicCreatedSubject;
import view.subscriptions.ShapeGraphicRemovedSubject;
import view.subscriptions.ShapeGraphicUpdatedSubject;

public interface IShapeGraphicCollectionSubjects extends ShapeGraphicCreatedSubject, ShapeGraphicRemovedSubject, ShapeGraphicUpdatedSubject {

}
