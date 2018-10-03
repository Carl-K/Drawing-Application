package view.graphicmanager;

import view.subscriptions.ShapeGraphicCreatedObserver;
import view.subscriptions.ShapeGraphicRemovedObserver;
import view.subscriptions.ShapeGraphicUpdatedObserver;

public interface IShapeGraphicCollectionObservers extends ShapeGraphicCreatedObserver, ShapeGraphicUpdatedObserver, ShapeGraphicRemovedObserver {

}
