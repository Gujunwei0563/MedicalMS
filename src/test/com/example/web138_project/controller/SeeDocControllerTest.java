package com.example.web138_project.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeeDocControllerTest {

    @Test
    public void loadComDate() {
        SeeDocController seeDocController = new SeeDocController();
        seeDocController.loadComDate();
        System.out.println(seeDocController.patNameCom);
    }
}