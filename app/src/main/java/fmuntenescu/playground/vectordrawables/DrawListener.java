package fmuntenescu.playground.vectordrawables;

/**
 * Listener that notifies when a view has been redrawn
 */
public interface DrawListener {

    /**
     * Called when the view has been redrawn
     *
     * @param miliseconds the time took to draw the view.
     */
    void viewDrawn(long miliseconds);
}
