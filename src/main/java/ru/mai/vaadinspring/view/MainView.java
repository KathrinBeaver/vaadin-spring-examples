/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package ru.mai.vaadinspring.view;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import ru.mai.vaadinspring.logic.GreeterComponent;
import ru.mai.vaadinspring.page.ExampleTemplate;

@Route
public class MainView extends VerticalLayout implements LocaleChangeObserver {

    private RouterLink link;

    public MainView(@Autowired GreeterComponent greeter, @Autowired ExampleTemplate template) {
        H1 heading = new H1("Vaadin + Spring тоже дружат :) ");
        
        Label greeting = new Label(greeter.sayHello());
        Style grretingStyle = greeting.getElement().getStyle();
        grretingStyle.set("display", "block");
        grretingStyle.set("margin-bottom", "10px");

        Button buttonLang = new Button("Switch language to Chinese",
                event -> getUI().get().setLocale(Locale.CHINESE));

        link = new RouterLink(
                getTranslation("root.navigate_to_component"),
                ViewComponent.class);

        Style linkStyle = link.getElement().getStyle();
        linkStyle.set("display", "block");
        linkStyle.set("margin-bottom", "10px");

        add(heading, greeting, buttonLang, link, template);
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        link.setText(
                getTranslation("root.navigate_to_component"));
    }

}
