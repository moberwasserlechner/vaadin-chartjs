package com.byteowls.vaadin.chartjs.options;

public enum InteractionMode {
    
    /**
     * Finds all of the items that intersect the point
     */
    POINT,
    /**
     * Gets the item that is nearest to the point. The nearest item is determined based on the distance to the center of the chart item (point, bar). 
     * If 2 or more items are at the same distance, the one with the smallest area is used. 
     * If intersect is true, this is only triggered when the mouse position intersects an item in the graph. 
     * This is very useful for combo charts where points are hidden behind bars.
     */
    NEAREST,
    /**
     * Finds item at the same index. 
     * If the intersect setting is true, the first intersecting item is used to determine the index in the data. 
     * If intersect false the nearest item is used to determine the index.
     */
    INDEX,
    /**
     * Finds items in the same dataset. If the intersect setting is true, the first intersecting item is used to determine the index in the data. 
     * If intersect false the nearest item is used to determine the index.
     */
    DATASET,
    /**
     * Returns all items that would intersect based on the X coordinate of the position only. 
     * Would be useful for a vertical cursor implementation. Note that this only applies to cartesian charts 
     */
    X,
    /**
     * Returns all items that would intersect based on the Y coordinate of the position. 
     * This would be useful for a horizontal cursor implementation. Note that this only applies to cartesian charts.
     */
    Y

}
