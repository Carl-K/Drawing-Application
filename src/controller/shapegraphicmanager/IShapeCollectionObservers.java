package controller.shapegraphicmanager;

import model.subscriptions.ShapeAddedObserver;
import model.subscriptions.ShapeRemovedObserver;
import model.subscriptions.ShapeUpdatedObserver;

public interface IShapeCollectionObservers extends ShapeAddedObserver, ShapeUpdatedObserver, ShapeRemovedObserver {

}
