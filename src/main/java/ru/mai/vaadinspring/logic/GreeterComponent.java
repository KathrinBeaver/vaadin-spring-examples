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
package ru.mai.vaadinspring.logic;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringComponent
@UIScope
public class GreeterComponent {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String beanCreatedDate = "";

    public GreeterComponent() {
        LocalDateTime dateTime = LocalDateTime.now();
        beanCreatedDate = dateTime.format(formatter);
        System.out.println(beanCreatedDate);
    }

    public String sayHello() {
        return "Всем привет! (from bean " + toString() + " created at " + beanCreatedDate + ")";
    }

    public String sayBye() {
        return "Всем пока! (from bean " + toString() + " created at " + beanCreatedDate + ")";
    }
}
