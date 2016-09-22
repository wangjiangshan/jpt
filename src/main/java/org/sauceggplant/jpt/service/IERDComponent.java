package org.sauceggplant.jpt.service;

import java.io.Serializable;

/**
 * All Component interface.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public interface IERDComponent extends IERDLogger, Serializable {

    /**
     * Init all child components.
     */
    void initComponents();

    /**
     * Get component name.
     *
     * @return Component name
     */
    String getComponentName();

    /**
     * Get component code.
     */
    String getComponentCode();

    /**
     * Get component key.
     *
     * @return Type
     */
    int getComponentKey();

    /**
     * Get component id.
     *
     * @return Component id.
     */
    String getComponentId();
}
