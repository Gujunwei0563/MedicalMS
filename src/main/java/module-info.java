module com.example.web138_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.commons.pool2;
    requires commons.dbcp2;
    requires java.naming;
    requires java.management;
    requires org.reflections;
    requires langchain4j.core;
    requires langchain4j.zhipu.ai;

    opens com.example.web138_project to javafx.fxml;
    exports com.example.web138_project;
    exports com.example.web138_project.controller;
    opens com.example.web138_project.controller to javafx.fxml;
    opens com.example.web138_project.entity to javafx.base;
    opens com.example.web138_project.vo to javafx.base;
}