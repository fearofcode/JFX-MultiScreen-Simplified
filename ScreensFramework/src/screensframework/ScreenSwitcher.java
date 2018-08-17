/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License"). You
 * may not use this file except in compliance with the License. You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
/*
 * Portions Copyright 2018 Warren Henning.
 * Contributor elects to include this software in this distribution under the
 * GPL Version 2 license.
 */
package screensframework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

class ScreenSwitcher extends StackPane {
    private HashMap<Class, Node> screens = new HashMap<>();

    private void addScreen(Class klazz, Node screen) {
        screens.put(klazz, screen);
    }

    void loadController(Class klazz) throws Exception {
        String resourcePath = klazz.getSimpleName() + ".fxml";
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resourcePath));
        Parent loadScreen = myLoader.load();
        ControlledScreen controller = myLoader.getController();
        controller.setScreenParent(this);
        addScreen(klazz, loadScreen);
    }

    void setController(Class klazz) {
        Node node = screens.get(klazz);
        if (node != null) {
            if (!getChildren().isEmpty()) {
                getChildren().remove(0);
            }

            getChildren().add(node);
        }
    }
}
